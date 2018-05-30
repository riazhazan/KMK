package com.kmk_uniworld.Views.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.kmk_uniworld.R
import com.kmk_uniworld.Views.NewOrder.AddNewOrder
import com.kmk_uniworld.Views.NewOrder.AddNewSchool
import kotlinx.android.synthetic.main.activity_home_tab.*

class HomeTabActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar

    companion object {
        fun newIntent(context: Context, userId: String): Intent {
            val intent = Intent(context, HomeTabActivity::class.java)
            return intent
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.hasSubMenu() == false){
            val intent = AddNewSchool.newIntent(this)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_tab)
        val homeFragment = HomeFragment.newInstance()
        openFragment(homeFragment)
        toolbar = supportActionBar!!
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val cuttingFragment = CuttingFragment.newInstance()
                openFragment(cuttingFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val deliveryFragment = DeliveryFragment.newInstance()
                openFragment(deliveryFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
