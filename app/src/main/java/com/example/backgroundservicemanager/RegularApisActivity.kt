package com.example.backgroundservicemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegularApisActivity : AppCompatActivity() {
    private lateinit var toggleButton: ToggleButton
    private var apiJob: Job? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regular_apis)

        toggleButton = findViewById(R.id.toggleButton)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                startApiPolling()
            } else {
                stopApiPolling()
            }
        }
    }
    private fun startApiPolling() {
        apiJob = lifecycleScope.launch {
            repeatApiCall()
        }
    }

    private fun stopApiPolling() {
        apiJob?.cancel()
        apiJob = null
    }

    private suspend fun repeatApiCall() {
        while (isActive) {
            try {
                val response = withContext(Dispatchers.IO) {
                    api.getAircraftDetails()
                }
                updateUI(response)
            } catch (e: Exception) {
                // Handle the error appropriately
                e.printStackTrace()
            }
            delay(5000)  // Delay for 5 seconds
        }
    }

    private fun updateUI(aircraftList: List<Aircraft>) {
        // Update your UI with the new data
        runOnUiThread {
            // For example, update a RecyclerView or TextViews
        }
    }

}