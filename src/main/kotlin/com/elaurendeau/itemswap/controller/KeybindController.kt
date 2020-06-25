package com.elaurendeau.itemswap.controller

import com.elaurendeau.itemswap.executionflow.ItemSwapExecutionFlow
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener
import java.util.concurrent.atomic.AtomicBoolean

class KeybindController(val itemSwapExecutionFlow: ItemSwapExecutionFlow) : NativeKeyListener {
    private val isCtrlPressed = AtomicBoolean(false)

    override fun nativeKeyTyped(nativeKeyEvent: NativeKeyEvent?) {
    }

    override fun nativeKeyPressed(nativeKeyEvent: NativeKeyEvent?) {
        nativeKeyEvent?.let {
            when (it.keyCode) {
                NativeKeyEvent.VC_CONTROL -> {
                    isCtrlPressed.set(true)
                }
                NativeKeyEvent.VC_S -> {
                    if(isCtrlPressed.get()) {
                        itemSwapExecutionFlow.execute()
                    }
                }
            }

        }
    }

    override fun nativeKeyReleased(nativeKeyEvent: NativeKeyEvent?) {
        nativeKeyEvent?.let {
            if (it.keyCode == NativeKeyEvent.VC_CONTROL) {
                isCtrlPressed.set(false)
            }
        }
    }

}