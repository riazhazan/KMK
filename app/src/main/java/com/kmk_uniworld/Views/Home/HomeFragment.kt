package com.kmk_uniworld.Views.Home


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kmk_uniworld.DataModel.School

import com.kmk_uniworld.R
import com.kmk_uniworld.Views.Details.OrderDetailsActivity


class HomeFragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        mRecyclerView = view.findViewById(R.id.recyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

        val schoolList = generateTestData()
        var adapter = HomeRecyclerAdapter(schoolList){ itemDto: School, position: Int ->

            val intent = OrderDetailsActivity.newIntent(inflater.context, schoolID = itemDto.schoolId)
            startActivity(intent)

        }
        mRecyclerView.adapter = adapter

        return view
    }


    fun generateTestData(): ArrayList<School> {
        var result = ArrayList<School>()

        for (i in 0..9) {
            var user: School = School(schoolId = "AUPSA1", schoolName = "AUP School Chelari", orderStatus = true)
            result.add(user)
        }

        return result
    }
}
