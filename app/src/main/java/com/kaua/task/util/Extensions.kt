package com.kaua.task.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kaua.task.R
import com.kaua.task.databinding.BottomSheetBinding

fun Fragment.initToolbar(toolbar: Toolbar){
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: Int,
    onClick: () -> Unit = {}
){
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding = BottomSheetBinding.inflate(layoutInflater, null, false)

    binding.title.text = getText(titleDialog ?: R.string.text_title_warning)
    binding.message.text = getText(message)
    binding.button.text=getText(titleButton ?: R.string.text_button_warning)
    binding.button.setOnClickListener {
        onClick()
        bottomSheetDialog.dismiss()
    }

    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()
}
