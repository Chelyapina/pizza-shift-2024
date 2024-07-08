package com.example.finalpizzashift2024.ui.theme.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.finalpizzashift2024.R
import com.example.finalpizzashift2024.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaApp(modifier: Modifier = Modifier) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar (
                title = {
                    Text(
                        text = stringResource(id =R.string.main_page_title),
                        style = Typography.headlineLarge,
                        textAlign = TextAlign.Left,
                        modifier = modifier.padding(16.dp)
                    )
                }
            )
        }

    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
        ) {
            HomeScreen()
        }
    }
}