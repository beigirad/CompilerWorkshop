package app.controller

import lexical.AnalyzerException
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.TextArea
import javafx.stage.Modality
import javafx.stage.Stage
import lexical.Lexer

/**
 * Created by Farhad's-Macbook on 6/22/18.
 */

public class HomeController {

    @FXML
    private lateinit var codeArea: TextArea

    fun onAnalysis(actionEvent: ActionEvent) {
        if (codeArea.text.isNullOrBlank()) {
            showError("Please enter source code.")
            return
        }
        showResult(lexicalAnalyse(codeArea.text))
    }

    private fun lexicalAnalyse(sourceCode: String): String {
        var lexer = Lexer()
        var stringBuilder = StringBuilder()
        try {
            lexer.tokenize(sourceCode)
        } catch (exception: AnalyzerException) {
            showError(exception.msg)
        } catch (exception: Exception) {
            showError("" + exception.message)
        } finally {
            var i = 0
            for (token in lexer.tokens) {
                if (token.tokenType.isAuxiliary)
                    stringBuilder.appendln("        " + token.toString())
                else {
                    i++
                    stringBuilder.appendln(String.format("%03d", i) + "  " + token.toString())
                }
            }
            return stringBuilder.toString()
        }
    }

    private fun showError(error: String) {
        var alert = Alert(Alert.AlertType.ERROR)
        alert.title = "Error"
        alert.contentText = error
        alert.showAndWait()
    }

    private fun showResult(result: String) {
        val loader = FXMLLoader(javaClass.getResource("../view/lexical.fxml"))
        val parent = loader.load<Parent>()

        val controller = loader.getController<LexicalController>()
        controller.setResult(result)
        var stage = Stage()
        stage.title = "Lexical Analyse"
        stage.scene = Scene(parent)
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.showAndWait()
    }
}


