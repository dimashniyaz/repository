package com.example.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import com.example.account.databinding.ActivityAdBinding

class AdActivity : AppCompatActivity() {
    private val binding: ActivityAdBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ad)
        val back = binding.backButton4
        back.setOnClickListener {
            finish()
        }
    }
}