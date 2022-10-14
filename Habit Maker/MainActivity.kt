package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateIntSizeAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breens.flowermeditationapp.ui.theme.*
import com.breens.flowermeditationapp.ui.utils.FILTER_CONTENT_LIST
import com.breens.flowermeditationapp.ui.utils.MEDITATION_TYPE_LIST
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.ui.theme.Shape
import com.example.mycity.ui.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitMakerTheme() {

            }theme {
                Column(
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .fillMaxSize()
                ) {
                    HeaderProfileComponent()
                    SearchInputComponent()
                    FilterOptionsComponent()
                    Destination_comp()
                }
            }
        }
    }

    @Preview
    @Composable
    fun HeaderProfileComponent() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 15.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.streak),
                    contentDescription = "sreakcount",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(
                        text = "Welcome back ",
                       fontFamily = FontFamily.SansSerif,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Melissa         ",
                       fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }

            }
        }
    }

    @Preview
    @Composable
    fun SearchInputComponent() {
        OutlinedTextField(
            value = "", onValueChange = {},
            placeholder = { Text(text = "Search", fontFamily = FontFamily.SansSerif) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "HAbits"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, start = 15.dp, end = 15.dp)
                .background(color = Color.White, shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.LightGray,
                trailingIconColor = Color.Black
            )
        )
    }

    @Composable
    fun FilterOptionsComponent() {
        val filterOptions = FILTER_CONTENT_LIST
        LazyRow(
            Modifier.padding(top = 15.dp, start = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(filterOptions.size) {
                ChipComponent(filter = filterOptions[it])
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun ChipComponent(filter: habits) {
        val contentColor = filter.contentColor
        val chipBackground = filter.backgroundColor
        val filterText = filter.filterText
        Chip(
            onClick = { /*TODO*/ },
            colors = ChipDefaults.chipColors(
                contentColor = contentColor,
                 backgroundColor = chipBackground
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = filterText, fontFamily = FontFamily.Serif)
        }
    }

    @Composable
    fun Destination() {
        val sites = MEDITATION_TYPE_LIST
        LazyColumn(
            Modifier.padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(sites.size) {
                Sites(sites = animateIntSizeAsState(targetValue = )[it])
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun Destination_comp(sites: sites) {
        Card(
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.fillMaxSize(),
            backgroundColor = sites.backgroundColor
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(20.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    ChipComponent(
                        Button(onClick = { /*TODO*/ }) {

                        }
                     //shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = sites.Description, fontFamily = FontFamily.Serif)
                    }
                    Box(

                        Button(onClick = { /*TODO*/ }) {

                        }
                        )
                    //var shape = RoundedCornerShape(8.dp)
                     {
                        Text(text = sites.Description, fontFamily = FontFamily.Serif)
                    }
                }

                Text(
                    text = sites.title,
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    color = sites.contentColor,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = sites.Description,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    color = sites.contentColor,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}
