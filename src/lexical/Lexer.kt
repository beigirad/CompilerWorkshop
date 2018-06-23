package lexical

import java.util.ArrayList
import java.util.TreeMap
import java.util.regex.Pattern

/**
 * Created by Farhad's-Macbook on 6/22/18.
 */

class Lexer {

    private val regEx: MutableMap<TokenType, String>

    private val result: MutableList<Token>

    val tokens: List<Token>
        get() = result

    val filteredTokens: List<Token>
        get() {
            val filteredResult = ArrayList<Token>()
            for (t in this.result) {
                if (!t.tokenType.isAuxiliary) {
                    filteredResult.add(t)
                }
            }
            return filteredResult
        }

    init {
        regEx = TreeMap()
        launchRegEx()
        result = ArrayList()
    }

    @Throws(AnalyzerException::class)
    fun tokenize(source: String) {
        var position = 0
        var token: Token? = null
        do {
            token = separateToken(source, position)
            if (token != null) {
                position = token.end
                result.add(token)
            }
        } while (token != null && position != source.length)
        if (position != source.length) {
            throw AnalyzerException("Lexical error at position # $position", position)

        }
    }

    private fun separateToken(source: String, fromIndex: Int): Token? {
        if (fromIndex < 0 || fromIndex >= source.length) {
            throw IllegalArgumentException("Illegal index in the input stream!")
        }
        for (tokenType in TokenType.values()) {
            val p = Pattern.compile(".{" + fromIndex + "}" + regEx[tokenType],
                    Pattern.DOTALL)
            val m = p.matcher(source)
            if (m.matches()) {
                val lexema = m.group(1)
                return Token(fromIndex, fromIndex + lexema.length, lexema, tokenType)
            }
        }

        return null
    }

    private fun launchRegEx() {
        regEx[TokenType.BlockComment] = "(/\\*.*?\\*/).*"
        regEx[TokenType.LineComment] = "(//(.*?)[\r$]?\n).*"
        regEx[TokenType.WhiteSpace] = "( ).*"
        regEx[TokenType.OpenBrace] = "(\\().*"
        regEx[TokenType.CloseBrace] = "(\\)).*"
        regEx[TokenType.Semicolon] = "(;).*"
        regEx[TokenType.Comma] = "(,).*"
        regEx[TokenType.OpeningCurlyBrace] = "(\\{).*"
        regEx[TokenType.ClosingCurlyBrace] = "(\\}).*"
        regEx[TokenType.DoubleConstant] = "\\b(\\d{1,9}\\.\\d{1,32})\\b.*"
        regEx[TokenType.IntConstant] = "\\b(\\d{1,9})\\b.*"
        regEx[TokenType.Void] = "\\b(void)\\b.*"
        regEx[TokenType.Int] = "\\b(int)\\b.*"
        regEx[TokenType.Double] = "\\b(int|double)\\b.*"
        regEx[TokenType.Tab] = "(\\t).*"
        regEx[TokenType.NewLine] = "(\\n).*"
        regEx[TokenType.Public] = "\\b(public)\\b.*"
        regEx[TokenType.Private] = "\\b(private)\\b.*"
        regEx[TokenType.False] = "\\b(false)\\b.*"
        regEx[TokenType.True] = "\\b(true)\\b.*"
        regEx[TokenType.Null] = "\\b(null)\\b.*"
        regEx[TokenType.Return] = "\\b(return)\\b.*"
        regEx[TokenType.New] = "\\b(new)\\b.*"
        regEx[TokenType.Class] = "\\b(class)\\b.*"
        regEx[TokenType.If] = "\\b(if)\\b.*"
        regEx[TokenType.Else] = "\\b(else)\\b.*"
        regEx[TokenType.While] = "\\b(while)\\b.*"
        regEx[TokenType.Static] = "\\b(static)\\b.*"
        regEx[TokenType.Point] = "(\\.).*"
        regEx[TokenType.Plus] = "(\\+{1}).*"
        regEx[TokenType.Minus] = "(\\-{1}).*"
        regEx[TokenType.Multiply] = "(\\*).*"
        regEx[TokenType.Divide] = "(/).*"
        regEx[TokenType.EqualEqual] = "(==).*"
        regEx[TokenType.Equal] = "(=).*"
        regEx[TokenType.ExclameEqual] = "(\\!=).*"
        regEx[TokenType.Greater] = "(>).*"
        regEx[TokenType.Less] = "(<).*"
        regEx[TokenType.Identifier] = "\\b([a-zA-Z]{1}[0-9a-zA-Z_]{0,31})\\b.*"
    }
}