package com.udacoding.mahasiswa_app_eriennadaazandra.Adapter

import android.app.LauncherActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacoding.mahasiswa_app_eriennadaazandra.Model.getdata.DataItem
import com.udacoding.mahasiswa_app_eriennadaazandra.R
import kotlinx.android.synthetic.main.item_mahasiswa.view.*

class MahasiswaAdapter(val data : List<DataItem>?, val itemClick : OnClickListener) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaHolder>() {
    class MahasiswaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tnama = itemView.tvNama
        val tnohp = itemView.tvNohp
        val talamat = itemView.tvAlamat
        val btnHapus = itemView.btnHapus
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa,parent,false)
        val holder = MahasiswaHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: MahasiswaHolder, position: Int) {
        val item = data?.get(position)
        holder.tnama.text = data?.get(position)?.mahasiswaNama
        holder.tnohp.text = data?.get(position)?.mahasiswaNohp
        holder.talamat.text = data?.get(position)?.mahasiswaAlamat

        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }

        holder.btnHapus.setOnClickListener {
            itemClick.hapus(item)
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?:0
    }

    interface OnClickListener{
        fun detail(item: DataItem?)
        fun hapus(item: DataItem?)
    }
}