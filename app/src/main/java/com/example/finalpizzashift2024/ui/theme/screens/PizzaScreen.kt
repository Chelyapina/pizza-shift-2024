package com.example.finalpizzashift2024.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.example.finalpizzashift2024.net.data.DataToppings
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
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
            .clickable { showDialog = true },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        if (showDialog) {
            PizzaAlert(pizza, onDismiss = { showDialog = false })
        }

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

@Composable
fun PizzaAlert(pizza: OnePizzaInfo, onDismiss: () -> Unit){
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(id =R.string.main_page_title)) },
        text = {
            Column {
                pizza.name?.let { Text(it, style = Typography.titleLarge) }

                AsyncImage(
                    modifier = Modifier.size(220.dp,220.dp),
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(pizza.img)
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(id = R.string.content_description),
                    contentScale = ContentScale.Crop
                )

                //Spacer(modifier = Modifier.height(16.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    itemsIndexed(pizza.dataToppings ?: emptyList()) { _, ingredient ->
                        IngredientCard(ingredient = ingredient)
                    }
                }
            }
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(1),
//                contentPadding = PaddingValues(4.dp)
//            ) {
//                itemsIndexed(pizza) { _, piz ->
//                    PizzaCard(pizza = piz)
//                }
//            }
        },

        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Close")
            }
        },
        //style = Typography.titleLarge,
    )
}


@Composable
fun IngredientCard(
    ingredient: DataToppings
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        //elevation = 4.dp,
        //shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ingredient.img,
                    contentDescription = ingredient.name.toString(),
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = ingredient.name.toString(),
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Text(
                text = ingredient.cost?.toString() ?: "N/A",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}