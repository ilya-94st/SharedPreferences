package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferences.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<FragmentFirstBinding>() {
    override fun getBinding() = R.layout.fragment_first
    var boolean: Boolean = false
    lateinit var sharedPreferences: SharedPreferences
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("Shared", Context.MODE_PRIVATE)
        boolean = sharedPreferences.getBoolean("Boolean", false)
        saveChoose()
        sharedPreference()
    }

    @SuppressLint("CommitPrefEdits")
    fun sharedPreference() {
        binding.button.setOnClickListener {
            val editText = binding.editText.text.toString()
            val checkBox = binding.checkBox.isChecked
            val  editor = sharedPreferences.edit()
            editor.apply {
                putString("editText", editText)
                putBoolean("Boolean", checkBox)
                apply()
            }
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
    fun saveChoose() {
        if (boolean){
           findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}