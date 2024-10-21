package com.example.fragment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración de la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Reserva de Citas"

        // Inicialización del primer fragmento
        if (savedInstanceState == null) {
            val doctorSelectionFragment = DoctorSelectionFragment(sharedViewModel)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, doctorSelectionFragment)
                .commit()
        }
    }
}
