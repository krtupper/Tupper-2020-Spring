package com.example.homeworktodo

import com.example.homeworktodo.models.HomeworkItem
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebServices {
    private var service: HomeworkInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://bsu-kylertupper.s3.us-west-2.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(HomeworkInterface::class.java)
    }

    fun homeworks( callback: Callback<List<HomeworkItem>>){
        val call = service.currentHomeworks()
        call.enqueqe(callback)
    }
}