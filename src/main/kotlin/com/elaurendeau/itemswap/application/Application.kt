package com.elaurendeau.itemswap.application

import com.elaurendeau.itemswap.controller.KeybindController
import com.elaurendeau.itemswap.executionflow.ItemSwapExecutionFlow
import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import org.slf4j.bridge.SLF4JBridgeHandler
import java.util.Properties
import kotlin.system.exitProcess

fun main() {
    try {
        SLF4JBridgeHandler.removeHandlersForRootLogger()
        SLF4JBridgeHandler.install()

        GlobalScreen.registerNativeHook();
    } catch (e: NativeHookException) {
        System.err.println("There was a problem registering the native hook.")
        System.err.println(e.message)

        exitProcess(1)
    }

    GlobalScreen.addNativeKeyListener(KeybindController(ItemSwapExecutionFlow()))
}

