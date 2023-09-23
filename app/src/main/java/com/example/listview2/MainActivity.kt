package com.example.listview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Anmol" , " Anmol New" , "Anmol Extra" , "Anmol More" , "Verma")
        val lastMsg = arrayOf("Hey everyone", "I am fine", "Good", "Awesome", "cool")
        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM")
        val phoneNumber = arrayOf("786453739", "986453739", "7366382829", "7383413440", "4159251517")
        val imgId = intArrayOf(R.drawable.pic5, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4) // setting the image id

        userArrayList = ArrayList() // initialised now as it was lateinit var above.

        // will iterate over each index and prepare a user for each one.
        for(eachIndex in name.indices){
            val user = User(name[eachIndex] , lastMsg[eachIndex] , lastMsgTime[eachIndex] , phoneNumber[eachIndex] , imgId[eachIndex])
            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = myAdapter(this , userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            // open a new activity

            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val intent = Intent(this, UserActivity::class.java)

            intent.putExtra("name", userName)
            intent.putExtra("phone", userPhone)
            intent.putExtra("imageId", imageId)
            startActivity(intent)
        }


    }
}