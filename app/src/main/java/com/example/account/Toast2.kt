package com.example.account

import android.app.Activity
import android.view.Gravity
import android.widget.Toast

fun Toast.showCustomToast2(activity: Activity)
{
    val layout = activity.layoutInflater.inflate (
        R.layout.my_toast2,
        activity.findViewById(R.id.toast2),false
    )

    this.apply {
        setGravity(Gravity.TOP, 0,22)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}