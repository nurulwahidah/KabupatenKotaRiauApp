package nurul.polbeng.ac.id.kabupatenkotariau1app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nurul.polbeng.ac.id.kabupatenkotariau1app.databinding.ItemGridKabkotaBinding

class GridKabKotaAdapter(private val listKabKota: ArrayList<KabKota>):
    RecyclerView.Adapter<GridKabKotaAdapter.GridViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: KabKota)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = ItemGridKabkotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }
    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listKabKota[position].gambar)
            .into(holder.binding.imgItemPhoto)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listKabKota[holder.adapterPosition]) }
    }
    override fun getItemCount(): Int = listKabKota.size
    inner class GridViewHolder(val binding: ItemGridKabkotaBinding): RecyclerView.ViewHolder(binding.root)
}
