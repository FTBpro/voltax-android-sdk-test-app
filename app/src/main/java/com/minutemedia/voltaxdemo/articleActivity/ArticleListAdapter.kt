package com.minutemedia.voltaxdemo.articleActivity

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minutemedia.voltaxdemo.R
import com.minutemedia.voltaxsdk.mmVideoView.MMVideoView

class ArticleListAdapter(private val activity: Activity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ARTICLE_TEXT_VIEW_TYPE = 1
    private val ARTICLE_HEADER_VIEW_TYPE = 2
    private val MM_VIDEO_VIEW_TYPE = 3

    class MMVideoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var mmVideoView: MMVideoView = this.view.findViewById(R.id.mm_video_view)
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ARTICLE_HEADER_VIEW_TYPE
            2 -> MM_VIDEO_VIEW_TYPE
            else -> ARTICLE_TEXT_VIEW_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v: View
        when (viewType) {
            ARTICLE_HEADER_VIEW_TYPE -> {
                v = inflater.inflate(R.layout.article_header_item, parent, false)
                return object: RecyclerView.ViewHolder(v) {}
            }
            ARTICLE_TEXT_VIEW_TYPE -> {
                v = inflater.inflate(R.layout.article_text_item, parent, false)
                return object: RecyclerView.ViewHolder(v) {}
            }
            MM_VIDEO_VIEW_TYPE -> {
                v = inflater.inflate(R.layout.article_mm_video_item, parent, false)
                return MMVideoViewHolder(
                    v
                )
            }
            else -> {
                v = View(parent.context)
                return object: RecyclerView.ViewHolder(v) {}
            }
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 2) {
            val mmVideoViewHolder: MMVideoViewHolder = holder as MMVideoViewHolder
            mmVideoViewHolder.mmVideoView.load(this.activity, "01dnemrsc8vhsc1y4t", "01ewfqp7dxa0egkh62")

            // handle click on url
            // if not implemented the url will be open in Custom Tabs by the SDK
//            mmVideoViewHolder.mmVideoView.onUrlClick {
//                // Do something
//            }
        }
    }
}