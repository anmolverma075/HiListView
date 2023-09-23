package com.example.listview2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phone")
        val image = intent.getIntExtra("imageId", R.drawable.pic5)

        val nameTv = findViewById<TextView>(R.id.tVName)
        val phoneTv = findViewById<TextView>(R.id.tVPhone)
        val imageId = findViewById<CircleImageView>(R.id.profile_image)

        nameTv.text = name
        phoneTv.text = phoneNumber
        imageId.setImageResource(image)
    }
}