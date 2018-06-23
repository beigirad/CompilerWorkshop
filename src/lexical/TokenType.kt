package lexical

/**
 * Created by Farhad's-Macbook on 6/22/18.
 */

enum class TokenType {
    BlockComment,

    LineComment,

    WhiteSpace,

    Tab,

    NewLine,

    CloseBrace,

    OpenBrace,

    OpeningCurlyBrace,

    ClosingCurlyBrace,

    DoubleConstant,

    IntConstant,

    Plus,

    Minus,

    Multiply,

    Divide,

    Point,

    EqualEqual,

    Equal,

    ExclameEqual,

    Greater,

    Less,

    Static,

    Public,

    Private,

    Int,

    Double,

    Void,

    False,

    True,

    Null,

    Return,

    New,

    Class,

    If,

    While,

    Else,

    Semicolon,

    Comma,

    Identifier,

    DoubleQuote;

    val isAuxiliary: Boolean
        get() = (this == BlockComment || this == LineComment || this == NewLine || this == Tab
                || this == WhiteSpace)
}