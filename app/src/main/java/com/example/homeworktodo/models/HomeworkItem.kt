package com.example.homeworktodo.models

import java.io.Serializable
import java.util.*

data class HomeworkItem(
    var homeworkTitle: String?,
    var homeworkDescription: String?,
    var homeworkDueDate: String?,
    var homeworkPriority: Int?,
    var homeworkPoints: Int?,
    var homeworkPercentage: Int?,
    var isDone: Boolean?
):Serializable
