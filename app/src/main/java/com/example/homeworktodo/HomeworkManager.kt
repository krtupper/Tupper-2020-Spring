package com.example.homeworktodo

import com.example.homeworktodo.models.HomeworkItem
import java.util.*

object HomeworkManager {
    private val homeworkList = mutableListOf<HomeworkItem>()

    val num = homeworkList.size
    init {
        for(i in 1..20)
        {
            addHomework(HomeworkItem("title","description", Date(), 10, 100, 10))
        }
    }

    fun homeworkList(): MutableList<HomeworkItem>
    {
        return homeworkList
    }

    fun addHomework(homeworkTitle: String, homeworkDescription: String, homeworkDueDate: String, homeworkPriority: Int, homeworkPoints: Int, homeworkPercentage: Int = 10)
    {
        val dueDate:Date = Date(homeworkDueDate)

        val newHomework = HomeworkItem(homeworkTitle,homeworkDescription,dueDate,homeworkPriority,homeworkPoints,homeworkPercentage)
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