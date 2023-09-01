package ru.nb.camera_presenter.test

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.nb.domofon_compose.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CameraView(state: CameraState) {

	val grouped = state.cameras.groupBy { it.room }

	LazyColumn(
		modifier = Modifier.fillMaxSize().padding(vertical = 4.dp),
		verticalArrangement = Arrangement.spacedBy(16.dp)
	) {
		grouped.forEach { (initial, cameras) ->
			this@LazyColumn.stickyHeader {
				Text(
					text = initial ?: stringResource(R.string.withoutRoom),
					style = MaterialTheme.typography.headlineSmall,
					modifier = Modifier
						.fillMaxWidth()
						.background(MaterialTheme.colorScheme.background.copy(alpha = 0.95f))
						.padding(horizontal = 16.dp, vertical = 8.dp)
				)
			}
			items(items = cameras, key = { it.id }) { camera ->
				CameraCard(camera)
			}
		}
	}
}