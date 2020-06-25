package com.elaurendeau.itemswap.enumeration

import java.lang.NumberFormatException

enum class ItemTypeEnumeration(val itemName: String, val priority: Int, val isCurrentType: (String) -> Boolean) {

    CURRENCY(itemName = "CURRENCY",
            priority = 2,
            isCurrentType = { description: String ->
                description.contains("Rarity: Currency")
            }),
    MAP(itemName = "MAP",
            priority = 1,
            isCurrentType = { description: String ->
                description.contains("Map Tier: ")
            }),
    CARD(itemName = "CARD",
            priority = 1,
            isCurrentType = { description: String ->
                description.contains("Rarity: Divination Card")
            }),
    FOSSIL(itemName = "FOSSIL",
            priority = 1,
            isCurrentType = { description: String ->
                description.contains("TODO")
            }),
    UNIQUE(itemName = "UNIQUE",
            priority = 1,
            isCurrentType = { description: String ->
                description.contains("TODO")
            }),
    FRAGMENT(itemName = "FRAGMENT",
            priority = 1,
            isCurrentType = { description: String ->
                description.contains("TODO")
            }),
    ESSENCE(itemName = "ESSENCE",
            priority = 1,
            isCurrentType = { description: String ->
                description.contains("TODO")
            }),

}