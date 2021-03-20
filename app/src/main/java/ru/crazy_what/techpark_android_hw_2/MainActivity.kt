package ru.crazy_what.techpark_android_hw_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.crazy_what.techpark_android_hw_2.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentByTag("main") == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.main_layout, MainFragment(), "main")
                    .commit()
        }
    }
}