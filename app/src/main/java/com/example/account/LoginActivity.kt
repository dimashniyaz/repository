package com.example.account

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.viewbinding.library.activity.viewBinding
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.account.databinding.ActivityLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import showCustomToast

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by viewBinding()
    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val viewModel: NewViewModel = ViewModelProvider(this).get(NewViewModel::class.java)
        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "Users"
        ).allowMainThreadQueries().build()
        val users = ArrayList<User>()
        val user1 = User(
            1,
            R.drawable.ic_logo_main,
            "Ниязбеков Динмухамед Ерланович",
            "dimashgunner",
            "Dimash"
        )
        val user2 = User(2, R.drawable.chat, "Full Name", "user", "password")
        val user3 = User(3, R.drawable.ic_logo_main, "Example", "1", "2")

        users.add(user1)
        users.add(user2)
        users.add(user3)
        GlobalScope.launch {
            userDao = db.userDao()
            userDao.insertAll(user1)
            userDao.insertAll(user2)
            userDao.insertAll(user3)
        }
        var uid = intent.getIntExtra("uid", 0)
        val updated_password = intent.getStringExtra("updated_password")
        if (uid != 0 && updated_password != "") {
            val new_user = db.userDao().getUserById(uid)
            new_user.password = updated_password
            userDao = db.userDao()
            userDao.updateUser(new_user)
        }

        val username = binding.username
        val password = binding.password
        val login_btn = binding.login
        val new_list: List<User> = userDao.getAll()

        login_btn.setOnClickListener {
            uid = 0
            var isCorrect = false
            val input_user = username.text.toString()
            val input_password = password.text.toString()
            var sent_fullname = ""
            var sent_picture = 0
            for (i in new_list) {
                if ((i.username == input_user) && (i.password == input_password)) {
                    isCorrect = true
                    sent_fullname = i.full_name
                    sent_picture = i.picture
                    uid = i.uid
                }
            }

            if (isCorrect) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("full_name", sent_fullname)
                intent.putExtra("picture", sent_picture)
                intent.putExtra("uid", uid)
                intent.putExtra("username", input_user)
                startActivity(intent)
            } else {
                Toast(this).showCustomToast(this)
            }
        }

        val card = binding.cardView
        card.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
        val vis_button = binding.noEye
        vis_button.setOnClickListener {
            if (vis_button.tag == "no_eye") {
                vis_button.setImageResource(R.drawable.eye)
                password.transformationMethod = PasswordTransformationMethod()
                password.setSelection(password.text.length)
                vis_button.tag = "eye"
            } else {
                vis_button.setImageResource(R.drawable.no_eye)
                password.transformationMethod = null
                password.setSelection(password.text.length)
                vis_button.tag = "no_eye"
            }
        }

        val text = binding.someId
        text.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialogFragment(R.layout.bottom_sheet_dialog_layout)
        dialog.setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
        val cross = dialog.view?.findViewById<ImageView>(R.id.cross)
        cross?.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show(supportFragmentManager, "tag")
    }
}
