package ru.crazy_what.techpark_android_hw_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NumAdapter : RecyclerView.Adapter<NumViewHolder>() {

    companion object {
        private var count: Int = 100
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return NumViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumViewHolder, position: Int) {
        holder.bind(position + 1)
    }

    override fun getItemCount(): Int {
        return count
    }

    fun addInt() {
        notifyItemInserted(count)
        count++
    }

}