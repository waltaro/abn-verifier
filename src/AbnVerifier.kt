import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import view.createMainView

class AbnVerifier : Application() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(AbnVerifier::class.java)
        }
    }

    override fun start(primaryStage: Stage) {

        /* Set the window title */
        primaryStage.title = "ABN Verifier"

        /* Get main view */
        val mainView = createMainView()

        /* Create a new scene */
        val scene = Scene(mainView)

        /* Set scene */
        primaryStage.scene = scene

        /* Disable resizing of window button */
        primaryStage.resizableProperty().value = false

        /* Display the screen contents */
        primaryStage.show()
    }
}