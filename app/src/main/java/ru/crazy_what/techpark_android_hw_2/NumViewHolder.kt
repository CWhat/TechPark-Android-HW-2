package ru.crazy_what.techpark_android_hw_2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.crazy_what.techpark_android_hw_2.fragments.ShowFragment
import ru.crazy_what.techpark_android_hw_2.fragments.NUM_EXTRA

const val SHOW_NAME = "show"

class NumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val view: Button = itemView.findViewById(R.id.text)

    fun bind(num: Int) {
        if (num % 2 == 0)
            view.setTextColor(Color.RED)
        else
            view.setTextColor(Color.BLUE)

        view.text = num.toString()
        view.setOnClickListener {
            val show = ShowFragment()

            val args = Bundle()
            args.putString(NUM_EXTRA, (it as Button).text.toString())
            show.arguments = args

            (it.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_layout, show, SHOW_NAME)
                    .addToBackStack(SHOW_NAME)
                    .commit()
        }
    }
}
