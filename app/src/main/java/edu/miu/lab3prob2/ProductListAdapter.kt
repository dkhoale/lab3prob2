package edu.miu.lab3prob2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.miu.lab3prob2.model.Product
import kotlinx.android.synthetic.main.item_view.view.*
import java.util.*
import kotlin.collections.ArrayList

class ProductListAdapter(val context: Context, private val productList: ArrayList<Product>) : RecyclerView.Adapter<ProductListAdapter.ProductListVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProductListVH(view)
    }

    override fun onBindViewHolder(holder: ProductListVH, position: Int) {
        val formatter = Formatter(Locale.US)
        holder.itemView.imageView.setImageResource(productList[position].image)
        holder.itemView.tvTitle.text = productList[position].title
        holder.itemView.tvColor.text = productList[position].color
        holder.itemView.tvPrice.text = formatter.format("$%,.2f",productList[position].price).toString()

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,ProductDetailActivity::class.java).apply {
                putExtra("product", productList[position])
            })
        }
    }

    override fun getItemCount(): Int {
        return this.productList.size
    }

    inner class ProductListVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}