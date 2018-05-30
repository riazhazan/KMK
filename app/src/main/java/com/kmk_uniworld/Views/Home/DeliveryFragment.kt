package com.kmk_uniworld.Views.Home


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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DeliveryFragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    companion object {
        fun newInstance():DeliveryFragment = DeliveryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        mRecyclerView = view.findViewById(R.id.recyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        val schoolList = generateTestData()
        var adapter = HomeRecyclerAdapter(schoolList)
        mRecyclerView.adapter = adapter
        return view
    }

    fun generateTestData(): ArrayList<School> {
        var result = ArrayList<School>()

        for (i in 0..9) {
            var user: School = School(schoolId = "AUPSA1", schoolName = "AUP School Wandoor", orderStatus = true)
            result.add(user)
        }

        return result
    }

}
