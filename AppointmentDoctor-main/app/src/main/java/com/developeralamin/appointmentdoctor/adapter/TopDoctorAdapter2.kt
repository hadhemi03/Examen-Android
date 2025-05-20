package com.developeralamin.appointmentdoctor.adapter

import android.content.Context
import android.content.Intent
import android.os.Parcelable.Creator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.developeralamin.appointmentdoctor.databinding.ViewholderCategoryBinding
import com.developeralamin.appointmentdoctor.databinding.ViewholderTopDoctor2Binding
import com.developeralamin.appointmentdoctor.databinding.ViewholderTopDoctorBinding
import com.developeralamin.appointmentdoctor.domain.CategoryModel
import com.developeralamin.appointmentdoctor.domain.DoctorModel
import com.developeralamin.appointmentdoctor.ui.DoctorDetailsActivity
import javax.microedition.khronos.opengles.GL

class TopDoctorAdapter2(val items: MutableList<DoctorModel>) :
    RecyclerView.Adapter<TopDoctorAdapter2.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(val binding: ViewholderTopDoctor2Binding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopDoctorAdapter2.ViewHolder {
        context = parent.context
        val binding =
            ViewholderTopDoctor2Binding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopDoctorAdapter2.ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.nameTxt.text = item.Name
        holder.binding.specialTxt.text = item.Special
        holder.binding.ratingBar.rating = item.Rating.toFloat()
        holder.binding.ratingTxt.text = item.Rating.toString()
        holder.binding.titleTxt.text="Professional Doctor"

        Glide.with(context)
            .load(item.Picture)
            .apply { RequestOptions().transform(CenterCrop()) }
            .into(holder.binding.img)

        holder.binding.makeAppointmentBtn.setOnClickListener {
            val intent = Intent(context, DoctorDetailsActivity::class.java)
            intent.putExtra("object", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}