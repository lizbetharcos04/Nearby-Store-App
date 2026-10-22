package com.example.nearbystoreapp.Activites.Dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import com.example.nearbystoreapp.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview

import com.example.nearbystoreapp.ui.theme.NearbyStoreAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashboardScreen()
        }
    }
}
@Composable
@Preview
fun DashboardScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = colorResource(R.color.blue))
    Scaffold(
        bottomBar = {MyBottomBar()}
    ){
        paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.white))
                .padding(paddingValues=paddingValues)
        ){
            item{TopBar()}
        }
    }
}