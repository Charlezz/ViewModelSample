package com.charlezz.viewmodelsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    private lateinit var tv : TextView
    private lateinit var btn : Button
    private lateinit var finish : Button
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = viewModelProvider.get(MainViewModel::class.java)

        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.btn)
        finish = findViewById(R.id.finish)
        btn.setOnClickListener {
            viewModel.count++
            showCount()
        }
        finish.setOnClickListener {
            finish()
        }
        showCount()
    }
    private fun showCount(){
        tv.text = "Count is ${viewModel.count}"
    }
}