package com.irohouse.shoestoreinventoryapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.irohouse.shoestoreinventoryapp.databinding.FragmentListingScreenBinding
import com.irohouse.shoestoreinventoryapp.databinding.ListItemBinding
import com.irohouse.shoestoreinventoryapp.models.Shoe

class ListingScreenFragment : Fragment() {
    private lateinit var binding: FragmentListingScreenBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing_screen, container, false
        )

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.shoeItemList.observe(viewLifecycleOwner) { list ->
            listShoes(list)
        }

        setHasOptionsMenu(true)
        binding.detailsButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_listingScreenFragment_to_detailFragment)
        )

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        )
    }

    private fun listShoes(listItem: MutableList<Shoe>) {
        listItem.forEach { shoe ->
            val itemBinding: ListItemBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.list_item,
                binding.shoeLlView,
                false
            )

            itemBinding.apply {
                this.shoe = shoe
            }
            itemBinding.shoeNameItemLabel.text = shoe.name
            itemBinding.companyShoeItemText.text = shoe.company
            itemBinding.sizeShoeItemText.text = shoe.size.toString()
            itemBinding.descriptionShoeItemText.text = shoe.description

            binding.shoeLlView.addView(itemBinding.root)
        }
    }
}