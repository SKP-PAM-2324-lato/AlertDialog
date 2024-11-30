package com.example.oknadialogowe

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.dialog_button)
        button.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Proste okno dialogowe")
            alertDialogBuilder.setMessage("To jest moje pierwsze okno dialogowe")
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }

        val button2 = findViewById<Button>(R.id.dialog_button2)
        button2.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Okno dialogowe")
                .setMessage("Czy akcpetujesz regulamin?")
                .setPositiveButton("OK"){ dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(this, "Zaakaceptowano regulamin", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Nie zgadzam się"){_, _ ->
                    Toast.makeText(this,"Regulmain nie został zaakceptowny",
                        Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Anuluj"){_,_ -> }
                .setCancelable(false)
                .create()

            alertDialog.show()

        }

        val button3 = findViewById<Button>(R.id.dialog_button3)
        button3.setOnClickListener {

            val calendar = Calendar.getInstance()

            val datePickerDialog = DatePickerDialog(this, {_, selectedYear, selectedMonth, selectedDay ->
                Toast.makeText(this, "Wybrana data $selectedDay.${selectedMonth+1}.${selectedYear}",
                    Toast.LENGTH_SHORT).show()
            },
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

            datePickerDialog.show()
        }

        val button4 = findViewById<Button>(R.id.dialog_button4)
        button4.setOnClickListener {

            val nameEdit = EditText(this)
            val dialog = AlertDialog.Builder(this)
                .setTitle("Uwaga!")
                .setMessage("Podaj swoje imę:")
                .setView(nameEdit)
                .setPositiveButton("OK"){_, _ ->
                    val name = nameEdit.text.toString()
                    if(name != ""){
                        Toast.makeText(this, "Cześć $name!", Toast.LENGTH_SHORT).show()
                    }
                }
                .create()
            dialog.show()
        }

        val button5 = findViewById<Button>(R.id.dialog_button5)
        button5.setOnClickListener {
            val items = arrayOf("Opcja 1", "Opcja 2", "Opcja 3")
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Wybierz opcję")
                .setItems(items){_, which ->
                    Toast.makeText(this, "Wybrałeś opcję ${items[which]}", Toast.LENGTH_SHORT).show()
                }
                .create()
            alertDialog.show()
        }

        /*
        val button6 = findViewById<Button>(R.id.dialog_button6)
        button6.setOnClickListener {
            val progressDialog = ProgressDialog(this)
        }

         */

    }

}