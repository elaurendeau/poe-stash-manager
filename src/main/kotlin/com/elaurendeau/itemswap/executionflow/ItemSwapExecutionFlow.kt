package com.elaurendeau.itemswap.executionflow

import com.elaurendeau.itemswap.entity.PositionEntity
import com.elaurendeau.itemswap.enumeration.ItemTypeEnumeration
import com.elaurendeau.itemswap.utility.ClipboardUtility
import com.elaurendeau.itemswap.utility.KeyboardUtility
import com.elaurendeau.itemswap.utility.MouseUtility
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import kotlin.collections.MutableMap as MutableMap

class ItemSwapExecutionFlow {

    fun execute() {

        val itemTypeToListPositionMap = mutableMapOf<ItemTypeEnumeration, List<PositionEntity>>()

        for (columnIndex in 1..20) {
            for (rowIndex in 1..5) {

                val position = PositionEntity(x = 0 + (columnIndex * 50),
                        y = 0 + (rowIndex * 50))

                MouseUtility.move(position.x, position.y)
                KeyboardUtility.press()

                val data: String = ClipboardUtility.getClipboardData()
                println(data)

                ItemTypeEnumeration
                        .values()
                        .iterator()
                        .asSequence()
                        .sortedBy { it.priority }
                        .filter {
                            val function: (String) -> Boolean = it.isCurrentType
                            function(data)
                        }
                        .first()
                        .let {
                            println("The clipboard content is a " + it.itemName)

                            val listOfPosition = itemTypeToListPositionMap.getOrDefault(it, listOf())
                            itemTypeToListPositionMap.put(it, listOfPosition + position)
                        }
            }
        }
        println(itemTypeToListPositionMap)


    }
}