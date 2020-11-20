package com.cockatoo.androidarchitecturetemplate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cockatoo.androidarchitecturetemplate.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}