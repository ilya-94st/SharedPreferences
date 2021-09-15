package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferences.databinding.FragmentSecondBinding


class SecondFragment : BaseFragment<FragmentSecondBinding>() {
    lateinit var sharedPreferences: SharedPreferences
    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
sharedPreferences = requireContext().getSharedPreferences("Shared", Context.MODE_PRIVATE)
      getValueShared()
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    fun getValueShared() {
        val name = sharedPreferences.getString("editText", "")
        binding.textView.text = name
        binding.button2.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor?.clear()
            editor?.apply()
            findNavController().navigateUp()
        }
    }
    override fun getBinding() = R.layout.fragment_second
}