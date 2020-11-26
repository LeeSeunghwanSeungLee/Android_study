package com.seunghwan.develop_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Tag","메세지")//Tag는 찾기 위함, msg는 메시지


        var myName = "test"
        val youName = "test2"

    }
}