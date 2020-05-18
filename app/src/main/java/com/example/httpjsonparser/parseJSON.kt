package com.example.httpjsonparser

import android.app.Application

class parseJSON: Application() {
    var counter = 0

    lateinit var apiManager: Api

    override fun onCreate() {
        super.onCreate()

        apiManager = Api(this)
    }

}