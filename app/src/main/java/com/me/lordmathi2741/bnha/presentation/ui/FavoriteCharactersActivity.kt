package com.me.lordmathi2741.bnha.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.me.lordmathi2741.bnha.R
import com.me.lordmathi2741.bnha.data.local.AppDataBase
import com.me.lordmathi2741.bnha.data.local.FavoriteCharacter
import com.me.lordmathi2741.bnha.presentation.adapters.FavoriteCharacterRecyclerViewAdapter

class FavoriteCharactersActivity : AppCompatActivity() {
     lateinit var favoriteCharacters : List<FavoriteCharacter>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favorite_characters)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cvCredits)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        navigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottomHome -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.bottomCharacters -> {
                    val intent = Intent(this, CharactersInfoActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.bottomFavorite -> {
                    val intent = Intent(this, FavoriteCharactersActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
            getAllFavoriteCharacters()
    }

    override fun onResume() {
        super.onResume()
        getAllFavoriteCharacters()
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.info_button -> {
                val intent = Intent(this, CreditsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun getAllFavoriteCharacters(){
        val favoriteCharacterDao = AppDataBase.getInstance(this).characterDao()
        favoriteCharacters = favoriteCharacterDao.getAll()
        val adapter = FavoriteCharacterRecyclerViewAdapter(favoriteCharacters)
        val recyclerView = findViewById<RecyclerView>(R.id.rvFavoriteCharacter)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}