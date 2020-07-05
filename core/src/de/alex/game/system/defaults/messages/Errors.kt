package de.alex.game.system.defaults.messages

object Errors {
    const val NOT_EXISTENT_FILE = "The file does not exist: "
    const val PARSING_XML = "An error has occurred while parsing the XML file!"
    const val READING_FILE = "An error has occurred while reading the file!"
    const val WRONG_CONFIG = "Something was wrong with the given configuration!"

    object Gui {
        const val BUILDING_GUI = "Failed to build the gui from the XML file."
    }
}