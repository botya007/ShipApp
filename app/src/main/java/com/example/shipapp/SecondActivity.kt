package com.example.shipapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shipapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = intent.getStringArrayListExtra(MainActivity.KEY)
        binding.recycler.adapter = list?.let { Adapter(it) }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}