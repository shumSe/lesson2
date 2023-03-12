package ru.mirea.shumikhin.diaolog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickShowDialog(view: View){
        val dialogFragment = MyDialogFragment()
        dialogFragment.show(supportFragmentManager, "mirea")
    }

    fun onOkClicked(){
        Toast.makeText(applicationContext,"Вы выбрали кнопку \"Иду дальше\"!", Toast.LENGTH_LONG).show()
    }

    fun onCancelClicked(){
        Toast.makeText(applicationContext,"Вы выбрали кнопку \"Нет\"!", Toast.LENGTH_LONG).show()
    }

    fun onNeutralClicked(){
        Toast.makeText(applicationContext,"Вы выбрали кнопку \"На паузе\"!", Toast.LENGTH_LONG).show()
    }

    fun onClickShowTimeDialog(view: View){
        val dialogFragment = MyTimeDialogFragment()
        dialogFragment.show(supportFragmentManager, "mirea")
    }

    fun onClickShowDateDialog(view: View){
        val dialogFragment = MyDateDialogFragment()
        dialogFragment.show(supportFragmentManager, "mirea")
    }

    fun onClickShowProgressDialog(view: View){
        val dialogFragment = MyProgressDialogFragment()
        dialogFragment.show(supportFragmentManager, "mirea")
        GlobalScope.launch{
            delay(4000)
            if(supportFragmentManager.findFragmentByTag("mirea") != null){
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Загрузка завершена",
                    Snackbar.LENGTH_SHORT
                ).show()
                dialogFragment.dismiss()
            }
        }
    }
}