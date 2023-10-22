package com.example.noteapp_ovl.screens

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import com.example.noteapp_ovl.R
import android.app.AlertDialog
import android.content.Intent
import android.widget.EditText
import android.widget.Toast

class SecondScreen : ComponentActivity() {

    val BackButton by lazy { findViewById<ImageButton>(R.id.backbutton) }
    val DelButton by lazy { findViewById<ImageButton>(R.id.delbutton) }

    lateinit var noteTitleEditText: EditText
    lateinit var noteDescriptionEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondscreen)

        BackButton.setOnClickListener() {
            var popUp = AlertDialog.Builder(this)
            popUp.setTitle("CUIDADO")
            popUp.setMessage("¿Que quieres hacer con la nota?")

            popUp.setPositiveButton("Guardar") { dialog, witch ->
                val nTitle = noteTitleEditText.text.toString()
                val nDescription = noteDescriptionEditText.text.toString()

                val intent = Intent()
                intent.putExtra("noteTitle", nTitle)
                intent.putExtra("noteDescription", nDescription)
                setResult(Activity.RESULT_OK, intent)
                finish()

                val outPopUp = Toast(this)
                outPopUp.setText("Nota guardada")
                outPopUp.show()
            }

            popUp.setNegativeButton("Salir sin guardar") { dialog, witch ->
                val goHome = Intent(this, MainActivity::class.java)
                this.startActivity(goHome)
            }

            val alert_popUp = popUp.create()
            alert_popUp.show()
        }


        DelButton.setOnClickListener() {
            var popUp = AlertDialog.Builder(this)
            popUp.setTitle("CUIDADO")
            popUp.setMessage("¿Seguro que quieres borrar la nota?")

            popUp.setPositiveButton("Si") { dialog, witch ->
                val AddNotePhase = Intent(this, SecondScreen::class.java)
                this.startActivity(AddNotePhase)
            }

            popUp.setNegativeButton("No") { dialog, witch ->
                dialog.dismiss()
            }

            val alert_popUp = popUp.create()
            alert_popUp.show()
        }
    }

}