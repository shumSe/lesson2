package ru.mirea.shumikhin.toastapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalc: Button
    private lateinit var tvOut: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc = findViewById(R.id.btnCalc)
        tvOut = findViewById(R.id.tvOut)
        btnCalc.setOnClickListener {
            var toast = Toast.makeText(applicationContext, "Студент №28 БСБО-06-21 Количество символов - ${tvOut.length()}", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}