package com.example.homeworktodo

import android.util.Log
import com.example.homeworktodo.models.HomeworkItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

object HomeworkManager {
    private val homeworkList = mutableListOf<HomeworkItem>()

    val num = homeworkList.size
    init {
        for(i in 1..20)
        {
            addHomework(HomeworkItem("title","description", "2020-04-23", 10, 100, 10, isDone = false))
        }
    }

    fun updateHomeworks()
    {
        val callback = object: Callback<List<HomeworkItem>> {
            override fun onFailure(call: Call<List<HomeworkItem>>, t: Throwable) {
                Log.e("BSU", "Error: ${call.toString()})")
            }

          override fun onResponse(
            cll: Call<List<HomeworkItem>>,
                response: Response<List<HomeworkItem>>
            ) {
                if(response?.isSuccessful()){
                    Log.d("BSU", response.body()!!.toString())
                }
            }
        }

        WebServices.homeworks(callback)
    }

    fun homeworkList(): MutableList<HomeworkItem>
    {
        return homeworkList
    }

    fun addHomework(homeworkTitle: String, homeworkDescription: String, homeworkDueDate: String, homeworkPriority: Int, homeworkPoints: Int, homeworkPercentage: Int = 10)
    {
        var dueDate:Date
        if(homeworkDueDate.isBlank())
        {
            dueDate = Date()
        }
        else
        {
            dueDate = Date(homeworkDueDate)
        }

        val newHomework = HomeworkItem(homeworkTitle,homeworkDescription,dueDate,homeworkPriority,homeworkPoints,homeworkPercentage,isDone = false)
        addHomework(newHomework)
    }


    fun addHomework(newHomework: HomeworkItem)
    {
        homeworkList.add(newHomework)
    }

    fun addHomeworks(listofHomeworks:List<HomeworkItem>)
    {
        homeworkList.addAll(listofHomeworks)
    }

    fun removeHomework(homeworkToRemove:HomeworkItem)
    {
        homeworkList.remove(homeworkToRemove)
    }



}