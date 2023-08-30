package ru.nb.domofon

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitHorizontalDragOrCancellation
import androidx.compose.foundation.gestures.awaitHorizontalTouchSlopOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Test2() {
	val offsetX = remember { mutableStateOf(0f) }
	val offsetY = remember { mutableStateOf(0f) }
	var width by remember { mutableStateOf(0f) }
	Box(
		Modifier.fillMaxSize()
			.onSizeChanged { width = it.width.toFloat() }
	) {
		Box(
			Modifier.offset { IntOffset(offsetX.value.roundToInt(), offsetY.value.roundToInt()) }
				.heightIn(100.dp)
				.width(200.dp)
				.background(Color.Blue)
				.pointerInput(Unit) {
					awaitEachGesture {
						val down = awaitFirstDown()
						var change =
							awaitHorizontalTouchSlopOrCancellation(down.id) { change, over ->
								val originalX = offsetX.value
								val newValue =
									(originalX + over).coerceIn(0f, width - 50.dp.toPx())
								change.consume()
								offsetX.value = newValue
							}
						while (change != null && change.pressed) {
							change = awaitHorizontalDragOrCancellation(change.id)
							if (change != null && change.pressed) {
								val originalX = offsetX.value
								val newValue = (originalX + change.positionChange().x)
									.coerceIn(0f, width - 50.dp.toPx())
								change.consume()
								offsetX.value = newValue
							}
						}
					}
				}
		)
	}
}