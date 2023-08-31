package ru.nb.domofon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.nb.camera_presenter.test.CameraScreen
import ru.nb.domofon.ui.theme.DomofonTheme

@OptIn(ExperimentalFoundationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DomofonTheme {
				val coroutineScope = rememberCoroutineScope()

				val tabRowItems = listOf(
					TabRowItem(
						title = getString(R.string.cameras),
						screen = { CameraScreen() }
					),
					TabRowItem(
						title = getString(R.string.doors),
						screen = { TabScreen(title = "Camera") }
					),
				)

				val pagerState = rememberPagerState(pageCount = { tabRowItems.size })
				Column(modifier = Modifier.fillMaxSize()) {
					Text(
						text = getString(R.string.app_name),
						modifier = Modifier
							.fillMaxWidth()
							.padding(vertical = 8.dp),
						textAlign = TextAlign.Center,
						style = typography.headlineSmall
					)
					TabRow(
						modifier = Modifier.padding(vertical = 4.dp),
						selectedTabIndex = pagerState.currentPage,
						indicator = { tabPositions ->
							TabRowDefaults.Indicator(
								height = 4.dp,
								color = MaterialTheme.colorScheme.primary,
								modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
							)
						}
					) {
						tabRowItems.forEachIndexed { index, item ->
							Tab(
								selected = pagerState.currentPage == index,
								onClick = {
									coroutineScope.launch {
										pagerState.animateScrollToPage(page = index)
									}
								},
//								icon = {
//									item.icon?.let {
//										Icon(imageVector = it, contentDescription = item.title)
//									}
//								},
								text = {
									Text(
										text = item.title, style = typography.bodyLarge,
										color = MaterialTheme.colorScheme.onBackground
									)
								}
							)
						}
					}

					HorizontalPager(
						state = pagerState,
						userScrollEnabled = false
					) {page ->
						tabRowItems[page].screen()
					}
				}

			}
		}
	}

	@Composable
	fun TabScreen(title: String) {
		Box(
			modifier = Modifier.fillMaxSize(),
			contentAlignment = Alignment.Center,
		) {
			Text(
				text = title,
				style = typography.bodyMedium
			)
		}
	}

}