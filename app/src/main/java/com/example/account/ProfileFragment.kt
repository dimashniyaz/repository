package com.example.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProfileFragment : Fragment() {

    private lateinit var full_name: TextView
    private lateinit var profile_picture: ImageView
    private var uid = 0
    var updated_password:String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        full_name  = view.findViewById(R.id.full_name)
        profile_picture = view.findViewById(R.id.profile_picture)

        val logout_btn = view.findViewById<ImageView>(R.id.log_out)
        logout_btn.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            intent.putExtra("updated_password",updated_password)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }
        val pay_button = view.findViewById<CardView>(R.id.pay_button)
        pay_button.setOnClickListener{
            showBottomSheetDialog2()
        }
        val toSettings = view.findViewById<CardView>(R.id.cardView_settings)
        toSettings.setOnClickListener{
            val intent = Intent(context, SettingsActivity::class.java )
            intent.putExtra("uid",uid)
            startActivity(intent)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getExtras(activity?.intent?.extras)
    }

    private fun getExtras(bundle: Bundle?){
        var name: String?
        var picture: Int
        var uid0: Int
        var password: String?
        bundle?.let {
            if (it.containsKey("full_name")) {
                name = it.getString("full_name")
                full_name.text = name
            }
            if (it.containsKey("picture")) {
                picture = it.getInt("picture", 0)
                profile_picture.setImageResource(picture)
            }
            if (it.containsKey("uid")) {
                uid0 = it.getInt("uid")
                uid = uid0
            }
            if (it.containsKey("updated_password")) {
                password = it.getString("updated_password")
                updated_password = password.toString()
            }
        }
    }
    fun showBottomSheetDialog2(){
        val dialog = BottomSheetDialogFragment(R.layout.bottom_sheet_dialog2)
        dialog.setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
        val cross =dialog.view?.findViewById<ImageView>(R.id.cross2)
        cross?.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show(parentFragmentManager, "tag")
    }
}