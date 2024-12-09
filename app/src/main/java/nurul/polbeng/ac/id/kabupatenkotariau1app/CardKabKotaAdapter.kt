package nurul.polbeng.ac.id.kabupatenkotariau1app


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nurul.polbeng.ac.id.kabupatenkotariau1app.databinding.ItemCardKabkotaBinding

class CardKabKotaAdapter(private val listKabKota: ArrayList<KabKota>) :
    RecyclerView.Adapter<CardKabKotaAdapter.CardViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: KabKota)
    }
    // Fungsi untuk membuat ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardKabkotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    // Fungsi untuk mengisi data ke ViewHolder
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val kabKota = listKabKota[position]

        // Memuat gambar menggunakan Glide
        Glide.with(holder.itemView.context)
            .load(kabKota.gambar)
            .into(holder.binding.imgItemPhoto)

        // Mengisi data kabupaten/kota ke ViewHolder
        holder.binding.tvItemName.text = kabKota.kabupaten_kota
        holder.binding.tvItemDetail.text = "Pusat Pemerintahan: \n${kabKota.pusat_pemerintahan}"

        // Menangani tombol Share
        holder.binding.btnSetShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share Data: ${kabKota.kabupaten_kota}",
                Toast.LENGTH_SHORT
            ).show()
            holder.itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(listKabKota[holder.adapterPosition]) }
        }
    }

    // Mengembalikan jumlah item dalam daftar
    override fun getItemCount(): Int = listKabKota.size

    // ViewHolder untuk CardView
    inner class CardViewHolder(val binding: ItemCardKabkotaBinding) :
        RecyclerView.ViewHolder(binding.root)
}
