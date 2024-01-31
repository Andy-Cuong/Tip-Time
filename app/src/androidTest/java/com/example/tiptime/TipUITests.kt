package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

/**
 * Instrumentation Test class
 */
class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        // Set up the app layout
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        // Perform user input
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")

        // Assert if the expected result is met
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: €$expectedTip")
            .assertExists("No node with this text found")
    }
}