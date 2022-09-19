package com.dag.odev2fmss

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.dag.odev2fmss.databinding.ActivityLetsGetStartedBinding

class LetsGetStartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLetsGetStartedBinding
    private lateinit var myIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Status bar hided.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //Layout binding inflated.
        binding = ActivityLetsGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Intent assigned to myIntent.
        myIntent = Intent(this, WelcomeBackActivity::class.java)

        // joinNowButton switches LetsGetStartedActivity to WelcomeBackAtivity
        binding.joinNowButton.setOnClickListener {
            startActivity(myIntent)
        }
    }
}