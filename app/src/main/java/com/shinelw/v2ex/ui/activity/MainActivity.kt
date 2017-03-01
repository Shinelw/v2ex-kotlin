package com.shinelw.v2ex.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shinelw.v2ex.R
import kotlinx.android.synthetic.main.layout_content.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}
