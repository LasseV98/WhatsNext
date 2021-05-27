package com.whatsnextfood.whatsnexthomescreen

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {


//permissions vragen en scan aanzetten
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),111)
        }
        else {
            var camerafunctie = findViewById<ImageButton>(R.id.Cam)
            camerafunctie.isEnabled = true
        }
        var camerafunctie = findViewById<ImageButton>(R.id.Cam)
        camerafunctie.setOnClickListener{
            val scanfunctie = IntentIntegrator(this)
            scanfunctie.setCameraId(0)
            scanfunctie.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
            scanfunctie.setBarcodeImageEnabled(true)
            scanfunctie.initiateScan()
        }
    val button: Button = findViewById(R.id.Add_Item)
    button.setOnClickListener {
        startActivity(Intent(this@MainActivity, AddItem::class.java))
    }
    }
    //nagaan of je de results krijgt
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var camerafunctie = findViewById<ImageButton>(R.id.Cam)
        if(requestCode == 111 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            camerafunctie.isEnabled= true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result==null){
            Toast.makeText(this,"Scanning cancelled",Toast.LENGTH_LONG).show()
        }
        else{
            //redirect of add naar de kast
            //TextView.setText("${result.contents}")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        findViewById<Button>(R.id.Add_Item).setOnClickListener { view ->
            Snackbar.make(view, "Voeg Item toe", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()}
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.kastInstellingen->true
            else -> super.onOptionsItemSelected(item)




        }
    }
}