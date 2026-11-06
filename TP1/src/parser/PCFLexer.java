// Generated from C:/Users/A D M I N/compilation/TP1/src/parser/PCF.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PCFLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, NUMBER=15, VAR=16, WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "NUMBER", "VAR", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'", "'let'", "'='", "'in'", "'ifz'", "'then'", 
			"'else'", "'('", "')'", "'fun'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "NUMBER", "VAR", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public PCFLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PCF.g4"; }

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
		"\u0004\u0000\u0011e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000eQ\b\u000e\n\u000e\f\u000eT\t\u000e\u0003\u000eV\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0005\u000fZ\b\u000f\n\u000f\f\u000f]\t\u000f"+
		"\u0001\u0010\u0004\u0010`\b\u0010\u000b\u0010\f\u0010a\u0001\u0010\u0001"+
		"\u0010\u0000\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011\u0001\u0000\u0005"+
		"\u0001\u000019\u0001\u000009\u0001\u0000az\u0002\u000009az\u0003\u0000"+
		"\t\n\r\r  h\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003%"+
		"\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007)\u0001"+
		"\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b/\u0001\u0000\u0000"+
		"\u0000\r1\u0001\u0000\u0000\u0000\u000f4\u0001\u0000\u0000\u0000\u0011"+
		"8\u0001\u0000\u0000\u0000\u0013=\u0001\u0000\u0000\u0000\u0015B\u0001"+
		"\u0000\u0000\u0000\u0017D\u0001\u0000\u0000\u0000\u0019F\u0001\u0000\u0000"+
		"\u0000\u001bJ\u0001\u0000\u0000\u0000\u001dU\u0001\u0000\u0000\u0000\u001f"+
		"W\u0001\u0000\u0000\u0000!_\u0001\u0000\u0000\u0000#$\u0005*\u0000\u0000"+
		"$\u0002\u0001\u0000\u0000\u0000%&\u0005/\u0000\u0000&\u0004\u0001\u0000"+
		"\u0000\u0000\'(\u0005+\u0000\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005"+
		"-\u0000\u0000*\b\u0001\u0000\u0000\u0000+,\u0005l\u0000\u0000,-\u0005"+
		"e\u0000\u0000-.\u0005t\u0000\u0000.\n\u0001\u0000\u0000\u0000/0\u0005"+
		"=\u0000\u00000\f\u0001\u0000\u0000\u000012\u0005i\u0000\u000023\u0005"+
		"n\u0000\u00003\u000e\u0001\u0000\u0000\u000045\u0005i\u0000\u000056\u0005"+
		"f\u0000\u000067\u0005z\u0000\u00007\u0010\u0001\u0000\u0000\u000089\u0005"+
		"t\u0000\u00009:\u0005h\u0000\u0000:;\u0005e\u0000\u0000;<\u0005n\u0000"+
		"\u0000<\u0012\u0001\u0000\u0000\u0000=>\u0005e\u0000\u0000>?\u0005l\u0000"+
		"\u0000?@\u0005s\u0000\u0000@A\u0005e\u0000\u0000A\u0014\u0001\u0000\u0000"+
		"\u0000BC\u0005(\u0000\u0000C\u0016\u0001\u0000\u0000\u0000DE\u0005)\u0000"+
		"\u0000E\u0018\u0001\u0000\u0000\u0000FG\u0005f\u0000\u0000GH\u0005u\u0000"+
		"\u0000HI\u0005n\u0000\u0000I\u001a\u0001\u0000\u0000\u0000JK\u0005-\u0000"+
		"\u0000KL\u0005>\u0000\u0000L\u001c\u0001\u0000\u0000\u0000MV\u00050\u0000"+
		"\u0000NR\u0007\u0000\u0000\u0000OQ\u0007\u0001\u0000\u0000PO\u0001\u0000"+
		"\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"UM\u0001\u0000\u0000\u0000UN\u0001\u0000\u0000\u0000V\u001e\u0001\u0000"+
		"\u0000\u0000W[\u0007\u0002\u0000\u0000XZ\u0007\u0003\u0000\u0000YX\u0001"+
		"\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\ \u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000^`\u0007\u0004\u0000\u0000_^\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000cd\u0006\u0010\u0000\u0000d\"\u0001\u0000\u0000\u0000"+
		"\u0005\u0000RU[a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}