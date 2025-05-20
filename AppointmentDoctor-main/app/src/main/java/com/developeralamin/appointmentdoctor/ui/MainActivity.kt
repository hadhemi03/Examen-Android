package com.developeralamin.appointmentdoctor.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.developeralamin.appointmentdoctor.R
import com.developeralamin.appointmentdoctor.adapter.CategoryAdapter
import com.developeralamin.appointmentdoctor.adapter.TopDoctorAdapter
import com.developeralamin.appointmentdoctor.databinding.ActivityMainBinding
import com.developeralamin.appointmentdoctor.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategory()
        initDoctors()

    }

    private fun initDoctors() {
        binding.apply {
            viewTopDoctorsProgressbar.visibility = View.VISIBLE
            viewModel.doctors.observe(this@MainActivity, Observer {
                viewTopDoctors.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                viewTopDoctors.adapter = TopDoctorAdapter(it)
                viewTopDoctorsProgressbar.visibility = View.GONE
            })

            viewModel.loadDoctors()

            doctorListsAll.setOnClickListener {
                startActivity(Intent(this@MainActivity, TopDoctorActivity::class.java))
            }
        }
    }

    private fun initCategory() {
        binding.viewCategoryProgressbar.visibility = View.VISIBLE
        viewModel.category.observe(this, Observer {
            binding.viewCategory.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.viewCategory.adapter = CategoryAdapter(it)
            binding.viewCategoryProgressbar.visibility = View.GONE
        })

        viewModel.loadCategory()
    }
}