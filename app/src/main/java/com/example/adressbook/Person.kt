package com.example.adressbook

import android.app.appsearch.SearchResult
import java.io.Serializable

data class Person (val lastName: String, val firstName: String, val address: String, val phone: String) : Serializable{
    override fun toString(): String {
        return "$lastName $firstName"
    }
}