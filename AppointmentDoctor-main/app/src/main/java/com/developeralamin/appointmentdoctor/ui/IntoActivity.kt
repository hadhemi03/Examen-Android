package com.developeralamin.appointmentdoctor.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.developeralamin.appointmentdoctor.R
import com.developeralamin.appointmentdoctor.databinding.ActivityIntoBinding

class IntoActivity : BaseActivity() {

    private lateinit var binding: ActivityIntoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            startBtn.setOnClickListener {
                startActivity(Intent(this@IntoActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}