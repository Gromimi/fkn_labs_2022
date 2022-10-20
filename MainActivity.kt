package com.example.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            Screen();
        }
    }
}


@Composable
private fun Screen() {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    )
    {


        LazyColumn {
            item {
                Head();
            }
            item {
                Body();
            }
        }
    }
}



@Composable
fun Head() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel),
            contentDescription = "marvel",
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = "Choose your hero",
            style = TextStyle(color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        )
    }
}




@Composable
fun Body() {



    val lazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState

    ) {
        item {
            Hero(imgName = R.drawable.deadpool, description = "Deadpool")
        }

        item {

            Hero(imgName = R.drawable.doctor_strange, description = "Doctor strange")
        }
        item {

            Hero(imgName = R.drawable.iron_man, description = "Iron man")

        }
        item {

            Hero(imgName = R.drawable.thor, description = "Thor")

        }
        item {

            Hero(imgName = R.drawable.spider_man, description = "Spider man")

        }
    }
}



@Composable
fun Hero(imgName: Int, description: String) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .shadow(
                elevation =5.dp,
                shape = RoundedCornerShape(10)
            )
    )
    {
        Image(
            painter = painterResource(id = imgName),
            contentDescription = description,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(350.dp, 550.dp)
                .clip(RoundedCornerShape(10))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = description,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
