package com.gdx.game.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.gdx.game.desktop.system.defaults.Params
import de.alex.game.Main.Companion.instance

object DesktopLauncher {

    @JvmStatic  // this annotation is necessary because the game is started from a Java library
    fun main(args: Array<String>) {
        val windowWidth = Params.Window.DIMENSIONS.x.toInt()
        val windowHeight = Params.Window.DIMENSIONS.y.toInt()

        val config = Lwjgl3ApplicationConfiguration()
        config.setResizable(true)
        config.setWindowedMode(windowWidth, windowHeight)
        config.setTitle(Params.Window.TITLE)
        config.useVsync(true)

        Lwjgl3Application(instance, config)
    }
}