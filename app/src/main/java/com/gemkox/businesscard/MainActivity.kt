package com.gemkox.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gemkox.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  BusinessCard()
                }
            }
        }
    }
}

@Composable
private fun Header(image: Int, fullName: String, title: String, modifier: Modifier = Modifier){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(8.dp)) {
        Image(painter = painterResource(id = image), contentDescription = "$fullName image",
            modifier
                .width(80.dp)
                .height(80.dp)
                .onFocusEvent {  }
        )
        Text(text = fullName, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 20.sp, modifier = modifier.padding(6.dp))
        Text(text = title, textAlign = TextAlign.Center)
    }
}

@Composable
private fun ContactInfoCard(icon: Int, text: String, modifier: Modifier = Modifier){
    Row (modifier = modifier.padding(6.dp)){
        Icon(painter = painterResource(id = icon) , contentDescription = "$text icon", tint = Color.LightGray)
        Text(text = text, textAlign = TextAlign.Center)
    }
}

@Composable
private fun Footer(){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
        ContactInfoCard(icon = R.drawable.baseline_local_phone_24, text = "614-588-4217, 614-588-4217")
        ContactInfoCard(icon = R.drawable.baseline_email_24, text = "alemajohmartin@gmail.com")
        ContactInfoCard(
            icon = R.drawable.baseline_location_on_24,
            text = "6943 Woody CT. Canal Winchester"
        )
    }
}

@Composable
private fun BusinessCard(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header(
                image = R.drawable.profile,
                fullName = "Martin Alemajoh",
                title = "Software Engineer"
            )
            Spacer(modifier = modifier.padding(top = 8.dp, bottom = 8.dp))
            Footer()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
       BusinessCard()
    }
}