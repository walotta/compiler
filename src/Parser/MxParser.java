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
		RULE_ifStatement = 12, RULE_forStatement = 13, RULE_whileStatement = 14, 
		RULE_expersion = 15, RULE_constValue = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programBlock", "classBlock", "buildFuncBlock", "funcBlock", 
			"varBlock", "retType", "singleVarBlock", "type", "singleType", "statementBlock", 
			"statement", "ifStatement", "forStatement", "whileStatement", "expersion", 
			"constValue"
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Class) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(34);
				programBlock();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
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
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				classBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				funcBlock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
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
			setState(47);
			match(Class);
			setState(48);
			match(Identifier);
			setState(49);
			match(LeftBrace);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(53);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(50);
					buildFuncBlock();
					}
					break;
				case 2:
					{
					setState(51);
					funcBlock();
					}
					break;
				case 3:
					{
					setState(52);
					varBlock();
					}
					break;
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(RightBrace);
			setState(59);
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
			setState(61);
			((BuildFuncBlockContext)_localctx).funcName = match(Identifier);
			setState(62);
			match(LeftParen);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(63);
				type();
				setState(64);
				match(Identifier);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(65);
					match(T__1);
					setState(66);
					type();
					setState(67);
					match(Identifier);
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(76);
			match(RightParen);
			setState(77);
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
		public RetTypeContext funcType;
		public Token funcName;
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public RetTypeContext retType() {
			return getRuleContext(RetTypeContext.class,0);
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
			setState(79);
			((FuncBlockContext)_localctx).funcType = retType();
			setState(80);
			((FuncBlockContext)_localctx).funcName = match(Identifier);
			setState(81);
			match(LeftParen);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(82);
				type();
				setState(83);
				match(Identifier);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(84);
					match(T__1);
					setState(85);
					type();
					setState(86);
					match(Identifier);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(95);
			match(RightParen);
			setState(96);
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
			setState(98);
			type();
			setState(99);
			singleVarBlock();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(100);
				match(T__1);
				setState(101);
				singleVarBlock();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
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
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				type();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
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
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
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
			setState(113);
			match(Identifier);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equal) {
				{
				setState(114);
				match(Equal);
				setState(115);
				expersion(0);
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
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				singleType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				singleType();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LeftBracket) {
					{
					{
					setState(120);
					match(LeftBracket);
					setState(121);
					match(RightBracket);
					}
					}
					setState(126);
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
			setState(129);
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
			setState(131);
			match(LeftBrace);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << If) | (1L << For) | (1L << While) | (1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace))) != 0)) {
				{
				{
				setState(132);
				statement();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
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
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public VarBlockContext varBlock() {
			return getRuleContext(VarBlockContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		int _la;
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				statementBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				varBlock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				match(Break);
				setState(146);
				match(T__0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(Continue);
				setState(148);
				match(T__0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(149);
				match(Return);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen))) != 0)) {
					{
					setState(150);
					expersion(0);
					}
				}

				setState(153);
				match(T__0);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen))) != 0)) {
					{
					setState(154);
					expersion(0);
					}
				}

				setState(157);
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

	public static class IfStatementContext extends ParserRuleContext {
		public StatementContext trueStatement;
		public StatementContext falseStatement;
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(If);
			setState(161);
			match(LeftParen);
			setState(162);
			expersion(0);
			setState(163);
			match(RightParen);
			setState(164);
			((IfStatementContext)_localctx).trueStatement = statement();
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(165);
				match(Else);
				setState(166);
				((IfStatementContext)_localctx).falseStatement = statement();
				}
				break;
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

	public static class ForStatementContext extends ParserRuleContext {
		public ExpersionContext initExp;
		public ExpersionContext finishExp;
		public ExpersionContext stepExp;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(For);
			setState(170);
			match(LeftParen);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen))) != 0)) {
				{
				setState(171);
				((ForStatementContext)_localctx).initExp = expersion(0);
				}
			}

			setState(174);
			match(T__0);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen))) != 0)) {
				{
				setState(175);
				((ForStatementContext)_localctx).finishExp = expersion(0);
				}
			}

			setState(178);
			match(T__0);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen))) != 0)) {
				{
				setState(179);
				((ForStatementContext)_localctx).stepExp = expersion(0);
				}
			}

			setState(182);
			match(RightParen);
			setState(183);
			statement();
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

	public static class WhileStatementContext extends ParserRuleContext {
		public ExpersionContext finishExp;
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(While);
			setState(186);
			match(LeftParen);
			setState(187);
			((WhileStatementContext)_localctx).finishExp = expersion(0);
			setState(188);
			match(RightParen);
			setState(189);
			statement();
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

	public static class ExpersionContext extends ParserRuleContext {
		public ExpersionContext array;
		public ExpersionContext funcName;
		public Token op;
		public ExpersionContext index;
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ConstValueContext constValue() {
			return getRuleContext(ConstValueContext.class,0);
		}
		public TerminalNode New() { return getToken(MxParser.New, 0); }
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
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(MxParser.SelfSub, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public TerminalNode LogicNot() { return getToken(MxParser.LogicNot, 0); }
		public TerminalNode BitNot() { return getToken(MxParser.BitNot, 0); }
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
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
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public ExpersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expersion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExpersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExpersion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExpersion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpersionContext expersion() throws RecognitionException {
		return expersion(0);
	}

	private ExpersionContext expersion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpersionContext _localctx = new ExpersionContext(_ctx, _parentState);
		ExpersionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expersion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(192);
				match(LeftParen);
				setState(193);
				expersion(0);
				setState(194);
				match(RightParen);
				}
				break;
			case 2:
				{
				setState(196);
				match(Identifier);
				}
				break;
			case 3:
				{
				setState(197);
				constValue();
				}
				break;
			case 4:
				{
				setState(198);
				match(New);
				setState(199);
				singleType();
				}
				break;
			case 5:
				{
				setState(200);
				match(New);
				setState(201);
				singleType();
				setState(202);
				match(LeftParen);
				setState(203);
				match(RightParen);
				}
				break;
			case 6:
				{
				setState(205);
				match(New);
				setState(206);
				singleType();
				setState(207);
				match(LeftParen);
				setState(208);
				expersion(0);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(209);
					match(T__1);
					setState(210);
					expersion(0);
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(216);
				match(RightParen);
				}
				break;
			case 7:
				{
				setState(218);
				match(New);
				setState(219);
				singleType();
				setState(224); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(220);
						match(LeftBracket);
						setState(221);
						expersion(0);
						setState(222);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(226); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(228);
						match(LeftBracket);
						setState(229);
						match(RightBracket);
						}
						} 
					}
					setState(234);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case 8:
				{
				setState(235);
				match(New);
				setState(236);
				singleType();
				setState(241); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(237);
						match(LeftBracket);
						setState(238);
						expersion(0);
						setState(239);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(243); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(245);
						match(LeftBracket);
						setState(246);
						match(RightBracket);
						}
						} 
					}
					setState(251);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(256); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(252);
						match(LeftBracket);
						setState(253);
						expersion(0);
						setState(254);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(258); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 9:
				{
				setState(260);
				((ExpersionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfAdd || _la==SelfSub) ) {
					((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(261);
				expersion(15);
				}
				break;
			case 10:
				{
				setState(262);
				((ExpersionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Add || _la==Sub) ) {
					((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(263);
				expersion(14);
				}
				break;
			case 11:
				{
				setState(264);
				((ExpersionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LogicNot || _la==BitNot) ) {
					((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(265);
				expersion(13);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(327);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(268);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(269);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(270);
						expersion(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(271);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(272);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(273);
						expersion(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(274);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(275);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==BitLeft || _la==BitRight) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(276);
						expersion(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(277);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(278);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SmallThan || _la==BigThan) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(279);
						expersion(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(280);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(281);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SmallEqual || _la==BigEqual) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(282);
						expersion(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(283);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(284);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IsEqual || _la==IsNotEqual) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(285);
						expersion(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(286);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(287);
						((ExpersionContext)_localctx).op = match(BitAnd);
						setState(288);
						expersion(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(289);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(290);
						((ExpersionContext)_localctx).op = match(BitXor);
						setState(291);
						expersion(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(292);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(293);
						((ExpersionContext)_localctx).op = match(BitOr);
						setState(294);
						expersion(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(295);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(296);
						((ExpersionContext)_localctx).op = match(LogicAnd);
						setState(297);
						expersion(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(298);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(299);
						((ExpersionContext)_localctx).op = match(LogicOr);
						setState(300);
						expersion(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(301);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(302);
						((ExpersionContext)_localctx).op = match(Equal);
						setState(303);
						expersion(1);
						}
						break;
					case 13:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(304);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(305);
						match(T__2);
						setState(306);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						_localctx.array = _prevctx;
						_localctx.array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(307);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(308);
						match(LeftBracket);
						setState(309);
						((ExpersionContext)_localctx).index = expersion(0);
						setState(310);
						match(RightBracket);
						}
						break;
					case 15:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						_localctx.funcName = _prevctx;
						_localctx.funcName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(312);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(313);
						match(LeftParen);
						setState(322);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen))) != 0)) {
							{
							setState(314);
							expersion(0);
							setState(319);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__1) {
								{
								{
								setState(315);
								match(T__1);
								setState(316);
								expersion(0);
								}
								}
								setState(321);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(324);
						match(RightParen);
						}
						break;
					case 16:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(325);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(326);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfAdd || _la==SelfSub) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
				setState(331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		enterRule(_localctx, 32, RULE_constValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
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
		case 15:
			return expersion_sempred((ExpersionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expersion_sempred(ExpersionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u0151\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\5\5M\n\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\5\6`\n\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\3\7\3\7\3\b\3\b\5\br\n\b\3\t"+
		"\3\t\3\t\5\tw\n\t\3\n\3\n\3\n\3\n\7\n}\n\n\f\n\16\n\u0080\13\n\5\n\u0082"+
		"\n\n\3\13\3\13\3\f\3\f\7\f\u0088\n\f\f\f\16\f\u008b\13\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009a\n\r\3\r\3\r\5\r\u009e"+
		"\n\r\3\r\5\r\u00a1\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00aa\n"+
		"\16\3\17\3\17\3\17\5\17\u00af\n\17\3\17\3\17\5\17\u00b3\n\17\3\17\3\17"+
		"\5\17\u00b7\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\7\21\u00d6\n\21\f\21\16\21\u00d9\13\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u00e3\n\21\r\21\16\21\u00e4\3\21\3"+
		"\21\7\21\u00e9\n\21\f\21\16\21\u00ec\13\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\6\21\u00f4\n\21\r\21\16\21\u00f5\3\21\3\21\7\21\u00fa\n\21\f\21\16"+
		"\21\u00fd\13\21\3\21\3\21\3\21\3\21\6\21\u0103\n\21\r\21\16\21\u0104\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\5\21\u010d\n\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\7\21\u0140\n\21\f\21\16\21\u0143\13\21\5\21\u0145\n\21\3\21"+
		"\3\21\3\21\7\21\u014a\n\21\f\21\16\21\u014d\13\21\3\22\3\22\3\22\2\3 "+
		"\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\f\4\2\6\b\27\27\3\2\36"+
		"\37\3\2 !\3\2\"#\3\2$&\3\2\'(\3\2)*\3\2+,\3\2-.\4\2\23\26\30\31\2\u017f"+
		"\2\'\3\2\2\2\4/\3\2\2\2\6\61\3\2\2\2\b?\3\2\2\2\nQ\3\2\2\2\fd\3\2\2\2"+
		"\16q\3\2\2\2\20s\3\2\2\2\22\u0081\3\2\2\2\24\u0083\3\2\2\2\26\u0085\3"+
		"\2\2\2\30\u00a0\3\2\2\2\32\u00a2\3\2\2\2\34\u00ab\3\2\2\2\36\u00bb\3\2"+
		"\2\2 \u010c\3\2\2\2\"\u014e\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3"+
		"\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7\2\2\3+\3\3\2\2\2,\60\5\6\4"+
		"\2-\60\5\n\6\2.\60\5\f\7\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\5\3\2\2\2"+
		"\61\62\7\t\2\2\62\63\7\27\2\2\639\79\2\2\648\5\b\5\2\658\5\n\6\2\668\5"+
		"\f\7\2\67\64\3\2\2\2\67\65\3\2\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\2"+
		"9:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7:\2\2=>\7\3\2\2>\7\3\2\2\2?@\7\27\2"+
		"\2@L\7\65\2\2AB\5\22\n\2BI\7\27\2\2CD\7\4\2\2DE\5\22\n\2EF\7\27\2\2FH"+
		"\3\2\2\2GC\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JM\3\2\2\2KI\3\2\2\2L"+
		"A\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\66\2\2OP\5\26\f\2P\t\3\2\2\2QR\5\16"+
		"\b\2RS\7\27\2\2S_\7\65\2\2TU\5\22\n\2U\\\7\27\2\2VW\7\4\2\2WX\5\22\n\2"+
		"XY\7\27\2\2Y[\3\2\2\2ZV\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]`\3\2"+
		"\2\2^\\\3\2\2\2_T\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\66\2\2bc\5\26\f\2c\13"+
		"\3\2\2\2de\5\22\n\2ej\5\20\t\2fg\7\4\2\2gi\5\20\t\2hf\3\2\2\2il\3\2\2"+
		"\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\3\2\2n\r\3\2\2\2or\5\22"+
		"\n\2pr\7\n\2\2qo\3\2\2\2qp\3\2\2\2r\17\3\2\2\2sv\7\27\2\2tu\7\64\2\2u"+
		"w\5 \21\2vt\3\2\2\2vw\3\2\2\2w\21\3\2\2\2x\u0082\5\24\13\2y~\5\24\13\2"+
		"z{\7\67\2\2{}\78\2\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"\u0082\3\2\2\2\u0080~\3\2\2\2\u0081x\3\2\2\2\u0081y\3\2\2\2\u0082\23\3"+
		"\2\2\2\u0083\u0084\t\2\2\2\u0084\25\3\2\2\2\u0085\u0089\79\2\2\u0086\u0088"+
		"\5\30\r\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d"+
		"\7:\2\2\u008d\27\3\2\2\2\u008e\u00a1\5\26\f\2\u008f\u00a1\5\f\7\2\u0090"+
		"\u00a1\5\32\16\2\u0091\u00a1\5\34\17\2\u0092\u00a1\5\36\20\2\u0093\u0094"+
		"\7\13\2\2\u0094\u00a1\7\3\2\2\u0095\u0096\7\f\2\2\u0096\u00a1\7\3\2\2"+
		"\u0097\u0099\7\r\2\2\u0098\u009a\5 \21\2\u0099\u0098\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u00a1\7\3\2\2\u009c\u009e\5 \21\2\u009d"+
		"\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\7\3"+
		"\2\2\u00a0\u008e\3\2\2\2\u00a0\u008f\3\2\2\2\u00a0\u0090\3\2\2\2\u00a0"+
		"\u0091\3\2\2\2\u00a0\u0092\3\2\2\2\u00a0\u0093\3\2\2\2\u00a0\u0095\3\2"+
		"\2\2\u00a0\u0097\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1\31\3\2\2\2\u00a2\u00a3"+
		"\7\16\2\2\u00a3\u00a4\7\65\2\2\u00a4\u00a5\5 \21\2\u00a5\u00a6\7\66\2"+
		"\2\u00a6\u00a9\5\30\r\2\u00a7\u00a8\7\17\2\2\u00a8\u00aa\5\30\r\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\33\3\2\2\2\u00ab\u00ac\7\20\2"+
		"\2\u00ac\u00ae\7\65\2\2\u00ad\u00af\5 \21\2\u00ae\u00ad\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\7\3\2\2\u00b1\u00b3\5 "+
		"\21\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b6\7\3\2\2\u00b5\u00b7\5 \21\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\66\2\2\u00b9\u00ba\5\30\r\2\u00ba"+
		"\35\3\2\2\2\u00bb\u00bc\7\21\2\2\u00bc\u00bd\7\65\2\2\u00bd\u00be\5 \21"+
		"\2\u00be\u00bf\7\66\2\2\u00bf\u00c0\5\30\r\2\u00c0\37\3\2\2\2\u00c1\u00c2"+
		"\b\21\1\2\u00c2\u00c3\7\65\2\2\u00c3\u00c4\5 \21\2\u00c4\u00c5\7\66\2"+
		"\2\u00c5\u010d\3\2\2\2\u00c6\u010d\7\27\2\2\u00c7\u010d\5\"\22\2\u00c8"+
		"\u00c9\7\22\2\2\u00c9\u010d\5\24\13\2\u00ca\u00cb\7\22\2\2\u00cb\u00cc"+
		"\5\24\13\2\u00cc\u00cd\7\65\2\2\u00cd\u00ce\7\66\2\2\u00ce\u010d\3\2\2"+
		"\2\u00cf\u00d0\7\22\2\2\u00d0\u00d1\5\24\13\2\u00d1\u00d2\7\65\2\2\u00d2"+
		"\u00d7\5 \21\2\u00d3\u00d4\7\4\2\2\u00d4\u00d6\5 \21\2\u00d5\u00d3\3\2"+
		"\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7\66\2\2\u00db\u010d\3"+
		"\2\2\2\u00dc\u00dd\7\22\2\2\u00dd\u00e2\5\24\13\2\u00de\u00df\7\67\2\2"+
		"\u00df\u00e0\5 \21\2\u00e0\u00e1\78\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00de"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00ea\3\2\2\2\u00e6\u00e7\7\67\2\2\u00e7\u00e9\78\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u010d\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7\22\2\2\u00ee\u00f3\5"+
		"\24\13\2\u00ef\u00f0\7\67\2\2\u00f0\u00f1\5 \21\2\u00f1\u00f2\78\2\2\u00f2"+
		"\u00f4\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00fb\3\2\2\2\u00f7\u00f8\7\67\2\2\u00f8"+
		"\u00fa\78\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0102\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\u00ff\7\67\2\2\u00ff\u0100\5 \21\2\u0100\u0101\78\2\2\u0101\u0103\3\2"+
		"\2\2\u0102\u00fe\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u010d\3\2\2\2\u0106\u0107\t\3\2\2\u0107\u010d\5 "+
		"\21\21\u0108\u0109\t\4\2\2\u0109\u010d\5 \21\20\u010a\u010b\t\5\2\2\u010b"+
		"\u010d\5 \21\17\u010c\u00c1\3\2\2\2\u010c\u00c6\3\2\2\2\u010c\u00c7\3"+
		"\2\2\2\u010c\u00c8\3\2\2\2\u010c\u00ca\3\2\2\2\u010c\u00cf\3\2\2\2\u010c"+
		"\u00dc\3\2\2\2\u010c\u00ed\3\2\2\2\u010c\u0106\3\2\2\2\u010c\u0108\3\2"+
		"\2\2\u010c\u010a\3\2\2\2\u010d\u014b\3\2\2\2\u010e\u010f\f\16\2\2\u010f"+
		"\u0110\t\6\2\2\u0110\u014a\5 \21\17\u0111\u0112\f\r\2\2\u0112\u0113\t"+
		"\4\2\2\u0113\u014a\5 \21\16\u0114\u0115\f\f\2\2\u0115\u0116\t\7\2\2\u0116"+
		"\u014a\5 \21\r\u0117\u0118\f\13\2\2\u0118\u0119\t\b\2\2\u0119\u014a\5"+
		" \21\f\u011a\u011b\f\n\2\2\u011b\u011c\t\t\2\2\u011c\u014a\5 \21\13\u011d"+
		"\u011e\f\t\2\2\u011e\u011f\t\n\2\2\u011f\u014a\5 \21\n\u0120\u0121\f\b"+
		"\2\2\u0121\u0122\7/\2\2\u0122\u014a\5 \21\t\u0123\u0124\f\7\2\2\u0124"+
		"\u0125\7\60\2\2\u0125\u014a\5 \21\b\u0126\u0127\f\6\2\2\u0127\u0128\7"+
		"\61\2\2\u0128\u014a\5 \21\7\u0129\u012a\f\5\2\2\u012a\u012b\7\62\2\2\u012b"+
		"\u014a\5 \21\6\u012c\u012d\f\4\2\2\u012d\u012e\7\63\2\2\u012e\u014a\5"+
		" \21\5\u012f\u0130\f\3\2\2\u0130\u0131\7\64\2\2\u0131\u014a\5 \21\3\u0132"+
		"\u0133\f\25\2\2\u0133\u0134\7\5\2\2\u0134\u014a\7\27\2\2\u0135\u0136\f"+
		"\24\2\2\u0136\u0137\7\67\2\2\u0137\u0138\5 \21\2\u0138\u0139\78\2\2\u0139"+
		"\u014a\3\2\2\2\u013a\u013b\f\23\2\2\u013b\u0144\7\65\2\2\u013c\u0141\5"+
		" \21\2\u013d\u013e\7\4\2\2\u013e\u0140\5 \21\2\u013f\u013d\3\2\2\2\u0140"+
		"\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145\3\2"+
		"\2\2\u0143\u0141\3\2\2\2\u0144\u013c\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u014a\7\66\2\2\u0147\u0148\f\22\2\2\u0148\u014a\t"+
		"\3\2\2\u0149\u010e\3\2\2\2\u0149\u0111\3\2\2\2\u0149\u0114\3\2\2\2\u0149"+
		"\u0117\3\2\2\2\u0149\u011a\3\2\2\2\u0149\u011d\3\2\2\2\u0149\u0120\3\2"+
		"\2\2\u0149\u0123\3\2\2\2\u0149\u0126\3\2\2\2\u0149\u0129\3\2\2\2\u0149"+
		"\u012c\3\2\2\2\u0149\u012f\3\2\2\2\u0149\u0132\3\2\2\2\u0149\u0135\3\2"+
		"\2\2\u0149\u013a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c!\3\2\2\2\u014d\u014b\3\2\2\2"+
		"\u014e\u014f\t\13\2\2\u014f#\3\2\2\2\"\'/\679IL\\_jqv~\u0081\u0089\u0099"+
		"\u009d\u00a0\u00a9\u00ae\u00b2\u00b6\u00d7\u00e4\u00ea\u00f5\u00fb\u0104"+
		"\u010c\u0141\u0144\u0149\u014b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}