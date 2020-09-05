package com.udacoding.mahasiswa_app_eriennadaazandra.Model.getdata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

    @field:SerializedName("mahasiswa_alamat")
    val mahasiswaAlamat: String? = null,

    @field:SerializedName("mahasiswa_nohp")
    val mahasiswaNohp: String? = null,

    @field:SerializedName("id_mahasiswa")
    val idMahasiswa: String? = null,

    @field:SerializedName("mahasiswa_nama")
    val mahasiswaNama: String? = null
) : Parcelable