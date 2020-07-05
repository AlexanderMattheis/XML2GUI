package de.alex.game.system.storage.loader

import org.w3c.dom.Document

class GuiDataParser : DataParser {
    override fun getData(xmlDocument: Document): Data {
        return GuiData()
    }
}