package com.example.httpjsonparser

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import androidx.core.text.HtmlCompat
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var parseJson: parseJSON

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parseJson = (application as parseJSON)

        btnCount.setOnClickListener {
            parseJson.apiManager.userInfo {currentUser ->
                tvUsername.text = HtmlCompat.fromHtml("Username: ${currentUser.username}", HtmlCompat.FROM_HTML_MODE_LEGACY)
                imgCurrUser.visibility = View.VISIBLE
                Picasso.get().load("https://picsum.photos/seed/voldemort/256").into(imgCurrUser)
                tvFirstName.text = HtmlCompat.fromHtml("First Name: ${currentUser.firstName}", HtmlCompat.FROM_HTML_MODE_LEGACY)
                tvLastName.text = HtmlCompat.fromHtml("Last Name: ${currentUser.lastName}", HtmlCompat.FROM_HTML_MODE_LEGACY)
                if (currentUser.hasNose) {
                    tvHasNose.text = HtmlCompat.fromHtml("has nose: Yes", HtmlCompat.FROM_HTML_MODE_LEGACY)
                } else {
                    tvHasNose.text = HtmlCompat.fromHtml("has nose: No", HtmlCompat.FROM_HTML_MODE_LEGACY)
                }
                tvPlatform.text = HtmlCompat.fromHtml("Platform: ${currentUser.platform}", HtmlCompat.FROM_HTML_MODE_LEGACY)
            }
            parseJson.counter = parseJson.counter + 1
            tvCounter.text = "Count is: ${parseJson.counter}"
        }
    }
}
