package com.example.podcastselection.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.podcastselection.databinding.ListItemPodcastBinding
import com.example.podcastselection.model.PodcastListItem


class PodcastListAdapter(
    private val listItems: List<PodcastListItem>,
    private val onPodcastClicked:(podcast:PodcastListItem) -> Unit
):RecyclerView.Adapter<PodcastViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PodcastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemPodcastBinding.inflate(inflater, parent,false)
        return PodcastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PodcastViewHolder, position: Int) {
        val item = listItems[position]
        holder.bind(item, onPodcastClicked)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

}