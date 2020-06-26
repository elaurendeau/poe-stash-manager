package com.elaurendeau.itemswap.utility

import com.elaurendeau.itemswap.entity.PositionEntity
import kotlin.random.Random

object PositionUtility {
    fun getPositionWithOffsetByMagnitude(position: PositionEntity, randomMagnitude: Int): PositionEntity {
        val xOffset = Random.nextInt(randomMagnitude * -1, randomMagnitude)
        val yOffset = Random.nextInt(randomMagnitude * -1, randomMagnitude)
        return PositionEntity(position.x + xOffset, position.y + yOffset)
    }
}