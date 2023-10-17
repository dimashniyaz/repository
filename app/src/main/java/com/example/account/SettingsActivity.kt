package com.example.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import com.example.account.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private val binding: ActivitySettingsBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val uid = intent.getIntExtra("uid",0)
        var updated_password = intent.getStringExtra("updated_password")
        val back = binding.backButton2
        back.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java )
            intent.putExtra("uid",uid)
            intent.putExtra("updated_password",updated_password)
            startActivity(intent)
        }
        val change_password = binding.changePassword
        change_password.setOnClickListener {
            val intent = Intent(this, PasswordActivity::class.java )
            intent.putExtra("uid",uid)
            startActivity(intent)
        }
    }
}