package net.jetpackcompose.composetext.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ActivityTextField : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldRootView()
        }
    }
}

@Composable
fun TextFieldRootView() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        SimpleTextField()
        LabelAndPlaceHolder()
        TextFieldWithInputType()
        TextFieldWithPasswordType()
        OutLineTextFieldSample()
        TextFieldWithIcons()
        TextFieldValidation()
    }
}

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}


@Composable
fun LabelAndPlaceHolder() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Your Label") },
        placeholder = { Text(text = "Your Placeholder/Hint") },
    )
}

@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }
    )
}

@Composable
fun TextFieldWithPasswordType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Password Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { it ->
            text = it
        }
    )
}

@Composable
fun OutLineTextFieldSample() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Your Name") },
        onValueChange = {
            text = it
        }
    )
}


@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
    )
}

@Composable
fun TextFieldValidation() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val isInvalidValidMobile = text.text.length in 1..9

    OutlinedTextField(value = text,
        label = {
            var labelText = "Mobile Number"
            if (isInvalidValidMobile) {
                labelText = "Invalid Mobile Number"
            }
            Text(text = labelText)

        },
        placeholder = { Text(text = "Enter Your Mobile Number") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        isError = isInvalidValidMobile,
        onValueChange = {
            text = it

        })


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldPreview() {
    TextFieldRootView()
}