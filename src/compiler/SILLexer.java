// Generated from SIL.g4 by ANTLR 4.7
package compiler;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SILLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, Variable=14, Number=15, MINUS=16, 
		Cop=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "Variable", "Number", "MINUS", "Cop", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'+'", "'*'", "'/'", "'if'", "':'", "'else'", "'stop'", "'true'", 
		"'false'", "'while'", "'end'", "'disp'", null, null, "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "Variable", "Number", "MINUS", "Cop", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SILLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SIL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\6\17Z\n\17\r\17\16\17[\3\20\5\20_\n\20\3\20\6\20b\n\20\r"+
		"\20\16\20c\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"q\n\22\3\23\6\23t\n\23\r\23\16\23u\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3"+
		"\2\6\5\2\62;C\\c|\3\2\62;\4\2>>@@\5\2\13\f\16\17\"\"\2\u0080\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r\62\3\2"+
		"\2\2\17\64\3\2\2\2\219\3\2\2\2\23>\3\2\2\2\25C\3\2\2\2\27I\3\2\2\2\31"+
		"O\3\2\2\2\33S\3\2\2\2\35Y\3\2\2\2\37^\3\2\2\2!e\3\2\2\2#p\3\2\2\2%s\3"+
		"\2\2\2\'(\7?\2\2(\4\3\2\2\2)*\7-\2\2*\6\3\2\2\2+,\7,\2\2,\b\3\2\2\2-."+
		"\7\61\2\2.\n\3\2\2\2/\60\7k\2\2\60\61\7h\2\2\61\f\3\2\2\2\62\63\7<\2\2"+
		"\63\16\3\2\2\2\64\65\7g\2\2\65\66\7n\2\2\66\67\7u\2\2\678\7g\2\28\20\3"+
		"\2\2\29:\7u\2\2:;\7v\2\2;<\7q\2\2<=\7r\2\2=\22\3\2\2\2>?\7v\2\2?@\7t\2"+
		"\2@A\7w\2\2AB\7g\2\2B\24\3\2\2\2CD\7h\2\2DE\7c\2\2EF\7n\2\2FG\7u\2\2G"+
		"H\7g\2\2H\26\3\2\2\2IJ\7y\2\2JK\7j\2\2KL\7k\2\2LM\7n\2\2MN\7g\2\2N\30"+
		"\3\2\2\2OP\7g\2\2PQ\7p\2\2QR\7f\2\2R\32\3\2\2\2ST\7f\2\2TU\7k\2\2UV\7"+
		"u\2\2VW\7r\2\2W\34\3\2\2\2XZ\t\2\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\"+
		"\3\2\2\2\\\36\3\2\2\2]_\5!\21\2^]\3\2\2\2^_\3\2\2\2_a\3\2\2\2`b\t\3\2"+
		"\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d \3\2\2\2ef\7/\2\2f\"\3\2\2"+
		"\2gh\7?\2\2hq\7?\2\2ij\7@\2\2jq\7?\2\2kl\7>\2\2lq\7?\2\2mq\t\4\2\2no\7"+
		"\u0080\2\2oq\7?\2\2pg\3\2\2\2pi\3\2\2\2pk\3\2\2\2pm\3\2\2\2pn\3\2\2\2"+
		"q$\3\2\2\2rt\t\5\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2"+
		"wx\b\23\2\2x&\3\2\2\2\b\2[^cpu\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}