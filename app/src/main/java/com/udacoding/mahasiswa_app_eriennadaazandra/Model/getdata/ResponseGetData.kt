package com.udacoding.mahasiswa_app_eriennadaazandra.Model.getdata

import com.google.gson.annotations.SerializedName
import com.udacoding.mahasiswa_app_eriennadaazandra.Model.getdata.DataItem

data class ResponseGetData(

    @field:SerializedName("isSucces")
    val isSucces: Boolean? = null,

    @field:SerializedName("data")
    val data: List<DataItem>? = null,

    @field:SerializedName("message")
    val message: String? = null
)