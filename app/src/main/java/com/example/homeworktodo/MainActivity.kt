package com.example.homeworktodo

import android.os.Bundle
import android.util.Log

import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.content.Intent
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu

import com.example.homeworktodo.models.HomeworkItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), HomeworkItemFragment.OnListFragmentInteractionListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var service: HomeworkInterface

    //homeworks.json?response-content-disposition=attachment&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEOr%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLXdlc3QtMiJGMEQCIAxcH6Y9iwxE%2FcBSyiSF%2FkjylOFx02Zy0ob35lalHsI2AiB7YgjVWE8H4e3JNDil92ELLgFRUw%2FxTrhUmH%2FFnMR68CrmAQgzEAAaDDIzNzgwNTM1MTk0MyIMJLwfv6ZG8D7C0NgwKsMB7X0WU%2BrCKmRLaL9DbGcmB5%2FxVkJMP1Zxd0dHaLFcQYcUHC6qZngRMzyiZkqHlnf%2F4o9ol4Mg0ZcRqVd4g44GY2UBLmTybDVE9GPnzvK2yaafwx5cZOg%2FaoQF%2FhQFA0EseMyW3HhuaZ5kUbq03%2BK3qIIvzYVQUio0zcIFQWslibH51jeEpZ38Oe%2FcmGmMLCbgt9ju4SKq0ztPhc%2F0h4aFv%2BtpHruOQOWJrLHEVJxs6o6jYdpHkhvSAJQrnRg0vTscK85qMPWr5vUFOvECOGxVcpZGtbO5MDXwEEDbpuOTP3fqLCfL0NqW1gizAfjH0jMUW7zPHnYqUTcfpArb5SGNygCLulDfRo7huTnqvlg%2BPP1IXcCjryJbThlhbJ105hTeqj%2BeNotk%2FB%2FpOxkYAGFcVG7ViqWh2BtdxtrLKCzv2V9IhywBVZvLEraNQc7zUn0hIW65qXq3F3svMUlezcsdtnRBOTfsdfDrh7y80zwXjdWbUEYlPa63Z5NYZSGeHD0bVAQCaNM9md5mgt%2BoRw0LMFwZgkqdjWPRXDycdzIJ07Xe7k1xraD4LvBC7t8HjvmyJoOIg5HPeb6WcsswLfzUaLdiySMHWJY8QVqd8Wbn%2BiALrkyDPluKAGk3c41%2FHvNUB5nVErSECXc2qYGzkXL0e3Srk%2BmOAVVfJ3SbuBVxg%2BmzinTX1cuWAxbhPUe%2FvBG7z8dbBu2x%2F4Kdva2zUgS3oCm4iNc3LNxxhWFR3uGVDIZDZrz4GwaI6tjRNLao&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200511T185328Z&X-Amz-SignedHeaders=host&X-Amz-Expires=299&X-Amz-Credential=ASIATOXSNWQD4G6D36G5%2F20200511%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Signature=ae6f58d4feede32c26c37cf364006ca0ae3ab7aac9b57cd7b5304296d3835a70

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
           val intent = Intent(this, HomeworkItemCrudActivity::class.java)
            startActivity(intent)
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun onResume() {
        super.onResume()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onListFragmentInteraction(item: HomeworkItem?) {
        val intent = Intent(this, HomeworkItemCrudActivity::class.java)
        intent.putExtra("homeworkItem", item)
        startActivity(intent)
    }


    val callback = object: Callback<List<HomeworkItem>> {
        override fun onFailure(call: Call<List<HomeworkItem>>, t: Throwable) {
            Log.e("BSU", "Error: ${call.toString()})")
        }

        override fun onResponse(
            cll: Call<List<HomeworkItem>>,
            response: Response<List<HomeworkItem>>
        ) {
            if (response?.isSuccessful()) {
                Log.d("BSU", response.body()!!.toString())
            }
        }
    }
}
