package ua.opu.gridapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ua.opu.gridapp.databinding.ItemListBinding

class ItemAdapter(
    private val inflater: LayoutInflater,
    private val onClick: (MainActivity.Item) -> Unit) :
    ListAdapter<MainActivity.Item, ItemAdapter.ItemViewHolder>(ItemDiffCallback) {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemListBinding = ItemListBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = getItem(position)
        holder.binding.textView.text = item.number.toString()
        holder.binding.cardView.setCardBackgroundColor(item.color)

        holder.itemView.setOnClickListener {
          item.let(onClick)
        }
    }

    object ItemDiffCallback : DiffUtil.ItemCallback<MainActivity.Item>() {
        override fun areItemsTheSame(
            oldItem: MainActivity.Item,
            newItem: MainActivity.Item
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: MainActivity.Item,
            newItem: MainActivity.Item
        ): Boolean = oldItem == newItem

    }
}