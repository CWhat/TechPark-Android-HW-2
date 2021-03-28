package ru.crazy_what.techpark_android_hw_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NumAdapter(private val showNum: NumWorker) : RecyclerView.Adapter<NumViewHolder>() {
    private var count = showNum.getCount()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return NumViewHolder(view, showNum)
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
        showNum.setCount(count)
    }

}