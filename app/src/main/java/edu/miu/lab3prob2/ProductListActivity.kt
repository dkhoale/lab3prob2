package edu.miu.lab3prob2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import edu.miu.lab3prob2.model.Product
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : AppCompatActivity() {
    val products = arrayListOf<Product>().apply {
        add(Product("VIZIO 70 inches Class 4K",1200.00,"Black",
            R.drawable.vizio_tel,"9023801", R.string.vizio_desc))
        add(Product("HP Flyer Red 15.6\" Laptop",1700.00,"Black & Red",
            R.drawable.hp_laptop,"5023801",R.string.hp_laptop_desc))
        add(Product("Samsung Galaxy Tablet",429.00,"Black",
            R.drawable.samsung_galaxy,"5022234",R.string.tablet_desc))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = ProductListAdapter(this,products)
    }
}