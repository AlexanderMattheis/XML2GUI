package de.alex.game.system.storage.loader

import org.w3c.dom.Document

interface DataParser {
    fun getData(xmlDocument: Document): Data
}