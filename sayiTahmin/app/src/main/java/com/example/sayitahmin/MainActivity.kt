/* KOTLİN DİLİ İLE SAYI TAHMİN ET OYUNU
          Hasan Şenmemiş-210303020*/

package com.example.sayitahmin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sayitahmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()

        //Oyuna Başla Fonksiyonu
        binding.buttonStart.setOnClickListener{
            val intent= Intent(applicationContext,TahminActivity::class.java)
            startActivity(intent)
        }
    }

    fun setupBinding(){
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }

}




