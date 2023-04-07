//TahminActivity.kt
package com.example.sayitahmin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sayitahmin.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTahminBinding

    private var rastgeleSayi=0 //rastgele sayı değişkeni
    private var sayac=5// kalan hakları belirtmek için bir değişken belirledim.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()

        rastgeleSayi= Random.nextInt(100) // 0 ile 100 arasında değer döndürür. Rastgele sayı konsol ekranında görünür.
        Log.e("Rastgele Sayı",rastgeleSayi.toString())

        //Tahmin Et butonu fonksiyonu
        binding.buttonGuess.setOnClickListener{

            sayac = sayac-1//Kullanıcı doğru sayıyı bilemedikçe haklarını azaldığını gösteriyor.

            val tahmin = binding.editTextGirdi.text.toString().toInt()

            //Kazanma veya kaybetme durumları
            if(tahmin==rastgeleSayi){
                val intent= Intent(applicationContext,SonucActivity::class.java)
                intent.putExtra("sonuc","true")
                startActivity(intent)
                finish()
                return@setOnClickListener
            }
            if(tahmin>rastgeleSayi){
                binding.editTextYardim.text="Daha küçük bir sayı söyleyin"
                binding.textViewKalanHak.text="Kalan Hak: ${sayac}"
            }
            if(tahmin<rastgeleSayi) {
                binding.editTextYardim.text="Daha büyük bir sayı söyleyin"
                binding.textViewKalanHak.text="Kalan Hak: ${sayac}"
            }
            if(sayac==0){
                val intent= Intent(applicationContext,SonucActivity::class.java)
                intent.putExtra("sonuc","false")
                finish()
                startActivity(intent)
            }

            binding.editTextGirdi.setText("")
        }

    }

    fun setupBinding(){
        binding= ActivityTahminBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }

}
