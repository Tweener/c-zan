package com.tweener.czan.designsystem.atom.bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.tweener.czan.designsystem.atom.bars.icon.ArrowBackIconButton
import com.tweener.czan.designsystem.atom.bars.icon.CloseBackIconButton
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveTopAppBar
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import org.jetbrains.compose.resources.DrawableResource

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
    colors: TopBarColors = TopBarDefaults.colors(),
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
                        colorFilter = ColorFilter.tint(color = colors.contentColor()),
                        contentDescription = null
                    )
                }

                Text(
                    text = title,
                    color = colors.contentColor(),
                    style = textStyle
                )
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colors.containerColor(),
            actionIconContentColor = colors.contentColor(),
            titleContentColor = colors.contentColor(),
            navigationIconContentColor = colors.contentColor(),
        )
    )
}

@Composable
fun SimpleTopBar(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        style = textStyle,
        topBarColors = colors,
        actions = actions
    )
}

@Composable
fun NoTitleTopBarWithBackButton(
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = "",
        topBarColors = colors,
        navigationIcon = { ArrowBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun TopBarWithBackButton(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        style = textStyle,
        topBarColors = colors,
        navigationIcon = { ArrowBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun NoTitleTopBarWithCloseButton(
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = "",
        topBarColors = colors,
        navigationIcon = { CloseBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@Composable
fun TopBarWithCloseButton(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    colors: TopBarColors = TopBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
    onBackClicked: (() -> Unit)? = null
) {
    TopBarWithIcon(
        modifier = modifier,
        title = title,
        style = textStyle,
        topBarColors = colors,
        navigationIcon = { CloseBackIconButton(onClick = onBackClicked) },
        actions = actions
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAdaptiveApi::class)
@Composable
fun TopBarWithIcon(
    title: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    topBarColors: TopBarColors = TopBarDefaults.colors(),
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    AdaptiveTopAppBar(
        modifier = modifier,
        title = { Text(text = title, style = style) },
        navigationIcon = navigationIcon,
        actions = actions,
        adaptation = {
            material {
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarColors.containerColor(),
                    actionIconContentColor = topBarColors.contentColor(),
                    titleContentColor = topBarColors.contentColor(),
                    navigationIconContentColor = topBarColors.contentColor(),
                )
            }
        },
//        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}

@Composable
fun RowScope.TopBarAction(
    icon: DrawableResource,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(resource = icon, contentDescription = contentDescription)
    }
}

@Composable
fun RowScope.TopBarAction(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(imageVector = icon, contentDescription = contentDescription)
    }
}

@Composable
fun RowScope.TopBarAction(
    icon: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentDescription: String? = null
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(painter = icon, contentDescription = contentDescription)
    }
}

object TopBarDefaults {

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        contentColor: Color = MaterialTheme.colorScheme.contentColorFor(containerColor),
    ): TopBarColors = TopBarColors(
        containerColor = containerColor,
        contentColor = contentColor,
    )
}

@Immutable
class TopBarColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun contentColor(): Color = contentColor
}
