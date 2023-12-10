/*package com.boukouch.mini_projet.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boukouch.mini_projet.R
import com.boukouch.mini_projet.adapter.Noteadapter
import com.boukouch.mini_projet.dao.NoteHelper
import com.google.android.material.navigation.NavigationView

class MainActivity_note : AppCompatActivity() {
    lateinit var AddButton : Button
    lateinit var toggle : ActionBarDrawerToggle
    private lateinit var db: NoteHelper
    private lateinit var noteAdapter : Noteadapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_note)
        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)
        recyclerView = findViewById(R.id.notesRecycleView)
        AddButton = findViewById(R.id.Addbutton)
        db = NoteHelper(this)

        noteAdapter = Noteadapter(emptyList(), this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = noteAdapter

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



<<<<<<< HEAD:app/src/main/java/com/boukouch/mini_projet/View/MainActivity_note.kt
=======
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mail_academique -> {Toast.makeText(this , "Mail Académique" , Toast.LENGTH_LONG).show()
                    val intent = Intent( this, Recuperation_mot_pass_Activity::class.java)
                    startActivity(intent)
                }
                R.id.nav_message -> {
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                }
                R.id.nav_Memo -> {
                    val intent = Intent(this, MainActivity_note::class.java)
                    startActivity(intent)
                    Log.d("Home", "memeo Home")
                }
                R.id.nav_settings -> Toast.makeText(applicationContext, "Clicked Settings", Toast.LENGTH_LONG).show()
                R.id.nav_Comte -> Toast.makeText(applicationContext, "Clicked login", Toast.LENGTH_LONG).show()
                R.id.nav_Password -> Toast.makeText(applicationContext, "Clicked login", Toast.LENGTH_LONG).show()
                R.id.nav_share -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_feedback -> Toast.makeText(applicationContext, "Clicked FeedBack", Toast.LENGTH_LONG).show()
            }
            true
        }
>>>>>>> fc482ce9a75eb645312dc40b6d49fe254f09cab7:app/src/main/java/com/boukouch/mini_projet/MainActivity_note.kt

        AddButton.setOnClickListener {
            val intent = Intent(this, addNoteActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onResume() {
        super.onResume()
        noteAdapter.refreshData(db.getAllNotes())
    }

}*/