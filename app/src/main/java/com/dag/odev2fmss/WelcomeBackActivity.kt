package com.dag.odev2fmss

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dag.odev2fmss.databinding.ActivityWelcomeBackBinding


class WelcomeBackActivity : AppCompatActivity() {

    private val username = "Alp Tazecicek"
    private val password = "1234"

    private lateinit var binding: ActivityWelcomeBackBinding
    private lateinit var myIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Status bar hided.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //Layout binding inflated.
        binding = ActivityWelcomeBackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Intent assigned to myIntent.
        myIntent = Intent(this, CreateAccountActivity::class.java)

        //createNewAccount textview switches WelcomebackActivity to CreateAccountActivity
        binding.textCreateNewAccount.setOnClickListener {
            startActivity(myIntent)
        }
    }

    override fun onResume() {
        super.onResume()

        //Checking edittexts if they are empty or correct. Showing Toastmessages according to conditions.
        binding.loginButton.setOnClickListener {
            if (username == binding.edittextUsername.text.toString()
                && password == binding.edittextPassword.text.toString()
            ) {
                Toast.makeText(this, "Logged In", Toast.LENGTH_LONG).show()
            } else if (binding.edittextUsername.text.isEmpty() || binding.edittextPassword.text.isEmpty()) {
                Toast.makeText(this, "Username or Password can't leave empty.", Toast.LENGTH_LONG)
                    .show()
            } else Toast.makeText(this, "Wrong Username or Password!", Toast.LENGTH_LONG).show()
        }
    }
}