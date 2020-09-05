package com.udacoding.mahasiswa_app_eriennadaazandra.Config

import com.udacoding.mahasiswa_app_eriennadaazandra.Model.action.ResponseAction
import com.udacoding.mahasiswa_app_eriennadaazandra.Model.getdata.ResponseGetData
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    // Get Data
    @GET("getData.php")
    fun getData() : Call<ResponseGetData>

    // Get Data by Id
    @GET("getData.php")
    fun getDataById(@Query("id_mahasiswa")id_mahasiswa : String) : Call<ResponseGetData>

    // Insert
    @FormUrlEncoded
    @POST("insert.php")
    fun insertData(
        @Field("mahasiswa_nama")mahasiswa_nama : String,
        @Field("mahasiswa_nohp")mahasiswa_nohp : String,
        @Field("mahasiswa_alamat")mahasiswa_alamat : String) : Call<ResponseAction>

    // Update
    @FormUrlEncoded
    @POST("update.php")
    fun updateData(
        @Field("id_mahasiswa")id_mahasiswa : String,
        @Field("mahasiswa_nama")mahasiswa_nama : String,
        @Field("mahasiswa_nohp")mahasiswa_nohp : String,
        @Field("mahasiswa_alamat")mahasiswa_alamat : String) : Call<ResponseAction>

    // Delete
    @FormUrlEncoded
    @POST("delete.php")
    fun deleteData(@Field("id_mahasiswa")id_mahasiswa_ : String ) : Call<ResponseAction>

}