package com.elaurendeau.itemswap.utility

import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection

object ClipboardUtility {
    fun resetClipboardData() {
        Toolkit.getDefaultToolkit()
                .systemClipboard.setContents(StringSelection(""), null)
    }
    fun getClipboardData(): String {
        return Toolkit.getDefaultToolkit()
                .systemClipboard.getData(DataFlavor.stringFlavor) as String
    }
}