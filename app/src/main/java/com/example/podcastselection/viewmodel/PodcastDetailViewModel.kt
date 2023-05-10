package com.example.podcastselection.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.podcastselection.model.PodcastListItem
import com.example.podcastselection.model.PodcastRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PodcastDetailViewModel(podcastid:String): ViewModel() {
    //private val podcastRepository = PodcastRepository.get()

    private val _podcast: MutableStateFlow<PodcastListItem?> = MutableStateFlow(null)
    val podcast: StateFlow<PodcastListItem?> = _podcast.asStateFlow()

    init {
        viewModelScope.launch {
            _podcast.value
        }
    }
}