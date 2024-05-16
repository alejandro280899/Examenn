package com.example.examen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    var meters: String? = null
        set(value) {
            field = value
            convertToMeters()
        }

    private fun convertToMeters() {
        val meters = meters?.toDoubleOrNull() ?: 0.0
        _result.value = String.format("%.2f metros", meters)
    }

    fun convertToKilometers() {
        val meters = meters?.toDoubleOrNull() ?: 0.0
        val kilometers = meters / 1000.0
        _result.value = String.format("%.2f kilómetros", kilometers)
    }

    fun convertToCentimeters() {
        val meters = meters?.toDoubleOrNull() ?: 0.0
        val centimeters = meters * 100.0
        _result.value = String.format("%.2f centímetros", centimeters)
    }

    fun convertToMillimeters() {
        val meters = meters?.toDoubleOrNull() ?: 0.0
        val millimeters = meters * 1000.0
        _result.value = String.format("%.2f milímetros", millimeters)
    }
}