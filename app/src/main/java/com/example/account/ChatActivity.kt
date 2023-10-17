package com.example.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import java.time.LocalDateTime
import java.time.LocalDate
import java.time.LocalTime
import java.time.temporal.ChronoUnit

class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var list = ArrayList<Message>()
    private lateinit var adapter: MessageListAdapter
    private lateinit var db: AppDatabase
    private lateinit var userdao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val back = findViewById<ImageView>(R.id.back_button5)
        back.setOnClickListener {
            finish()
        }
        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "Users"
        ).allowMainThreadQueries().build()
        userdao = db.userDao()
        val uid = intent.getIntExtra("uid", 0)
        val user = userdao.getUserById(uid)
        val send_message: ImageView = findViewById(R.id.button_gchat_send)
        val editText: EditText = findViewById(R.id.edit_gchat_message)
        send_message.setOnClickListener {
            val text = editText.text.toString()
            val time = LocalDateTime.now()
            val month = LocalDate.now().month.toString()
            val day = LocalDate.now().dayOfMonth.toString()
            val time0 = LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString()
            val date = "$day $month, $time0"
            val message = Message(text, date, user)
            if (text != ""){
                list.add(message)
                setupRecycler()
                editText.setText("")
            }
        }
    }

    private fun setupRecycler() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = MessageListAdapter(list) { message ->
        }
        recyclerView.adapter = adapter
    }
}