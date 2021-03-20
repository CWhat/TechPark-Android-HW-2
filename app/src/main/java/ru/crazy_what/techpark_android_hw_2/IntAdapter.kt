package ru.crazy_what.techpark_android_hw_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class IntAdapter : RecyclerView.Adapter<IntViewHolder>() {

    companion object {
        private var count: Int = 100
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return IntViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
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