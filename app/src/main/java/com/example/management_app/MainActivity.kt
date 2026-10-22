package com.example.management_app

import android.content.Intent // <-- Jangan lupa import Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.management_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // deklarasikan binding untuk main dashboard kita
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inisialisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // mengubah teks agar tidak menjadi dinamis
        binding.tvNamaSiswa.text = "Wawan Kriuk (XII RPL 2)"
        binding.tvJumlahTugas.text = "4"
        binding.tvRataNilai.text = "90.0"

        // Aksi ketika klik tombol navigasi ke Form tugas (Diperbaiki: setOnClickListener)
        binding.TombolForm.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
} // <-- Kurung tutup class MainActivity