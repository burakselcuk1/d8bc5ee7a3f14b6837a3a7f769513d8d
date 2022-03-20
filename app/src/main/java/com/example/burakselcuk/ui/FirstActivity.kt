package com.example.burakselcuk.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.burakselcuk.MainActivity
import com.example.burakselcuk.R
import com.example.burakselcuk.model.spaceShip
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        //Check parametres for null or not
        git.setOnClickListener {

            if(dayaniklilik.text.toString().trim().isEmpty()){
                Snackbar.make(it, "Dayanıklılık boş olamaz", Snackbar.LENGTH_SHORT).show()
            }
            else if(hız.text.toString().trim().isEmpty()){
                Snackbar.make(it, "Hız boş olamaz", Snackbar.LENGTH_SHORT).show()
            }
            else if(kapasite.text.toString().trim().isEmpty()){
                Snackbar.make(it, "Kapasite boş olamaz", Snackbar.LENGTH_SHORT).show()
            }
            else if(nameSpaceShip.text.toString().trim().isEmpty()){
                Snackbar.make(it, "Gemi ismi boş olamaz", Snackbar.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}