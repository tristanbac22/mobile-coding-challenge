package com.example.podcastselection.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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
    private lateinit var podcast: Podcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        podcast = Podcast(
            id = "jakgnbkjasengi3",
            title = "Avenue",
            author = "John Doe",
            fullImage = "url_fullsize",
            thumbnail ="urk_thumbnail"
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

        }
    }


}