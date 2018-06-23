package app.controller

import javafx.fxml.FXML
import javafx.scene.control.TextArea

/**
 * Created by Farhad's-Macbook on 6/23/18.
 */

public class LexicalController {

    @FXML
    private var lexicalArea: TextArea? = null

    fun setResult(result: String) {
        lexicalArea?.text = result
    }
}


