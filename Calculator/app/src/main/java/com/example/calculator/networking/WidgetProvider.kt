package com.example.calculator.networking

object WidgetProvider {
    fun provide (): Widget{
        return RetrofitProvider.provide()
            .create(Widget::class.java)
    }
}