package com.base.testproject.signalstrength

interface SignalStrength {
    enum class Theme {
        ROUNDED,
        SHARP
    }

    var theme: Theme
    var signalLevel: Int
    var color: Int
}
