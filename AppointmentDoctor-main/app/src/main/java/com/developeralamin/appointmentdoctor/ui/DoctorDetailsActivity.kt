package com.developeralamin.appointmentdoctor.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.developeralamin.appointmentdoctor.R
import com.developeralamin.appointmentdoctor.databinding.ActivityDoctorDetailsBinding
import com.developeralamin.appointmentdoctor.domain.DoctorModel

class DoctorDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorDetailsBinding
    private lateinit var item: DoctorModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()
    }

    private fun getBundle() {
        item = intent.getParcelableExtra("object")!!

        binding.apply {
            titleTxt.text = item.Name
            specialTxt.text = item.Special
            patinesTxt.text = item.Patiens
            bioTxt.text = item.Biography
            addressTxt.text = item.Address
            exprienseTxt.text = "${item.Expriense} Years"
            ratingTxt.text = "${item.Rating}"

            backBtn.setOnClickListener { finish() }

            websiteBtn.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(item.Site))
                startActivity(i)
            }

            messageBtn.setOnClickListener {
                val uri = Uri.parse("smsto:${item.Mobile}")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", "How are you")
                startActivity(intent)
            }

            callBtn.setOnClickListener {
                val uri = "tel:${item.Mobile.trim()}"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse(uri))
                startActivity(intent)
            }

            directionBtn.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(item.Location)
                )
                startActivity(intent)
            }

            shareBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT, item.Name)
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "${item.Name} ${item.Address} ${item.Mobile}"
                )
                startActivity(Intent.createChooser(intent, "Choose One"))
            }

            Glide.with(this@DoctorDetailsActivity)
                .load(item.Picture)
                .into(img)
        }
    }

}