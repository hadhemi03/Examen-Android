package com.developeralamin.appointmentdoctor.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.developeralamin.appointmentdoctor.R
import com.developeralamin.appointmentdoctor.adapter.TopDoctorAdapter
import com.developeralamin.appointmentdoctor.adapter.TopDoctorAdapter2
import com.developeralamin.appointmentdoctor.databinding.ActivityTopDoctorBinding
import com.developeralamin.appointmentdoctor.viewmodel.MainViewModel

class TopDoctorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopDoctorBinding
    private val viewModel = MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDoctors()
    }

    private fun initDoctors() {
        binding.apply {
            topDoctorProgressBar.visibility = View.VISIBLE
            viewModel.doctors.observe(this@TopDoctorActivity, Observer {
                viewTopDoctor.layoutManager =
                    LinearLayoutManager(
                        this@TopDoctorActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                viewTopDoctor.adapter = TopDoctorAdapter2(it)
                topDoctorProgressBar.visibility = View.GONE
            })
        }

        viewModel.loadDoctors()

        binding.backBtn.setOnClickListener { finish() }
    }
}