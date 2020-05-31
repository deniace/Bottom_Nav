package com.deni.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.deni.bottomnav.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Deni Supriyatna (deni ace) on 31 - 05 - 2020.
 * Email : denisupriyatna01@gmail.com
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(navigationItemSelected)
        val homeFragment: HomeFragment = HomeFragment()
        replaceFragment(homeFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
//            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(R.id.fl_main, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    private val navigationItemSelected =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btm_home -> {
                    val homeFragment:HomeFragment = HomeFragment()
                    replaceFragment(homeFragment)
                    true
                }
                R.id.btm_search -> {
                    val searchFragment:SearchFragment = SearchFragment()
                    replaceFragment(searchFragment)
                    true
                }
                R.id.btm_plus -> {
                    val plusFragment:PlusFragment = PlusFragment()
                    replaceFragment(plusFragment)
                    true
                }
                R.id.btm_build -> {
                    val buildFragment:BuildFragment  = BuildFragment()
                    replaceFragment(buildFragment)
                    true
                }
                R.id.btm_profile -> {
                    val profileFragment:ProfileFragment = ProfileFragment()
                    replaceFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
}
