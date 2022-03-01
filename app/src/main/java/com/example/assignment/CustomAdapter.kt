package com.example.assignment

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.data.ResultsData
import com.example.assignment.utils.ImageDownloaderImage
import kotlin.concurrent.thread

class CustomAdapter(
    private val mList: Array<ResultsData>,
    private val listener: CellClickedListener?
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.typeTextView.text = itemsViewModel.type
        holder.itemView.setOnClickListener {
            listener?.cellClicked(itemsViewModel)
        }
        if (!itemsViewModel.name.isNullOrEmpty()) {
            holder.textView.text = itemsViewModel.name
        } else {
            holder.textView.text = itemsViewModel.mainArtist?.name
        }
        val uiHandler = Handler(Looper.getMainLooper())
        thread(start = true) {
            val bitmap = ImageDownloaderImage.getBitmap(itemsViewModel.cover?.small.toString())
            uiHandler.post {
                holder.imageView.setImageBitmap(bitmap)
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val typeTextView: TextView = itemView.findViewById(R.id.typeTextView)
    }

    interface CellClickedListener {
        fun cellClicked(itemsViewModel: ResultsData)
    }
}
