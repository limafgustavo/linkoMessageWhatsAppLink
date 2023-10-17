package com.limagustavo.linkomessage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.limagustavo.linkomessage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMessage.setOnClickListener {
            if (binding.editPhoneNumber.text.length == 13) {
                var phoneNumberOnly = binding.editPhoneNumber.text.replace(Regex("[^0-9]"), "")
                var linkUrl = "https://api.whatsapp.com/send?phone=55$phoneNumberOnly"

                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkUrl))
                startActivity(browserIntent)
            }else if(binding.editPhoneNumber.text.toString() == "" || binding.editPhoneNumber.text.length < 13){
                Toast.makeText(this@MainActivity, "Por favor, insira o número completo.",Toast.LENGTH_SHORT).show()
            }

        }
        binding.editPhoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher("BR"))

    }
}