package com.elaurendeau.itemswap.utility

import java.awt.Robot

object MouseUtility {
    fun move(x: Int, y: Int) {
       Robot().mouseMove(x, y)
    }
}