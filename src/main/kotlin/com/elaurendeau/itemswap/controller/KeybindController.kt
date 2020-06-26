package com.elaurendeau.itemswap.controller

import com.elaurendeau.itemswap.executionflow.ItemSwapExecutionFlow
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.coroutines.CoroutineContext

class KeybindController(val itemSwapExecutionFlow: ItemSwapExecutionFlow) : NativeKeyListener {
    private val isCtrlPressed = AtomicBoolean(false)
    private val isRunning = AtomicBoolean(false)

    override fun nativeKeyTyped(nativeKeyEvent: NativeKeyEvent?) {
    }

    override fun nativeKeyPressed(nativeKeyEvent: NativeKeyEvent?) {
        nativeKeyEvent?.let {
            when(it.keyCode) {
                NativeKeyEvent.VC_CONTROL -> {
                    isCtrlPressed.set(true)
                }
            }
        }
    }

    override fun nativeKeyReleased(nativeKeyEvent: NativeKeyEvent?) {
        nativeKeyEvent?.let {
            when (it.keyCode) {

                NativeKeyEvent.VC_F -> {
                    if(isCtrlPressed.get() && !isRunning.get()) {
                        isRunning.set(true)
                        Thread {
                            println("--- Stashing everything ---")
                            itemSwapExecutionFlow.execute()
                        }.start()
                    }
                }
                NativeKeyEvent.VC_F10 -> {
                    System.exit(1)
                }
            }

            if (it.keyCode == NativeKeyEvent.VC_CONTROL) {
                isCtrlPressed.set(false)
                isRunning.set(false)
            }
        }
    }


}