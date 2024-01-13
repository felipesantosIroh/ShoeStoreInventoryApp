package com.irohouse.shoestoreinventoryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.irohouse.shoestoreinventoryapp.databinding.FragmentInstructionsScreenBinding

class InstructionsScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentInstructionsScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructions_screen, container, false
        )
        binding.instructionToListButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_instructionsScreenFragment_to_listingScreenFragment)
        )
        return binding.root
    }


}