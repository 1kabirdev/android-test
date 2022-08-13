package com.android_test.form_with_rx

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android_test.databinding.ActivityFormWithRxBinding
import com.jakewharton.rxbinding2.widget.textChangeEvents
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

class FormWithRxActivity : AppCompatActivity() {
    private lateinit var bindign: ActivityFormWithRxBinding

    private var conditionMet: Boolean = false
    lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindign = ActivityFormWithRxBinding.inflate(layoutInflater)
        setContentView(bindign.root)

        with(bindign) {
            val usernameObservable =
                usernameEditText.textChangeEvents().map { textViewTextChangeEvent ->
                    textViewTextChangeEvent.text().trim().toString()
                }
            val passwordObservable =
                passwordEditText.textChangeEvents().map { textViewTextChangeEvent ->
                    textViewTextChangeEvent.text().trim().toString()
                }

            disposable =
                Observable.zip(usernameObservable, passwordObservable) { username, password ->
                    if (conditionForUserName(username) && conditionForPassword(password)) {
                        conditionMet = true
                        conditionMet
                    } else {
                        conditionMet = false
                        conditionMet
                    }
                }.subscribe({
                    if (conditionMet) {
                        runOnUiThread {
                            loginButton.isEnabled = true
                        }
                    } else {
                        runOnUiThread {
                            loginButton.isEnabled = false
                        }
                    }
                }, { e -> e.printStackTrace() })

            loginButton.setOnClickListener {
                toast("Process your Login")
            }
        }
    }

    private fun Context.toast(msg: CharSequence) =
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()

    private fun conditionForUserName(username: String): Boolean {
        if (username.length >= 2) {
            return true
        }
        return false
    }

    private fun conditionForPassword(password: String): Boolean {
        if (password.length >= 2) {
            return true
        }
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!(disposable.isDisposed)) {
            disposable.dispose()
        }
    }
}