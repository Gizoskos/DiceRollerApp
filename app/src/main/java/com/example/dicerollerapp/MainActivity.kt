package com.example.dicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                DiceRollerApp()
                // A surface container using the 'background' color from the theme
                }
            }
        }
    }

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageResource = when(result){
        1 -> R.drawable.dice_1 //string
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val background = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
    }
    Row {
        Text("Let's Roll Your Dice My Friend!",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            lineHeight = 80.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterVertically))
        }
    Column (
    modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
    horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = imageResource),
        contentDescription = result.toString())
        Spacer(modifier = Modifier.height(1.dp))
        Button(onClick = {result = (1 .. 6).random()}){
            Text(stringResource(R.string.roll))
        }
    }

}
@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceRollerAppTheme {
        DiceWithButtonAndImage()
    }
}
