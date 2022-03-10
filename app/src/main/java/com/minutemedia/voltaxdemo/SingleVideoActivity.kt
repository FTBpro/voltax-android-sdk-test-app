package com.minutemedia.voltaxdemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.minutemedia.voltaxsdk.mmVideoView.MMVideoView
import kotlinx.android.synthetic.main.activity_single_video_item.*

class SingleVideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_video_item)

        val mmVideoView = findViewById<MMVideoView>(R.id.mm_video_view)
        mmVideoView.setOnLoadListener {
            loaded_text.text = "Player loaded!"
        }

        mmVideoView.setOnErrorListener {
            println("Error: ${it.message}")
        }

        findViewById<Button>(R.id.play_player_btn).setOnClickListener {
            mmVideoView.play()
        }

        findViewById<Button>(R.id.pause_player_btn).setOnClickListener {
            mmVideoView.pause()
        }

        // handle click on url
        // if not implemented the url will be open in Custom Tabs by the SDK
//        mmVideoView.onUrlClick {
//            // Do something
//        }
    }

    override fun onResume() {
        super.onResume()

        loaded_text.text = "Resume"

        val mmVideoView = findViewById<MMVideoView>(R.id.mm_video_view)
        mmVideoView.load(this,"01fqtx7qpnayc5zbtw", "01ewfqp7dxa0egkh62")
//        mmVideoView.load(this,"01dnemrsc8vhsc1y4t", "01ewfqp7dxa0egkh62")
    }

    override fun onPause() {
        val mmVideoView = findViewById<MMVideoView>(R.id.mm_video_view)
        mmVideoView.release()

        loaded_text.text = "Paused"

        super.onPause()
    }
}