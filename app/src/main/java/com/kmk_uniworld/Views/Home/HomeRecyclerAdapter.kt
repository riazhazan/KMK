package com.kmk_uniworld.Views.Home


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kmk_uniworld.DataModel.School
import com.kmk_uniworld.R
import java.util.zip.Inflater

class HomeRecyclerAdapter(val schoolList: ArrayList<School>, val clickListener: (School, Int) -> Unit) : RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.txtName?.text = schoolList[position].schoolName
        holder?.txtTitle?.text = schoolList[position].schoolId
        holder?.itemView.setOnClickListener{clickListener(schoolList[position], position)}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = LayoutInflater.from(parent?.context).inflate(R.layout.home_item_layout, parent, false)
        return ViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return  schoolList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)

    }
}

interface OnItemClickListener {
    fun onItemClick(item: School)
}
