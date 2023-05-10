package com.example.podcastselection.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.podcastselection.R
import com.example.podcastselection.databinding.ListItemPodcastBinding
import com.example.podcastselection.model.PodcastListItem
import com.squareup.picasso.Picasso

class PodcastViewHolder(
    private val binding: ListItemPodcastBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bind(podcast: PodcastListItem, onPodcastClicked: (podcast: PodcastListItem) -> Unit){
        binding.tvPodcastTitle.text = podcast.title
        binding.tvPodcastCreator.text = podcast.author
        Picasso.get().load(podcast.thumbnail).placeholder(R.drawable.downloading_image).into(binding.ivPodcastIcon)

        binding.tvPodcastFavourite.visibility = if(podcast.isFavourite){
            View.VISIBLE
        } else{
            View.INVISIBLE
        }

        binding.root.setOnClickListener{
            onPodcastClicked(podcast)
        }
    }
}