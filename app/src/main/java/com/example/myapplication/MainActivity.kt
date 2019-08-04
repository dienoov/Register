package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var edtNama : EditText? = null
    var spinGender : EditText? = null
    var edtEmail : EditText? = null
    var edtNo : EditText? = null
    var edtAlamat : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNama = findViewById(R.id.nama)
        spinGender = findViewById(R.id.gender)
        edtEmail = findViewById(R.id.email)
        edtNo = findViewById(R.id.no)
        edtAlamat = findViewById(R.id.alamat)

        saves.setOnClickListener {
            validasiInput()
        }

        setDataSpinner()

    }

    fun setDataSpinner() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.genderList, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        gender?.adapter = adapter
    }

    fun validasiInput() {
        val namaInput : String = edtNama?.text.toString()
        val emailInput : String = edtEmail?.text.toString()
        val noInput : String = edtNo?.text.toString()
        val alamatInput : String = edtAlamat?.text.toString()
        val genderInput : String = gender?.selectedItem.toString()

        when {
            genderInput.equals("Pilih jenis kelamin") ->
                Toast.makeText(this, "Kelamin harus dipilih", Toast.LENGTH_SHORT).show()
            namaInput.isEmpty() -> edtNama?.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() -> edtEmail?.error = "Nama tidak boleh kosong"
            noInput.isEmpty() -> edtNo?.error = "Nama tidak boleh kosong"
            alamatInput.isEmpty() -> edtAlamat?.error = "Nama tidak boleh kosong"

        else -> {
            Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show ()
        }
    }

    }
}
