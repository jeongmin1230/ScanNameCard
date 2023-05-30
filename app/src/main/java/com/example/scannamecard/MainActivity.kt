package com.example.scannamecard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.scannamecard.ui.theme.PrimaryColor
import com.example.scannamecard.ui.theme.ScanNameCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScanNameCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}



@SuppressLint("DiscouragedApi")
@Composable
fun MainScreen() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.scan))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)
    val context = LocalContext.current // LocalContext를 사용하여 context를 가져옴

    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.weight(1f)) {
            LottieAnimation(
                composition = composition,
                progress = progress,
            )
        }
        Column(modifier = Modifier.padding(bottom = 20.dp)) {
            Row(
                modifier = Modifier
                .clickable {
                    // TODO - OCR 스캔 카메라 열기
                }
                .border(BorderStroke(1.dp, PrimaryColor), shape = CircleShape),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.button_image),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 10.dp, top = 20.dp, end = 4.dp)
                )
                Text(text = stringResource(id = R.string.easy_scan),
                    modifier = Modifier.padding(end = 10.dp))
            }
        }

    }

}