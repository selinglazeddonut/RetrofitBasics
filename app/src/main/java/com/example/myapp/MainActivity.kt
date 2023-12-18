package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainViewModel.post.observe(this){ myPost->
            findViewById<TextView>(R.id.txPost).text= myPost.title

        }
 mainViewModel.isLoading.observe(this){isLoading->
     findViewById<ProgressBar>(R.id.progress).isVisible=isLoading

 }

    }
}