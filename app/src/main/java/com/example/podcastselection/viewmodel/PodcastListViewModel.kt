package com.example.podcastselection.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.podcastselection.model.PodcastListItem
import com.example.podcastselection.model.PodcastRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "PodcastListViewModel"

/*
* View model for the list fragment, when created will fetch and cache the remote data
*/
class PodcastListViewModel: ViewModel() {
    private val podcastRepository = PodcastRepository()

    private val _podcastListItems: MutableStateFlow<List<PodcastListItem>> =
        MutableStateFlow(emptyList())
    val podcastListItems: StateFlow<List<PodcastListItem>>
        get() = _podcastListItems.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val items = podcastRepository.fetchPodcasts()
                Log.d(TAG,"Items received: $items" )
                _podcastListItems.value = items
            }catch (ex:Exception){
                Log.e(TAG, "Failed to fetch list items", ex)
            }
        }
    }
}