package com.kmk_uniworld.Views.Details

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import com.kmk_uniworld.R
import de.codecrafters.tableview.TableView
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter
import kotlinx.android.synthetic.main.activity_order_details.*


class OrderDetailsActivity : AppCompatActivity() {

    var spaceProbes = arrayOf(arrayOf("1", "20", "4", "15", "2"),  arrayOf("1", "20", "4", "15", "2"),  arrayOf("1", "20", "4", "15", "2"),  arrayOf("1", "20", "4", "15", "2"),  arrayOf("1", "20", "4", "15", "2"),  arrayOf("1", "20", "4", "15", "2"))
    var tableHeaders = arrayOf("STD", "BOYS", "SP-BOY", "GIRLS", "SP-GIRL")

    companion object {
        fun newIntent(context: Context, schoolID:String): Intent {
            val intent = Intent(context, OrderDetailsActivity:: class.java)
            return  intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        //SET PROP
        tableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
        tableView.headerAdapter = SimpleTableHeaderAdapter(this, *tableHeaders)
        tableView.dataAdapter = SimpleTableDataAdapter(this, spaceProbes)
        tableView.setColumnCount(5)
    }
}

