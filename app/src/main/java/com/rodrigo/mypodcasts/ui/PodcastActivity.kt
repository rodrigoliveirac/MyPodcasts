package com.rodrigo.mypodcasts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rodrigo.mypodcasts.R
import com.rodrigo.mypodcasts.repository.ItunesRepo
import com.rodrigo.mypodcasts.service.ItunesService
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class PodcastActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podcast)

        val itunesService = ItunesService.instance
        val itunesRepo = ItunesRepo(itunesService)

        GlobalScope.launch {

            withContext(Dispatchers.Default) {
                val results = itunesRepo.searchByTerm("Android Developer")
                Log.i(TAG, "Results = ${results.body()}")
            }

        }
    }
}