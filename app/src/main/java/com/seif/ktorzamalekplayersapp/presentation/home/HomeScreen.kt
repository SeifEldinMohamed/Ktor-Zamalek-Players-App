package com.seif.ktorzamalekplayersapp.presentation.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.seif.ktorzamalekplayersapp.data.remote.dto.Player

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val player: Player? = homeViewModel.state.value.player
    val error: String? = homeViewModel.state.value.error
val context = LocalContext.current

    player?.let {
        PlayerData(it, homeViewModel)
    }
    error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PlayerData(player: Player, homeViewModel: HomeViewModel) {
    val isLoading: Boolean = homeViewModel.state.value.isLoading

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = player.name,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = rememberImagePainter(
                data = player.imageUrl,
                builder = { crossfade(true) }
            ),
            contentDescription = "player",
            Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Age: ${player.age}", color = Color.Black)
            Text(text = "Position: ${player.position}", color = Color.Black)

        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick =  homeViewModel::getRandomPlayer
        ) {
            Text(text = "Next Player")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) CircularProgressIndicator()
    }
}
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    KtorZamalekPlayersAppTheme {
//        HomeScreen()
//    }
//}