package ru.mirea.shumikhin.multiactivity

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnToSecondActivity: Button
    private lateinit var fio: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fio = findViewById(R.id.fio)
        btnToSecondActivity = findViewById(R.id.btnToSecond)
        btnToSecondActivity.setOnClickListener{
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", "MIREA - ${fio.text}")
            startActivity(intent)
        }
        Log.i(TAG,"Main: onCreate()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"Main: onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"Main: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"Main: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"Main: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"Main: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"Main: onDestroy()")
    }
}