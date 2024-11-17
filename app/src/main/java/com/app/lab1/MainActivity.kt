package com.app.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.app.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MixedAdapter()
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        observeViewModel()
    }

    private fun initRecyclerView() {
        binding.rcView.layoutManager = GridLayoutManager(this, 2)
        binding.rcView.adapter = adapter

        binding.buttonAdd.setOnClickListener {
            viewModel.addNextItem()
        }
    }

    private fun observeViewModel() {
        viewModel.itemList.observe(this, Observer { itemList ->
            adapter.submitList(itemList)
        })
    }
}
