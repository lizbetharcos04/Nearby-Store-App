package com.example.nearbystoreapp.Activites.Dashboard
import androidx.compose.ui.Alignment
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import com.example.nearbystoreapp.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.sp


@Composable
@Preview
fun MyBottomBar() {
    val bottomMenuItemsList = prepareBottomMenu()
    val context = LocalContext.current
    var selected by remember { mutableStateOf("Home") }

    BottomAppBar(
        backgroundColor = colorResource(R.color.white),
        elevation = 3.dp
    ) {
        bottomMenuItemsList.forEach{ bottomMenuItemsList->
            BottomNavigationItem(
                selected=(selected==bottomMenuItemsList.label),
                onClick = {
                    selected=bottomMenuItemsList.label
                        Toast.makeText(context, bottomMenuItemsList.label, Toast.LENGTH_SHORT).show()
                }, icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painter = bottomMenuItemsList.icon, 
                            contentDescription = null,
                            tint = colorResource(R.color.darkBrown),
                            modifier = Modifier
                                .padding(top=8.dp)
                                .size(20.dp)
                        )
                        Text(
                            text = bottomMenuItemsList.label,
                            fontSize = 12.sp,
                            color = colorResource(R.color.darkBrown),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            )
        }
    }
}

data class BottomMenuItem(
    val label:String, val icon:Painter
)

@Composable
fun prepareBottomMenu():List<BottomMenuItem>{
    val bottomMenuItemsList= arrayListOf<BottomMenuItem>()
    bottomMenuItemsList.add(BottomMenuItem(label = "Home", icon = painterResource(R.drawable.btn_1)))
    bottomMenuItemsList.add(BottomMenuItem(label = "Support", icon = painterResource(R.drawable.btn_2)))
    bottomMenuItemsList.add(BottomMenuItem(label = "Wishlist", icon = painterResource(R.drawable.btn_3)))
    bottomMenuItemsList.add(BottomMenuItem(label = "Profile", icon = painterResource(R.drawable.btn_4)))

    return bottomMenuItemsList
}