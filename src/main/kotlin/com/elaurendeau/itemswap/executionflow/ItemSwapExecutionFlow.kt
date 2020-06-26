package com.elaurendeau.itemswap.executionflow

import com.elaurendeau.itemswap.entity.PositionEntity
import com.elaurendeau.itemswap.enumeration.ItemTypeEnumeration
import com.elaurendeau.itemswap.utility.ClipboardUtility
import com.elaurendeau.itemswap.utility.KeyboardUtility
import com.elaurendeau.itemswap.utility.MouseUtility
import com.elaurendeau.itemswap.utility.PositionUtility
import kotlin.random.Random

class ItemSwapExecutionFlow {


    fun execute() {

        var keepFirstWisdomScroll = true
        var keepFirstTPScroll = true
        var keepXAmountOfMap: Int = 3

        val itemTypeToListPositionMap = mutableMapOf<ItemTypeEnumeration, List<PositionEntity>>()

        val inventoryPosition = PositionEntity(1725, 820)
        val inventorySize = PositionEntity(69, 69)
        //First slot x => 1695 - 1764 = 69 width
        //First slot x => 783 - 854 = 71 height

        // 0,2 y = 855 - 924 = 69
        // 0,3 y = 925 - 993 = 68
        // 0,4 y = 994 - 1064 = 70
        // 0,4 y = 1065 - 1134 = 69

        for (columnIndex in 0 .. 11) {
            for (rowIndex in 0 .. 4) {

                val newXPosition = inventoryPosition.x + (columnIndex * inventorySize.x)
                val newYPosition = inventoryPosition.y + (rowIndex * inventorySize.y)
                val position = PositionEntity(x = newXPosition, y = newYPosition)

                MouseUtility.move(PositionUtility.getPositionWithOffsetByMagnitude(position, 10))
                ClipboardUtility.resetClipboardData()
                KeyboardUtility.press()

                Thread.sleep(Random.nextLong(100, 150))

                val data: String = ClipboardUtility.getClipboardData()
                println(data)

                ItemTypeEnumeration
                        .values()
                        .iterator()
                        .asSequence()
                        .sortedBy { it.priority }
                        .find {
                            val function: (String) -> Boolean = it.isCurrentType
                            function(data)
                        }
                        ?.let {

                            when {
                                it == ItemTypeEnumeration.CURRENCY && keepFirstWisdomScroll && data.contains("Scroll of Wisdom") -> {
                                    keepFirstWisdomScroll = false
                                }
                                it == ItemTypeEnumeration.CURRENCY && keepFirstTPScroll && data.contains("Portal Scroll") -> {
                                    keepFirstTPScroll = false
                                }
                                it == ItemTypeEnumeration.MAP && keepXAmountOfMap > 0 -> {
                                    keepXAmountOfMap--
                                }
                                else -> {

                                    val listOfPosition = itemTypeToListPositionMap.getOrDefault(it, listOf())
                                    itemTypeToListPositionMap.put(it, listOfPosition + position)
                                }

                            }
                        }
            }
        }
        println(itemTypeToListPositionMap)
        itemTypeToListPositionMap.forEach { (itemType, itemPositionList) ->

            MouseUtility.move(PositionUtility.getPositionWithOffsetByMagnitude(itemType.stashPosition, 10))
            MouseUtility.click()

            itemPositionList.forEach { itemPosition ->
                MouseUtility.move(PositionUtility.getPositionWithOffsetByMagnitude(itemPosition, 10))
                MouseUtility.controlClick()
            }


        }


    }
}
