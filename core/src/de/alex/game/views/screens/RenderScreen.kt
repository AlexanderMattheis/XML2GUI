package com.gdx.game.views.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import de.alex.game.Main.Companion.manager

class RenderScreen : ScreenAdapter() {
    companion object {
        private val MANAGER = manager
    }

    override fun render(deltaTime: Float) {
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        update(deltaTime)
        draw(deltaTime)
    }

    fun update(deltaTime: Float) {
    }

    fun draw(deltaTime: Float) { // NOP
    }
}