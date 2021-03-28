package ru.crazy_what.techpark_android_hw_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.crazy_what.techpark_android_hw_2.fragments.MainFragment

private const val MAIN_NAME = "main"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentByTag(MAIN_NAME) == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.main_layout, MainFragment(), MAIN_NAME)
                    .commit()
        }
    }

}