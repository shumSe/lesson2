package ru.mirea.shumikhin.multiactivity

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import ru.mirea.shumikhin.multiactivity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fio = intent.getSerializableExtra("key") as? String

        binding.tvOut.text = fio

        binding.btnToFirst.setOnClickListener {
            finish()
        }
        Log.i(TAG,"Second: onCreate()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(ContentValues.TAG,"Second: onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.i(ContentValues.TAG,"Second: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(ContentValues.TAG,"Second: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(ContentValues.TAG,"Second: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(ContentValues.TAG,"Second: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ContentValues.TAG,"Second: onDestroy()")
    }

}