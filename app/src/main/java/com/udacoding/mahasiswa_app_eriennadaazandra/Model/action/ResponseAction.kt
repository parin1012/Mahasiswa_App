package com.udacoding.mahasiswa_app_eriennadaazandra.Model.action

import com.google.gson.annotations.SerializedName

data class ResponseAction(

    @field:SerializedName("isSucces")
    val isSucces: Boolean,

    @field:SerializedName("message")
    val message: String
)