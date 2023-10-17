package com.example.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import com.example.account.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private val binding: ActivityInfoBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val back = binding.backButton
        back.setOnClickListener{
            finish()
        }
    }
}