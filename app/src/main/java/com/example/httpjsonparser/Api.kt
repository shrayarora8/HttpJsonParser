package com.example.httpjsonparser

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class Api(context: Context) {
    private val queue: RequestQueue = Volley.newRequestQueue(context)
    private val cont: Context = context

    fun userInfo(onUserReady: (userInformation) -> Unit) {
        val url = "https://raw.githubusercontent.com/echeeUW/codesnippets/master/user_info.json"
        val request = StringRequest(Request.Method.GET, url, { response ->
            val gson = Gson()
            val user = gson.fromJson(response, userInformation::class.java)
            onUserReady(user)
        }, {error ->
            Toast.makeText(cont, "Error while fetching: ${error.message}", Toast.LENGTH_SHORT).show()
        })
        queue.add(request)
    }
}