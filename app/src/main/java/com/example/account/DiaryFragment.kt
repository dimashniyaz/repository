package com.example.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DiaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_diary,container,false)
        val textView = view.findViewById<TextView>(R.id.kazakh)
        textView.setOnClickListener{
            if (textView.lineCount == 1){
                textView.maxLines = 2
            }else {
                textView.maxLines = 1
            }
        }
        val textView2 = view.findViewById<TextView>(R.id.kazakh2)
        textView2.setOnClickListener{
            if (textView2.lineCount == 1){
                textView2.maxLines = 2
            }else {
                textView2.maxLines = 1
            }
        }
        return view
    }
}
