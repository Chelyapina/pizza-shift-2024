package com.example.finalpizzashift2024.ui.theme.screens

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.finalpizzashift2024.net.data.OnePizzaInfo
import com.example.finalpizzashift2024.net.data.cart.DataCart
import com.example.finalpizzashift2024.net.data.cart.DataCartForOnePizza
import com.example.finalpizzashift2024.ui.theme.CartViewModel
import com.example.finalpizzashift2024.ui.theme.Typography


@Composable
fun PizzaScreen(pizza: List<OnePizzaInfo>, modifier: Modifier) {
    val cartViewModel = remember { CartViewModel() }
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(4.dp)
        ) {
            itemsIndexed(pizza) { _, piz ->
                PizzaCard(pizza = piz, onAddToCart = {
                        newItem ->
                    cartViewModel.addPizzaToCart(newItem)
                })
            }
        }
    }
}

@Composable
fun PizzaCard(pizza: OnePizzaInfo, onAddToCart: (DataCartForOnePizza) -> Unit, modifier: Modifier = Modifier) {
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
//            PizzaAlert(
//                pizza = pizza,
//                pizzaRes = pizzaRes,
//                onDismiss = { showDialog = false })
            PizzaAlert(
                pizza = pizza,
                onDismiss = { showDialog = false },
                onAddToCart = { newItem ->
                    onAddToCart(newItem)
                }
            )
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
                        text = stringResource(id = R.string.from) +
                                " "+ it + " " +
                                stringResource(id = R.string.ruble_symb),
                        style = Typography.titleLarge,
                        textAlign = TextAlign.Left,
                        modifier = modifier
                    )
                }

            }
        }
    }
}
