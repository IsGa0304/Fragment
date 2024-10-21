package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ConfirmationFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)


        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        sharedViewModel.selectedDoctor.observe(viewLifecycleOwner) { doctor ->
            view.findViewById<TextView>(R.id.textViewDoctor).text = doctor.name
            view.findViewById<TextView>(R.id.textViewSpecialty).text = doctor.specialty
        }

        sharedViewModel.appointmentDate.observe(viewLifecycleOwner) { appointmentDate ->
            view.findViewById<TextView>(R.id.textViewDate).text = appointmentDate
        }


        view.findViewById<Button>(R.id.buttonConfirmAppointment).setOnClickListener {
            Toast.makeText(context, "Cita confirmada", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
