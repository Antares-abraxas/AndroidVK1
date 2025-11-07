package com.example.rectlist


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rectlist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spanCount = resources.getInteger(R.integer.columns_count)
        val adapter = RectanglesAdapter()


        binding.recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        binding.recyclerView.adapter = adapter


        viewModel.items.observe(this) { list ->
            adapter.submitList(list)
        }


        binding.addButton.setOnClickListener {
            viewModel.addItem()
        }
    }
}