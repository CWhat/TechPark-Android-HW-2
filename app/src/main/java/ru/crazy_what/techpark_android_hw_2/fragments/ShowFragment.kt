package ru.crazy_what.techpark_android_hw_2.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.crazy_what.techpark_android_hw_2.R

const val NUM_EXTRA = "num"
const val DEFAULT_VALUE = "-1"

class ShowFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val textView = inflater.inflate(R.layout.show_fragment, container, false) as TextView

        val str = arguments?.getString(NUM_EXTRA, DEFAULT_VALUE) ?: DEFAULT_VALUE
        textView.text = str

        if (str.toInt() % 2 == 0)
            textView.setTextColor(Color.RED)
        else
            textView.setTextColor(Color.BLUE)

        return textView
    }
}