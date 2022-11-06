package edu.miu.lab3prob2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.miu.lab3prob2.model.Product
import edu.miu.lab3prob2.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val users = arrayListOf<User>().apply {
        add(User("Kevin", "Lee", "kevin.lee@gmail.com", "123456"))
        add(User("Joe", "John", "joe.john@gmail.com", "nopass"))
        add(User("Mike", "Zang", "mike.zang@gmail.com", "112233"))
        add(User("Steve", "Job", "steve@gmail.com", "223344"))
        add(User("John", "Ivy", "j.ivy@gmail.com", "556677"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        btn_sign_in.setOnClickListener {
            val email = edt_emailAddress.text.toString().trim()
            val password = edt_password.text.toString().trim()
            if (email.isNotEmpty() && password.isNotEmpty() && users.any { it.username == email && it.password == password}) {
                startActivity(Intent(this, ShoppingActivity::class.java).apply {
                    putExtra("username", email)
                })
            } else {
                Toast.makeText(this, "The username or password is invalid.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}