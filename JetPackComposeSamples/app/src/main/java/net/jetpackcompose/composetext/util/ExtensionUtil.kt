package net.jetpackcompose.composetext


val String.color
    get() = androidx.compose.ui.graphics.Color(android.graphics.Color.parseColor(this))
