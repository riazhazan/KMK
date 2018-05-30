package com.kmk_uniworld.Views.NewOrder

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.kmk_uniworld.R
import kotlinx.android.synthetic.main.activity_add_new_school.*


class AddNewSchool : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            val newIntent = Intent(context, AddNewSchool::class.java)
            return newIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_school)
        buttonAdd.setOnClickListener { addNewScholButtonAction() }
    }

    private fun addNewScholButtonAction() {
        Snackbar.make(
                view,
                R.string.add_New_School,
                Snackbar.LENGTH_SHORT
        ).show()
        this.finish()
    }
}
