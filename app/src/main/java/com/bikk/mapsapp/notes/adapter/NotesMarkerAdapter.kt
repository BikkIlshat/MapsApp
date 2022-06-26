package com.bikk.mapsapp.notes.adapter

import OnNotesClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bikk.mapsapp.R
import com.bikk.mapsapp.databinding.LayoutNotesMarkerListItemBinding
import com.bikk.mapsapp.domain.models.NotesMarker


class CategoryAdapter(private val onNotesClickListener: OnNotesClickListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    var notesMarkerData = listOf<NotesMarker>()
        set(value) {
            field = value
            notifyItemChanged(itemCount)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_notes_marker_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = notesMarkerData[position]
        holder.itemView.setOnClickListener {
            onNotesClickListener.onClick(item)
        }
        holder.bind(onNotesClickListener, item)

    }

    override fun getItemCount() = notesMarkerData.size

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding: LayoutNotesMarkerListItemBinding by viewBinding()

        fun bind(onNotesClickListener: OnNotesClickListener, item: NotesMarker) =
            with(viewBinding) {
                nameMarker.text = item.nameMarker
                address.text = item.address
                longitude.text = item.longitude
                latitude.text = item.latitude
            }
    }
}


