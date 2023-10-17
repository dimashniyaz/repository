package com.example.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MessageListAdapter(private val messageList: List<Message>,private val onItemClicked: ((Message) -> Unit)):
    RecyclerView.Adapter<MessageListAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date_time: TextView = itemView.findViewById(R.id.date_time)
        val root: CardView = itemView.findViewById(R.id.card_gchat_message_me)
        var message: TextView = itemView.findViewById(R.id.message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_message, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messageList[position]
        holder.message.text = message.text
        holder.date_time.text= message.date_time.toString()
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
}