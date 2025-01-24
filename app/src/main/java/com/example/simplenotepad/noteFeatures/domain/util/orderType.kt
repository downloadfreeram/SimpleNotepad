package com.example.simplenotepad.noteFeatures.domain.util

sealed class OrderType {
    object ascending : OrderType()
    object descending : OrderType()
}