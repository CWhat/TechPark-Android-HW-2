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
private const val DEFAULT_VALUE = -1

class ShowFragment : Fragment() {
    private var num: Int = DEFAULT_VALUE

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.show_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView: TextView = view.findViewById(R.id.num)
        num = savedInstanceState?.getInt(NUM_EXTRA)
                ?: (arguments?.getInt(NUM_EXTRA, DEFAULT_VALUE) ?: DEFAULT_VALUE)

        textView.text = num.toString()

        if (num % 2 == 0)
            textView.setTextColor(Color.RED)
        else
            textView.setTextColor(Color.BLUE)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(NUM_EXTRA, num)
    }

}