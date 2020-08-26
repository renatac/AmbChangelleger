package com.example.challengeambar.view.communs

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, titleIDRes: Int,
                               hasBackArrow: Boolean = false) {
        toolbar.title = getString(titleIDRes)
        setSupportActionBar(toolbar)
        if (hasBackArrow) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}