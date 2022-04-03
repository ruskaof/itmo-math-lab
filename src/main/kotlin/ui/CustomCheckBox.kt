package ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomCheckBox(
    onValueChange: (Boolean) -> Unit,
    value: Boolean,
    label: String
) {
    Row {
        Checkbox(value, onValueChange)
        Text(label)
    }
}