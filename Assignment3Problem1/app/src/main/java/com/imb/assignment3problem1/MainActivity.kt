package com.imb.assignment3problem1

import android.os.Bundle
import android.util.TypedValue
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            val version = etVer.text.toString()
            val name = etCodeName.text.toString()

            if (version.isNotBlank() && name.isNotBlank()) {
                val tvCode = TextView(applicationContext)
                tvCode.setBackgroundResource(R.drawable.border)
                tvCode.setTextColor(ContextCompat.getColor(this, R.color.black))
                tvCode.text = version
                tvCode.setPadding((resources.displayMetrics.density * 5 + 0.5f).toInt(), 0, 0, 0)
                val tvVer = TextView(applicationContext)
                tvVer.setBackgroundResource(R.drawable.border)
                tvVer.setTextColor(ContextCompat.getColor(this, R.color.black))
                tvVer.setPadding((resources.displayMetrics.density * 5 + 0.5f).toInt(), 0, 0, 0)
                tvVer.text = name

                val tableRow = TableRow(applicationContext)
                val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
                layoutParams.setMargins(
                    0, 0, 0, TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 5F, resources
                            .displayMetrics
                    ).toInt()
                )
                tableRow.layoutParams = layoutParams

                tableRow.addView(tvVer, 0, layoutParams)
                tableRow.addView(tvCode, 1, layoutParams)
                tbl.addView(tableRow, layoutParams)

                etVer.setText("")
                etCodeName.setText("")
            } else {
                Toast.makeText(this, "Fields can not be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}