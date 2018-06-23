package runner

import javax.swing.JFrame
import javax.swing.SwingUtilities

object Main {
    
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater {
            val frame = JFrame("Compiler Workshop")
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.pack()
            frame.isResizable = false
            frame.isVisible = true
        }
    }
}
