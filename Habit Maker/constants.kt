package com.example.mycity.ui.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import com.example,mycity.ui.theme.Black
import com.example,mycity.ui.theme.Green
import com.example,mycity.ui.theme.Yellow

val FILTER_CONTENT_LIST = listOf(
    FilterContent(Color.White, Black, "Study math"),
    FilterContent(Black, Color.White, "DSA assignment"),
    FilterContent(Black, Color.White, "Calculus assignment"),
    FilterContent(Black, Color.White, "Go to gym"),

)

val MEDITATION_TYPE_LIST = listOf(
    sites(
        "45 mins",
        "Go to walk",
        Black,
        Green
    ),
    sites(
        "34 mins",
        "Do math",
        Green,
        Black,
        Yellow
    ),
    sites(
        "25 mins",
        "Practice Dance",
        Black,
        Color.White,
        Yellow
    )

)