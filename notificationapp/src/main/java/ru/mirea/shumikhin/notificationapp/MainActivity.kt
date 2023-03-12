package ru.mirea.shumikhin.notificationapp

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "com.mirea.asd.notification.ANDROID"
    private val permissionCode = 200

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED){
            Log.d(MainActivity::class.java.name.toString(), "Разрешения получены")
        } else {
            Log.d(MainActivity::class.java.name.toString(), "Нет разрешения")
            ActivityCompat.requestPermissions(this, arrayOf(POST_NOTIFICATIONS), permissionCode)
        }
    }

    fun onClickSendNotification(view: View) {
        if (ActivityCompat.checkSelfPermission(
                this,
                POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentText("Congratulation!")
            .setSmallIcon(R.drawable.mirea_gerb)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fill one line...")
            )
            .setContentTitle("Mirea")

        val importance = NotificationManager.IMPORTANCE_DEFAULT
        var channel = NotificationChannel(CHANNEL_ID, "Student FIO Notification", importance)
        var notificationManager = NotificationManagerCompat.from(this)
        notificationManager.createNotificationChannel(channel)
        notificationManager.notify(1, builder.build())
    }

}