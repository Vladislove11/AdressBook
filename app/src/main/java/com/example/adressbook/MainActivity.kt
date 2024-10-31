package com.example.adressbook

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var lastNameET: EditText
    private lateinit var firstNameET: EditText
    private lateinit var addressET: EditText
    private lateinit var phoneET: EditText
    private lateinit var buttonBTN: Button
    private lateinit var listViewLV: ListView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    var person: Person? = null
    val listPersons: MutableList<Person?> = mutableListOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lastNameET = findViewById(R.id.lastNameET)
        firstNameET = findViewById(R.id.firstNameET)
        addressET = findViewById(R.id.addresET)
        phoneET = findViewById(R.id.phoneET)
        buttonBTN = findViewById(R.id.buttonBTN)
        listViewLV = findViewById(R.id.listView)
        toolbar = findViewById(R.id.toolbarTB)

        setSupportActionBar(toolbar)
        title = "Menu"

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listPersons)
        listViewLV.adapter = adapter

        buttonBTN.setOnClickListener {
            val person = Person(lastNameET.text.toString(), firstNameET.text.toString(), addressET.text.toString(), phoneET.text.toString())

            listPersons.add(person)
            adapter.notifyDataSetChanged()
            lastNameET.text.clear()
            firstNameET.text.clear()
            addressET.text.clear()
            phoneET.text.clear()

        }

        listViewLV.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                val intent = Intent(this, SecondActivity::class.java)
                val note = adapter.getItem(position)
                intent.putExtra(Person::class.java.simpleName, note)
                startActivity(intent)

                adapter.remove(note)
            }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_exit -> finish()
            else -> return  super.onContextItemSelected(item)
        }
        return true
    }
}