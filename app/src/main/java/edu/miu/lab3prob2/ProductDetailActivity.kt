package edu.miu.lab3prob2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.miu.lab3prob2.model.Product
import kotlinx.android.synthetic.main.activity_product_detail.*
import java.util.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        if(intent.hasExtra("product")){
            (intent.getSerializableExtra("product") as? Product)?.let {
                tvTitle.text = it.title
                imageView5.setImageResource(it.image)
                tvColor.text = "Color: ${it.color}"
                tvItemId.text = "Walmart #${it.itemId}"
                tvPrice.text = Formatter(Locale.US).format("Price: $%,.2f",it.price).toString()
                tvDesc.text = resources.getString(it.desc)
            }
        }
    }
}