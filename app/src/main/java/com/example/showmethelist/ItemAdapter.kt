import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.showmethelist.Item
import com.example.showmethelist.R

// Adapter for the RecyclerView to display items
class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // ViewHolder pattern to cache view references
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // References to views in item layout
        val title: TextView = view.findViewById(R.id.item_title)
        val subtitle: TextView = view.findViewById(R.id.item_subtitle)
        val description: TextView = view.findViewById(R.id.item_description)
        val thumbnail: ImageView = view.findViewById(R.id.item_thumbnail)
    }

    // Create new ViewHolder instances
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        // Create and return a new ViewHolder instance
        return ItemViewHolder(view)
    }

    // Bind data to ViewHolder instances
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Retrieve the item at the specified position
        val item = items[position]
        // Set the title, subtitle, and description for the item
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
        holder.description.text = item.description
        // Set the thumbnail image. You might want to use a library like Glide or Picasso for loading images.
        // holder.thumbnail.setImageResource(item.imageResId)
    }

    // Return the total number of items in the dataset
    override fun getItemCount(): Int = items.size
}
