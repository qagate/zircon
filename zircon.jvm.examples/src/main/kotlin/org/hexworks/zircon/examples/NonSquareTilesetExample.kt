package org.hexworks.zircon.examples

import org.hexworks.zircon.api.*

object NonSquareTilesetExample {

    @JvmStatic
    fun main(args: Array<String>) {

        // TODO: fix multi-size tilesets
        val tileGrid = SwingApplications.startTileGrid(
                AppConfigs.newConfig()
                        .enableBetaFeatures()
                        .withSize(Sizes.create(50, 40))
                        .withDefaultTileset(CP437TilesetResources.rexPaint16x16())
                        .build())

        val screen = Screens.createScreenFor(tileGrid)

        val textBox = Components.textBox()
                .withPosition(Positions.create(2, 0))
                .withContentWidth(20)
                .addParagraph("This text is more readable because it does not use a square tileset.")
                .addParagraph("This is a 8x16 tileset in fact...")
                .addParagraph("It works fine with a Panel which uses a 16x16 tileset!")
                .withTileset(TrueTypeFontResources.ubuntuMono(16))
                .build()

        val panel = Components.panel()
                .withTitle("Multi-size test")
                .wrapWithBox(true)
                .wrapWithShadow(true)
                .withPosition(Positions.create(2, 2))
                .withSize(Sizes.create(40, 30))
                .build()

        panel.addComponent(textBox)

        screen.addComponent(panel)
        screen.applyColorTheme(ColorThemes.amigaOs())
        screen.display()


    }

}
