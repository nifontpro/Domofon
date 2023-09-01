package ru.nb.door_presenter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.nb.domofon_compose.R
import ru.nb.door_presenter.cards.DomofonCard
import ru.nb.door_presenter.cards.DoorCard

@Composable
fun DoorView(state: DoorState) {

	if (state.success) {
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
	} else {
		Box(modifier = Modifier.fillMaxSize()) {
			Text(
				text = stringResource(R.string.data_load_error),
				modifier = Modifier.align(Alignment.Center)
			)
		}
	}
}