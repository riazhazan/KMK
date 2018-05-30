package com.kmk_uniworld.Views.NewOrder

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kmk_uniworld.R
import com.kmk_uniworld.Views.Home.HomeTabActivity
import kotlinx.android.synthetic.main.activity_add_new_order.*

class AddNewOrder : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context, schoolID: String): Intent {
            val intent = Intent(context, AddNewOrder::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_order)
        buttonConfirm.setOnClickListener { confirmButtonClicked()}
    }

    private fun confirmButtonClicked() {
        this.finish()
    }
}
