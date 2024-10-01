package com.example.MyApplication2.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.task_2.R

class FirstFragment : Fragment() {

    private lateinit var editTextLogin: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var textViewResult: TextView

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Find views
        editTextLogin = view.findViewById(R.id.editTextLogin)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        textViewResult = view.findViewById(R.id.textViewResult)

        val buttonLogin: Button = view.findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val login = editTextLogin.text.toString()
            val password = editTextPassword.text.toString()

            if (login == "root" && password == "root") {
                textViewResult.text = "Success"
            } else {
                textViewResult.text = "Invalid login or password"
            }
        }

        val buttonManually: Button = view.findViewById(R.id.buttonManually)
        buttonManually.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.nav_host_fragment, SecondFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        // Navigation button
        val buttonNavigate: Button = view.findViewById(R.id.buttonNavi)
        buttonNavigate.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            Log.d("FirstFragment", "Navigated to SecondFragment")
        }

        return view
    }
}
