package com.example.account


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.account.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private val binding: FragmentChatBinding by viewBinding()
    private var uid = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        var arrow = view.findViewById<ImageView>(R.id.arrow_down)
        val text = view.findViewById<TextView>(R.id.hidden_text)
        var arrow2 = view.findViewById<ImageView>(R.id.arrow_down2)
        val text2 = view.findViewById<TextView>(R.id.hidden_text2)
        var arrow3 = view.findViewById<ImageView>(R.id.arrow_down3)
        val text3 = view.findViewById<TextView>(R.id.hidden_text3)
        var arrow4 = view.findViewById<ImageView>(R.id.arrow_down4)
        val text4 = view.findViewById<TextView>(R.id.hidden_text4)
        var arrow5 = view.findViewById<ImageView>(R.id.arrow_down5)
        val text5 = view.findViewById<TextView>(R.id.hidden_text5)
        val toChat = view.findViewById<ImageView>(R.id.ellipse)
        var down = view.findViewById<RelativeLayout>(R.id.down)
        var down2 = view.findViewById<RelativeLayout>(R.id.down2)
        var down3 = view.findViewById<RelativeLayout>(R.id.down3)
        var down4 = view.findViewById<RelativeLayout>(R.id.down4)
        var down5 = view.findViewById<RelativeLayout>(R.id.down5)
        toChat.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("uid",uid)

            startActivity(intent)
        }
        down.setOnClickListener {
            if (arrow.tag == "down") {
                arrow.setImageResource(R.drawable.up)
                text.visibility = View.VISIBLE
                arrow.tag = "up"
            } else {
                arrow.setImageResource(R.drawable.arrow_down)
                text.visibility = View.GONE
                arrow.tag = "down"
            }
        }
        down2.setOnClickListener {
            if (arrow2.tag == "down") {
                arrow2.setImageResource(R.drawable.up)
                text2.visibility = View.VISIBLE
                arrow2.tag = "up"
            } else {
                arrow2.setImageResource(R.drawable.arrow_down)
                text2.visibility = View.GONE
                arrow2.tag = "down"
            }
        }
        down3.setOnClickListener {
            if (arrow3.tag == "down") {
                arrow3.setImageResource(R.drawable.up)
                text3.visibility = View.VISIBLE
                arrow3.tag = "up"
            } else {
                arrow3.setImageResource(R.drawable.arrow_down)
                text3.visibility = View.GONE
                arrow3.tag = "down"
            }
        }
        down4.setOnClickListener {
            if (arrow4.tag == "down") {
                arrow4.setImageResource(R.drawable.up)
                text4.visibility = View.VISIBLE
                arrow4.tag = "up"
            } else {
                arrow4.setImageResource(R.drawable.arrow_down)
                text4.visibility = View.GONE
                arrow4.tag = "down"
            }
        }
        down5.setOnClickListener {
            if (arrow5.tag == "down") {
                arrow5.setImageResource(R.drawable.up)
                text5.visibility = View.VISIBLE
                arrow5.tag = "up"
            } else {
                arrow5.setImageResource(R.drawable.arrow_down)
                text5.visibility = View.GONE
                arrow5.tag = "down"
            }
        }
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getExtras2(activity?.intent?.extras)
    }
    private fun getExtras2(bundle: Bundle?) {
        var uid0: Int
        bundle?.let {

            if (it.containsKey("uid")) {
                uid0 = it.getInt("uid")
                uid = uid0
            }
        }
    }
}