package com.example.finalproject.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.R
import com.example.finalproject.activities.DashboardActivity
import com.example.finalproject.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Assuming the layout XML is activity_main.xml

        // Using findViewById to access the UI elements
        val usernameEditText = findViewById<EditText>(R.id.user_id)
        val passwordEditText = findViewById<EditText>(R.id.enter_pass)
        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            loginViewModel.login(username, password)
        }

        // Observe the login result from the ViewModel
        loginViewModel.loginResult.observe(this) { result ->
            result.onSuccess { keypass ->
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, DashboardActivity::class.java).apply {
                    putExtra("keypass", keypass) // Passing the keypass to the next activity
                }
                startActivity(intent)

                // Optionally, finish the login activity so user can't go back to it
                finish()

            }.onFailure {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
