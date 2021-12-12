package net.jetpackcompose.composetext.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp

class Sdp {

}
@Composable
fun Int.sdp(): Dp {
    return dimensionResource(id = this)
}
