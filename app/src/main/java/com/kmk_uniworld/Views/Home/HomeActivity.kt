package com.kmk_uniworld.Views.Home

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.kmk_uniworld.DataModel.School
import com.kmk_uniworld.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val schoolList = generateData()
        var adapter = HomeRecyclerAdapter(schoolList)
        recyclerView.adapter = adapter
    }
    companion object {

        private val INTENT_USER_ID = "user_id"

        fun newIntent(context: Context, userId: String): Intent {
            val intent = Intent(context, HomeActivity::class.java)
            intent.putExtra(INTENT_USER_ID, userId)
            return intent
        }
    }

    fun generateData(): ArrayList<School> {
        var result = ArrayList<School>()

        for (i in 0..9) {
            var user: School = School(schoolId = "AUPSA1", schoolName = "AUP School Chelari", orderStatus = true)
            result.add(user)
        }

        return result
    }
}
