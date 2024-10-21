package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DoctorSelectionFragment(private val sharedViewModel: SharedViewModel) : Fragment() {
    private lateinit var doctorAdapter: DoctorAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_doctor_selection, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewDoctors)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Suponiendo que tienes una lista de médicos
        val doctorList = listOf(
            Doctor("Dr. Amadeo López", "Cardiología", "Lunes a Viernes 9 AM - 5 PM", R.drawable.doctor_amadeo),
            Doctor("Dra. Ana Gómez", "Pediatría", "Lunes a Jueves 10 AM - 4 PM", R.drawable.doctora_ana),
            Doctor("Dr. Carlos González", "Dermatología", "Martes y Jueves 11 AM - 3 PM", R.drawable.doctor_carlos),
            Doctor("Dra. Laura Isabel Martínez", "Ginecología", "Lunes a Viernes 8 AM - 3 PM", R.drawable.doctora_laura),
            Doctor("Dra. Silvia Fernández", "Oftalmología", "Martes y Miércoles 9 AM - 2 PM", R.drawable.doctora_silvia),
            Doctor("Dr. Felipe Ramírez", "Neurología", "Miércoles a Viernes 1 PM - 6 PM", R.drawable.doctor_felipe)

        )

        doctorAdapter = DoctorAdapter(doctorList) { doctor ->
            // Actualiza el SharedViewModel con el médico seleccionado
            sharedViewModel.selectDoctor(doctor)

            // Crea el nuevo fragmento AppointmentDetailsFragment
            val appointmentDetailsFragment = AppointmentDetailsFragment()

            // Crea un Bundle y pasa el Doctor seleccionado al siguiente fragmento
            val args = Bundle()
            args.putParcelable("selectedDoctor", doctor)
            appointmentDetailsFragment.arguments = args

            // Navega al AppointmentDetailsFragment
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, appointmentDetailsFragment)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = doctorAdapter

        return view
    }
}
