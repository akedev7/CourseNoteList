package com.example.myfirstapplication

class DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourse()
    }

    private fun initializeCourse() {
        var course = CourseInfo("android_intents", "Android Programing with Intents")
        courses[course.courseId] = course

        course = CourseInfo("andriod_asyns", "Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo("java_core", "Java Fundamental The Core Platform")
        courses[course.courseId] = course
    }
}