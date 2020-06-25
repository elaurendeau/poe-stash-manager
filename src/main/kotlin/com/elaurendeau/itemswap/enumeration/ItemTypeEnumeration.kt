package com.elaurendeau.itemswap.enumeration

enum class ItemTypeEnumeration(val itemName: String, val isCurrentType: (String) -> Boolean) {

    CURRENCY(itemName = "CURRENCY",
            isCurrentType = { description: String ->
                description.contains("Rarity: Currency")
            }),
    MAP(itemName = "MAP",
            isCurrentType = { description: String ->
                description.contains("Map Tier: ")
            }),
    CARD(itemName = "CARD",
            isCurrentType = { description: String ->
                description.contains("Rarity: Divination Card")
            }),
    FOSSIL(itemName = "FOSSIL",
            isCurrentType = { description: String ->
                description.contains("TODO")
            }),
    UNIQUE(itemName = "UNIQUE",
            isCurrentType = { description: String ->
                description.contains("TODO")
            }),
    FRAGMENT(itemName = "FRAGMENT",
            isCurrentType = { description: String ->
                description.contains("TODO")
            }),
    ESSENCE(itemName = "ESSENCE",
            isCurrentType = { description: String ->
                description.contains("TODO")
            }),

}