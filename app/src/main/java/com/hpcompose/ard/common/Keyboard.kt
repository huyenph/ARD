package com.hpcompose.ard.common

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

@SuppressLint("ClickableViewAccessibility")
fun setupKeyboard(view: View, activity: Activity, clearFocus: Boolean) {
    if (view !is EditText) {
        view.setOnTouchListener { _, _ ->
            if (view.tag != null) {
                return@setOnTouchListener false
            }
            if (clearFocus) {
                view.requestFocus()
            }
            hideSoftKeyboard(activity)
            return@setOnTouchListener false
        }
    }
    if (view is ViewGroup) {
        val childCount = view.childCount
        for (i in 0 until childCount) {
            val innerView = view.getChildAt(i)
            setupKeyboard(innerView, activity, clearFocus)
        }
    }
}

private fun hideSoftKeyboard(activity: Activity) {
    try {
        val manager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity.currentFocus
        if (view != null) {
            manager.hideSoftInputFromWindow(view.windowToken, 0)
            if (view is EditText) {
                clearFocusEditText(arrayOf(view))
            }
        }
    } catch (_: Exception) {
    }
}

private fun clearFocusEditText(editTexts: Array<EditText>) {
    for (editText in editTexts) {
        editText.clearFocus()
    }
}