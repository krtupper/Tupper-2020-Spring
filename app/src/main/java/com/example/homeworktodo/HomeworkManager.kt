package com.example.homeworktodo

import com.example.homeworktodo.models.HomeworkItem

object HomeworkManager {
    private val homeworkList = mutableListOf<HomeworkItem>()

    fun homeworkList(): MutableList<HomeworkItem>
    {
        return homeworkList
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