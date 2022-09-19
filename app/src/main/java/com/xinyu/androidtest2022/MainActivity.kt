package com.xinyu.androidtest2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.xinyu.androidtest2022.ui.ImageFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ConstraintLayout>(R.id.root)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.root, ImageFragment())
        transaction.commitNow()
    }
}