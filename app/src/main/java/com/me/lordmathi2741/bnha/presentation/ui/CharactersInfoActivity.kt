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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.me.lordmathi2741.bnha.R
import com.me.lordmathi2741.bnha.domain.factories.CharacterServiceFactory
import com.me.lordmathi2741.bnha.domain.models.Character
import com.me.lordmathi2741.bnha.presentation.adapters.CharacterRecyclerViewAdapter
import com.me.lordmathi2741.bnha.shared.Resource
import kotlinx.coroutines.launch

class CharactersInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_characters_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cvCredits)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val context = this
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
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
        lifecycleScope.launch {
            val characters = getCharacters()
            val adapter = CharacterRecyclerViewAdapter(characters)
            val recyclerView = findViewById<RecyclerView>(R.id.rvCharacters)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
    }

    private suspend fun getCharacters() : List<Character> {
        val characterService = CharacterServiceFactory().createCharacterServiceInstance()
        val characterWrapper = characterService.getAllCharacters()
        if(characterWrapper.characters.isEmpty()){
            throw Exception(Resource.Error<List<Character>>("No characters found").message)
        }
        return characterWrapper.characters
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.info_button -> {
                val intent = Intent(this, CreditsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}