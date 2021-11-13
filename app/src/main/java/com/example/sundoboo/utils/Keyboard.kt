package com.example.sundoboo.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun Context.showKeyboard(view: View) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
        showSoftInput(view, 0)
    }
}

fun Context.hideKeyboard(view: View) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
        hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun EditText.showKeyboardAndFocus() {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
        showSoftInput(this@showKeyboardAndFocus, 0)
    }
    requestFocus()
}

fun EditText.showKeyboardAndClearFocus() {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
        hideSoftInputFromWindow(this@showKeyboardAndClearFocus.windowToken, 0)
    }
    clearFocus()
}


