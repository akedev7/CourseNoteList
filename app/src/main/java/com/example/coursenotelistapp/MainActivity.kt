package com.example.coursenotelistapp

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.coursenotelistapp.databinding.ActivityMainBinding
import com.example.myfirstapplication.CourseInfo
import com.example.myfirstapplication.DataManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dm = DataManager()
        val adapterCourses = ArrayAdapter<CourseInfo>(
            this,
            R.layout.simple_spinner_item,
            dm.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCourses.adapter = adapterCourses
    }
}