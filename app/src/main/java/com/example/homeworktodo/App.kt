package com.example.homeworktodo

import android.app.Application
import android.util.Log

class App:Application() {
    override fun onCreate() {
        super.onCreate()


        ObjectBoxObject.init(this)
        HomeworkManager.updateHomeworks()
        Log.d("BSU", "Loaded Application")
    }
}