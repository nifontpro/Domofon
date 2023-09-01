package ru.nb.domofon.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class TabRowItem (
	val title: String,
	val icon: ImageVector? = null,
	val screen: @Composable ()-> Unit,
)