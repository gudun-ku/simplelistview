package com.beloushkin.learning.android.simplelistview

import android.content.Context
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayOfStrings = arrayOf<String>("zero","one","two","three","four","five","six","seven","eight","nine","ten")

        var arrayList: ArrayList<Data> = ArrayList()
        for(i in 0..10) {
            arrayList.add(Data(arrayOfStrings[i], "t$i"))
        }

        var adapter: NumberAdapter = NumberAdapter(this, arrayList)
        listView.adapter = adapter
    }
}

class NumberAdapter: BaseAdapter {

    var arrayList: ArrayList<Data> = ArrayList()
    var context: Context?

    constructor(context: Context, arrayList: ArrayList<Data>) {
        this.context = context
        this.arrayList = arrayList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View
        val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var holder: ViewHolder

        if (convertView == null) {
           view = inflater.inflate(R.layout.list_item, parent, false)
           holder = ViewHolder()

           holder.text = view.findViewById(R.id.textView)
           holder.image = view.findViewById(R.id.imageView)

           view.tag = holder
        } else {
           view = convertView
           holder = convertView.tag as ViewHolder
        }

        val textValue = holder.text
        textValue?.text = arrayList[position].textNumber

        var mediaPlayer: MediaPlayer?

        val imageValue = holder.image
        imageValue?.setOnClickListener {
           mediaPlayer = MediaPlayer.create(context,context?.resources!!.getIdentifier(arrayList[position].audioNumber
               , "raw",context?.packageName))
           mediaPlayer?.start()
        }

        return view

    }

    private class ViewHolder {
        var text: TextView? = null
        var image: ImageView? = null
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}
