package com.example.androiddevchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blankj.utilcode.util.BarUtils
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.SolarTerm

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val index = intent.getIntExtra("index", 1)
        val solarTerm = DataProvider.solarTermList[index - 1]

        BarUtils.transparentStatusBar(this)
        BarUtils.setStatusBarLightMode(this, false)

        setContent {
            DetailsView(solarTerm = solarTerm)
        }
    }
}

@Preview
@Composable
fun DetailsViewPreview() {
    DetailsView(solarTerm = DataProvider.solarTermList[23])
}

@Composable
fun DetailsView(solarTerm: SolarTerm) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())

        ) {
            Image(
                painter = painterResource(id = solarTerm.detailsRes),
                contentDescription = solarTerm.titleOfEn,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(16.dp)
                        .height(8.dp)
                        .background(
                            color = Color(0xFF464679),
                            shape = RoundedCornerShape(size = 4.dp)
                        )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            color = Color(0xFF464679),
                            shape = RoundedCornerShape(size = 4.dp)
                        )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            color = Color(0xFF464679),
                            shape = RoundedCornerShape(size = 4.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Image(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = solarTerm.time,
                    color = Color(0xFF666666),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            TitleText(id = R.string.paraphrase)
            Spacer(modifier = Modifier.height(8.dp))
            ContentText(id = R.string.paraphrase_content)

            Spacer(modifier = Modifier.height(16.dp))
            TitleText(id = R.string.feature)
            Spacer(modifier = Modifier.height(8.dp))
            ContentText(id = R.string.feature_content)

            Spacer(modifier = Modifier.height(16.dp))
            TitleText(id = R.string.farming)
            Spacer(modifier = Modifier.height(8.dp))
            ContentText(id = R.string.farming_content)

            Spacer(modifier = Modifier.height(64.dp))
//
//            Spacer(modifier = Modifier.height(16.dp))
//            TitleText(id = R.string.folk)
//            Spacer(modifier = Modifier.height(8.dp))
//            ContentText(id = R.string.folk_content)
        }

        Box(
            modifier = Modifier
                .width(160.dp)
                .height(56.dp)
                .background(
                    color = Color(0xFF464679),
                    shape = RoundedCornerShape(topStart = 28.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "学习到了",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
        }
    }

}

@Composable
fun TitleText(@StringRes id: Int) {
    Text(
        text = stringResource(id = id),
        color = Color(0xFF464679),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun ContentText(@StringRes id: Int) {
    Text(
        text = stringResource(id = id),
        color = Color(0xFF999999),
        fontSize = 14.sp,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}