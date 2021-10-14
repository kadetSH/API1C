package com.example.jsonMy
import com.google.gson.annotations.SerializedName

data class AuthorizationJS(
    @SerializedName("Surname") val Surname : String,
    @SerializedName("Name") val Name : String,
    @SerializedName("Patronymic") val Patronymic : String,
    @SerializedName("Password") val Password : String
)