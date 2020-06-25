package com.elaurendeau.itemswap.utility

import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

object ClipboardUtility {
    fun getClipboardData(): String {
        return Toolkit.getDefaultToolkit()
                .systemClipboard.getData(DataFlavor.stringFlavor) as String
    }
}