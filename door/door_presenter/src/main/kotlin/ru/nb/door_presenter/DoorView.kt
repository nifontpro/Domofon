package ru.nb.door_presenter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.nb.door_presenter.cards.DomofonCard
import ru.nb.door_presenter.cards.DoorCard

@Composable
fun DoorView(state: DoorState) {

	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceBetween
	) {
		LazyColumn(
			modifier = Modifier
				.padding(vertical = 8.dp)
				.weight(1f),
			verticalArrangement = Arrangement.spacedBy(16.dp)
		) {
			items(items = state.doors, key = { it.id }) { door ->
				DoorCard(door)
			}
		}

		DomofonCard()

	}
}