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
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.finalpizzashift2024.R
import com.example.finalpizzashift2024.net.data.DataToppings
import com.example.finalpizzashift2024.ui.theme.Typography
import com.example.finalpizzashift2024.net.data.OnePizzaInfo
import com.example.finalpizzashift2024.net.data.cart.DataCart
import com.example.finalpizzashift2024.net.data.cart.DataCartForOnePizza


@Composable
fun PizzaScreen(pizza: List<OnePizzaInfo>, modifier: Modifier) {
    Column {
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
fun PizzaCard(pizza: OnePizzaInfo, pizzaRes: DataCart, modifier: Modifier = Modifier) {
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
            PizzaAlert(
                pizza = pizza,
                pizzaRes = pizzaRes,
                onDismiss = { showDialog = false })
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
