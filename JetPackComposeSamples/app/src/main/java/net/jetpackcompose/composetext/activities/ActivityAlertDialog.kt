package net.jetpackcompose.composetext.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import net.jetpackcompose.composetext.R

class ActivityAlertDialog : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertRootView()
        }
    }

    @Composable
    private fun AlertRootView() {
        val showDialog = remember {
            mutableStateOf(false)
        }
        Column(modifier = Modifier.fillMaxSize()) {
            Button(onClick = {
                showDialog.value = !showDialog.value
            }) {
                Text(text = "Show Dialog")
            }
            val context = LocalContext.current
            if (showDialog.value) {
               // customDialog()
                SimpleAlertDialog(
                    title = "Alert Title",
                    content = "Alert content" ,
                    okButtonTitle ="ok" ,
                    cancelBtnTitle ="cancel" ,
                    cancelCallBack = { showDialog.value = false },okCallBack = {
                        
                    })
            }
        }

    }
}

@Composable
fun SimpleAlertDialog(
    title: String, content: String,
    okButtonTitle: String,
    cancelBtnTitle: String,
    cancelCallBack: () -> Unit,
    okCallBack: () -> Unit,

    ) {
    Column(modifier = Modifier.fillMaxSize()) {
        AlertDialog(onDismissRequest = cancelCallBack, title = {
            Text(text = title, style = MaterialTheme.typography.h5)
        }, text = {
            Text(text = content)
        },
            confirmButton = {
                Button(onClick = okCallBack) {
                    Text(text = okButtonTitle)
                }
            },
            dismissButton = {
                Button(onClick = cancelCallBack) {
                    Text(text = cancelBtnTitle)
                }
            }
        )
    }

}

@Composable
fun CustomAlertDialog(
    title: String, content: String,
    okButtonTitle: String,
    cancelBtnTitle: String,
    cancelCallBack: () -> Unit,
    okCallBack: () -> Unit,

    ) {
    AlertDialog(
        onDismissRequest = cancelCallBack,


        title = {
            Text(text = title, style = MaterialTheme.typography.h5)
        },
        text = {
            Text(text = content)
        },


        confirmButton = {
            Button(onClick = okCallBack) {
                Text(text = okButtonTitle)
            }
        },
        dismissButton = {
            Button(onClick = cancelCallBack) {
                Text(text = cancelBtnTitle)
            }
        },
        backgroundColor = colorResource(id = R.color.purple_200),
        contentColor = Color.White,
    )
}

@Composable
fun customDialog(){
    AlertDialog(
        onDismissRequest = {

        },
        title = {
            Text(text = "Title")
        },
        text = {
            Text(
                "This area typically contains the supportive text " +
                        "which presents the details regarding the Dialog's purpose."
            )
        },
        buttons = {},
        modifier = Modifier.size(200.dp,250.dp)
    )
}

