package com.elaurendeau.itemswap.utility

import java.awt.Robot
import java.awt.event.KeyEvent

object KeyboardUtility {
    fun press() {
        Robot().keyPress(KeyEvent.VK_CONTROL)
        Robot().keyPress(KeyEvent.VK_C)
        Robot().keyRelease(KeyEvent.VK_C)
        Robot().keyRelease(KeyEvent.VK_CONTROL)
    }
}