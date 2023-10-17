package com.example.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class NewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        val ad = view.findViewById<ImageView>(R.id.ad)
        ad.setOnClickListener {
            val intent = Intent(context, AdActivity::class.java )
            startActivity(intent)
        }
        return view
    }
}