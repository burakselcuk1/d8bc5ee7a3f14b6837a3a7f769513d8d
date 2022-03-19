package com.example.burakselcuk.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.burakselcuk.MainActivity
import com.example.burakselcuk.R
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
            else{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}