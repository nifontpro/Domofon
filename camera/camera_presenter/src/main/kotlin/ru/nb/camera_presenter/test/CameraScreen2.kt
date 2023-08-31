package ru.nb.camera_presenter.test

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

val list = listOf(
	EmailMessage("John Doe", "Hello"),
	EmailMessage("Alice", "Hey there! How's it going?"),
	EmailMessage("Bob", "I just discovered a cool new programming language!"),
	EmailMessage("Geek", "Have you seen the latest tech news? It's fascinating!"),
	EmailMessage("Mark", "Let's grab a coffee and talk about coding!"),
	EmailMessage("Cyan", "I need help with a coding problem. Can you assist me?"),
)


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CameraScreen2() {

	val squareSize = 96.dp

	val sizePx = with(LocalDensity.current) { -squareSize.toPx() }
	val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states

	LazyColumn(modifier = Modifier.fillMaxWidth()) {

		 items(list) { emailContent ->
			val swipeableState = rememberSwipeableState(0)
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.background(Color.Green)
			) {
				Row(modifier = Modifier.align(Alignment.CenterEnd)) {
					Text("Del")
					Spacer(modifier = Modifier.width(4.dp))
					Text("Ed")
				}
				Box(
					modifier = Modifier
						.fillMaxWidth()
						.swipeable(
							state = swipeableState,
							anchors = anchors,
							thresholds = { _, _ -> FractionalThreshold(0.1f) },
							orientation = Orientation.Horizontal
						)
				) {
					Box(
						Modifier
							.offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
							.fillMaxWidth()
							.background(Color.LightGray)
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
		}
	}
}
