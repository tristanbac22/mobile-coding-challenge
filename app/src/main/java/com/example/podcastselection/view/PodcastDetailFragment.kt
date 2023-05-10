package com.example.podcastselection.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.podcastselection.databinding.FragmentPodcastDetailBinding
import com.example.podcastselection.model.api.Podcast

/**
 * Fragment responsible for providing the detailed description of a selected podcast,
 * the user can click the favorite to toggle the favorite property
 */
class PodcastDetailFragment: Fragment() {
    private var _binding: FragmentPodcastDetailBinding ?= null
    private val binding
        get() = checkNotNull(_binding){
            "Cannot access Binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPodcastDetailBinding.inflate(inflater,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnFavourite.setOnClickListener {

            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}