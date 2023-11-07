package com.example.p007_asynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.example.p007_asynctask.api.SlotApi
import com.example.p007_asynctask.databinding.ActivityMainBinding
import com.example.p007_asynctask.retrofit.RetrofitApi
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var buttonSpin: Button

    private lateinit var image1: ImageView

    private lateinit var image2: ImageView

    private lateinit var image3: ImageView

    private lateinit var progressBar: ProgressBar

    private lateinit var job: Job

    private var continueSpinning: Boolean = false

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(this.layoutInflater)

        setContentView(binding.root)

        buttonSpin = binding.buttonSpin

        image1 = binding.gambar1

        image2 = binding.gambar2

        image3 = binding.gambar3

        progressBar = binding.progressBar

        buttonSpin.setOnClickListener {

            this.continueSpinning = !this.continueSpinning

            val coroutineErrorHandler = CoroutineExceptionHandler { _, throwable ->
                Toast.makeText(applicationContext, "exception occurred with message ${throwable.message}", Toast.LENGTH_SHORT)
            }

            if(this.continueSpinning){
                runOnUiThread{
                    progressBar.visibility = View.VISIBLE
                }
                job = CoroutineScope(Dispatchers.IO + coroutineErrorHandler).launch {
                    val res = RetrofitApi
                        .INSTANCE
                        .create(SlotApi::class.java)
                        .listSlotImage()
                    runOnUiThread {
                        progressBar.visibility = View.GONE
                        buttonSpin.text = "Stop Spin"
                    }
                    var randomNumber1 = 0
                    var randomNumber2 = 0
                    var randomNumber3 = 0
                    while (true){
                        randomNumber1 = (Math.random() * 3).toInt()
                        randomNumber2 = (Math.random() * 3).toInt()
                        randomNumber3 = (Math.random() * 3).toInt()
                        runOnUiThread {
                            val firstUrl = res[randomNumber1].url.replace("https", "http")
                            val secondUrl = res[randomNumber2].url.replace("https", "http")
                            val thirdUrl = res[randomNumber3].url.replace("https", "http")
                            Log.d(TAG, "url1 = ${firstUrl}, url2 = ${secondUrl}, url3 = ${thirdUrl}")
                            Picasso
                                .get()
                                .load(firstUrl)
                                .into(image1)
                            Picasso
                                .get()
                                .load(secondUrl)
                                .into(image2)
                            Picasso
                                .get()
                                .load(thirdUrl)
                                .into(image3)
                        }
                        delay(500)
                    }
                }
            } else {
                job.cancel()
                runOnUiThread {
                    buttonSpin.text = "Spin"
                }
            }
        }
    }
}