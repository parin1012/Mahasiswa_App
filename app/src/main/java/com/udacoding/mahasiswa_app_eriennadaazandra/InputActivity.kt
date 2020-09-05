package com.udacoding.mahasiswa_app_eriennadaazandra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.udacoding.mahasiswa_app_eriennadaazandra.Config.NetworkModule
import com.udacoding.mahasiswa_app_eriennadaazandra.Model.action.ResponseAction
import com.udacoding.mahasiswa_app_eriennadaazandra.Model.getdata.DataItem
import kotlinx.android.synthetic.main.activity_input.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        val getData = intent.getParcelableExtra<DataItem>("data")
        if(getData != null){
            etNama.setText(getData.mahasiswaNama)
            etNohp.setText(getData.mahasiswaNohp)
            etAlamat.setText(getData.mahasiswaAlamat)

            btn1.text ="Update"
        }


        when(btn1.text){
            "Update" -> {
                btn1.setOnClickListener {
                    updateData(getData?.idMahasiswa, etNama.text.toString(), etNohp.text.toString(), etAlamat.text.toString())
                }
            }else -> {
            btn1.setOnClickListener {
                inputData(etNama.text.toString(), etNohp.text.toString(), etAlamat.text.toString())
            }
        }
        }



        btn2.setOnClickListener {
            finish()
        }

    }

    private fun inputData(mahasiswa_nama : String? , mahasiswa_nohp : String? , mahasiswa_alamat : String?){
        val input = NetworkModule.service().insertData(mahasiswa_nama ?: "", mahasiswa_nohp ?: "", mahasiswa_alamat ?: "")
        input.enqueue(object : Callback<ResponseAction> {
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext,"Data berhasil disimpan", Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateData(id_mahasiswa : String? , mahasiswa_nama : String? , mahasiswa_nohp : String? , mahasiswa_alamat : String?){
        val input = NetworkModule.service().updateData(id_mahasiswa ?: "" ,mahasiswa_nama ?: "", mahasiswa_nohp ?: "", mahasiswa_alamat ?: "")
        input.enqueue(object : Callback<ResponseAction> {
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext,"Data berhasil diupdate", Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}