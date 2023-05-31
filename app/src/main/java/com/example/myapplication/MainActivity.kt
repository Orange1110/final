package com.example.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Greeting("")
                    MyComposable()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "作者：資管二A 許梓揚" + "$name")
        Image(
            painter = painterResource(R.drawable.map),
            contentDescription = "地图"
        )
    }

}

@Composable
fun Image(painter: Painter, contentDescription: String) {
    androidx.compose.foundation.Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("")
    }
}
@Composable
fun MyComposable() {
    val showMessage = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            val rect1Color = Color.Blue
            val rect1Position = Offset(canvasWidth * 0.405f, canvasHeight * 0.18f)
            val rect1Size = Size(canvasWidth * 0.01f, canvasHeight * 0.02f)
            drawRect(rect1Color, rect1Position, rect1Size)

            val rect2Color = Color.Blue
            val rect2Position = Offset(canvasWidth * 0.89f, canvasHeight * 0.93f)
            val rect2Size = Size(canvasWidth * 0.01f, canvasHeight * 0.02f)
            drawRect(rect2Color, rect2Position, rect2Size)
        }

    }
}
