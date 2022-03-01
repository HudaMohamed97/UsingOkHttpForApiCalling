package com.example.assignment.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        val obj: String? = intent.getStringExtra("obj")
        /*val textView: TextView = findViewById(R.id.text)
        textView.text = obj.name*/
    }
}