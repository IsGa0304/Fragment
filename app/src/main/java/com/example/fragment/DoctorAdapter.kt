package com.example.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(
    private val doctorList: List<Doctor>,
    private val onDoctorSelected: (Doctor) -> Unit
) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    inner class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewDoctor: ImageView = itemView.findViewById(R.id.imageViewDoctor)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewSpecialty: TextView = itemView.findViewById(R.id.textViewSpecialty)

        fun bind(doctor: Doctor) {
            imageViewDoctor.setImageResource(doctor.imageResId) // Carga la imagen del médico
            textViewName.text = doctor.name
            textViewSpecialty.text = doctor.specialty

            itemView.setOnClickListener {
                onDoctorSelected(doctor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(doctorList[position])
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }
}
