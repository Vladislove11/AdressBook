package com.example.adressbook

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private var person: Person? = null
    private lateinit var lastNameTV: TextView
    private lateinit var firstNameTV: TextView
    private lateinit var addressTV: TextView
    private lateinit var phoneTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        lastNameTV = findViewById(R.id.lastNameTV)
        firstNameTV = findViewById(R.id.firstNameTV)
        addressTV = findViewById(R.id.addressTV)
        phoneTV = findViewById(R.id.phoneTV)

        person = intent.extras?.getSerializable(Person::class.java.simpleName) as Person?
        lastNameTV.text = person?.lastName
        firstNameTV.text = person?.firstName
        addressTV.text = person?.address
        phoneTV.text = person?.phone

    }
}