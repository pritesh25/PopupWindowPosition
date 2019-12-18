package com.example.viewposition

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mTag = "MainActivity"
    var popupWindow: PopupWindow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<LinearLayoutCompat>(R.id.mainLayout)
        Log.d(mTag, "mainLayout height = ${mainLayout.height}")
        Log.d(mTag, "mainLayout width  = ${mainLayout.width}")

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {

            val location1 = IntArray(2)
            val location2 = IntArray(2)
            Log.d(mTag, "location screen = ${it.getLocationOnScreen(location1)}")
            Log.d(mTag, "(screen) btn location X = ${location1[0]}")
            Log.d(mTag, "(screen) btn location Y = ${location1[1]}")
            Log.d(mTag, "location window = ${it.getLocationInWindow(location2)}")
            Log.d(mTag, "(window) X = ${location2[0]}")
            Log.d(mTag, "(window) Y = ${location2[1]}")

            Log.d(mTag, "btn height = ${btn.height}")
            Log.d(mTag, "btn width  = ${btn.width}")
            val h = location1[1] - btn.height
            Log.d(mTag, "popup y  = $h")

            displayPop(location1, location2, btn, h)

        }
    }

    private fun displayPop(
        location1: IntArray,
        location2: IntArray,
        btn: Button,
        h: Int
    ) {
        val layoutInflater =
            this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customView = layoutInflater.inflate(R.layout.popup, null)
        val closePopupBtn = customView.findViewById(R.id.closePopupBtn) as Button

        popupWindow = PopupWindow(
            customView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        popupWindow!!.showAtLocation(
            mainLayout,
            Gravity.CENTER,
            0,
            700
        )

        closePopupBtn.setOnClickListener {
            popupWindow!!.dismiss()
        }
    }

}