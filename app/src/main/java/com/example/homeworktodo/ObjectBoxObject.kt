package com.example.homeworktodo

import android.content.Context
import com.example.homeworktodo.models.MyObjectBox
import io.objectbox.BoxStore
object ObjectBoxObject {
    lateinit var boxStore: BoxStore private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
           .build()
    }
}