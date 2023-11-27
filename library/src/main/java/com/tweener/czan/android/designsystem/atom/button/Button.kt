package com.tweener.czan.android.designsystem.atom.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.tweener.czan.android.designsystem.atom.text.Text
import com.tweener.czan.android.preview.UiModePreviews
import com.tweener.czan.android.theme.CzanTheme
import com.tweener.czan.android.theme.Size

/**
 * @author Vivien Mahe
 * @since 24/08/2023
 */

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    size: ButtonSize = ButtonSize.REGULAR,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    enabled: Boolean = true,
    outlined: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    val shouldUseIconPadding = (leadingIcon != null || trailingIcon != null) && text != null

    Button(
        modifier = modifier.height(size.height),
        enabled = enabled,
        onClick = { onClick?.invoke() },
        contentPadding = if (shouldUseIconPadding) size.contentWithIconPadding else size.contentPadding,
        shape = size.shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (outlined) Color.Transparent else style.containerColor,
            contentColor = if (outlined) style.containerColor else style.contentColor,
            disabledContainerColor = style.disabledContainerColor,
            disabledContentColor = style.disabledContentColor
        ),
        border = if (outlined) BorderStroke(1.dp, style.containerColor) else null
    ) {
        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null
            )

            if (text != null) {
                Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
            }
        }

        if (text != null) {
            Text(
                text = text,
                style = size.textStyle
            )
        }

        if (trailingIcon != null) {
            if (text != null) {
                Spacer(modifier = Modifier.size(Size.Padding.ExtraSmall))
            }

            Icon(
                imageVector = trailingIcon,
                contentDescription = null
            )
        }
    }
}

// region Preview Primary

@UiModePreviews
@Composable
private fun PrimaryButtonRegularEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularWithLeadingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularWithTrailingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled",
            enabled = false
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularWithLeadingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularWithTrailingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun PrimaryButtonRegularOutlinedEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true,
            outlined = true
        )
    }
}

// endregion Preview Primary

// region Preview Secondary

@UiModePreviews
@Composable
private fun SecondaryButtonRegularEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.SECONDARY
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularWithLeadingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularWithTrailingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.SECONDARY
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularWithLeadingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonRegularWithTrailingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun SecondaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.SECONDARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

// endregion Preview Secondary

// region Preview Tertiary

@UiModePreviews
@Composable
private fun TertiaryButtonRegularEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.TERTIARY
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularWithLeadingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularWithTrailingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithLeadingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithTrailingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.TERTIARY
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularWithLeadingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonRegularWithTrailingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithLeadingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun TertiaryButtonSmallRegularWithTrailingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.TERTIARY,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

// endregion Preview Tertiary

// region Preview Error

@UiModePreviews
@Composable
private fun ErrorButtonRegularEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true,
            style = ButtonStyle.ERROR
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularWithLeadingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularWithTrailingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithLeadingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithTrailingIconEnabledPreview() {
    CzanTheme {
        Button(
            text = "Enabled with icon",
            enabled = true,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled",
            enabled = false,
            style = ButtonStyle.ERROR
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularWithLeadingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonRegularWithTrailingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithLeadingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            leadingIcon = Icons.Rounded.Add
        )
    }
}

@UiModePreviews
@Composable
private fun ErrorButtonSmallRegularWithTrailingIconDisabledPreview() {
    CzanTheme {
        Button(
            text = "Disabled with icon",
            enabled = false,
            size = ButtonSize.SMALL,
            style = ButtonStyle.ERROR,
            trailingIcon = Icons.Rounded.Add
        )
    }
}

// endregion Preview Error