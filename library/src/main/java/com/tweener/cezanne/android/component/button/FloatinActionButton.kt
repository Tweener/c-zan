package com.tweener.cezanne.android.component.button

import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@Composable
fun FloatingActionButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    LargeFloatingActionButton(
        modifier = modifier,
        onClick = { onClick?.invoke() },
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            modifier = Modifier.size(size = FloatingActionButtonDefaults.LargeIconSize),
            imageVector = icon,
            contentDescription = null
        )
    }
}
