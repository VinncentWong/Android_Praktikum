package com.example.p005_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.p005_intent.constant.IntentConstant
import com.example.p005_intent.databinding.ActivityPotatoManBinding

class PotatoManActivity: AppCompatActivity() {

    private lateinit var hair: ImageView

    private lateinit var eyebrows: ImageView

    private lateinit var mustache: ImageView

    private lateinit var beard: ImageView

    private lateinit var binding: ActivityPotatoManBinding

    private lateinit var checkboxHair: CheckBox

    private lateinit var checkboxEyebrows: CheckBox

    private lateinit var checkboxMustache: CheckBox

    private lateinit var checkboxBeards: CheckBox

    private lateinit var emailText: TextView

    private lateinit var passwordText: TextView

    private lateinit var buttonContactUs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityPotatoManBinding.inflate(this.layoutInflater)

        setContentView(binding.root)

        hair = binding.hair
        eyebrows = binding.eyebrows
        mustache = binding.mustache
        beard = binding.beards
        checkboxHair = binding.checkboxRambut
        checkboxHair.isChecked = true
        checkboxMustache = binding.checkboxKumis
        checkboxMustache.isChecked = true
        checkboxBeards = binding.checkboxJanggut
        checkboxBeards.isChecked = true
        checkboxEyebrows = binding.checkboxAlis
        checkboxEyebrows.isChecked = true
        buttonContactUs = binding.contactUs

        emailText = binding.email
        passwordText = binding.password

        intent?.let {
            emailText.text = it.getStringExtra(IntentConstant.emailKey)
            passwordText.text = it.getStringExtra(IntentConstant.passwordKey)
        }

        checkboxHair.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                this.hair.visibility = View.VISIBLE
            } else {
                this.hair.visibility = View.INVISIBLE
            }
        }

        checkboxBeards.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                this.beard.visibility = View.VISIBLE
            } else {
                this.beard.visibility = View.INVISIBLE
            }
        }

        checkboxEyebrows.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                this.eyebrows.visibility = View.VISIBLE
            } else {
                this.eyebrows.visibility = View.INVISIBLE
            }
        }

        checkboxMustache.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                this.mustache.visibility = View.VISIBLE
            } else {
                this.mustache.visibility = View.INVISIBLE
            }
        }

        buttonContactUs.setOnClickListener {
            val intent = Intent(this, ContactUsActivity::class.java)
            intent.putExtra(IntentConstant.emailKey, this.intent.getStringExtra(IntentConstant.emailKey))
            intent.putExtra(IntentConstant.passwordKey, this.intent.getStringExtra(IntentConstant.passwordKey))
            startActivity(intent)
        }
    }
}