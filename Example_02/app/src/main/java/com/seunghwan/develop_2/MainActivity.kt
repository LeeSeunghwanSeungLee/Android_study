package com.seunghwan.develop_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var test_data=listOf("--선택하세요--","1월","2월","3월","4월","5월","6월")
        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,test_data)
        spinner.adapter=adapter

        setFragment()
    }

    fun setFragment(){
        val listFragment: ListFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }
}