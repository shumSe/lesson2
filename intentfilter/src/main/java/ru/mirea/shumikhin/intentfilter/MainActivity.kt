package ru.mirea.shumikhin.intentfilter

import android.content.Intent
import android.net.Uri
import android.net.UrlQuerySanitizer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnGoToUrl: Button
    private lateinit var btnFio: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFio = findViewById(R.id.btnFio)
        btnGoToUrl = findViewById(R.id.btnGoToUrl)

        btnGoToUrl.setOnClickListener{
            val address = Uri.parse("https://mirea.ru/")
            var openLinkIntent = Intent(Intent.ACTION_VIEW, address)
            startActivity(openLinkIntent)
        }

        btnFio.setOnClickListener {
            var shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Шумихин Семён Сергеевич")
            startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"))
        }
    }
}