package com.islas.codechallengenov.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.islas.codechallengenov.R
import com.islas.codechallengenov.domain.IMarvelApiImpl
import com.islas.codechallengenov.domain.utils.ClientHttp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.body)

        val list = IMarvelApiImpl().makeCall()
//        if(list?.status.equals("OK")){
//            textView.text = list?.code.toString()
//        }
        //makeCall()
        //println(ClientHttp.BASE_URL+"/v1/public/characters?limit=50&ts="+ClientHttp.timeStamp+"&apikey="+ClientHttp.API_KEY+"&hash="+ClientHttp.hash())
    }
}
