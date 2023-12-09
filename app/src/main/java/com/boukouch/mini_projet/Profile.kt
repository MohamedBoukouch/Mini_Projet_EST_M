package com.boukouch.mini_projet



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.boukouch.mini_projet.R.id.recyclerView
import com.boukouch.mini_projet.R.layout
import com.google.android.material.textfield.TextInputEditText
import com.boukouch.mini_projet.adapter.NewsItemAdapter
import com.boukouch.mini_projet.model.NewsItem


class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main_avis)
        val newsList = mutableListOf(
            NewsItem("2023-12-07", true, "Titre de l'actualité 1", "Depliant_Conference.pdf"),
            NewsItem("2023-12-03", true, "Titre de l'actualité 2", "Rapport_Mensuel.pdf"),
            NewsItem("2023-12-01", true, "Titre de l'actualité 3", "Autre_Fichier.pdf"),
            NewsItem("2022-12-31", false, "Titre de l'actualité 4", "Document_Important.pdf"),
            // Ajoutez d'autres éléments de test au besoin
        )


        // Trouver le RecyclerView dans la mise en page et lui fournir la liste d'actualités
        val recyclerView: RecyclerView = findViewById(recyclerView)
        recyclerView.setupNewsRecyclerView(newsList)
    }

    fun onChangePasswordClick(view: View) {
        // Inflate the custom layout
        val changePasswordView = LayoutInflater.from(this).inflate(layout.layout_change_password,null)

        // Access the TextInputEditTexts in the custom layout
        val oldPasswordEditText = changePasswordView.findViewById<TextInputEditText>(R.id.editTextOldPassword)
        val newPasswordEditText = changePasswordView.findViewById<TextInputEditText>(R.id.editTextNewPassword)
        val repeatNewPasswordEditText = changePasswordView.findViewById<TextInputEditText>(R.id.editTextRepeatNewPassword)

        // Build the AlertDialog
        val alertDialogBuilder = AlertDialog.Builder(this)
            .setView(changePasswordView)
            .setPositiveButton("Changer") { dialog, which ->
                // Handle password change logic here
                val oldPassword = oldPasswordEditText.text.toString()
                val newPassword = newPasswordEditText.text.toString()
                val repeatNewPassword = repeatNewPasswordEditText.text.toString()

                // TODO: Implement your password change logic
                // For now, just print the values to the log
                println("Old Password: $oldPassword")
                println("New Password: $newPassword")
                println("Repeat New Password: $repeatNewPassword")
            }
            .setNegativeButton("Annuler", null) // Cancel button

        // Show the AlertDialog
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    fun onBackButtonClick(view: View) {
        // Create an Intent to start the activity_home.xml
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }




}
