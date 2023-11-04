package com.example.a004_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import com.example.a004_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var hair: ImageView

    private lateinit var eyebrows: ImageView

    private lateinit var mustache: ImageView

    private lateinit var beard: ImageView

    private lateinit var binding: ActivityMainBinding

    private lateinit var checkboxHair: CheckBox

    private lateinit var checkboxEyebrows: CheckBox

    private lateinit var checkboxMustache: CheckBox

    private lateinit var checkboxBeards: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityMainBinding.inflate(this.layoutInflater)

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

        val tag = "MainActivity"

        checkboxHair.setOnCheckedChangeListener{ _, isChecked ->
            Log.d(tag, "checkbox hair terpanggil dengan isChecked = $isChecked")
            if(isChecked){
                this.hair.visibility = View.VISIBLE
            } else {
                this.hair.visibility = View.INVISIBLE
            }
        }

        checkboxBeards.setOnCheckedChangeListener{_, isChecked ->
            Log.d(tag, "checkbox beards terpanggil dengan isChecked = $isChecked")
            if(isChecked){
                this.beard.visibility = View.VISIBLE
            } else {
                this.beard.visibility = View.INVISIBLE
            }
        }

        checkboxEyebrows.setOnCheckedChangeListener { _, isChecked ->
            Log.d(tag, "checkbox eyebrows terpanggil dengan isChecked = $isChecked")
            if(isChecked){
                this.eyebrows.visibility = View.VISIBLE
            } else {
                this.eyebrows.visibility = View.INVISIBLE
            }
        }

        checkboxMustache.setOnCheckedChangeListener { _, isChecked ->
            Log.d(tag, "checkbox mustache terpanggil dengan isChecked = $isChecked")
            if(isChecked){
                this.mustache.visibility = View.VISIBLE
            } else {
                this.mustache.visibility = View.INVISIBLE
            }
        }
    }
}