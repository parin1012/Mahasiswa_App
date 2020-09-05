package com.udacoding.mahasiswa_app_eriennadaazandra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.udacoding.mahasiswa_app_eriennadaazandra.Adapter.MahasiswaAdapter
import com.udacoding.mahasiswa_app_eriennadaazandra.Config.NetworkModule
import com.udacoding.mahasiswa_app_eriennadaazandra.Model.action.ResponseAction
import com.udacoding.mahasiswa_app_eriennadaazandra.Model.getdata.DataItem
import com.udacoding.mahasiswa_app_eriennadaazandra.Model.getdata.ResponseGetData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        fab.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showData(){
        val listAnggota = NetworkModule.service().getData()
        listAnggota.enqueue(object : Callback<ResponseGetData> {
            override fun onResponse(
                call: Call<ResponseGetData>,
                response: Response<ResponseGetData>
            ) {

                Log.d("Data response",response.message())
                if (response.isSuccessful) {
                    val item = response.body()?.data
                    val adapter = MahasiswaAdapter(item, object : MahasiswaAdapter.OnClickListener {
                        override fun detail(item: DataItem?) {
                            val intent = Intent(applicationContext, InputActivity::class.java)
                            intent.putExtra("data", item)
                            startActivity(intent)
                        }

                        override fun hapus(item: DataItem?) {

                            AlertDialog.Builder(this@MainActivity).apply {
                                setTitle("Hapus data..?")
                                setMessage("Yakin data akan dihapus..?")
                                setPositiveButton("Hapus"){ dialog, which ->
                                    hapusData(item?.idMahasiswa)

                                    dialog.dismiss()
                                }

                                setNegativeButton("Batal"){ dialog, which ->
                                    dialog.dismiss()
                                }
                            }.show()



                        }
                    })

                    list.adapter = adapter
                }
            }

            override fun onFailure(call: Call<ResponseGetData>, t: Throwable) {
                Log.d("Error Connection", t.message)
            }
        })
    }

    private fun hapusData(id_mahasiswa: String?) {
        val hapus = NetworkModule.service().deleteData(id_mahasiswa ?: "")
        hapus.enqueue(object : Callback<ResponseAction>{
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext,"Data sukses dihapus", Toast.LENGTH_SHORT)
                showData()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        showData()
    }

}