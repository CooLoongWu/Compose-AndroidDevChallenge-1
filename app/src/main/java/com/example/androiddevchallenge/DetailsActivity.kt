package com.example.androiddevchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.blankj.utilcode.util.BarUtils
import com.example.androiddevchallenge.data.DataProvider

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val index = intent.getIntExtra("index", 1)
        val solarTerm = DataProvider.solarTermList[index - 1]

        BarUtils.transparentStatusBar(this)
        BarUtils.setStatusBarLightMode(this, false)

        setContent {
            Column {
                Image(
                    painter = painterResource(id = solarTerm.detailsRes),
                    contentDescription = solarTerm.titleOfEn,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}