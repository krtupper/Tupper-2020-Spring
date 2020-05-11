package com.example.homeworktodo.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class HomeworkItem(
    @SerializedName("homeworkTitle")
    var homeworkTitle: String?,
    var homeworkDescription: String?,
    var homeworkDueDate: String?,
    var homeworkPriority: Int?,
    var homeworkPoints: Int?,
    var homeworkPercentage: Int?,
    var isDone: Boolean?
):Serializable
