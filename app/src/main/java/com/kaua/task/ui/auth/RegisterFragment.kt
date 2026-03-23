package com.kaua.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kaua.task.R
import com.kaua.task.databinding.FragmentRegisterBinding
import com.kaua.task.util.initToolbar
import com.kaua.task.util.showBottomSheet

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentRegisterBinding.inflate(inflater, container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
    }

    private fun initListener(){
        binding.button.setOnClickListener { validateData() }
    }

    private fun validateData(){
        val email = binding.email.text.toString().trim()
        val senha = binding.password.text.toString().trim()

        if ( email.isNotBlank() ) {
            if ( senha.isNotBlank() ){
                Toast.makeText(requireContext(), "Tudo OK!", Toast.LENGTH_SHORT).show()
            } else {
                showBottomSheet(message = R.string.password_empty_register)
            }
        } else {
            showBottomSheet(message = R.string.email_empty_register)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}