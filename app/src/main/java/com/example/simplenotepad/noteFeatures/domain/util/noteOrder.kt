package com.example.simplenotepad.noteFeatures.domain.util

sealed class noteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) :  noteOrder(orderType)
    class Date(orderType: OrderType) :  noteOrder(orderType)
    class Color(orderType: OrderType) :  noteOrder(orderType)
}