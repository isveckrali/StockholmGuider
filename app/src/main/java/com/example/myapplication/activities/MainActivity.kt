package com.example.myapplication.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.TouristDestinationsAdapter
import com.example.myapplication.model.TouristDestinationsModel
import com.example.myapplication.utils.Constants
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.Serializable

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    // A global variable for SharedPreferences
    private lateinit var mSharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        Constants.populateCityInfo()
        Constants.populateTouristAttractions()

        setupActionBar()

        // Assign the NavigationView.OnNavigationItemSelectedListener to navigation view.
        nav_view.setNavigationItemSelectedListener(this)

        mSharedPreferences =
            this.getSharedPreferences(Constants.COMETOSTOCKHOLM_PREFERENCES, Context.MODE_PRIVATE)


        populateDestinationAndAttractionsListToUI()

    }


    /**
     * A function to populate the result of BOARDS list in the UI i.e in the recyclerView.
     */
    fun populateDestinationAndAttractionsListToUI() {

       // hideProgressDialog()

        if (Constants.cityArrayList.size > 0) {

            tourist_destination_recycler_view.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            tourist_destination_recycler_view.setHasFixedSize(true)

            // Create an instance of TouristDestainationItemsAdapter and pass the boardList to it.
            val adapter = TouristDestinationsAdapter(this@MainActivity, Constants.cityArrayList)
            tourist_destination_recycler_view.adapter = adapter // Attach the adapter to the recyclerView.

            adapter.setOnClickListener(object :
                TouristDestinationsAdapter.OnClickListener {
                override fun onClick(position: Int, model: TouristDestinationsModel) {
                    val intent = Intent(this@MainActivity, CityDetailActivity::class.java)
                    intent.putExtra(Constants.CITY_DETAIL, model as Serializable)
                    startActivity(intent)
                }
            })

        } else {
          //  tv_no_boards_available.visibility = View.VISIBLE
        }

        if (Constants.touristAttractionsArrayList.size > 0) {

            tourist_destination_recycler_view_second.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            tourist_destination_recycler_view_second.setHasFixedSize(true)

            // Create an instance of TouristDestainationItemsAdapter and pass the boardList to it.
            val adapter = TouristDestinationsAdapter(this@MainActivity, Constants.touristAttractionsArrayList)
            tourist_destination_recycler_view_second.adapter = adapter // Attach the adapter to the recyclerView.

        } else {
            //  tv_no_boards_available.visibility = View.VISIBLE
        }


    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            // A double back press function is added in Base Activity.
            doubleBackToExit()
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_my_profile -> {
            }
            R.id.nav_sign_out -> {
                // Here sign outs the user from firebase in this device.
                FirebaseAuth.getInstance().signOut()

                mSharedPreferences.edit().clear().apply()

                // Send the user to the intro screen of the application.
                val intent = Intent(this, IntroActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_main_activity)
        toolbar_main_activity.setNavigationIcon(R.drawable.ic_action_navigation_menu)

        toolbar_main_activity.setNavigationOnClickListener {
            toggleDrawer()
        }
    }

    /**
     * A function for opening and closing the Navigation Drawer.
     */
    private fun toggleDrawer() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }

}