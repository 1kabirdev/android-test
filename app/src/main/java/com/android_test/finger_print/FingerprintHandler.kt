package com.android_test.finger_print

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.fingerprint.FingerprintManager
import android.os.CancellationSignal
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android_test.R

class FingerprintHandler(private val context: Context) :
    FingerprintManager.AuthenticationCallback() {

    fun startAuth(manager: FingerprintManager, cryptoObject: FingerprintManager.CryptoObject) {
        val cancellationSignal = CancellationSignal()
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.USE_FINGERPRINT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        manager.authenticate(cryptoObject, cancellationSignal, 0, this, null)
    }

    @Deprecated("Deprecated in Java")
    override fun onAuthenticationError(errMsgId: Int, errString: CharSequence) =
        this.update("Fingerprint Authentication error\n$errString", false)
    
    @Deprecated("Deprecated in Java")
    override fun onAuthenticationHelp(helpMsgId: Int, helpString: CharSequence) =
        this.update("Fingerprint Authentication help\n$helpString", false)

    @Deprecated("Deprecated in Java")
    override fun onAuthenticationFailed() = this.update("Fingerprint Authentication failed.", false)


    @Deprecated("Deprecated in Java")
    override fun onAuthenticationSucceeded(result: FingerprintManager.AuthenticationResult) =
        this.update("Fingerprint Authentication succeeded.", true)


    private fun update(e: String, success: Boolean?) {
        val textView = (context as Activity).findViewById<View>(R.id.errorText) as TextView
        textView.text = e
        if (success!!) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
        }
    }
}