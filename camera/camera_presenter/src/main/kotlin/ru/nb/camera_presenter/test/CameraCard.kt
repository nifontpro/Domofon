package ru.nb.camera_presenter.test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.nb.camera_domain.model.Camera
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CameraCard(camera: Camera) {
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

		Icon(
			imageVector = if (camera.favorites) Icons.Filled.Star else Icons.Outlined.Grade,
			contentDescription = "Favorite",
			tint = MaterialTheme.colorScheme.secondaryContainer,
			modifier = Modifier
				.clickable { }
				.align(Alignment.CenterEnd)
				.padding(squareSize / 2)
				.drawBehind {
					drawCircle(
						color = Color.LightGray,
						radius = 56f,
						style = Stroke(4f)
					)
				}
		)

		Surface(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp)
				.offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) },
			shape = RoundedCornerShape(8.dp),
			elevation = 4.dp,
		) {
			Box {
				Column {
					Box(
						modifier = Modifier
							.fillMaxWidth()
							.height(250.dp)
					) {
						AsyncImage(
							modifier = Modifier.fillMaxWidth(),
							model = camera.snapshot,
							contentDescription = camera.name,
							contentScale = ContentScale.FillWidth,
						)
						Icon(
							imageVector = Icons.Outlined.PlayCircle,
							contentDescription = "Play",
							tint = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f),
							modifier = Modifier
								.size(60.dp)
								.clickable { }
								.align(Alignment.Center)
						)
					}
					Text(
						text = camera.name,
						style = MaterialTheme.typography.titleLarge,
						modifier = Modifier.padding(16.dp)
					)
				}

				if (camera.favorites) {
					Icon(
						imageVector = Icons.Filled.Star,
						contentDescription = "Star",
						tint = MaterialTheme.colorScheme.secondaryContainer,
						modifier = Modifier
							.padding(4.dp)
							.align(Alignment.TopEnd)
					)
				}

				if (camera.rec) {
					val color = MaterialTheme.colorScheme.error
					Text(text = "REC",
						color = color,
						style = MaterialTheme.typography.bodySmall,
						modifier = Modifier
							.padding(16.dp)
							.drawBehind {
								drawCircle(
									center = Offset(-4f, 6f),
									color = color,
									radius = 8f,
								)
							}
					)
				}
			}
		}
	}
}