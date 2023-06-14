package com.paparazziteam.dialogcustom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.paparazziteam.dialogcustom.ui.theme.DialogCustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogCustomTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogCustomTheme {
        CustomDialog(
            onDismissRequest = { /*TODO*/ }
        )
    }
}

@Composable
fun HomeScreen(){
    val showDialog = remember { mutableStateOf(false) }

    if(showDialog.value){
        CustomDialog(
            onDismissRequest = { showDialog.value = false }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {
            showDialog.value = true }
        ) {
            Text(text = "Show Dialog")
        }
    }


}


@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomDialog(
    onDismissRequest: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box() {
            Card(modifier = Modifier
                .padding(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Successfully",
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.padding(14.dp))
                    Text(
                        text = "Your account has been created, you can now log in.",
                        fontWeight = FontWeight.Normal,
                    )
                    Spacer(modifier = Modifier.padding(14.dp))
                    Button(
                        onClick = { onDismissRequest() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF1276C5),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Regresar")
                    }
                    Spacer(modifier = Modifier.padding(14.dp))

                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.TopCenter)
            )

        }
    }
}