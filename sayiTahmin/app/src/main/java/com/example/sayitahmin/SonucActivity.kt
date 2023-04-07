
package com.example.sayitahmin


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sayitahmin.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySonucBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()

        val sonuc = intent.getBooleanExtra("sonuc",false)

        //Kullanıcı doğru veya yanlış bilirse ekranda çıkacak yazılar.
        if(sonuc){
            binding.textViewSonuc.text="TEBRİKLER"
            binding.imageViewSonuc.setImageResource(R.drawable.mutlu_resim)
        }else{
            binding.textViewSonuc.text="KAYBETTİNİZ"
            binding.imageViewSonuc.setImageResource(R.drawable.uzgun_resim)
        }

        //Tekrar oyna butonu fonksiyonu
        binding.buttonPlayAgain.setOnClickListener{
            val intent= Intent(applicationContext,TahminActivity::class.java)
            finish()
            startActivity(intent)
        }

        //Çıkış butonu fonskiyonu-Bu butona bastığımızda uygulamadan çıkış yapılır.
        binding.buttonExit.setOnClickListener{
            moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(1)
        }

    }

    fun setupBinding(){
        binding= ActivitySonucBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }

}