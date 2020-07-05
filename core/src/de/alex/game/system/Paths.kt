package de.alex.game.system;

object Paths {
    const val PATHS_SEPARATOR = "/"  // LibGDX can only handle "/", so File.separator cannot be used to handle it manually
    const val MAPS = ".." + PATHS_SEPARATOR + "maps" + PATHS_SEPARATOR  // hint: this path is for official maps
    const val SPRITES = "sprites" + PATHS_SEPARATOR + "default" + PATHS_SEPARATOR

    object Files {
        val ATLASES = arrayOf(Atlases.DEFAULT_MENU_ATLAS)

        object Atlases {
            const val DEFAULT_MENU_ATLAS = "default.atlas"
        }
    }
}
