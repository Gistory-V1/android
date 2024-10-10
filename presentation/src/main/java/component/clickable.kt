package component

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.clickable(
    enabled: Boolean = true,
    onClick: () -> Unit
) = composed {
    val multipleEventsCutter = remember { MultipleEtventsCutter.get() }
    Modifier.clickable(
        enabled = enabled,
        onClick = { multipleEventsCutter.processEvent { onClick() } },
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    )
}