package net.jetpackcompose.composetext.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import net.jetpackcompose.composetext.R
import net.jetpackcompose.composetext.model.FoodModel
import net.jetpackcompose.composetext.ui.theme.*

class ActivityThemes : ComponentActivity() {
    private val TAG = "ThemesSamplesActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = remember { mutableStateOf(false) }
            if(isDarkTheme.value){
                this.window.statusBarColor = ContextCompat.getColor(this, R.color.black)
            }else{
                this.window.statusBarColor = ContextCompat.getColor(this, R.color.purple_700)
            }
            //custom theme
            MyAppTheme(darkTheme = isDarkTheme.value) {
                Log.d(TAG, "onCreate: isSystemInDarkTheme " + isSystemInDarkTheme())
                Scaffold(topBar = {
                    ThemeAppBar(darkThemeState = isDarkTheme)
                },floatingActionButton = {
                    FloatingActionButton(onClick = { Toast.makeText(this,"You clicked",Toast.LENGTH_SHORT).show() }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                    }
                }
                ) {
                    FoodItemsRootView()
                }
            }
        }
    }

    @Composable
    fun ThemeAppBar(darkThemeState: MutableState<Boolean>) {
        TopAppBar(title = {
            Row {
                Text(text = "Themes", modifier = Modifier.weight(8f))
                Switch(checked = darkThemeState.value, onCheckedChange = {
                    darkThemeState.value = it
                }, modifier = Modifier.weight(2f))
            }
        }
        )
    }

    @Composable
    fun FoodItemsRootView() {
        val scrollState = rememberScrollState()
        val pizzaImageUrl =
            "https://media.istockphoto.com/photos/italian-food-delicious-homemade-pizza-with-mozzarella-and-cherry-picture-id1194486151?s=612x612"
        val burgerImageUrl =
            "https://media.istockphoto.com/photos/juicy-burger-on-the-board-black-background-dark-background-fast-food-picture-id1215384689?s=612x612"
        val pizza = FoodModel(
            "Homemade veg pizza",
            "$ 10.50",
            pizzaImageUrl,
            "Italian food: delicious homemade pizza with mozzarella and cherry tomatoes shot from above on rustic wooden table. Some ingredients for preparing pizza like mozzarella cheese, basil, fresh tomatoes, olive oil, salt and pepper are all around the pizza. "
        )

        val burger = FoodModel(
            "Cheese Burger",
            "$ 5.50",
            burgerImageUrl,
            "Juicy burger on the board, black background. Dark background, fast food. Traditional american food. "
        )
        Column(
            Modifier
                .background(MaterialTheme.colors.PageBackground)
                .padding(10.dp)
                .verticalScroll(scrollState)
        ) {
            RowFoodItem(pizza)
            RowFoodItem(burger)
            RowFoodItem(pizza)
            RowFoodItem(burger)
        }
    }


    @Composable
    fun RowFoodItem(foodModel: FoodModel) {
        Card(elevation = 10.dp, modifier = Modifier.padding(top = 20.dp)) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                FoodImage(url = foodModel.imageUrl)
                Text(text = foodModel.name, style = MaterialTheme.typography.customTitle)

                CompositionLocalProvider(LocalContentAlpha provides (ContentAlpha.disabled)) {
                    Text(text = foodModel.description)//description
                }
            }
        }
    }

    //Image - It will load image from URL using coil library 
    @Composable
    fun FoodImage(url: String) {
        Image(
            painter = rememberImagePainter(data = url, builder = {
                crossfade(true)
                crossfade(2000)
            }), contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}