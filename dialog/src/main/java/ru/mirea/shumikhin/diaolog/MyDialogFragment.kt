package ru.mirea.shumikhin.diaolog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(activity)
        builder.setTitle("Здравствуй МИРЭА!")
            .setMessage("Успех близок?")
            .setIcon(R.mipmap.ic_launcher_round)
            .setPositiveButton("Иду дальше", DialogInterface.OnClickListener { dialog, which ->
                (context as MainActivity).onOkClicked()
                dialog.cancel()
            })
            .setNeutralButton("На паузе", DialogInterface.OnClickListener { dialog, which ->
                (context as MainActivity).onNeutralClicked()
                dialog.cancel()
            })
            .setNegativeButton("Нет", DialogInterface.OnClickListener { dialog, which ->
                (context as MainActivity).onCancelClicked()
                dialog.cancel()
            })
        return builder.create()
    }
}