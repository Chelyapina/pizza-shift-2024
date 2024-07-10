package com.example.finalpizzashift2024.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import com.example.finalpizzashift2024.net.data.OnePizzaInfo
import com.example.finalpizzashift2024.net.data.cart.DataCartForOnePizza
import com.example.finalpizzashift2024.net.model.NameDoughs
import com.example.finalpizzashift2024.ui.theme.Typography
import com.example.pizzashift2024.Doughs
import com.example.pizzashift2024.Sizes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaAlert(
    pizza: OnePizzaInfo,
    pizzaRes: MutableList<DataCartForOnePizza>,
    onDismiss: () -> Unit
){
    val selectedSize = remember { mutableStateListOf<Sizes?>(null) }
    val selectedDough = remember { mutableStateListOf<Doughs?>(null) }
    selectedDough.add(Doughs(name = NameDoughs.THIN, price = 0))
    val selectedToppings = remember { mutableStateListOf<DataToppings>() }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                androidx.compose.material3.Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = stringResource(id = R.string.close),
                    modifier = Modifier
//                        .size(14.dp)
                        .clickable { onDismiss() }
                        .padding(16.dp)
                )
                pizza.name?.let { Text(it, style = Typography.headlineLarge, textAlign = TextAlign.Left) }
            }
        },
        text = {
            Column {

                AsyncImage(
                    modifier = Modifier
                        .size(220.dp, 220.dp)
                        .align(Alignment.CenterHorizontally),
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(pizza.img)
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(id = R.string.content_description),
                    contentScale = ContentScale.Crop
                )

                pizza.description?.let {
                    Text(
                        text = it,
                        style = Typography.titleLarge,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                var selectedIndex by remember { mutableStateOf(0) }
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                ) {
                    pizza.sizes?.forEachIndexed { index, size ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = pizza.sizes?.size ?: 0
                            ),
                            onClick = { selectedIndex = index; selectedSize.add(size) },
                            selected = index == selectedIndex
                        ) {
                            Text(size.name.toString(), style = Typography.bodyLarge)
                        }
                    }
                }

                Text(
                    text = stringResource(id = R.string.add_to_taste),
                    style = Typography.titleLarge,
                    modifier = Modifier.padding(8.dp)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(4.dp) ) {
                    itemsIndexed(pizza.dataToppings ?: emptyList()) { _, ingredient ->
                        ToppingsCard(ingredient = ingredient, selectedToppings)
                    }
                }
            }
        },

        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth()
                .wrapContentSize(Alignment.Center)
            ) {
                Button(
                    onClick = {
                        val updatedPizza = pizza.description?.let {
                            pizza.name?.let { it1 ->
                                DataCartForOnePizza(
                                    name = it1,
                                    sizes = selectedSize,
                                    description = it,
                                    doughs = selectedDough,
                                    dataToppings = selectedToppings
                                )
                            }
                        }
                        if (updatedPizza != null) {
                            pizzaRes.add(updatedPizza)
                        }
                    },
                    content = {
                        Text(stringResource(R.string.add_to_cart))
                    }
                )
            }
        }
    )
}


@Composable
fun ToppingsCard(
    ingredient: DataToppings,
    selectedToppings:  MutableList<DataToppings>
) {
    var isSelected by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { isSelected = !isSelected
                if (isSelected) {
                    selectedToppings.add(ingredient)
                } else {
                    selectedToppings.remove(ingredient)
                }}
            .background(
                color = if (isSelected) Color.LightGray else Color.White,

            ),
        shape = RoundedCornerShape(16.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .size(104.dp, 172.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            AsyncImage(
                model = ingredient.img,
                contentDescription = ingredient.name.toString(),
                modifier = Modifier
                    .size(88.dp)
                    .align(Alignment.CenterHorizontally)
            )

            ingredient.name?.toString()?.let {
                Text(
                    text = it,
                    style = Typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            ingredient.cost?.toString()?.let {
                Text(
                    text = it + " " +
                            stringResource(id = R.string.ruble_symb),
                    style = Typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
