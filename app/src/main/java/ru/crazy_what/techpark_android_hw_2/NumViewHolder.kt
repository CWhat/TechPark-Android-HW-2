package ru.crazy_what.techpark_android_hw_2

import android.graphics.Color
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class NumViewHolder(itemView: View, private val showNum: NumWorker) : RecyclerView.ViewHolder(itemView) {
    private val view: Button = itemView.findViewById(R.id.text)

    fun bind(num: Int) {
        if (num % 2 == 0)
            view.setTextColor(Color.RED)
        else
            view.setTextColor(Color.BLUE)

        view.text = num.toString()
        view.setOnClickListener {
            showNum.showNumber(num)
        }
    }
}
