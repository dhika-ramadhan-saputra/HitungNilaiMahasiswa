package com.example.menghitungnilaimahasiswa

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edNama: EditText
    private lateinit var edTugas: EditText
    private lateinit var edHadir: EditText
    private lateinit var edUts: EditText
    private lateinit var edUas: EditText
    private lateinit var edAkhir: EditText
    private lateinit var edHuruf: EditText
    private lateinit var btnHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNama = findViewById(R.id.ednama) // Assuming your EditText id is edNama
        edTugas = findViewById(R.id.edtugas)
        edHadir = findViewById(R.id.edhadir)
        edUts = findViewById(R.id.eduts)
        edUas = findViewById(R.id.eduas)
        edAkhir = findViewById(R.id.edakhir)
        edHuruf = findViewById(R.id.edhuruf)
        btnHitung = findViewById(R.id.btnhitung)
        btnHitung.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        if (view?.id == R.id.btnhitung) {
            val inputTugas = edTugas.text.toString().trim()
            val inputHadir = edHadir.text.toString().trim()
            val inputUts = edUts.text.toString().trim()
            val inputUas = edUas.text.toString().trim()

            // Convert inputs to double and handle potential parsing errors
            val tugas: Double = try {
                inputTugas.toDouble()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Input tugas harus berupa angka", Toast.LENGTH_SHORT).show()
                return
            }
            val hadir: Double = try {
                inputHadir.toDouble()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Input kehadiran harus berupa angka", Toast.LENGTH_SHORT).show()
                return
            }
            val uts: Double = try {
                inputUts.toDouble()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Input uts harus berupa angka", Toast.LENGTH_SHORT).show()
                return
            }
            val uas: Double = try {
                inputUas.toDouble()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Input uas harus berupa angka", Toast.LENGTH_SHORT).show()
                return
            }

            val finalScore = (0.15 * hadir) + (0.25 * tugas) + (0.25 * uts) + (0.35 * uas)

            var letterGrade: String = ""
            if (finalScore >= 90 && finalScore <= 100) {
                letterGrade = "A"
            } else if (finalScore >= 80 && finalScore <= 89) {
                letterGrade = "B"
            } else if (finalScore >= 70 && finalScore <= 79) {
                letterGrade = "C"
            } else if (finalScore >= 60 && finalScore <= 69) {
                letterGrade = "D"
            } else {
                letterGrade = "E"
            }

            edAkhir.setText("" + finalScore)
            edHuruf.setText(letterGrade)
        }
    }
}
