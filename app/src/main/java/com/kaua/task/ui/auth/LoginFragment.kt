package com.kaua.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.kaua.task.R
import com.kaua.task.databinding.FragmentLoginBinding
import com.kaua.task.util.showBottomSheet

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener(){
        binding.buttonLogin.setOnClickListener {
           validateData()
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnRecover.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
        }
    }

    private fun validateData(){
        var email = binding.email.text.toString().trim()
        var senha = binding.password.text.toString().trim()

        if (email.isNotBlank()){

            if (senha.isNotBlank()) {
                findNavController().navigate((R.id.action_global_homeFragment))
            } else {
                showBottomSheet(message = R.string.password_empty)
            }
        } else  {
            showBottomSheet(message = R.string.email_empty)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}