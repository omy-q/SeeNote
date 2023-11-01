package ru.mobileup.kmm_template.core.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val LightAppColors = CustomColors(
    isLight = true,

    text = TextColors(
        primary = Color(0xFFFFFFFF),
        secondary = Color(0xFF86B6FF),
        button = Color(0xFF0046AF),
        disabled = Color(0xFFD7D7D7),
        alert = Color(0xFFFF7D95),
        contrast = Color(0xFF0046AF)
    ),
    icon = IconColors(
        primary = Color(0xFF0046AF),
        secondary = Color(0xFF86B6FF),
        disabled = Color(0xFFA9A9A9),
        invert = Color(0xFFFFFFFF),
        contrast = Color(0xFFFFFFFF)
    ),
    background = BackgroundColors(
        primary = Color(0xFFFFFFFF),
        secondary = Color(0xFFE2EEFF),
        disabled = Color(0xFFA9A9A9),
        invert = Color(0xFF0046AF),
        formError = Color(0xFFFFF1F6)
    ),
    button = ButtonColors(
        primary = Color(0xFF0046AF),
        secondary = Color(0xFFF0F6FF),
        disabled = Color(0xFF909090)
    ),
    element = ElementColors(
        primary = Color(0xFFFFFFFF),
        secondary = Color(0xFFF0F6FF),
        contrast = Color(0xFF86B6FF),
        disabled = Color(0xFFE8E8E8)
    )
)

val AppTypography = CustomTypography(
    title = TitleTypography(
        semiBoldLarge = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
        ),
        mediumLarge = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
    ),
    text = TextTypography(
        mediumNormal = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
    ),
    button = ButtonTypography(
        mediumNormal = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
    ),
    caption = CaptionTypography(
        mediumSystem = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        ),
        semiBoldSmall = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        ),
        regularSmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colors = LightAppColors
    val typography = AppTypography

    CustomTheme(colors, typography) {
        MaterialTheme(
            colors = colors.toMaterialColors(),
            typography = typography.toMaterialTypography(),
            content = content
        )
    }
}

@Composable
fun CustomTheme(
    colors: CustomColors,
    typography: CustomTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalCustomColors provides colors,
        LocalCustomTypography provides typography
    ) {
        content()
    }
}

object CustomTheme {

    val colors: CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColors.current
            ?: throw Exception("CustomColors are not provided. Did you forget to apply CustomTheme?")

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomTypography.current
            ?: throw Exception("CustomTypography is not provided. Did you forget to apply CustomTheme?")
}
