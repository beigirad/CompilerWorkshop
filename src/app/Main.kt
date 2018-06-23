package app

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Created by Farhad's-Macbook on 6/22/18.
 */

class Main : Application() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }

    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("view/home.fxml"))
        primaryStage.title = "Compiler Workshop"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }
}
