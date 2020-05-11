package com.example.homeworktodo.models

import java.util.*

data class HomeworkItem(
    val homeworkTitle: String,
    val homeworkDescription: String,
    val homeworkDueDate: Date,
    val homeworkPriority: Int,
    val homeworkPoints: Int,
    val homeworkPercentage: Int
) {

}