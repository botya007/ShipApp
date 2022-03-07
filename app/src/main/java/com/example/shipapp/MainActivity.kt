package com.example.shipapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shipapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.OnClick {

    private lateinit var binding: ActivityMainBinding
    private val image = mutableListOf<String>()
    private val list = arrayListOf<String>()
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        sendToSecondActivity()
    }

    private fun sendToSecondActivity() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(KEY, list)
            startActivity(intent)
        }
    }

    private fun initView() {
        adapter = Adapter(fullList())
        adapter.setOnClick(this)
        binding.rvListImage.adapter = adapter
    }

    private fun fullList(): MutableList<String> {
        for (i in 1..4) {
            image.add("https://motgoctroi.com/DienDan/Dd_Doisong/TeBaoGoc/sheep.jpg")
            image.add("https://www.paulienlammers.nl/wp-content/uploads/2020/04/Sheep_square.jpg")
            image.add("https://www.trendsmap.com/ipx/https://pbs.twimg.com/profile_images/378800000049283270/385510ea1d3ea77985f69face5eba1d8.jpeg")
        }
        return image
    }

    companion object {
        const val KEY = "key"
    }

    override fun onClicked(position: String) {
        list.add(position)
    }

    override fun onRemoved(position: String) {
        list.remove(position)
    }
}