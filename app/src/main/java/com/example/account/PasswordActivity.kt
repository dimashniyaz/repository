package com.example.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.room.Room
import com.example.account.databinding.ActivityPasswordBinding

class PasswordActivity : AppCompatActivity() {
    private val binding: ActivityPasswordBinding by viewBinding()
    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        val back = binding.backButton3
        var newPass: String? = null

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "Users"
        ).allowMainThreadQueries().build()

        back.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        val current_username = intent.getStringExtra("username")
        val confirm = binding.confirm
        val uid = intent.getIntExtra("uid",0)
        var new_user = db.userDao().getUserById(uid)

        binding.newPass.doOnTextChanged { text, start, before, count ->
            newPass = text.toString()
        }
        confirm.setOnClickListener {
            val current = binding.currentPass.text.toString()
            val new_pass = binding.newPass.text.toString()
            val new_pass2 = binding.newPass2.text.toString()
            if ( (new_user.password == current) && (new_pass == new_pass2)) {
                new_user.password = new_pass
                val userDao = db.userDao()
                userDao.updateUser(new_user)
                var updated_password = userDao.getUserById(uid).password
                Toast(this).showCustomToast2(this)
                val intent = Intent(this,SettingsActivity::class.java)
                intent.putExtra("uid",uid)
                intent.putExtra("updated_password",updated_password)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
