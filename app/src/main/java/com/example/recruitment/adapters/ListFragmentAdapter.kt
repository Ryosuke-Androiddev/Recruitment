package com.example.recruitment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import com.example.recruitment.databinding.ListRowLayoutBinding
import com.example.recruitment.models.Connpass
import com.example.recruitment.models.Event

class ListFragmentAdapter: RecyclerView.Adapter<ListFragmentAdapter.MyViewHolder>() {

    private var informationList = emptyList<Event>()

    class MyViewHolder(private val binding: ListRowLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event){
            binding.event = event
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListRowLayoutBinding.inflate(layoutInflater,parent,false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentInformation = informationList[position]
        holder.bind(currentInformation)
    }

    override fun getItemCount(): Int {
        return informationList.size
    }

    fun saveData(newData: Connpass){
        val diffUtil = DiffUtil(informationList,newData.events)
        val diffUtilResult = calculateDiff(diffUtil)
        informationList = newData.events
        diffUtilResult.dispatchUpdatesTo(this)
    }
}