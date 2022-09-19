package com.dag.odev2fmss

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dag.odev2fmss.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var email: String
    private lateinit var username: String
    private lateinit var password: String

    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Status bar hided.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //Layout binding inflated.
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        //Checking edittexts if they are empty. If they are empty a toast message warns user.
        binding.signUpButton.setOnClickListener {
            if (binding.editTextEMail.text.isEmpty()
                || binding.edittextCreateUser.text.isEmpty()
                || binding.editTextPassword.text.isEmpty()
            )
                Toast.makeText(
                    this,
                    "Please fill e-mail, username and password!",
                    Toast.LENGTH_LONG
                ).show()
            //if edittexts are filled else statement assign variables and toast a message that account created to user.
            else {
                email = binding.editTextEMail.text.toString()
                username = binding.edittextCreateUser.text.toString()
                password = binding.editTextPassword.text.toString()

                Toast.makeText(
                    this,
                    "E-Mail: $email\nUsername: $username\nAccount Created!",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }
    }
}