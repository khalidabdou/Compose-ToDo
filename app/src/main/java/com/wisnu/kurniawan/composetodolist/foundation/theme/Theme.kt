package com.wisnu.kurniawan.composetodolist.foundation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wisnu.kurniawan.composetodolist.model.Theme

val LightColorPalette = lightColorScheme(
    primary = LightPrimary,
    primaryContainer = LightPrimary,
    onPrimary = Color.White,
    secondary = LightSecondary,
    secondaryContainer = LightSecondaryVariant,
    onSecondary = Color.Black,
    background = LightBackground,
    onBackground = Color.Black,
    surface = LightBackground,
    onSurface = Color.Black,
    error = LightError,
    onError = Color.White
)

val TwilightColorPalette = lightColorScheme(
    primary = TwilightPrimary,
    primaryContainer = TwilightPrimary,
    onPrimary = TwilightOn,
    secondary = TwilightSecondary,
    secondaryContainer = TwilightSecondaryVariant,
    onSecondary = TwilightOn,
    background = TwilightBackground,
    onBackground = TwilightOn,
    surface = TwilightBackground,
    onSurface = TwilightOn,
    error = Error,
    onError = Color.White
)

val NightColorPalette = darkColorScheme(
    primary = NightPrimary,
    primaryContainer = NightPrimary,
    onPrimary = Color.White,
    secondary = NightSecondary,
    secondaryContainer = NightSecondaryVariant,
    onSecondary = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = Color.Black,
    onSurface = Color.White,
    error = Error,
    onError = Color.White
)

val SunriseColorPalette = darkColorScheme(
    primary = SunrisePrimary,
    primaryContainer = SunrisePrimary,
    onPrimary = SunriseOn,
    secondary = SunriseSecondary,
    secondaryContainer = SunriseSecondaryVariant,
    onSecondary = SunriseOn,
    background = SunriseBackground,
    onBackground = SunriseOn,
    surface = SunriseBackground,
    onSurface = SunriseOn,
    error = SunriseError,
    onError = Color.White
)

val AuroraColorPalette = darkColorScheme(
    primary = AuroraPrimary,
    primaryContainer = AuroraPrimary,
    onPrimary = AuroraOn,
    secondary = AuroraSecondary,
    secondaryContainer = AuroraSecondaryVariant,
    onSecondary = AuroraOn,
    background = AuroraBackground,
    onBackground = AuroraOn,
    surface = AuroraBackground,
    onSurface = AuroraOn,
    error = Error,
    onError = Color.White
)

@Composable
fun Theme(
    theme: Theme,
    content: @Composable () -> Unit
) {
    val colors = when (theme) {
        Theme.SYSTEM -> {
            if (isSystemInDarkTheme()) {
                NightColorPalette
            } else {
                LightColorPalette
            }
        }
        Theme.LIGHT -> LightColorPalette
        Theme.TWILIGHT -> TwilightColorPalette
        Theme.NIGHT -> NightColorPalette
        Theme.SUNRISE -> SunriseColorPalette
        Theme.AURORA -> AuroraColorPalette
    }
    val darkIcons = colors == LightColorPalette || colors == SunriseColorPalette
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = darkIcons,
            isNavigationBarContrastEnforced = false
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        // shapes = Shapes,
        content = content
    )
}
