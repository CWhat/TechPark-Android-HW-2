package ru.crazy_what.techpark_android_hw_2.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.crazy_what.techpark_android_hw_2.IntAdapter
import ru.crazy_what.techpark_android_hw_2.R

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.main_fragment, container, false)

        val list: RecyclerView = view.findViewById(R.id.list)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            list.layoutManager = GridLayoutManager(context, 3)
        else
            list.layoutManager = GridLayoutManager(context, 4)

        val adapter = IntAdapter()
        list.adapter = adapter

        val add: Button = view.findViewById(R.id.add)
        add.setOnClickListener {
            adapter.addInt()
        }

        return view
    }

}