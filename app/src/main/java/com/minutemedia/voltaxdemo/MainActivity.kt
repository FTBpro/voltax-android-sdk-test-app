package com.minutemedia.voltaxdemo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.minutemedia.voltaxdemo.articleActivity.ArticleActivity
import com.minutemedia.voltaxsdk.MMSdkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MMSdkManager.setTestMode(true)

        val listView = findViewById<ListView>(R.id.main_list_view)
        val items = ArrayList<MenuItem>()

        items.add(MenuItem("MMVideoView single item", SingleVideoActivity::class.java))
        items.add(MenuItem("MMVideoView in RecycleView", ArticleActivity::class.java))

        listView.adapter = MainMenuListAdapter(items)
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                openActivity(items[position].openActivityClass)
            }
    }

    private fun openActivity(cls: Class<*>?) {
        cls?.let {
            val intent = Intent(this, cls)
            startActivity(intent)
        }
    }

    class MenuItem(val text: String, val openActivityClass: Class<*>?)

    class MainMenuListAdapter (private val items: ArrayList<MenuItem>) : BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val item = items[position]

            val returnView: View = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.main_menu_list_view_item, null)

            val textView = returnView.findViewById<TextView>(R.id.main_menu_item_text)

            textView.text = item.text

            return returnView
        }

        override fun getItem(position: Int): Any {
            return this.items[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return this.items.size
        }

    }
}