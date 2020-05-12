package com.example.homeworktodo.models

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.io.Serializable
import java.util.*
@Entity
data class HomeworkItem(
    @Id var id:Long = 0,
    @SerializedName("homeworkTitle")
    var homeworkTitle: String?,
    var homeworkDescription: String?,
    var homeworkDueDate: String?,
    var homeworkPriority: Int?,
    var homeworkPoints: Int?,
    var homeworkPercentage: Int?,
    var isDone: Boolean?
):Serializable
