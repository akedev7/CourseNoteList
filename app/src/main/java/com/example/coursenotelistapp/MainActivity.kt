package com.example.coursenotelistapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.DataManager

class MainActivity : AppCompatActivity() {

    private var notePosition = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapterCourses = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerCourse = findViewById<Spinner>(R.id.spinnerCourses)
        spinnerCourse.adapter = adapterCourses

        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)
        if (notePosition != POSITION_NOT_SET) {
            displayNote()
        }

    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        val textNoteTitle = findViewById<EditText>(R.id.textNoteTitle)
        val textNoteText = findViewById<EditText>(R.id.textNoteText)
        textNoteTitle.setText(note.title)
        textNoteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.courseInfo)
        val spinnerCourse = findViewById<Spinner>(R.id.spinnerCourses)
        spinnerCourse.setSelection(coursePosition)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_next -> {
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++notePosition
        displayNote()
    }
}