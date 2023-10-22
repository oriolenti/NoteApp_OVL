package com.example.noteapp_ovl.screens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.noteapp_ovl.R

class MainActivity : ComponentActivity() {

    val AddButton by lazy { findViewById<ImageButton>(R.id.addbutton) }
    val noteTitleView by lazy { findViewById<TextView>(R.id.titleTextView) }
    val noteDescriptionView by lazy { findViewById<TextView>(R.id.descriptionTextView) }

    // Código de solicitud
    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startscreen)

        AddButton.setOnClickListener {
            val AddNotePhase = Intent(this, SecondScreen::class.java)
            startActivityForResult(AddNotePhase, REQUEST_CODE)
        }
    }

    // Recibimos info de SecondScreen
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val noteTitle = data?.getStringExtra("noteTitle")
            val noteDescription = data?.getStringExtra("noteDescription")

            if (noteTitle != null && noteDescription != null) {
                noteTitleView.text = "Título: $noteTitle\n"
                noteDescriptionView.text = "Descripción: $noteDescription"
            }
        }
    }
}
