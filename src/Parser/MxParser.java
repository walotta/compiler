// Generated from /Users/wzj/Documents/code/compiler/src/Parser/Mx.g4 by ANTLR 4.9.1
package Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, Int=4, Bool=5, String=6, Class=7, Void=8, Break=9, 
		Continue=10, Return=11, If=12, Else=13, For=14, While=15, New=16, This=17, 
		True=18, False=19, Null=20, Identifier=21, IntegerConstant=22, StringConstant=23, 
		Whitespace=24, Newline=25, BlockComment=26, LineComment=27, SelfAdd=28, 
		SelfSub=29, Add=30, Sub=31, LogicNot=32, BitNot=33, Mul=34, Div=35, Mod=36, 
		BitLeft=37, BitRight=38, SmallThan=39, BigThan=40, SmallEqual=41, BigEqual=42, 
		IsEqual=43, IsNotEqual=44, BitAnd=45, BitXor=46, BitOr=47, LogicAnd=48, 
		LogicOr=49, Equal=50, LeftParen=51, RightParen=52, LeftBracket=53, RightBracket=54, 
		LeftBrace=55, RightBrace=56;
	public static final int
		RULE_program = 0, RULE_programBlock = 1, RULE_classBlock = 2, RULE_buildFuncBlock = 3, 
		RULE_funcBlock = 4, RULE_varBlock = 5, RULE_retType = 6, RULE_singleVarBlock = 7, 
		RULE_type = 8, RULE_singleType = 9, RULE_statementBlock = 10, RULE_statement = 11, 
		RULE_experssion = 12, RULE_constValue = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programBlock", "classBlock", "buildFuncBlock", "funcBlock", 
			"varBlock", "retType", "singleVarBlock", "type", "singleType", "statementBlock", 
			"statement", "experssion", "constValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'.'", "'int'", "'bool'", "'string'", "'class'", 
			"'void'", "'break'", "'continue'", "'return'", "'if'", "'else'", "'for'", 
			"'while'", "'new'", "'this'", "'true'", "'false'", "'null'", null, null, 
			null, null, null, null, null, "'++'", "'--'", "'+'", "'-'", "'!'", "'~'", 
			"'*'", "'/'", "'%'", "'<<'", "'>>'", "'<'", "'>'", "'<='", "'>='", "'=='", 
			"'!='", "'&'", "'^'", "'|'", "'&&'", "'||'", "'='", "'('", "')'", "'['", 
			"']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "Int", "Bool", "String", "Class", "Void", "Break", 
			"Continue", "Return", "If", "Else", "For", "While", "New", "This", "True", 
			"False", "Null", "Identifier", "IntegerConstant", "StringConstant", "Whitespace", 
			"Newline", "BlockComment", "LineComment", "SelfAdd", "SelfSub", "Add", 
			"Sub", "LogicNot", "BitNot", "Mul", "Div", "Mod", "BitLeft", "BitRight", 
			"SmallThan", "BigThan", "SmallEqual", "BigEqual", "IsEqual", "IsNotEqual", 
			"BitAnd", "BitXor", "BitOr", "LogicAnd", "LogicOr", "Equal", "LeftParen", 
			"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace"
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

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<ProgramBlockContext> programBlock() {
			return getRuleContexts(ProgramBlockContext.class);
		}
		public ProgramBlockContext programBlock(int i) {
			return getRuleContext(ProgramBlockContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Class) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(28);
				programBlock();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramBlockContext extends ParserRuleContext {
		public ClassBlockContext classBlock() {
			return getRuleContext(ClassBlockContext.class,0);
		}
		public FuncBlockContext funcBlock() {
			return getRuleContext(FuncBlockContext.class,0);
		}
		public VarBlockContext varBlock() {
			return getRuleContext(VarBlockContext.class,0);
		}
		public ProgramBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProgramBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProgramBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProgramBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramBlockContext programBlock() throws RecognitionException {
		ProgramBlockContext _localctx = new ProgramBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programBlock);
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				classBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				funcBlock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				varBlock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBlockContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<BuildFuncBlockContext> buildFuncBlock() {
			return getRuleContexts(BuildFuncBlockContext.class);
		}
		public BuildFuncBlockContext buildFuncBlock(int i) {
			return getRuleContext(BuildFuncBlockContext.class,i);
		}
		public List<FuncBlockContext> funcBlock() {
			return getRuleContexts(FuncBlockContext.class);
		}
		public FuncBlockContext funcBlock(int i) {
			return getRuleContext(FuncBlockContext.class,i);
		}
		public List<VarBlockContext> varBlock() {
			return getRuleContexts(VarBlockContext.class);
		}
		public VarBlockContext varBlock(int i) {
			return getRuleContext(VarBlockContext.class,i);
		}
		public ClassBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBlockContext classBlock() throws RecognitionException {
		ClassBlockContext _localctx = new ClassBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(Class);
			setState(42);
			match(Identifier);
			setState(43);
			match(LeftBrace);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(47);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(44);
					buildFuncBlock();
					}
					break;
				case 2:
					{
					setState(45);
					funcBlock();
					}
					break;
				case 3:
					{
					setState(46);
					varBlock();
					}
					break;
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(RightBrace);
			setState(53);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuildFuncBlockContext extends ParserRuleContext {
		public Token funcName;
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxParser.Identifier, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public BuildFuncBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buildFuncBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBuildFuncBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBuildFuncBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBuildFuncBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuildFuncBlockContext buildFuncBlock() throws RecognitionException {
		BuildFuncBlockContext _localctx = new BuildFuncBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_buildFuncBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			((BuildFuncBlockContext)_localctx).funcName = match(Identifier);
			setState(56);
			match(LeftParen);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(57);
				type();
				setState(58);
				match(Identifier);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(59);
					match(T__1);
					setState(60);
					type();
					setState(61);
					match(Identifier);
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(70);
			match(RightParen);
			setState(71);
			statementBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncBlockContext extends ParserRuleContext {
		public Token funcName;
		public RetTypeContext retType() {
			return getRuleContext(RetTypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxParser.Identifier, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public FuncBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFuncBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFuncBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFuncBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncBlockContext funcBlock() throws RecognitionException {
		FuncBlockContext _localctx = new FuncBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			retType();
			setState(74);
			((FuncBlockContext)_localctx).funcName = match(Identifier);
			setState(75);
			match(LeftParen);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(76);
				type();
				setState(77);
				match(Identifier);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(78);
					match(T__1);
					setState(79);
					type();
					setState(80);
					match(Identifier);
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(89);
			match(RightParen);
			setState(90);
			statementBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarBlockContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<SingleVarBlockContext> singleVarBlock() {
			return getRuleContexts(SingleVarBlockContext.class);
		}
		public SingleVarBlockContext singleVarBlock(int i) {
			return getRuleContext(SingleVarBlockContext.class,i);
		}
		public VarBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarBlockContext varBlock() throws RecognitionException {
		VarBlockContext _localctx = new VarBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			type();
			setState(93);
			singleVarBlock();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(94);
				match(T__1);
				setState(95);
				singleVarBlock();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public RetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterRetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitRetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitRetType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetTypeContext retType() throws RecognitionException {
		RetTypeContext _localctx = new RetTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_retType);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				type();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleVarBlockContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public SingleVarBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleVarBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSingleVarBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSingleVarBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSingleVarBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleVarBlockContext singleVarBlock() throws RecognitionException {
		SingleVarBlockContext _localctx = new SingleVarBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_singleVarBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Identifier);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equal) {
				{
				setState(108);
				match(Equal);
				setState(109);
				experssion(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				singleType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				singleType();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LeftBracket) {
					{
					{
					setState(114);
					match(LeftBracket);
					setState(115);
					match(RightBracket);
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public SingleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSingleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSingleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSingleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleTypeContext singleType() throws RecognitionException {
		SingleTypeContext _localctx = new SingleTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_singleType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementBlockContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statementBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(LeftBrace);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << If) | (1L << For) | (1L << While) | (1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket) | (1L << LeftBrace))) != 0)) {
				{
				{
				setState(126);
				statement();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyStatementContext extends StatementContext {
		public EmptyStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakContext extends StatementContext {
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public BreakContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueContext extends StatementContext {
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public ContinueContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpStatementContext extends StatementContext {
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public ExpStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExpStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForContext extends StatementContext {
		public ExperssionContext initExp;
		public ExperssionContext finishExp;
		public ExperssionContext stepExp;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExperssionContext> experssion() {
			return getRuleContexts(ExperssionContext.class);
		}
		public ExperssionContext experssion(int i) {
			return getRuleContext(ExperssionContext.class,i);
		}
		public ForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RetStatementContext extends StatementContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public RetStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterRetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitRetStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitRetStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends StatementContext {
		public ExperssionContext finishExp;
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends StatementContext {
		public StatementContext trueStatement;
		public StatementContext falseStatement;
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public IfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDefineContext extends StatementContext {
		public VarBlockContext varBlock() {
			return getRuleContext(VarBlockContext.class,0);
		}
		public VarDefineContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDefine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StateBlockContext extends StatementContext {
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public StateBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterStateBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitStateBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitStateBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		int _la;
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new StateBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				statementBlock();
				}
				break;
			case 2:
				_localctx = new VarDefineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				varBlock();
				}
				break;
			case 3:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(If);
				setState(137);
				match(LeftParen);
				setState(138);
				experssion(0);
				setState(139);
				match(RightParen);
				setState(140);
				((IfContext)_localctx).trueStatement = statement();
				setState(143);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(141);
					match(Else);
					setState(142);
					((IfContext)_localctx).falseStatement = statement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				match(For);
				setState(146);
				match(LeftParen);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket))) != 0)) {
					{
					setState(147);
					((ForContext)_localctx).initExp = experssion(0);
					}
				}

				setState(150);
				match(T__0);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket))) != 0)) {
					{
					setState(151);
					((ForContext)_localctx).finishExp = experssion(0);
					}
				}

				setState(154);
				match(T__0);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket))) != 0)) {
					{
					setState(155);
					((ForContext)_localctx).stepExp = experssion(0);
					}
				}

				setState(158);
				match(RightParen);
				setState(159);
				statement();
				}
				break;
			case 5:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(160);
				match(While);
				setState(161);
				match(LeftParen);
				setState(162);
				((WhileContext)_localctx).finishExp = experssion(0);
				setState(163);
				match(RightParen);
				setState(164);
				statement();
				}
				break;
			case 6:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(166);
				match(Break);
				setState(167);
				match(T__0);
				}
				break;
			case 7:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(168);
				match(Continue);
				setState(169);
				match(T__0);
				}
				break;
			case 8:
				_localctx = new RetStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(170);
				match(Return);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket))) != 0)) {
					{
					setState(171);
					experssion(0);
					}
				}

				setState(174);
				match(T__0);
				}
				break;
			case 9:
				_localctx = new ExpStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(175);
				experssion(0);
				setState(176);
				match(T__0);
				}
				break;
			case 10:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(178);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExperssionContext extends ParserRuleContext {
		public ExperssionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_experssion; }
	 
		public ExperssionContext() { }
		public void copyFrom(ExperssionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassMemberContext extends ExperssionContext {
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ClassMemberContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassMember(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExperssionContext {
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ConstValueContext constValue() {
			return getRuleContext(ConstValueContext.class,0);
		}
		public AtomExprContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayContext extends ExperssionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<ExperssionContext> experssion() {
			return getRuleContexts(ExperssionContext.class);
		}
		public ExperssionContext experssion(int i) {
			return getRuleContext(ExperssionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public NewArrayContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExperssionContext {
		public Token op;
		public List<ExperssionContext> experssion() {
			return getRuleContexts(ExperssionContext.class);
		}
		public ExperssionContext experssion(int i) {
			return getRuleContext(ExperssionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public TerminalNode BitLeft() { return getToken(MxParser.BitLeft, 0); }
		public TerminalNode BitRight() { return getToken(MxParser.BitRight, 0); }
		public TerminalNode SmallThan() { return getToken(MxParser.SmallThan, 0); }
		public TerminalNode BigThan() { return getToken(MxParser.BigThan, 0); }
		public TerminalNode SmallEqual() { return getToken(MxParser.SmallEqual, 0); }
		public TerminalNode BigEqual() { return getToken(MxParser.BigEqual, 0); }
		public TerminalNode IsEqual() { return getToken(MxParser.IsEqual, 0); }
		public TerminalNode IsNotEqual() { return getToken(MxParser.IsNotEqual, 0); }
		public TerminalNode BitAnd() { return getToken(MxParser.BitAnd, 0); }
		public TerminalNode BitXor() { return getToken(MxParser.BitXor, 0); }
		public TerminalNode BitOr() { return getToken(MxParser.BitOr, 0); }
		public TerminalNode LogicAnd() { return getToken(MxParser.LogicAnd, 0); }
		public TerminalNode LogicOr() { return getToken(MxParser.LogicOr, 0); }
		public BinaryExprContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewInitObjectContext extends ExperssionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<ExperssionContext> experssion() {
			return getRuleContexts(ExperssionContext.class);
		}
		public ExperssionContext experssion(int i) {
			return getRuleContext(ExperssionContext.class,i);
		}
		public NewInitObjectContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewInitObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewInitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewInitObject(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostFixIncDecContext extends ExperssionContext {
		public Token op;
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(MxParser.SelfSub, 0); }
		public PostFixIncDecContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPostFixIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPostFixIncDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPostFixIncDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayMemberContext extends ExperssionContext {
		public ExperssionContext array;
		public ExperssionContext index;
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public List<ExperssionContext> experssion() {
			return getRuleContexts(ExperssionContext.class);
		}
		public ExperssionContext experssion(int i) {
			return getRuleContext(ExperssionContext.class,i);
		}
		public ArrayMemberContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArrayMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArrayMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArrayMember(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExperssionContext {
		public Token op;
		public ExperssionContext experssion() {
			return getRuleContext(ExperssionContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(MxParser.SelfSub, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public TerminalNode LogicNot() { return getToken(MxParser.LogicNot, 0); }
		public TerminalNode BitNot() { return getToken(MxParser.BitNot, 0); }
		public UnaryExprContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayErrContext extends ExperssionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<ExperssionContext> experssion() {
			return getRuleContexts(ExperssionContext.class);
		}
		public ExperssionContext experssion(int i) {
			return getRuleContext(ExperssionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public NewArrayErrContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewArrayErr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewArrayErr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewArrayErr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExprContext extends ExperssionContext {
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode BitAnd() { return getToken(MxParser.BitAnd, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxParser.Identifier, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LambdaExprContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLambdaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLambdaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewObjectContext extends ExperssionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public NewObjectContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewObject(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallContext extends ExperssionContext {
		public ExperssionContext funcName;
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<ExperssionContext> experssion() {
			return getRuleContexts(ExperssionContext.class);
		}
		public ExperssionContext experssion(int i) {
			return getRuleContext(ExperssionContext.class,i);
		}
		public FuncCallContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExperssionContext {
		public Token op;
		public List<ExperssionContext> experssion() {
			return getRuleContexts(ExperssionContext.class);
		}
		public ExperssionContext experssion(int i) {
			return getRuleContext(ExperssionContext.class,i);
		}
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public AssignContext(ExperssionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExperssionContext experssion() throws RecognitionException {
		return experssion(0);
	}

	private ExperssionContext experssion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExperssionContext _localctx = new ExperssionContext(_ctx, _parentState);
		ExperssionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_experssion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(182);
				match(LeftParen);
				setState(183);
				experssion(0);
				setState(184);
				match(RightParen);
				}
				break;
			case 2:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(Identifier);
				}
				break;
			case 3:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				constValue();
				}
				break;
			case 4:
				{
				_localctx = new NewArrayErrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(New);
				setState(189);
				singleType();
				setState(194); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(190);
						match(LeftBracket);
						setState(191);
						experssion(0);
						setState(192);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(196); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(198);
						match(LeftBracket);
						setState(199);
						match(RightBracket);
						}
						} 
					}
					setState(204);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				setState(209); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(205);
						match(LeftBracket);
						setState(206);
						experssion(0);
						setState(207);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(211); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				{
				_localctx = new NewArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(New);
				setState(214);
				singleType();
				setState(219); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(215);
						match(LeftBracket);
						setState(216);
						experssion(0);
						setState(217);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(221); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(223);
						match(LeftBracket);
						setState(224);
						match(RightBracket);
						}
						} 
					}
					setState(229);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				}
				break;
			case 6:
				{
				_localctx = new NewInitObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(New);
				setState(231);
				singleType();
				setState(232);
				match(LeftParen);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket))) != 0)) {
					{
					setState(233);
					experssion(0);
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(234);
						match(T__1);
						setState(235);
						experssion(0);
						}
						}
						setState(240);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(243);
				match(RightParen);
				}
				break;
			case 7:
				{
				_localctx = new NewObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
				match(New);
				setState(246);
				singleType();
				}
				break;
			case 8:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfAdd || _la==SelfSub) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(248);
				experssion(16);
				}
				break;
			case 9:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Add || _la==Sub) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(250);
				experssion(15);
				}
				break;
			case 10:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LogicNot || _la==BitNot) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(252);
				experssion(14);
				}
				break;
			case 11:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				match(LeftBracket);
				setState(254);
				match(BitAnd);
				setState(255);
				match(RightBracket);
				setState(256);
				match(LeftParen);
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
					{
					setState(257);
					type();
					setState(258);
					match(Identifier);
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(259);
						match(T__1);
						setState(260);
						type();
						setState(261);
						match(Identifier);
						}
						}
						setState(267);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(270);
				match(RightParen);
				setState(271);
				match(LeftBrace);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << If) | (1L << For) | (1L << While) | (1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket) | (1L << LeftBrace))) != 0)) {
					{
					{
					setState(272);
					statement();
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				match(RightBrace);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(342);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(340);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(281);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(282);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(283);
						experssion(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(284);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(285);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(286);
						experssion(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(287);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(288);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==BitLeft || _la==BitRight) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(289);
						experssion(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(290);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(291);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SmallThan || _la==BigThan) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(292);
						experssion(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(293);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(294);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SmallEqual || _la==BigEqual) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(295);
						experssion(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(296);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(297);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IsEqual || _la==IsNotEqual) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(298);
						experssion(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(299);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(300);
						((BinaryExprContext)_localctx).op = match(BitAnd);
						setState(301);
						experssion(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(302);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(303);
						((BinaryExprContext)_localctx).op = match(BitXor);
						setState(304);
						experssion(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(305);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(306);
						((BinaryExprContext)_localctx).op = match(BitOr);
						setState(307);
						experssion(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(308);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(309);
						((BinaryExprContext)_localctx).op = match(LogicAnd);
						setState(310);
						experssion(5);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(311);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(312);
						((BinaryExprContext)_localctx).op = match(LogicOr);
						setState(313);
						experssion(4);
						}
						break;
					case 12:
						{
						_localctx = new AssignContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(314);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(315);
						((AssignContext)_localctx).op = match(Equal);
						setState(316);
						experssion(2);
						}
						break;
					case 13:
						{
						_localctx = new ClassMemberContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(317);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(318);
						match(T__2);
						setState(319);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ArrayMemberContext(new ExperssionContext(_parentctx, _parentState));
						((ArrayMemberContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(320);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(321);
						match(LeftBracket);
						setState(322);
						((ArrayMemberContext)_localctx).index = experssion(0);
						setState(323);
						match(RightBracket);
						}
						break;
					case 15:
						{
						_localctx = new FuncCallContext(new ExperssionContext(_parentctx, _parentState));
						((FuncCallContext)_localctx).funcName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(325);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(326);
						match(LeftParen);
						setState(335);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket))) != 0)) {
							{
							setState(327);
							experssion(0);
							setState(332);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__1) {
								{
								{
								setState(328);
								match(T__1);
								setState(329);
								experssion(0);
								}
								}
								setState(334);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(337);
						match(RightParen);
						}
						break;
					case 16:
						{
						_localctx = new PostFixIncDecContext(new ExperssionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_experssion);
						setState(338);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(339);
						((PostFixIncDecContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfAdd || _la==SelfSub) ) {
							((PostFixIncDecContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstValueContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public TerminalNode Null() { return getToken(MxParser.Null, 0); }
		public TerminalNode IntegerConstant() { return getToken(MxParser.IntegerConstant, 0); }
		public TerminalNode StringConstant() { return getToken(MxParser.StringConstant, 0); }
		public ConstValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConstValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConstValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConstValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstValueContext constValue() throws RecognitionException {
		ConstValueContext _localctx = new ConstValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return experssion_sempred((ExperssionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean experssion_sempred(ExperssionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 20);
		case 13:
			return precpred(_ctx, 19);
		case 14:
			return precpred(_ctx, 18);
		case 15:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u015e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\7\2 \n\2\f\2\16\2#\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\62\n\4\f\4\16"+
		"\4\65\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16"+
		"\5E\13\5\5\5G\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"U\n\6\f\6\16\6X\13\6\5\6Z\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7c\n\7\f\7"+
		"\16\7f\13\7\3\7\3\7\3\b\3\b\5\bl\n\b\3\t\3\t\3\t\5\tq\n\t\3\n\3\n\3\n"+
		"\3\n\7\nw\n\n\f\n\16\nz\13\n\5\n|\n\n\3\13\3\13\3\f\3\f\7\f\u0082\n\f"+
		"\f\f\16\f\u0085\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0092"+
		"\n\r\3\r\3\r\3\r\5\r\u0097\n\r\3\r\3\r\5\r\u009b\n\r\3\r\3\r\5\r\u009f"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00af"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b6\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00c5\n\16\r\16\16\16\u00c6\3\16"+
		"\3\16\7\16\u00cb\n\16\f\16\16\16\u00ce\13\16\3\16\3\16\3\16\3\16\6\16"+
		"\u00d4\n\16\r\16\16\16\u00d5\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00de"+
		"\n\16\r\16\16\16\u00df\3\16\3\16\7\16\u00e4\n\16\f\16\16\16\u00e7\13\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00ef\n\16\f\16\16\16\u00f2\13\16"+
		"\5\16\u00f4\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u010a\n\16\f\16\16"+
		"\16\u010d\13\16\5\16\u010f\n\16\3\16\3\16\3\16\7\16\u0114\n\16\f\16\16"+
		"\16\u0117\13\16\3\16\5\16\u011a\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u014d\n\16\f\16\16\16\u0150\13\16\5\16\u0152\n\16\3\16\3\16\3\16"+
		"\7\16\u0157\n\16\f\16\16\16\u015a\13\16\3\17\3\17\3\17\2\3\32\20\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\2\f\4\2\6\b\27\27\3\2\36\37\3\2 !\3\2\""+
		"#\3\2$&\3\2\'(\3\2)*\3\2+,\3\2-.\4\2\23\26\30\31\2\u0193\2!\3\2\2\2\4"+
		")\3\2\2\2\6+\3\2\2\2\b9\3\2\2\2\nK\3\2\2\2\f^\3\2\2\2\16k\3\2\2\2\20m"+
		"\3\2\2\2\22{\3\2\2\2\24}\3\2\2\2\26\177\3\2\2\2\30\u00b5\3\2\2\2\32\u0119"+
		"\3\2\2\2\34\u015b\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2"+
		"\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7\2\2\3%\3\3\2\2\2&*\5\6\4\2\'"+
		"*\5\n\6\2(*\5\f\7\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\5\3\2\2\2+,\7\t\2"+
		"\2,-\7\27\2\2-\63\79\2\2.\62\5\b\5\2/\62\5\n\6\2\60\62\5\f\7\2\61.\3\2"+
		"\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2"+
		"\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7:\2\2\678\7\3\2\28\7\3\2\2\29:\7"+
		"\27\2\2:F\7\65\2\2;<\5\22\n\2<C\7\27\2\2=>\7\4\2\2>?\5\22\n\2?@\7\27\2"+
		"\2@B\3\2\2\2A=\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2"+
		"\2F;\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\66\2\2IJ\5\26\f\2J\t\3\2\2\2KL\5"+
		"\16\b\2LM\7\27\2\2MY\7\65\2\2NO\5\22\n\2OV\7\27\2\2PQ\7\4\2\2QR\5\22\n"+
		"\2RS\7\27\2\2SU\3\2\2\2TP\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WZ\3\2"+
		"\2\2XV\3\2\2\2YN\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\66\2\2\\]\5\26\f\2]"+
		"\13\3\2\2\2^_\5\22\n\2_d\5\20\t\2`a\7\4\2\2ac\5\20\t\2b`\3\2\2\2cf\3\2"+
		"\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\3\2\2h\r\3\2\2\2il\5"+
		"\22\n\2jl\7\n\2\2ki\3\2\2\2kj\3\2\2\2l\17\3\2\2\2mp\7\27\2\2no\7\64\2"+
		"\2oq\5\32\16\2pn\3\2\2\2pq\3\2\2\2q\21\3\2\2\2r|\5\24\13\2sx\5\24\13\2"+
		"tu\7\67\2\2uw\78\2\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y|\3\2\2\2"+
		"zx\3\2\2\2{r\3\2\2\2{s\3\2\2\2|\23\3\2\2\2}~\t\2\2\2~\25\3\2\2\2\177\u0083"+
		"\79\2\2\u0080\u0082\5\30\r\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2"+
		"\2\2\u0086\u0087\7:\2\2\u0087\27\3\2\2\2\u0088\u00b6\5\26\f\2\u0089\u00b6"+
		"\5\f\7\2\u008a\u008b\7\16\2\2\u008b\u008c\7\65\2\2\u008c\u008d\5\32\16"+
		"\2\u008d\u008e\7\66\2\2\u008e\u0091\5\30\r\2\u008f\u0090\7\17\2\2\u0090"+
		"\u0092\5\30\r\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u00b6\3"+
		"\2\2\2\u0093\u0094\7\20\2\2\u0094\u0096\7\65\2\2\u0095\u0097\5\32\16\2"+
		"\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a"+
		"\7\3\2\2\u0099\u009b\5\32\16\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2"+
		"\u009b\u009c\3\2\2\2\u009c\u009e\7\3\2\2\u009d\u009f\5\32\16\2\u009e\u009d"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\66\2\2"+
		"\u00a1\u00b6\5\30\r\2\u00a2\u00a3\7\21\2\2\u00a3\u00a4\7\65\2\2\u00a4"+
		"\u00a5\5\32\16\2\u00a5\u00a6\7\66\2\2\u00a6\u00a7\5\30\r\2\u00a7\u00b6"+
		"\3\2\2\2\u00a8\u00a9\7\13\2\2\u00a9\u00b6\7\3\2\2\u00aa\u00ab\7\f\2\2"+
		"\u00ab\u00b6\7\3\2\2\u00ac\u00ae\7\r\2\2\u00ad\u00af\5\32\16\2\u00ae\u00ad"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b6\7\3\2\2\u00b1"+
		"\u00b2\5\32\16\2\u00b2\u00b3\7\3\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b6\7"+
		"\3\2\2\u00b5\u0088\3\2\2\2\u00b5\u0089\3\2\2\2\u00b5\u008a\3\2\2\2\u00b5"+
		"\u0093\3\2\2\2\u00b5\u00a2\3\2\2\2\u00b5\u00a8\3\2\2\2\u00b5\u00aa\3\2"+
		"\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"\31\3\2\2\2\u00b7\u00b8\b\16\1\2\u00b8\u00b9\7\65\2\2\u00b9\u00ba\5\32"+
		"\16\2\u00ba\u00bb\7\66\2\2\u00bb\u011a\3\2\2\2\u00bc\u011a\7\27\2\2\u00bd"+
		"\u011a\5\34\17\2\u00be\u00bf\7\22\2\2\u00bf\u00c4\5\24\13\2\u00c0\u00c1"+
		"\7\67\2\2\u00c1\u00c2\5\32\16\2\u00c2\u00c3\78\2\2\u00c3\u00c5\3\2\2\2"+
		"\u00c4\u00c0\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\u00cc\3\2\2\2\u00c8\u00c9\7\67\2\2\u00c9\u00cb\78\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00d3\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7\67\2\2\u00d0"+
		"\u00d1\5\32\16\2\u00d1\u00d2\78\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00cf\3"+
		"\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u011a\3\2\2\2\u00d7\u00d8\7\22\2\2\u00d8\u00dd\5\24\13\2\u00d9\u00da"+
		"\7\67\2\2\u00da\u00db\5\32\16\2\u00db\u00dc\78\2\2\u00dc\u00de\3\2\2\2"+
		"\u00dd\u00d9\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e5\3\2\2\2\u00e1\u00e2\7\67\2\2\u00e2\u00e4\78\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2"+
		"\2\2\u00e6\u011a\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\7\22\2\2\u00e9"+
		"\u00ea\5\24\13\2\u00ea\u00f3\7\65\2\2\u00eb\u00f0\5\32\16\2\u00ec\u00ed"+
		"\7\4\2\2\u00ed\u00ef\5\32\16\2\u00ee\u00ec\3\2\2\2\u00ef\u00f2\3\2\2\2"+
		"\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\u00eb\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\7\66\2\2\u00f6\u011a\3\2\2\2\u00f7\u00f8\7\22\2\2\u00f8\u011a\5"+
		"\24\13\2\u00f9\u00fa\t\3\2\2\u00fa\u011a\5\32\16\22\u00fb\u00fc\t\4\2"+
		"\2\u00fc\u011a\5\32\16\21\u00fd\u00fe\t\5\2\2\u00fe\u011a\5\32\16\20\u00ff"+
		"\u0100\7\67\2\2\u0100\u0101\7/\2\2\u0101\u0102\78\2\2\u0102\u010e\7\65"+
		"\2\2\u0103\u0104\5\22\n\2\u0104\u010b\7\27\2\2\u0105\u0106\7\4\2\2\u0106"+
		"\u0107\5\22\n\2\u0107\u0108\7\27\2\2\u0108\u010a\3\2\2\2\u0109\u0105\3"+
		"\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0103\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7\66\2\2\u0111\u0115\79\2\2\u0112"+
		"\u0114\5\30\r\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3"+
		"\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\u011a\7:\2\2\u0119\u00b7\3\2\2\2\u0119\u00bc\3\2\2\2\u0119\u00bd\3\2"+
		"\2\2\u0119\u00be\3\2\2\2\u0119\u00d7\3\2\2\2\u0119\u00e8\3\2\2\2\u0119"+
		"\u00f7\3\2\2\2\u0119\u00f9\3\2\2\2\u0119\u00fb\3\2\2\2\u0119\u00fd\3\2"+
		"\2\2\u0119\u00ff\3\2\2\2\u011a\u0158\3\2\2\2\u011b\u011c\f\17\2\2\u011c"+
		"\u011d\t\6\2\2\u011d\u0157\5\32\16\20\u011e\u011f\f\16\2\2\u011f\u0120"+
		"\t\4\2\2\u0120\u0157\5\32\16\17\u0121\u0122\f\r\2\2\u0122\u0123\t\7\2"+
		"\2\u0123\u0157\5\32\16\16\u0124\u0125\f\f\2\2\u0125\u0126\t\b\2\2\u0126"+
		"\u0157\5\32\16\r\u0127\u0128\f\13\2\2\u0128\u0129\t\t\2\2\u0129\u0157"+
		"\5\32\16\f\u012a\u012b\f\n\2\2\u012b\u012c\t\n\2\2\u012c\u0157\5\32\16"+
		"\13\u012d\u012e\f\t\2\2\u012e\u012f\7/\2\2\u012f\u0157\5\32\16\n\u0130"+
		"\u0131\f\b\2\2\u0131\u0132\7\60\2\2\u0132\u0157\5\32\16\t\u0133\u0134"+
		"\f\7\2\2\u0134\u0135\7\61\2\2\u0135\u0157\5\32\16\b\u0136\u0137\f\6\2"+
		"\2\u0137\u0138\7\62\2\2\u0138\u0157\5\32\16\7\u0139\u013a\f\5\2\2\u013a"+
		"\u013b\7\63\2\2\u013b\u0157\5\32\16\6\u013c\u013d\f\4\2\2\u013d\u013e"+
		"\7\64\2\2\u013e\u0157\5\32\16\4\u013f\u0140\f\26\2\2\u0140\u0141\7\5\2"+
		"\2\u0141\u0157\7\27\2\2\u0142\u0143\f\25\2\2\u0143\u0144\7\67\2\2\u0144"+
		"\u0145\5\32\16\2\u0145\u0146\78\2\2\u0146\u0157\3\2\2\2\u0147\u0148\f"+
		"\24\2\2\u0148\u0151\7\65\2\2\u0149\u014e\5\32\16\2\u014a\u014b\7\4\2\2"+
		"\u014b\u014d\5\32\16\2\u014c\u014a\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0149\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0157\7\66"+
		"\2\2\u0154\u0155\f\23\2\2\u0155\u0157\t\3\2\2\u0156\u011b\3\2\2\2\u0156"+
		"\u011e\3\2\2\2\u0156\u0121\3\2\2\2\u0156\u0124\3\2\2\2\u0156\u0127\3\2"+
		"\2\2\u0156\u012a\3\2\2\2\u0156\u012d\3\2\2\2\u0156\u0130\3\2\2\2\u0156"+
		"\u0133\3\2\2\2\u0156\u0136\3\2\2\2\u0156\u0139\3\2\2\2\u0156\u013c\3\2"+
		"\2\2\u0156\u013f\3\2\2\2\u0156\u0142\3\2\2\2\u0156\u0147\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\33\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\t\13\2\2\u015c\35"+
		"\3\2\2\2%!)\61\63CFVYdkpx{\u0083\u0091\u0096\u009a\u009e\u00ae\u00b5\u00c6"+
		"\u00cc\u00d5\u00df\u00e5\u00f0\u00f3\u010b\u010e\u0115\u0119\u014e\u0151"+
		"\u0156\u0158";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}