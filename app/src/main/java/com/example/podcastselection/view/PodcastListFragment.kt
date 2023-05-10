package com.example.podcastselection.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.podcastselection.databinding.FragmentPodcastListBinding
import com.example.podcastselection.viewmodel.PodcastListViewModel
import kotlinx.coroutines.launch

/* Fragment Class that is responsible for displaying the list of podcasts
* The Fragment consists of a title for the application with a Recyclerview implement the list
* req. needs to support pagination of 10 elements at a time
* */

private const val TAG = "PodcastListFragment"
class PodcastListFragment: Fragment() {
    //private view binding that can be reassigned
    private var _binding: FragmentPodcastListBinding? = null
    private val binding
        get() = checkNotNull(_binding){
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val podcastListViewModel: PodcastListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPodcastListBinding.inflate(inflater,container,false)
        binding.rvPodcast.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewLifecycleOwner.lifecycleScope.launch{
            //check for update everytime fragment goes from created to started
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                podcastListViewModel.podcastListItems.collect(){items ->
                    binding.rvPodcast.adapter = PodcastListAdapter(items){ podcast ->
                        findNavController().navigate(
                            PodcastListFragmentDirections.showPodcastDetail(podcast)
                        )
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}