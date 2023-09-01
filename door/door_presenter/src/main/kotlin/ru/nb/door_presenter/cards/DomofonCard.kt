package ru.nb.door_presenter.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DomofonCard() {
	Surface(
		modifier = Modifier
			.padding(horizontal = 16.dp)
			.fillMaxWidth(),
		shape = RoundedCornerShape(8.dp),
		elevation = 4.dp,
	) {
		Column {
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.height(250.dp)
			) {
				AsyncImage(
					modifier = Modifier.fillMaxWidth(),
					model = "http://www.eps-modernelectric.at/wp-content/uploads/sites/4/2021/08/cLoxone_Intercom_01_min-1024x683.jpg",
					contentDescription = "Domofon",
					contentScale = ContentScale.FillWidth,
				)
			}
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
					.padding(16.dp)
			) {
				Column {
					Text(
						text = "Домофон",
						style = MaterialTheme.typography.titleLarge,
					)
					Text(
						text = "В сети",
						style = MaterialTheme.typography.bodySmall,
						color = MaterialTheme.colorScheme.onSurfaceVariant
					)
				}
				Icon(
					imageVector = Icons.Outlined.Lock,
					contentDescription = "Lock",
					tint = MaterialTheme.colorScheme.primary,
				)
			}

		}
	}
}