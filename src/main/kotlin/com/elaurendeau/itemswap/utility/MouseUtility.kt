package com.elaurendeau.itemswap.utility

import com.elaurendeau.itemswap.entity.PositionEntity
import java.awt.Robot
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import kotlin.random.Random

object MouseUtility {
    fun move(x: Int, y: Int) {
       Robot().mouseMove(x, y)
        Thread.sleep(Random.nextLong(25, 75))
    }

    fun move(position: PositionEntity) {
        move(position.x, position.y)
    }

    fun click() {
        Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK)
        Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
        Thread.sleep(Random.nextLong(25, 75))
    }
    fun controlClick() {
        Robot().keyPress(KeyEvent.VK_CONTROL)
        Thread.sleep(Random.nextLong(25, 75))
        Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK)
        Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
        Thread.sleep(Random.nextLong(25, 75))
        Robot().keyRelease(KeyEvent.VK_CONTROL)
        Thread.sleep(Random.nextLong(25, 75))
    }
}