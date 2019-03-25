package com.beloushkin.learning.android.simplelistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayOfStrings = arrayOf<String>("zero","one","two","three","four","five","six","seven","eight","nine","ten")

        var arrayList: ArrayList<Data> = ArrayList()
        for(i in 0..10) {
            arrayList.add(Data(arrayOfStrings.get(i), i.toString()))
        }

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, arrayOfStrings)
        listView.adapter = adapter


    }
}
