package com.example.homeworktodo.models

import java.util.*

data class ToDoItem(
    val todoTitle: String,
    val todoDescription: String,
    val todoDueDate: Date,
    val todoPriority: Int,
    val todoPoints: Int,
    val todoPercentage: Int
) {

}