package com.example.jsonMy

import com.google.gson.annotations.SerializedName

data class DepartmentJS(
    @SerializedName("Department") val department : String
)