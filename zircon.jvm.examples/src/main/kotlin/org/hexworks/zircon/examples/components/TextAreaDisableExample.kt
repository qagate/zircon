package org.hexworks.zircon.examples.components

import org.hexworks.zircon.api.*
import org.hexworks.zircon.api.extensions.onMouseEvent
import org.hexworks.zircon.api.uievent.MouseEventType
import org.hexworks.zircon.api.uievent.Processed

object TextAreaDisableExample {

    private val theme = ColorThemes.ghostOfAChance()
    private val tileset = CP437TilesetResources.acorn8X16()

    @JvmStatic
    fun main(args: Array<String>) {

        val tileGrid = LibgdxApplications.startTileGrid(AppConfigs.newConfig()
                .withDefaultTileset(tileset)
                .withSize(Sizes.create(60, 30))
                .build())

        val screen = Screens.createScreenFor(tileGrid)

        val textArea = Components.textArea()
                .withText("Enabled")
                .withPosition(Positions.create(2, 2))
                .withSize(Sizes.create(10, 3))
                .build()

        val toggleButton = Components.button()
                .withText("Toggle TextArea")
                .withPosition(Positions.create(14, 2))
                .build()

        toggleButton.onMouseEvent(MouseEventType.MOUSE_RELEASED) { _, _ ->
            if (textArea.isEnabled) {
                textArea.disable()
                textArea.text = "Disabled"
            } else {
                textArea.enable()
                textArea.text = "Enabled"
            }
            Processed
        }

        screen.addComponent(textArea)
        screen.addComponent(toggleButton)

        screen.display()
        screen.applyColorTheme(theme)
    }

}
