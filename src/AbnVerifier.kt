import javafx.application.Application
import javafx.stage.Stage

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

        /* Display the screen contents */
        primaryStage.show()
    }
}