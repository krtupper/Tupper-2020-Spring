package com.example.homeworktodo

import com.example.homeworktodo.models.ToDoItem

object ToDoManager {
    private val homeworkList = mutableListOf<ToDoItem>()

    fun todoList(): MutableList<ToDoItem>
    {
        return homeworkList
    }

    fun addHomework(newHomework: ToDoItem)
    {
        homeworkList.add(newHomework)
    }

    fun addHomeworks(listofHomeworks:List<ToDoItem>)
    {
        homeworkList.addAll(listofHomeworks)
    }

    fun removeHomework(homeworkToRemove:ToDoItem)
    {
        homeworkList.remove(homeworkToRemove)
    }

}