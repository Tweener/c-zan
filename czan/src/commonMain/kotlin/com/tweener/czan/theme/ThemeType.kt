package com.tweener.czan.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */
enum class ThemeType {
    LIGHT, DARK, AUTO;
}

@Composable
fun shouldUseDarkTheme(themeType: ThemeType): Boolean =
    when (themeType) {
        ThemeType.LIGHT -> false
        ThemeType.DARK -> true
        ThemeType.AUTO -> isSystemInDarkTheme()
    }

//@Composable
//fun ApplyTheme(themeType: ThemeType) {
//    LocalConfiguration.current.uiMode = when (themeType) {
//        ThemeType.AUTO -> LocalConfiguration.current.uiMode
//        ThemeType.DARK -> Configuration.UI_MODE_NIGHT_YES
//        ThemeType.LIGHT -> Configuration.UI_MODE_NIGHT_NO
//    }
//}
