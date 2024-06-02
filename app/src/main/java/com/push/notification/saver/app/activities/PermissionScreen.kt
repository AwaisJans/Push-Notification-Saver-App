package com.push.notification.saver.app.activities

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.push.notification.saver.app.R
import com.push.notification.saver.app.databinding.ActivityPermissionBinding


class PermissionScreen : AppCompatActivity() {
    companion object{
        private const val PERMISSION_REQUEST_CODE = 1110
    }

    private lateinit var b:ActivityPermissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(b.root)



        if(SDK_INT >= TIRAMISU){
            if (checkPermissions()) {
                replaceActivity()
            } else {
                Toast.makeText(this, "Notification Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }else{
            replaceActivity()
        }





        if (checkPermissions()) {
//            Toast.makeText(this, "Notification Permission Granted", Toast.LENGTH_SHORT).show()
            replaceActivity()
        } else {
            Toast.makeText(this, "Notification Permission Denied", Toast.LENGTH_SHORT).show()
        }




        b.btnAllowPermission.setOnClickListener{
            requestPermissions()
        }

        b.btnSkip.setOnClickListener{
            AlertDialog.Builder(this, R.style.myDialogBoxTheme)
                .setTitle("Notification Permission")
                .setMessage("App can not run without this permission App Will now exit..")
                .setPositiveButton("OK"
                ) { dialog, whichButton ->
                    finish()
                }.show()
        }


    }

    private fun checkPermissions(): Boolean {
        var isGranted = false

        if (SDK_INT >= TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                isGranted = false
            } else {
                isGranted = true
            }
        }
        return isGranted
    }

    private fun requestPermissions() {
        if (SDK_INT >= TIRAMISU) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), PERMISSION_REQUEST_CODE)
        };
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Notification Permission Granted", Toast.LENGTH_SHORT).show()
                replaceActivity()
            } else {
                Toast.makeText(this, "Go to App Setting and grant permissions", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun replaceActivity() {
        startActivity(Intent(this, FirstScreen::class.java))
        finish()
    }


}