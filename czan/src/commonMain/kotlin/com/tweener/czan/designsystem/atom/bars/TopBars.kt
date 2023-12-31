package com.tweener.czan.designsystem.atom.bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.bars.icon.ArrowBackIconButton
import com.tweener.czan.designsystem.atom.bars.icon.CloseBackIconButton
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.CzanUiDefaults
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBar(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    logo: Painter? = null,
    backgroundColor: Color = CzanUiDefaults.TopBar.backgroundColor,
    contentColor: Color = CzanUiDefaults.TopBar.contentColor,
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
                verticalAlignment = Alignment.CenterVertically
            ) {
                logo?.let {
                    Image(
                        modifier = Modifier.size(42.dp),
                        painter = logo,
                        colorFilter = ColorFilter.tint(color = contentColor),
                        contentDescription = null
                    )
                }

                Text(
                    text = title,
                    color = contentColor,
                    style = textStyle
                )
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            actionIconContentColor = contentColor
        )
    )
}

@Composable
fun SimpleTopBar(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        style = textStyle,
        actions = actions
    )
}

@Composable
fun TopBarWithBackButton(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        style = textStyle,
        navigationIcon = { ArrowBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun TopBarWithCloseButton(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        style = textStyle,
        navigationIcon = { CloseBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarWithIcon(
    title: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = title, style = style) },
        navigationIcon = navigationIcon,
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(),
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}
