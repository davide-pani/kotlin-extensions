package com.davidepani.kotlinextensions.utils.currencyformatter

import org.junit.Assert.assertEquals
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.util.*
import kotlin.text.Typography.nbsp

class LocalizedCurrencyFormatterTest {

    private val cut = LocalizedCurrencyFormatter(
        locale = Locale.ITALY,
        currencyLocale = Locale.ITALY
    )


    @Test
    fun `format with default Locale returns formatted currency`() {
        val amount = 1200
        val expectedFormattedCurrency = "1.200,00${nbsp}€"

        val actualFormattedCurrency = cut.format(amount = amount)

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

    @Test
    fun `format with US Locale and ITALY currency Locale returns formatted currency`() {
        val amount = 1200
        val expectedFormattedCurrency = "€1,200.00"

        val actualFormattedCurrency = cut.format(
            amount = amount,
            locale = Locale.US,
            currencyLocale = Locale.ITALY
        )

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

    @Test
    fun `format with ITALY Locale and US currency Locale returns formatted currency`() {
        val amount = 1200
        val expectedFormattedCurrency = "1.200,00${nbsp}USD"

        val actualFormattedCurrency = cut.format(
            amount = amount,
            locale = Locale.ITALY,
            currencyLocale = Locale.US
        )

        assertEquals(actualFormattedCurrency, expectedFormattedCurrency)
    }

    @Test
    fun `format with Double amount with more than two decimal digits Locale returns formatted currency with two decimal digits`() {
        val amount = 2.96424
        val expectedFormattedCurrency = "2,96${nbsp}€"

        val actualFormattedCurrency = cut.format(amount = amount)

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

}