package ru.nb.camera_presenter.test
/*
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

val list = listOf(
	EmailMessage("John Doe", "Hello"),
	EmailMessage("Alice", "Hey there! How's it going?"),
	EmailMessage("Bob", "I just discovered a cool new programming language!"),
	EmailMessage("Geek", "Have you seen the latest tech news? It's fascinating!"),
	EmailMessage("Mark", "Let's grab a coffee and talk about coding!"),
	EmailMessage("Cyan", "I need help with a coding problem. Can you assist me?"),
)

@Composable
fun CameraScreen() {

	LazyColumn(modifier = Modifier.fillMaxWidth()) {
		items(list) { emailContent ->
			val archive = SwipeAction(
				onSwipe = {
					Log.d("Swipe", "Archive")
				},
				icon = {
					Icon(
						imageVector = Icons.Filled.Contacts, contentDescription = null,
						modifier = Modifier.padding(16.dp)
					)
				},
				background = Color.Green
			)
			val delete = SwipeAction(
				onSwipe = {
					Log.d("Swipe", "Delete")
				},
				icon = {
					Icon(
						imageVector = Icons.Filled.Delete, contentDescription = null,
						modifier = Modifier.padding(16.dp)
					)
				},
				background = Color.Red
			)

			SwipeableActionsBox(
				swipeThreshold = 200.dp,
				startActions = listOf(archive),
				endActions = listOf(delete),
			) {
				Text(
					emailContent.message,
					style = MaterialTheme.typography.headlineMedium,
					modifier = Modifier
						.fillMaxWidth()
						.padding(16.dp)
				)
			}
		}
	}
}*/
