package io.ainsigne.stores.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.ainsigne.repository.shop.model.Shop

import io.ainsigne.stores.databinding.ItemStoreBinding

class StoreCenterAdapter(
    private var items: List<Shop>,
    private val onClick: (Shop) -> Unit
) : RecyclerView.Adapter<StoreCenterAdapter.StoreViewHolder>() {

    class StoreViewHolder(
        private val binding: ItemStoreBinding,
        private val onClick: (Shop) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(shop: Shop){
            with(binding) {
                tvStore.text = shop.name

                root.setOnClickListener {
                    onClick(shop)
                }
            }
        }
    }

    fun updateStores(items : List<Shop>){
        this.items = items
        notifyDataSetChanged()
    }

    /**
     * Setup the binding for the view holder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {

        /**
         * inflates the current layout with view holder
         */
        ItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false).also {
            return StoreViewHolder(it, onClick)
        }
    }

    /**
     * Binds the data to the view
     */
    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(items[position])
    }

    /**
     * Returns the number of help titles
     */
    override fun getItemCount(): Int = items.size

}