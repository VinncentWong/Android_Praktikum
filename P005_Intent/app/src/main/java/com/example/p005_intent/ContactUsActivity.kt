package com.example.p005_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.p005_intent.constant.IntentConstant
import com.example.p005_intent.databinding.ActivityContactUsBinding

class ContactUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactUsBinding

    private lateinit var buttonContactUs: Button

    private lateinit var buttonEmailUs: Button

    private lateinit var buttonWebsite: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityContactUsBinding.inflate(this.layoutInflater)

        val root = binding.root

        setContentView(root)

        buttonContactUs = binding.buttonContactUs
        buttonEmailUs = binding.buttonEmailUs
        buttonWebsite = binding.buttonWebsite

        var email: String? = null
        var password: String? = null

        intent?.let {
            email = it.getStringExtra(IntentConstant.emailKey)
            password = it.getStringExtra(IntentConstant.passwordKey)
        }

        buttonContactUs.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${password ?: "0000000000"}"))
            startActivity(implicitIntent)
        }

        buttonEmailUs.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${email ?: "null@gmail.com"}"))
            startActivity(implicitIntent)
        }

        buttonWebsite.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kotlinlang.org/"))
            startActivity(implicitIntent)
        }
    }
}