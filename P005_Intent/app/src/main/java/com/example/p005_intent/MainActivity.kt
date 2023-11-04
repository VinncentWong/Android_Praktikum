package com.example.p005_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.p005_intent.constant.Identity
import com.example.p005_intent.constant.IntentConstant
import com.example.p005_intent.databinding.ActivityMainBinding
import com.example.p005_intent.extension.content

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var email: EditText

    private lateinit var password: EditText

    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(this.layoutInflater)

        val root = activityMainBinding.root
        setContentView(root)

        this.email = activityMainBinding.inputEmail
        this.password = activityMainBinding.inputPassword
        this.buttonLogin = activityMainBinding.buttonLogin

        buttonLogin.setOnClickListener {
            val emailText = email.content()
            val passwordText = password.content()

            if(emailText != Identity.email || passwordText != Identity.password){
                Toast
                    .makeText(this, "Kredensial tidak valid", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val explicitIntent = Intent(this, PotatoManActivity::class.java)
                explicitIntent.putExtra(IntentConstant.emailKey, emailText)
                explicitIntent.putExtra(IntentConstant.passwordKey, passwordText)
                startActivity(explicitIntent)
            }
        }
    }
}