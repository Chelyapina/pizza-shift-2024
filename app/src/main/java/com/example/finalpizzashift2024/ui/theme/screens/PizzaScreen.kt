package com.example.finalpizzashift2024.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.finalpizzashift2024.R
import com.example.finalpizzashift2024.ui.theme.Typography
import com.example.finalpizzashift2024.net.data.OnePizzaInfo

@Composable
fun PizzaScreen(pizza: List<OnePizzaInfo>, modifier: Modifier) {
    Column {
//        Text(
//            text = stringResource(id =R.string.main_page_title),
//            style = Typography.titleLarge,
//            textAlign = TextAlign.Left,
//            modifier = modifier.padding(16.dp)
//        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(4.dp)
        ) {
            itemsIndexed(pizza) { _, piz ->
                PizzaCard(pizza = piz)
            }
        }
    }
}

@Composable
fun PizzaCard(pizza: OnePizzaInfo, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            AsyncImage(
                modifier = modifier.size(160.dp, 160.dp),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(pizza.img)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.content_description),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                pizza.name?.let {
                    Text(
                        text = it,
                        style = Typography.titleLarge,
                        textAlign = TextAlign.Left,
                    )
                }

                pizza.description?.let {
                    Text(
                        text = it,
                        style = Typography.bodyMedium,
                        textAlign = TextAlign.Left,
                    )
                }

                pizza.minCost?.toString()?.let {
                    Text(
                        text = "От $it ₽",
                        style = Typography.titleLarge,
                        textAlign = TextAlign.Left,
                        modifier = modifier
                    )
                }

            }
        }
    }
}
