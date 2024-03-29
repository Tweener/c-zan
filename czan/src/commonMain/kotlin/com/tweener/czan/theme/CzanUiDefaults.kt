package com.tweener.czan.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kotlin.time.Duration.Companion.seconds

/**
 * @author Vivien Mahe
 * @since 26/09/2023
 */

object CzanUiDefaults {

    fun uiDisabledAlpha(): Float = 0.38f

    object TopBar {
        val backgroundColor: Color @Composable get() = MaterialTheme.colorScheme.primary

        val contentColor: Color @Composable get() = MaterialTheme.colorScheme.onPrimary
    }

    object ProgressBar {
        val trackColor: Color @Composable get() = MaterialTheme.colorScheme.primaryContainer

        val selectedColor: Color @Composable get() = MaterialTheme.colorScheme.primary

        val dashColor: Color @Composable get() = MaterialTheme.colorScheme.background
    }

    object Carousel {
        fun slideDuration() = 3.seconds

        val dropShadowColor: Color @Composable get() = MaterialTheme.colorScheme.onBackground
    }

    object Shimmer {
        val baseColor: Color @Composable get() = Color.Transparent

        val highlightColor: Color @Composable get() = Color.Transparent
    }
}
