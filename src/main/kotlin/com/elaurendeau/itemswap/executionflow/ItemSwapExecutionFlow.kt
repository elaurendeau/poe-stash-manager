package com.elaurendeau.itemswap.executionflow

import com.elaurendeau.itemswap.enumeration.ItemTypeEnumeration
import com.elaurendeau.itemswap.utility.ClipboardUtility
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

class ItemSwapExecutionFlow {

    fun execute() {

        val data: String = ClipboardUtility.getClipboardData()
        println(data)

        ItemTypeEnumeration.values().iterator().forEach {
            val function: (String) -> Boolean = it.isCurrentType

            if(function(data)) {
                println("The clipboard content is a " + it.itemName)
            }
        }
    }
}