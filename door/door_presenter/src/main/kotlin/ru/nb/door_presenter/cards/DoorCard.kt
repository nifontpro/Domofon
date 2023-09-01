package ru.nb.door_presenter.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.LockOpen
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import ru.nb.door_domain.model.Door
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DoorCard(door: Door) {
	val squareSize = 96.dp
	val sizePx = with(LocalDensity.current) { -squareSize.toPx() }
	val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states
	val swipeableState = rememberSwipeableState(0)

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

		Row(
			modifier = Modifier
				.align(Alignment.CenterEnd)
				.padding(end = 16.dp)
		) {
			Icon(
				imageVector = Icons.Outlined.Edit,
				contentDescription = "Edit",
				tint = MaterialTheme.colorScheme.primary,
				modifier = Modifier
					.padding(horizontal = 8.dp)
					.clickable { }
					.drawBehind {
						drawCircle(
							color = Color.LightGray,
							radius = 56f,
							style = Stroke(4f)
						)
					}
			)

			Icon(
				imageVector = if (door.favorites) Icons.Filled.Star else Icons.Outlined.Grade,
				contentDescription = "Favorite",
				tint = MaterialTheme.colorScheme.secondaryContainer,
				modifier = Modifier
					.padding(horizontal = 8.dp)
					.clickable { }
					.drawBehind {
						drawCircle(
							color = Color.LightGray,
							radius = 56f,
							style = Stroke(4f)
						)
					}
			)
		}


		Surface(
			modifier = Modifier
				.padding(horizontal = 16.dp)
				.fillMaxWidth()
				.offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) },
			shape = RoundedCornerShape(8.dp),
			elevation = 4.dp
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(16.dp),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(
					text = door.name,
					style = MaterialTheme.typography.titleLarge,
				)

				val isLock = listOf(true, false).random()
				Icon(
					imageVector = if (isLock) Icons.Outlined.Lock else Icons.Outlined.LockOpen,
					contentDescription = "Lock",
					tint = MaterialTheme.colorScheme.primary,
				)
			}
		}
	}
}