package lexical

/**
 * Created by Farhad's-Macbook on 6/22/18.
 */

data class Token (
        val begin: Int,

        val end: Int,

        val tokenString: String,

        val tokenType: TokenType) {

    override fun toString(): String {
        return if (!this.tokenType.isAuxiliary)
            tokenType.toString() + "  '" + tokenString + "' [" + begin + ";" + end + "] "
        else
            tokenType.toString() + "   [" + begin + ";" + end + "] "
    }
}