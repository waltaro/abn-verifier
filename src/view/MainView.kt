package view

import controller.verifyAbn
import javafx.beans.binding.Bindings
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text

fun createMainView() : GridPane {

    /* Create grid pane */
    val gridPane = GridPane()

    /* Set gridpane properties */
    gridPane.alignment = Pos.CENTER // Position
    gridPane.hgap = 10.0 // Horizontal gap between cells
    gridPane.vgap = 10.0 // Vertical gap between cells
    gridPane.padding = Insets(25.0, 25.0, 25.0, 25.0) // Padding

    /* Add components to grid pane */

    /* Add content title to grid pane */
    val title = Text("ABN Verifier")
    title.font = Font.font("Tahoma", FontWeight.NORMAL, 15.0)
    gridPane.add(title,0,0,2,1)

    /* Add ABN number label to grid pane */
    val abnNumber = Label("ABN Number:")
    gridPane.add(abnNumber,0,1)

    /* Add ABN number input field to grid pane */
    val abnNumberField = TextField()
    gridPane.add(abnNumberField,1,1)

    /* Add verify button to grid pane */
    val verifyButton = Button("Verify")
    val verifyButtonBox = HBox(10.0)
    verifyButtonBox.alignment = Pos.BOTTOM_RIGHT
    verifyButtonBox.children.add(verifyButton)
    gridPane.add(verifyButtonBox, 1, 3)

    /* Disable button based on abn number field input */
    verifyButton.disableProperty().bind(Bindings.length(abnNumberField.textProperty()).isEqualTo(0))

    /* Call verify function when button pressed */
    verifyButton.setOnAction { verifyAbn(abnNumberField.text) }

    /* Add verify status text to grid pane */
    val status = Text("Status")
    gridPane.add(status,0,3)

    return gridPane

}