package com.charlezz.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val TAG = "Charlezz"

    private lateinit var viewModel:MainViewModel

    private lateinit var tv : TextView
    private lateinit var btn : Button
    private lateinit var finish : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            Log.d(TAG, "onCreate - 액티비티 최초 생성")
        }else{
            Log.d(TAG, "onCreate - 액티비티 생성")
        }

        //ViewModel 인스턴스 생성
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        //View 초기화
        setContentView(R.layout.activity_main)
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

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        if(isChangingConfigurations){
            Log.d(TAG,"onDestroy - 액티비티 파괴 후 재생성 예정")
        }else{
            Log.d(TAG,"onDestroy - 액티비티 종료")
        }
    }

    private fun showCount(){
        tv.text = "Count is ${viewModel.count}"
    }


}
