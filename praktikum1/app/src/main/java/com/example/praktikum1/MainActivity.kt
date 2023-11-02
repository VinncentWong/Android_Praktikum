package com.example.praktikum1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)
        this.firstName = this.findViewById(R.id.edit_text_1)
        this.lastName = this.findViewById(R.id.edit_text_2)
        this.button = this.findViewById(R.id.button_klik)
        this.textView = this.findViewById(R.id.textView)
        savedInstanceState?.let {
            val firstNameText = savedInstanceState.getCharSequence("firstName")
            val lastNameText = savedInstanceState.getCharSequence("lastName")
            val textViewText = savedInstanceState.getCharSequence("textView")

            this.firstName.text = firstNameText as Editable?
            this.lastName.text = lastNameText as Editable?
            this.textView.text = textViewText
        }
        this.button.setOnClickListener {
            this.textView.text = "Hello ${firstName.text} ${lastName.text}!"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence("firstName", this.firstName.text)
        outState.putCharSequence("lastName", this.lastName.text)
        outState.putCharSequence("textView", this.textView.text)

    }
}