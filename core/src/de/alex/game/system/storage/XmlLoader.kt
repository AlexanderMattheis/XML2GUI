package de.alex.game.system.storage

import com.badlogic.gdx.scenes.scene2d.Stage
import de.alex.game.system.defaults.messages.Errors
import de.alex.game.system.defaults.messages.Errors.Gui.BUILDING_GUI
import de.alex.game.system.storage.loader.Data
import de.alex.game.system.storage.loader.GuiData
import de.alex.game.system.storage.loader.GuiDataParser
import org.w3c.dom.Document
import org.xml.sax.SAXException
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger
import javax.xml.XMLConstants
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

object XmlLoader {
    private val LOGGER = Logger.getLogger(XmlLoader::class.qualifiedName)

    fun load(path: String): Stage {
        val file = File(path)

        if (!file.exists()) {
            throw FileNotFoundException(Errors.NOT_EXISTENT_FILE + file.name)
        }

        val documentBuilderFactory = DocumentBuilderFactory.newInstance()
        // against XXE-Attack https://stackoverflow.com/questions/40649152/how-to-prevent-xxe-attack
        documentBuilderFactory.setAttribute(XMLConstants.FEATURE_SECURE_PROCESSING, true) // limits the number of XML constructs
        documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "") // restricts access to DTDs' on the specified protocols

        try {
            val documentBuilder = documentBuilderFactory.newDocumentBuilder()
            val document = documentBuilder.parse(file)
            // removes redundancies:
            // - comments
            // - white space outside root/document tags
            // - white space between an attribute name and "="
            // - white space between attributes
            // ...
            document.documentElement.normalize()
            return buildGui(document)
        } catch (e: ParserConfigurationException) {
            LOGGER.log(Level.SEVERE, Errors.WRONG_CONFIG, e)
        } catch (e: SAXException) {
            LOGGER.log(Level.SEVERE, Errors.PARSING_XML, e)
        } catch (e: IOException) {
            LOGGER.log(Level.SEVERE, Errors.READING_FILE, e)
        }

        throw NullPointerException(BUILDING_GUI)
    }

    private fun buildGui(xmlDocument: Document): Stage {
        val guiData = GuiDataParser()

        val stage = Stage()
        fillStage(stage, guiData.getData(xmlDocument) as GuiData)
        return stage
    }

    private fun fillStage(stage: Stage, guiData: GuiData) {

    }
}
