package com.elaurendeau.itemswap.enumeration

import com.elaurendeau.itemswap.entity.PositionEntity

enum class ItemTypeEnumeration(val itemName: String, val stashPosition: PositionEntity, val priority: Int, val isCurrentType: (String) -> Boolean) {

    CURRENCY(itemName = "CURRENCY",
            priority = 2,
            stashPosition = PositionEntity(1000, 190),
            isCurrentType = { description: String ->
                description.contains("Rarity: Currency")
            }),
    MAP(itemName = "MAP",
            priority = 1,
            stashPosition = PositionEntity(1000, 220),
            isCurrentType = { description: String ->
                description.contains("Map Tier: ")
            }),
    CARD(itemName = "CARD",
            priority = 1,
            stashPosition = PositionEntity(1000, 335),
            isCurrentType = { description: String ->
                description.contains("Rarity: Divination Card")
            }),
    FOSSIL(itemName = "FOSSIL",
            priority = 1,
            stashPosition = PositionEntity(1000, 365),
            isCurrentType = { description: String ->
                description.contains("Rarity: Currency") && description.contains("Fossil")
            }),
    UNIQUE(itemName = "UNIQUE",
            priority = 2,
            stashPosition = PositionEntity(1000, 250),
            isCurrentType = { description: String ->
                description.contains("Rarity: Unique")
            }),
    FRAGMENT(itemName = "FRAGMENT",
            priority = 1,
            stashPosition = PositionEntity(1000, 305),
            isCurrentType = { description: String ->
                description.contains("Can be used in a personal Map Device")
            }),
    ESSENCE(itemName = "ESSENCE",
            priority = 1,
            stashPosition = PositionEntity(1000, 280),
            isCurrentType = { description: String ->
                description.contains("Rarity: Currency") && description.contains("Essence")
            }),
    ORGAN(itemName = "ORGAN",
            priority = 1,
            stashPosition = PositionEntity(1000, 480),
            isCurrentType = { description: String ->
                (description.contains("Rarity: Unique") && description.contains("Tane's Laboratory")) || (description.contains("Rarity: Currency") && description.contains("Catalyst"))
            }),
    OIL(itemName = "OIL",
            priority = 1,
            stashPosition = PositionEntity(1000, 570),
            isCurrentType = { description: String ->
                description.contains("Rarity: Currency") && description.contains("Oil")
            }),
}