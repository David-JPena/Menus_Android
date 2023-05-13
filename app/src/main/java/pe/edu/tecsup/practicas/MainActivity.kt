package pe.edu.tecsup.practicas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.PopupMenu
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLeftNav = findViewById<Button>(R.id.moreInfo)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val btnNota = findViewById<Button>(R.id.btnNotaS)
        val listDocentes = findViewById<Button>(R.id.btnDocent)
        val uriLocations: Uri = Uri.parse("")

        listDocentes.setOnClickListener{
            startActivity(Intent(this,DocentesActivity::class.java))
        }
        btnNota.setOnClickListener{
            startActivity(Intent(this, NotaActivity::class.java))
        }

        btnLeftNav.setOnClickListener {
            navView.isEnabled = true
            drawerLayout.openDrawer(GravityCompat.END)
        }
        val uriLocation: Uri = Uri.parse("geo:0,0?q=Tecsup Trujillo")
        val ftlLocation = findViewById<FloatingActionButton>(R.id.floatingPreguntas)
        ftlLocation.setOnClickListener {
            //startActivity(Intent(Intent.ACTION_VIEW, uriLocation))
        }
    }
//----------------------------------------
    fun showPopPup(v: View) {
        val poppup = PopupMenu(this, v)
        val inflater: MenuInflater = poppup.menuInflater
        inflater.inflate(R.menu.menu_emergente, poppup.menu)
        poppup.setOnMenuItemClickListener(this)
        poppup.show()
    }
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.itemMenuMensaje -> {
                Toast.makeText(this, "Mensaje", Toast.LENGTH_LONG).show()
                true
            }
            R.id.itemMenuConversar -> {
                Toast.makeText(this, "Conversar", Toast.LENGTH_LONG).show()
                true
            }
            R.id.itemMenuPreguntas -> {
                Toast.makeText(this, "Preguntas", Toast.LENGTH_LONG).show()
                true
            }
            else -> false
        }
    }
    //---------------------------------------------------------------
    private fun configurarNavigationDrawer(){
        val navViewLeft = findViewById<NavigationView>(R.id.nav_view_left)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)



        navViewLeft.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawer(GravityCompat.START)
            when(menuItem.itemId){
                R.id.nav_calculator -> {
                    Toast.makeText(this, "Calculadora", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_gallery -> {
                    Toast.makeText(this, "Galeria", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_slideshow -> {
                    Toast.makeText(this, "Diapositivas", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    private fun configurationNavegatioDrawerLeft(){
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        navView.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawer(GravityCompat.END)
            when(menuItem.itemId){
                R.id.nav_notices -> {
                    Toast.makeText(this, "Noticias", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_curse -> {
                    Toast.makeText(this, "Cursos", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_teachers -> {
                    Toast.makeText(this, "Profesore", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_students -> {
                    Toast.makeText(this, "Estudiantes", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_notes -> {
                    Toast.makeText(this, "Notas", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_contact -> {
                    Toast.makeText(this, "Contactos", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_book -> {
                    Toast.makeText(this, "Libro de Reclamaciones", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}
