package com.pguides.exoplayer_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Player.Listener
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerControlView
import java.util.ArrayList

class MainActivity : AppCompatActivity(),Listener  {

    lateinit var  player: SimpleExoPlayer
    lateinit var  PlayerView:PlayerControlView
    lateinit var  mediaItemList: ArrayList<MediaItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaItemList = ArrayList()
        getRadios()
    }

    private fun getRadios(){

        val data = arrayOf(
            "https://us-b4-p-e-ft6-audio.cdn.mdstrm.com/live-audio-aw/5fada54116646e098d97e6a5",
            "https://streaming.gometri.com/stream/8011/stream/1/",
            "https://24973.live.streamtheworld.com/CRP_LI_SC?csegid=20001&dist=20001&ttag=20001",
            "https://19263.live.streamtheworld.com/CRP_MOD_SC?csegid=20001&dist=20001&ttag=20001",
            "https://cast10.plugstreaming.com:2000/sslstream/musik915/stream/1/",
            "http://node-30.zeno.fm/e2kzfpr34d0uv?rj-ttl=5&rj-tok=AAABfiK9BYMAhzmF4JUDwTTzHw",
            "https://20283.live.streamtheworld.com/DISNEY_ARG_BA_SC")
        for (posicion in data.indices){
            val item:MediaItem = MediaItem.Builder()
                .setUri(data.get(posicion))
                .build()
            mediaItemList.add(item)
        }
          PlayerMusic()
    }

    private fun PlayerMusic(){
        player = SimpleExoPlayer.Builder(this).build()
        PlayerView = findViewById(R.id.player)
        val param = PlaybackParameters(1f)
        player.playbackParameters = param
        player.addListener(this)
        player.repeatMode = Player.REPEAT_MODE_ALL
        PlayerView.player = player
        player.addMediaItems(mediaItemList)
        player.prepare()
    }
}