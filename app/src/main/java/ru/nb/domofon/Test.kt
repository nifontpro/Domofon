package ru.nb.domofon

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitDragOrCancellation
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitTouchSlopOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import kotlin.math.roundToInt

// https://developer.android.com/reference/kotlin/androidx/compose/foundation/gestures/package-summary#(androidx.compose.ui.Modifier).anchoredDraggable(androidx.compose.foundation.gestures.AnchoredDraggableState,androidx.compose.foundation.gestures.Orientation,kotlin.Boolean,kotlin.Boolean,androidx.compose.foundation.interaction.MutableInteractionSource)

@Composable
fun Test() {
	val offsetX = remember { mutableFloatStateOf(0f) }
//	val offsetY = remember { mutableStateOf(0f) }
	var size by remember { mutableStateOf(Size.Zero) }
	Box(
		Modifier.fillMaxSize()
			.onSizeChanged { size = it.toSize() }
	) {
		Box(
			Modifier.offset { IntOffset(offsetX.floatValue.roundToInt(), 0) }
				.size(50.dp)
				.background(Color.Blue)
				.pointerInput(Unit) {
					awaitEachGesture {
						val down = awaitFirstDown()
						var change = awaitTouchSlopOrCancellation(down.id) { change, over ->
							val original = Offset(offsetX.floatValue, 0f)
							val summed = original + over
							val newValue = Offset(
								x = summed.x.coerceIn(0f, size.width - 50.dp.toPx()),
								0f
							)
							change.consume()
							offsetX.floatValue = newValue.x
//							offsetY.value = newValue.y
						}
						while (change != null && change.pressed) {
							change = awaitDragOrCancellation(change.id)
							if (change != null && change.pressed) {
								val original = Offset(offsetX.floatValue, 0f)
								val summed = original + change.positionChange()
								val newValue = Offset(
									x = summed.x.coerceIn(0f, size.width - 50.dp.toPx()),
									y = 0f
								)
								change.consume()
								offsetX.floatValue = newValue.x
//								offsetY.value = newValue.y
							}
						}
					}
				}
		)
	}
}