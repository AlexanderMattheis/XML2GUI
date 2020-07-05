package com.gdx.game.views.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import de.alex.game.Main.Companion.manager
import de.alex.game.system.Paths

class LoadingScreen : ScreenAdapter() {
    companion object {
        private val MANAGER = manager
    }

    init {
        loadIntoQueue(Paths.Files.ATLASES)
    }

    private fun loadIntoQueue(fileNames: Array<String>) {
        for (fileName in fileNames) {
            MANAGER.load(Paths.SPRITES + fileName, TextureAtlas::class.java)
        }
    }

    override fun render(deltaTime: Float) {
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        update(deltaTime)
        draw(deltaTime)
    }

    fun update(deltaTime: Float) { // NOP
    }

    fun draw(deltaTime: Float) { // NOP
    }
}