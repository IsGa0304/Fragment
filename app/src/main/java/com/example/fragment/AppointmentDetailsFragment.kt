package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment

class AppointmentDetailsFragment : Fragment() {

    private lateinit var selectedDoctor: Doctor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        selectedDoctor = arguments?.getParcelable("selectedDoctor") ?: Doctor("", "", "", 0) // Valores por defecto
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_appointment_details, container, false)

        val datePicker: DatePicker = view.findViewById(R.id.datePicker)
        val timePicker: TimePicker = view.findViewById(R.id.timePicker)

        view.findViewById<Button>(R.id.buttonConfirm).setOnClickListener {

            val date = datePicker.dayOfMonth
            val month = datePicker.month
            val year = datePicker.year
            val hour = timePicker.hour
            val minute = timePicker.minute


            val confirmationFragment = ConfirmationFragment()
            val args = Bundle()
            args.putParcelable("selectedDoctor", selectedDoctor)
            args.putString("appointmentDate", "$year-${month + 1}-$date $hour:$minute") // Formato de fecha
            confirmationFragment.arguments = args

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, confirmationFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}

