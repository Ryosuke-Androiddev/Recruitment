package com.example.recruitment.adapters.databindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

class ListRowBinding {

    companion object{

        @BindingAdapter("setNumberOfAccepted")
        @JvmStatic
        fun setNumberOfAccepted(textView: TextView, accepted: Int){
            textView.text = accepted.toString()
        }

        @BindingAdapter("setNumberOfLimit")
        @JvmStatic
        fun setNumberOfLimit(textView: TextView, limit: Int){
            textView.text = limit.toString()
        }
    }
}