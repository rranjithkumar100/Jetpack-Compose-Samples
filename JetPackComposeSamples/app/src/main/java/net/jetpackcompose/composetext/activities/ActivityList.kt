package net.jetpackcompose.composetext.activities

import android.os.Bundle
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.R
import net.jetpackcompose.composetext.color
import net.jetpackcompose.composetext.model.FruitModel

class ActivityList : ComponentActivity() {
    private val TAG = "ListViewSampleActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ListListScopeSample()
            //SimpleListView()
             CustomListView()
        }
    }

    @Composable
    fun ListListScopeSample(){
        LazyColumn {
            // Add a single item
            item {
                Text(text = "Header")
            }

            // Add 3 items
            items(3) { index ->
                Text(text = "First List items : $index")
            }

            // Add 2 items
            items(2) { index ->
                Text(text = "Second List Items: $index")
            }

            // Add another single item
            item {
                Text(text = "Footer")
            }
        }
    }

    private val countryList =
        mutableListOf("India", "Pakistan", "China", "United States")
    private val listModifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .padding(10.dp)
    private val textStyle = TextStyle(fontSize = 20.sp, color = Color.White)

    @Composable
    fun SimpleListView() {
        LazyColumn(modifier = listModifier) {
            items(countryList) { country ->
                Text(text = country, style = textStyle,modifier = Modifier.padding(10.dp))
            }
        }
    }
    private val fruitsList = mutableListOf<FruitModel>()


    @Composable
    fun CustomListView() {
        //add the list
        fruitsList.add(FruitModel("Apple", R.drawable.apple))
        fruitsList.add(FruitModel("Orange", R.drawable.orange))
        fruitsList.add(FruitModel("Banana", R.drawable.banana))
        fruitsList.add(FruitModel("Strawberry", R.drawable.strawberry))
        fruitsList.add(FruitModel("Mango", R.drawable.mango))

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            items(fruitsList) { model ->
                ListRow(model = model)
            }
        }

    }


    @Composable
    fun ListRow(model: FruitModel) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background("#063041".color)
        ) {
            Image(
                painter = painterResource(id = model.image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)
            )
            Text(
                text = model.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}