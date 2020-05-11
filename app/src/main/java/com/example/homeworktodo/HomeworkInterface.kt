package com.example.homeworktodo

import com.example.homeworktodo.models.HomeworkItem
import retrofit2.http.GET
import retrofit2.Call

interface HomeworkInterface {

    interface ToDoInterface {
        @GET("homeworks.json")
//    @GET("history")
        fun currentHomeworks(): Call<List<HomeworkItem>>
    }
}