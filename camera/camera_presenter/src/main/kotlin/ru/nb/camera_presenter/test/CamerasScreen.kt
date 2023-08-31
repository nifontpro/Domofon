package ru.nb.camera_presenter.test

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

val messages = listOf(
	EmailMessage("John Doe", "Hello"),
	EmailMessage("Alice", "Hey there! How's it going?"),
	EmailMessage("Bob", "I just discovered a cool new programming language!"),
	EmailMessage("Geek", "Have you seen the latest tech news? It's fascinating!"),
	EmailMessage("Mark", "Let's grab a coffee and talk about coding!"),
	EmailMessage("Cyan", "I need help with a coding problem. Can you assist me?"),
)

@Composable
fun CamerasScreen() {

	LazyColumn(modifier = Modifier.fillMaxWidth()) {
		itemsIndexed(items = list, key = { _, item -> item.message }) { _, emailContent ->
//			Text(emailContent.message)
			EmailItem(emailMessage = emailContent, onRemove = {})
		}
	}

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailItem(
	emailMessage: EmailMessage,
	onRemove: (EmailMessage) -> Unit
) {
	val context = LocalContext.current
	var show by remember { mutableStateOf(true) }
	val currentItem by rememberUpdatedState(emailMessage)
	val dismissState = rememberDismissState(
		confirmValueChange = {
			if (it == DismissValue.DismissedToStart || it == DismissValue.DismissedToEnd) {
				show = false
				true
			} else false
		}, positionalThreshold = { 150.dp.toPx() }
	)
	AnimatedVisibility(
		show, exit = fadeOut(spring())
	) {
		SwipeToDismiss(
			state = dismissState,
			modifier = Modifier,
			background = {
				DismissBackground(dismissState)
			},
			dismissContent = {
				EmailMessageCard(emailMessage)
			}
		)
	}

	LaunchedEffect(show) {
		if (!show) {
			delay(800)
			onRemove(currentItem)
			Toast.makeText(context, "Item removed", Toast.LENGTH_SHORT).show()
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissBackground(dismissState: DismissState) {
	val color = when (dismissState.dismissDirection) {
		DismissDirection.StartToEnd -> Color(0xFFFF1744)
		DismissDirection.EndToStart -> Color(0xFF1DE9B6)
		null -> Color.Transparent
	}
	val direction = dismissState.dismissDirection

	Row(
		modifier = Modifier
			.fillMaxSize()
			.background(color)
			.padding(12.dp, 8.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		if (direction == DismissDirection.StartToEnd) Icon(
			Icons.Default.Delete,
			contentDescription = "delete"
		)
		Spacer(modifier = Modifier)
		if (direction == DismissDirection.EndToStart) Icon(
			// make sure add baseline_archive_24 resource to drawable folder
			imageVector = Icons.Filled.Delete,
			contentDescription = "Archive"
		)
	}
}

// https://github.com/saket/swipe

@Composable
fun EmailMessageCard(emailMessage: EmailMessage) {
	ListItem(
		modifier = Modifier.clip(MaterialTheme.shapes.small),
		headlineContent = {
			Text(
				emailMessage.sender,
				style = MaterialTheme.typography.titleMedium
			)
		},
		supportingContent = {
			Text(
				emailMessage.message,
				style = MaterialTheme.typography.bodySmall
			)
		},
		leadingContent = {
			Icon(
				Icons.Filled.Person,
				contentDescription = "person icon",
				Modifier
					.clip(CircleShape)
					.background(MaterialTheme.colorScheme.primaryContainer)
					.padding(10.dp)
			)
		}
	)
}

data class EmailMessage(
	val sender: String,
	val message: String
)