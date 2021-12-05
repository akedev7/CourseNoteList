package com.example.myfirstapplication

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourseAndNotes()
    }

    private fun initializeCourseAndNotes() {
        var course = CourseInfo("android_intents", "Android Programing with Intents")
        courses[course.courseId] = course
        notes.add(NoteInfo(course, "Thi note for Android Programing with Intents"))

        course = CourseInfo("andriod_asyns", "Android Async Programming and Services")
        courses[course.courseId] = course
        notes.add(NoteInfo(course, "Thi note for Android Async Programming and Services"))

        course = CourseInfo("java_core", "Java Fundamental The Core Platform")
        courses[course.courseId] = course
        notes.add(NoteInfo(course, "Thi note for Java Fundamental The Core Platform"))
    }
}