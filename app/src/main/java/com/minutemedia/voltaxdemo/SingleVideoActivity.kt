package com.minutemedia.voltaxdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.minutemedia.voltaxsdk.mmVideoView.MMVideoView

class SingleVideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_video_item)

        val mmVideoView = findViewById<MMVideoView>(R.id.mm_video_view)

        mmVideoView.load(this,"01dnemrsc8vhsc1y4t", "01ewfqp7dxa0egkh62")
    }
}