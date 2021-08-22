package net.jetpackcompose.composetext

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.model.FruitModel

class ListViewSampleActivity : ComponentActivity() {
    private  val TAG = "ListViewSampleActivity"
    private val fruitsList = mutableListOf<FruitModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setData()
        setContent {
            MaterialTheme() {
                ListRootView(fruitsList)
            }
        }
    }

    private fun setData() {
        fruitsList.add(FruitModel("Apple", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Banana", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Strawberry", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Mango", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Kiwi", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Papaya", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Apple", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Apple", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Banana", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Strawberry", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Mango", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Kiwi", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Papaya", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Apple", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Apple", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Banana", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Strawberry", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Mango", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Kiwi", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Papaya", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Apple", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Apple", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Banana", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Strawberry", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Mango", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Kiwi", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Papaya", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Apple", R.drawable.ic_cart))
        fruitsList.add(FruitModel("Orange", R.drawable.ic_cart))
    }

    @Composable
    fun ListRootView(data: List<FruitModel>) {
        var isLazyColumn = false
        Column() {
            Button(onClick = {
                isLazyColumn = !isLazyColumn
                Log.d(TAG, "ListRootView: click action : "+isLazyColumn)

            }) {
                if (!isLazyColumn) {
                    Text(text = "Switch to LazyColumn (RecyclerView)")

                } else {
                    Text(text = "Switch to Column (ListView)")
                }
            }
            if (isLazyColumn) {
                LazyColumnSample(data = data)
            } else {
                ColumnSample(data = data)
            }
        }

    }

    @Composable
    fun LazyColumnSample(data: List<FruitModel>) {
        Log.d(TAG, "LazyColumnSample: ")
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Gray)
        ) {
            items(data) { model ->

                ListRow(model = model)
            }
        }
    }

    @Composable
    fun ColumnSample(data: List<FruitModel>) {
        Log.d(TAG, "ColumnSample: ")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Gray)
        ) {
            data.forEach { model ->
                ListRow(model = model)
            }
        }
    }

    @Composable
    fun ListRow(model: FruitModel) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 10.dp)
                    .heightIn(100.dp, 150.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = model.image),
                    contentDescription = "",
                    modifier = Modifier
                        .width(100.dp)
                        .padding(15.dp)
                )
                Text(
                    text = model.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
            Divider()
        }
    }
}