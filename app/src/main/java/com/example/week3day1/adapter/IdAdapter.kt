package com.example.week3day1.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week3day1.R
import com.example.week3day1.model.DataId
import com.google.android.material.textview.MaterialTextView

class IdAdapter (private var mList:List<DataId>):RecyclerView.Adapter<IdAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val userid: MaterialTextView = itemView.findViewById((R.id.userId))
        val id: MaterialTextView = itemView.findViewById((R.id.id))
        val title: MaterialTextView = itemView.findViewById((R.id.title))
        val completed: MaterialTextView = itemView.findViewById((R.id.completed))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.id_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userid.text = mList[position].userId.toString()
        holder.id.text=mList[position].id.toString()
        holder.title.text=mList[position].title
        holder.completed.text= mList[position].completed.toString()
    }

    override fun getItemCount(): Int {
        return mList.size

    }
}
