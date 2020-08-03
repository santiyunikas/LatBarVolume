package com.santiyunikas.latbarvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var panjang: EditText
    private lateinit var lebar: EditText
    private lateinit var tinggi: EditText
    private lateinit var btn_hitung: Button
    private lateinit var hasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panjang = findViewById(R.id.panjang)
        lebar = findViewById(R.id.lebar)
        tinggi = findViewById(R.id.tinggi)
        btn_hitung = findViewById(R.id.btn_hitung)
        hasil = findViewById(R.id.hasil)

        btn_hitung.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString("state_result")
            hasil.text = result
        }

    }

    override fun onClick(v: View?) {
        if (v != null) {
            if(v.id == R.id.btn_hitung){
                val inPanjang = panjang.text.toString().trim()
                val inLebar = lebar.text.toString().trim()
                val inTinggi = tinggi.text.toString().trim()

                var isEmptyFields = false
                var isInvalidDouble = false

                if (inPanjang.isEmpty()){
                    isEmptyFields = true
                    panjang.error = "Form tidak boleh kosong"
                }

                if (inLebar.isEmpty()){
                    isEmptyFields = true
                    lebar.error = "Form tidak boleh kosong"
                }

                if (inTinggi.isEmpty()){
                    isEmptyFields = true
                    tinggi.error = "Form tidak boleh kosong"
                }

                val p = inPanjang.toDouble()
                val l = inLebar .toDouble()
                val t = inTinggi.toDouble()

                if (p == null){
                    isInvalidDouble = true
                    panjang.error = "Form ini harus berupa numerik"
                }

                if (l == null){
                    isInvalidDouble = true
                    lebar.error = "Form ini harus berupa numerik"
                }

                if (t == null){
                    isInvalidDouble = true
                    tinggi.error = "Form ini harus berupa numerik"
                }

                if(!isEmptyFields && !isInvalidDouble){
                    val volume = p * l * t
                    hasil.text = volume.toString()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("state_result", hasil.text.toString())
    }
}
