package com.example.jsonMy

import com.google.gson.annotations.SerializedName

data class DepartmentJS2(
        @SerializedName("Department") val department : String,
        @SerializedName("DaysCount") val daysCount : Int
)