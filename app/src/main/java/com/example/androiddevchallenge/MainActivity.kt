/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.BarUtils
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.SolarTerm
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val vm = viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BarUtils.transparentStatusBar(this)
        BarUtils.setStatusBarLightMode(this, true)

        setContent {
            MyTheme {
                MyApp(vm.value)
            }
        }

        vm.value.navigation.observe(this, Observer {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("index", it.index)
            startActivity(intent)
        })
    }
}

//https://en.wikipedia.org/wiki/Solar_term

// Start building your app here!
@Composable
fun MyApp(vm: MainViewModel) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Spacer(modifier = Modifier.height(32.dp))

            LazyColumn(
                content = {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.ic_title),
                            contentDescription = "",
                            modifier = Modifier
                                .width(240.dp)
                                .padding(horizontal = 16.dp),
                            contentScale = ContentScale.FillWidth
                        )
                    }

                    item {
                        Text(
                            text = "@麋鹿先生",
                            color = Color(0xFF68a78c),
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }

                    items(DataProvider.solarTermList) {
                        TermsItem(
                            term = it,
                            vm = vm,
                        )
                    }
                })
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(MainViewModel())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(MainViewModel())
    }
}

@Preview
@Composable
fun TermsItemPreview() {
    TermsItem(term = DataProvider.solarTermList[0], vm = MainViewModel())
}

@Composable
fun TermsItem(term: SolarTerm, vm: MainViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .clickable {
                vm.navigation.value = term
            }
    ) {
        Image(
            painter = painterResource(id = term.termRes),
            contentDescription = term.titleOfEn,
            modifier = Modifier.size(88.dp)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = term.titleOfEn,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = term.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraLight
            )
        }
    }
}
