package com.example.jsonMy

import com.google.gson.annotations.SerializedName

data class SearchKlientJS2 (
        @SerializedName("Surname") val surname : String,
        @SerializedName("Name") val name : String,
        @SerializedName("Patronymic") val patronymic : String,
        @SerializedName("Telephone") val telephone : String
)