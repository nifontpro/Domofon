package ru.nb.domofon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.nb.domofon.ui.theme.DomofonTheme

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DomofonTheme {
				val pagerState = rememberPagerState(
					initialPage = 0,
					pageCount = { 3 }
				)
				val coroutineScope = rememberCoroutineScope()

				val tabRowItems = listOf(
					TabRowItem(
						title = "Home",
						icon = Icons.Filled.Home,
						screen = { CameraScreen2() }
					),
					TabRowItem(
						title = "Chat",
						icon = Icons.Filled.Chat,
						screen = { CameraScreen() }
					),
					TabRowItem(
						title = "Contacts",
						icon = Icons.Filled.Contacts,
						screen = { TabScreen(title = "Contacts") }
					)
				)
				Column(modifier = Modifier.fillMaxSize()) {
					Text(
						"Мой дом", modifier = Modifier.fillMaxWidth(),
						textAlign = TextAlign.Center,
						style = typography.headlineSmall
					)
					TabRow(
						selectedTabIndex = pagerState.currentPage,
						indicator = { tabPositions ->
							TabRowDefaults.Indicator(
								height = 5.dp,
								color = Color.Red,
								modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
							)
						}
					) {
						tabRowItems.forEachIndexed { index, item ->
							Tab(
								selected = pagerState.currentPage == index,
								onClick = {
									coroutineScope.launch {
										pagerState.scrollToPage(page = index)
//										pagerState.animateScrollToPage(page = index)
									}
								},
								icon = {
									Icon(imageVector = item.icon, contentDescription = item.title)
								},
								text = {
									Text(
										text = item.title, style = typography.bodySmall, /*color = Color.White,*/
										maxLines = 1,
										overflow = TextOverflow.Ellipsis
									)
								}
							)
						}
					}

					HorizontalPager(
						state = pagerState,
//						pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
//							Orientation.Horizontal
//						),
						pageContent = {
							tabRowItems[pagerState.currentPage].screen()
						},
						userScrollEnabled = false
					)
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