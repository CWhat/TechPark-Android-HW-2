package ru.crazy_what.techpark_android_hw_2.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.crazy_what.techpark_android_hw_2.NumAdapter
import ru.crazy_what.techpark_android_hw_2.NumWorker
import ru.crazy_what.techpark_android_hw_2.R

private const val SHOW_NAME = "show"

private const val COLUMNS_IN_PORTRAIT = 3
private const val COLUMNS_IN_LANDSCAPE = 4

private const val SETTINGS_NAME = "settings"
private const val PREF_COUNT = "count"
private const val DEFAULT_COUNT = 100

class MainFragment : Fragment(), NumWorker {
    private var count = DEFAULT_COUNT

    private val settings by lazy {
        activity?.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val list: RecyclerView = view.findViewById(R.id.list)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            list.layoutManager = GridLayoutManager(context, COLUMNS_IN_PORTRAIT)
        else
            list.layoutManager = GridLayoutManager(context, COLUMNS_IN_LANDSCAPE)

        count = savedInstanceState?.getInt(PREF_COUNT)
                ?: (settings?.getInt(PREF_COUNT, DEFAULT_COUNT) ?: DEFAULT_COUNT)

        val adapter = NumAdapter(this)
        list.adapter = adapter

        val add: Button = view.findViewById(R.id.add)
        add.setOnClickListener {
            adapter.addInt()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(PREF_COUNT, count)
    }

    override fun showNumber(num: Int) {
        val show = ShowFragment()

        val args = Bundle()
        args.putInt(NUM_EXTRA, num)
        show.arguments = args

        activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_layout, show, SHOW_NAME)
                ?.addToBackStack(SHOW_NAME)
                ?.commit()
    }

    override fun getCount(): Int = count

    override fun setCount(count: Int) {
        this.count = count
        val editor = settings?.edit()
        editor?.putInt(PREF_COUNT, count)
        editor?.apply()
    }

}