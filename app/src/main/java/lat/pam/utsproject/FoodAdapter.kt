package lat.pam.utsproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val foodDescription: TextView = itemView.findViewById(R.id.foodDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodImage.setImageResource(food.imageResId)
        holder.foodName.text = food.name
        holder.foodDescription.text = food.description

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, OrderActivity::class.java)
            intent.putExtra("foodName", food.name)
            intent.putExtra("foodDescription", food.description)
            intent.putExtra("foodImage", food.imageResId)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = foodList.size
}
