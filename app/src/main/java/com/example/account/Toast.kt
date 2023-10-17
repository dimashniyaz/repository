import android.app.Activity
import android.view.Gravity
import android.widget.Toast
import com.example.account.R

fun Toast.showCustomToast(activity: Activity) {
    val layout = activity.layoutInflater.inflate(R.layout.my_toast, activity.findViewById(R.id.toast), false)
    this.apply {
        setGravity(Gravity.TOP, 0, 22)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}