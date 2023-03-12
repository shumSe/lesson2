package ru.mirea.shumikhin.diaolog

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class MyProgressDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Downloading...")
        progressDialog.setCancelable(true)
        return progressDialog
    }
}