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
		RULE_expersion = 12, RULE_constValue = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programBlock", "classBlock", "buildFuncBlock", "funcBlock", 
			"varBlock", "retType", "singleVarBlock", "type", "singleType", "statementBlock", 
			"statement", "expersion", "constValue"
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
			setState(73);
			((FuncBlockContext)_localctx).funcType = retType();
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
		public RetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retType; }
	 
		public RetTypeContext() { }
		public void copyFrom(RetTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeRetContext extends RetTypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeRetContext(RetTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTypeRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTypeRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTypeRet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VoidRetContext extends RetTypeContext {
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public VoidRetContext(RetTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVoidRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVoidRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVoidRet(this);
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
				_localctx = new TypeRetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				type();
				}
				break;
			case Void:
				_localctx = new VoidRetContext(_localctx);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleContext extends TypeContext {
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public SingleContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayContext extends TypeContext {
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
		public ArrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArray(this);
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
				_localctx = new SingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				singleType();
				}
				break;
			case 2:
				_localctx = new ArrayContext(_localctx);
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
	public static class RetContext extends StatementContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public RetContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitRet(this);
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
	public static class ForContext extends StatementContext {
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
	public static class WhileContext extends StatementContext {
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
	public static class ExpContext extends StatementContext {
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public ExpContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends StatementContext {
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
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
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
				expersion(0);
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
					((ForContext)_localctx).initExp = expersion(0);
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
					((ForContext)_localctx).finishExp = expersion(0);
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
					((ForContext)_localctx).stepExp = expersion(0);
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
				((WhileContext)_localctx).finishExp = expersion(0);
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
				_localctx = new RetContext(_localctx);
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
					expersion(0);
					}
				}

				setState(174);
				match(T__0);
				}
				break;
			case 9:
				_localctx = new ExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket))) != 0)) {
					{
					setState(175);
					expersion(0);
					}
				}

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

	public static class ExpersionContext extends ParserRuleContext {
		public ExpersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expersion; }
	 
		public ExpersionContext() { }
		public void copyFrom(ExpersionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewVarEmptyValueContext extends ExpersionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public NewVarEmptyValueContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewVarEmptyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewVarEmptyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewVarEmptyValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewVarNoValueContext extends ExpersionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public NewVarNoValueContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewVarNoValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewVarNoValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewVarNoValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstContext extends ExpersionContext {
		public ConstValueContext constValue() {
			return getRuleContext(ConstValueContext.class,0);
		}
		public ConstContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitOrContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode BitOr() { return getToken(MxParser.BitOr, 0); }
		public BitOrContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBitOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicOrContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode LogicOr() { return getToken(MxParser.LogicOr, 0); }
		public LogicOrContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareEqualContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode SmallEqual() { return getToken(MxParser.SmallEqual, 0); }
		public TerminalNode BigEqual() { return getToken(MxParser.BigEqual, 0); }
		public CompareEqualContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCompareEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCompareEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCompareEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassVarContext extends ExpersionContext {
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ClassVarContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicAndContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode LogicAnd() { return getToken(MxParser.LogicAnd, 0); }
		public LogicAndContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayErrContext extends ExpersionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public NewArrayErrContext(ExpersionContext ctx) { copyFrom(ctx); }
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
	public static class ValuenceOpContext extends ExpersionContext {
		public Token op;
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public ValuenceOpContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterValuenceOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitValuenceOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitValuenceOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends ExpersionContext {
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public BlockContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExpersionContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public IdentifierContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfOpLeftContext extends ExpersionContext {
		public Token op;
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(MxParser.SelfSub, 0); }
		public SelfOpLeftContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSelfOpLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSelfOpLeft(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSelfOpLeft(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfOpRightContext extends ExpersionContext {
		public Token op;
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(MxParser.SelfSub, 0); }
		public SelfOpRightContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSelfOpRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSelfOpRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSelfOpRight(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitMoveContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode BitLeft() { return getToken(MxParser.BitLeft, 0); }
		public TerminalNode BitRight() { return getToken(MxParser.BitRight, 0); }
		public BitMoveContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBitMove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBitMove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBitMove(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayContext extends ExpersionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public NewArrayContext(ExpersionContext ctx) { copyFrom(ctx); }
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
	public static class AddSubContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public AddSubContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualJudgeContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode IsEqual() { return getToken(MxParser.IsEqual, 0); }
		public TerminalNode IsNotEqual() { return getToken(MxParser.IsNotEqual, 0); }
		public EqualJudgeContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEqualJudge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEqualJudge(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEqualJudge(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewVarWithValueContext extends ExpersionContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public SingleTypeContext singleType() {
			return getRuleContext(SingleTypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public NewVarWithValueContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewVarWithValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewVarWithValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewVarWithValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyDivideContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public MultiplyDivideContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMultiplyDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMultiplyDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMultiplyDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitAndContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode BitAnd() { return getToken(MxParser.BitAnd, 0); }
		public BitAndContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBitAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayMemberContext extends ExpersionContext {
		public ExpersionContext array;
		public ExpersionContext index;
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public ArrayMemberContext(ExpersionContext ctx) { copyFrom(ctx); }
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
	public static class CompareNoEqualContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode SmallThan() { return getToken(MxParser.SmallThan, 0); }
		public TerminalNode BigThan() { return getToken(MxParser.BigThan, 0); }
		public CompareNoEqualContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCompareNoEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCompareNoEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCompareNoEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitXorContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode BitXor() { return getToken(MxParser.BitXor, 0); }
		public BitXorContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBitXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBitXor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBitXor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExpContext extends ExpersionContext {
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
		public LambdaExpContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLambdaExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLambdaExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLambdaExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicOpContext extends ExpersionContext {
		public Token op;
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public TerminalNode LogicNot() { return getToken(MxParser.LogicNot, 0); }
		public TerminalNode BitNot() { return getToken(MxParser.BitNot, 0); }
		public LogicOpContext(ExpersionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallContext extends ExpersionContext {
		public ExpersionContext funcName;
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public FuncCallContext(ExpersionContext ctx) { copyFrom(ctx); }
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
	public static class AssignContext extends ExpersionContext {
		public Token op;
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public AssignContext(ExpersionContext ctx) { copyFrom(ctx); }
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

	public final ExpersionContext expersion() throws RecognitionException {
		return expersion(0);
	}

	private ExpersionContext expersion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpersionContext _localctx = new ExpersionContext(_ctx, _parentState);
		ExpersionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expersion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new BlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(182);
				match(LeftParen);
				setState(183);
				expersion(0);
				setState(184);
				match(RightParen);
				}
				break;
			case 2:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(Identifier);
				}
				break;
			case 3:
				{
				_localctx = new ConstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				constValue();
				}
				break;
			case 4:
				{
				_localctx = new NewVarNoValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(New);
				setState(189);
				singleType();
				}
				break;
			case 5:
				{
				_localctx = new NewVarEmptyValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(New);
				setState(191);
				singleType();
				setState(192);
				match(LeftParen);
				setState(193);
				match(RightParen);
				}
				break;
			case 6:
				{
				_localctx = new NewVarWithValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(New);
				setState(196);
				singleType();
				setState(197);
				match(LeftParen);
				setState(198);
				expersion(0);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(199);
					match(T__1);
					setState(200);
					expersion(0);
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				match(RightParen);
				}
				break;
			case 7:
				{
				_localctx = new NewArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(New);
				setState(209);
				singleType();
				setState(214); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(210);
						match(LeftBracket);
						setState(211);
						expersion(0);
						setState(212);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(216); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(218);
						match(LeftBracket);
						setState(219);
						match(RightBracket);
						}
						} 
					}
					setState(224);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case 8:
				{
				_localctx = new NewArrayErrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(New);
				setState(226);
				singleType();
				setState(231); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(227);
						match(LeftBracket);
						setState(228);
						expersion(0);
						setState(229);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(233); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(235);
						match(LeftBracket);
						setState(236);
						match(RightBracket);
						}
						} 
					}
					setState(241);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(246); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(242);
						match(LeftBracket);
						setState(243);
						expersion(0);
						setState(244);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(248); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 9:
				{
				_localctx = new SelfOpLeftContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				((SelfOpLeftContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfAdd || _la==SelfSub) ) {
					((SelfOpLeftContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(251);
				expersion(16);
				}
				break;
			case 10:
				{
				_localctx = new ValuenceOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				((ValuenceOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Add || _la==Sub) ) {
					((ValuenceOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(253);
				expersion(15);
				}
				break;
			case 11:
				{
				_localctx = new LogicOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				((LogicOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LogicNot || _la==BitNot) ) {
					((LogicOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(255);
				expersion(14);
				}
				break;
			case 12:
				{
				_localctx = new LambdaExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(LeftBracket);
				setState(257);
				match(BitAnd);
				setState(258);
				match(RightBracket);
				setState(259);
				match(LeftParen);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Bool) | (1L << String) | (1L << Identifier))) != 0)) {
					{
					setState(260);
					type();
					setState(261);
					match(Identifier);
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(262);
						match(T__1);
						setState(263);
						type();
						setState(264);
						match(Identifier);
						}
						}
						setState(270);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(273);
				match(RightParen);
				setState(274);
				match(LeftBrace);
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Int) | (1L << Bool) | (1L << String) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << If) | (1L << For) | (1L << While) | (1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket) | (1L << LeftBrace))) != 0)) {
					{
					{
					setState(275);
					statement();
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281);
				match(RightBrace);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(345);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(343);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyDivideContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(284);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(285);
						((MultiplyDivideContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((MultiplyDivideContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(286);
						expersion(14);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(287);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(288);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(289);
						expersion(13);
						}
						break;
					case 3:
						{
						_localctx = new BitMoveContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(290);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(291);
						((BitMoveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==BitLeft || _la==BitRight) ) {
							((BitMoveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(292);
						expersion(12);
						}
						break;
					case 4:
						{
						_localctx = new CompareNoEqualContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(293);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(294);
						((CompareNoEqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SmallThan || _la==BigThan) ) {
							((CompareNoEqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(295);
						expersion(11);
						}
						break;
					case 5:
						{
						_localctx = new CompareEqualContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(296);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(297);
						((CompareEqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SmallEqual || _la==BigEqual) ) {
							((CompareEqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(298);
						expersion(10);
						}
						break;
					case 6:
						{
						_localctx = new EqualJudgeContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(299);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(300);
						((EqualJudgeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IsEqual || _la==IsNotEqual) ) {
							((EqualJudgeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(301);
						expersion(9);
						}
						break;
					case 7:
						{
						_localctx = new BitAndContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(302);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(303);
						((BitAndContext)_localctx).op = match(BitAnd);
						setState(304);
						expersion(8);
						}
						break;
					case 8:
						{
						_localctx = new BitXorContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(305);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(306);
						((BitXorContext)_localctx).op = match(BitXor);
						setState(307);
						expersion(7);
						}
						break;
					case 9:
						{
						_localctx = new BitOrContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(308);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(309);
						((BitOrContext)_localctx).op = match(BitOr);
						setState(310);
						expersion(6);
						}
						break;
					case 10:
						{
						_localctx = new LogicAndContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(311);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(312);
						((LogicAndContext)_localctx).op = match(LogicAnd);
						setState(313);
						expersion(5);
						}
						break;
					case 11:
						{
						_localctx = new LogicOrContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(314);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(315);
						((LogicOrContext)_localctx).op = match(LogicOr);
						setState(316);
						expersion(4);
						}
						break;
					case 12:
						{
						_localctx = new AssignContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(317);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(318);
						((AssignContext)_localctx).op = match(Equal);
						setState(319);
						expersion(2);
						}
						break;
					case 13:
						{
						_localctx = new ClassVarContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(320);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(321);
						match(T__2);
						setState(322);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ArrayMemberContext(new ExpersionContext(_parentctx, _parentState));
						((ArrayMemberContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(323);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(324);
						match(LeftBracket);
						setState(325);
						((ArrayMemberContext)_localctx).index = expersion(0);
						setState(326);
						match(RightBracket);
						}
						break;
					case 15:
						{
						_localctx = new FuncCallContext(new ExpersionContext(_parentctx, _parentState));
						((FuncCallContext)_localctx).funcName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(328);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(329);
						match(LeftParen);
						setState(338);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << True) | (1L << False) | (1L << Null) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << SelfAdd) | (1L << SelfSub) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBracket))) != 0)) {
							{
							setState(330);
							expersion(0);
							setState(335);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__1) {
								{
								{
								setState(331);
								match(T__1);
								setState(332);
								expersion(0);
								}
								}
								setState(337);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(340);
						match(RightParen);
						}
						break;
					case 16:
						{
						_localctx = new SelfOpRightContext(new ExpersionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(341);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(342);
						((SelfOpRightContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfAdd || _la==SelfSub) ) {
							((SelfOpRightContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
				setState(347);
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
			setState(348);
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
			return expersion_sempred((ExpersionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expersion_sempred(ExpersionContext _localctx, int predIndex) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u0161\4\2\t\2\4"+
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
		"\n\r\3\r\3\r\5\r\u00b3\n\r\3\r\5\r\u00b6\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u00cc\n\16\f\16\16\16\u00cf\13\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\6\16\u00d9\n\16\r\16\16\16\u00da\3\16\3\16\7\16\u00df"+
		"\n\16\f\16\16\16\u00e2\13\16\3\16\3\16\3\16\3\16\3\16\3\16\6\16\u00ea"+
		"\n\16\r\16\16\16\u00eb\3\16\3\16\7\16\u00f0\n\16\f\16\16\16\u00f3\13\16"+
		"\3\16\3\16\3\16\3\16\6\16\u00f9\n\16\r\16\16\16\u00fa\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u010d"+
		"\n\16\f\16\16\16\u0110\13\16\5\16\u0112\n\16\3\16\3\16\3\16\7\16\u0117"+
		"\n\16\f\16\16\16\u011a\13\16\3\16\5\16\u011d\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u0150\n\16\f\16\16\16\u0153\13\16\5\16\u0155\n\16"+
		"\3\16\3\16\3\16\7\16\u015a\n\16\f\16\16\16\u015d\13\16\3\17\3\17\3\17"+
		"\2\3\32\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\f\4\2\6\b\27\27\3\2\36"+
		"\37\3\2 !\3\2\"#\3\2$&\3\2\'(\3\2)*\3\2+,\3\2-.\4\2\23\26\30\31\2\u0196"+
		"\2!\3\2\2\2\4)\3\2\2\2\6+\3\2\2\2\b9\3\2\2\2\nK\3\2\2\2\f^\3\2\2\2\16"+
		"k\3\2\2\2\20m\3\2\2\2\22{\3\2\2\2\24}\3\2\2\2\26\177\3\2\2\2\30\u00b5"+
		"\3\2\2\2\32\u011c\3\2\2\2\34\u015e\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2 "+
		"#\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7\2\2\3%\3\3\2"+
		"\2\2&*\5\6\4\2\'*\5\n\6\2(*\5\f\7\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\5"+
		"\3\2\2\2+,\7\t\2\2,-\7\27\2\2-\63\79\2\2.\62\5\b\5\2/\62\5\n\6\2\60\62"+
		"\5\f\7\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7:\2\2\678\7\3\2"+
		"\28\7\3\2\2\29:\7\27\2\2:F\7\65\2\2;<\5\22\n\2<C\7\27\2\2=>\7\4\2\2>?"+
		"\5\22\n\2?@\7\27\2\2@B\3\2\2\2A=\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2"+
		"DG\3\2\2\2EC\3\2\2\2F;\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\66\2\2IJ\5\26\f"+
		"\2J\t\3\2\2\2KL\5\16\b\2LM\7\27\2\2MY\7\65\2\2NO\5\22\n\2OV\7\27\2\2P"+
		"Q\7\4\2\2QR\5\22\n\2RS\7\27\2\2SU\3\2\2\2TP\3\2\2\2UX\3\2\2\2VT\3\2\2"+
		"\2VW\3\2\2\2WZ\3\2\2\2XV\3\2\2\2YN\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\66"+
		"\2\2\\]\5\26\f\2]\13\3\2\2\2^_\5\22\n\2_d\5\20\t\2`a\7\4\2\2ac\5\20\t"+
		"\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\3\2"+
		"\2h\r\3\2\2\2il\5\22\n\2jl\7\n\2\2ki\3\2\2\2kj\3\2\2\2l\17\3\2\2\2mp\7"+
		"\27\2\2no\7\64\2\2oq\5\32\16\2pn\3\2\2\2pq\3\2\2\2q\21\3\2\2\2r|\5\24"+
		"\13\2sx\5\24\13\2tu\7\67\2\2uw\78\2\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy"+
		"\3\2\2\2y|\3\2\2\2zx\3\2\2\2{r\3\2\2\2{s\3\2\2\2|\23\3\2\2\2}~\t\2\2\2"+
		"~\25\3\2\2\2\177\u0083\79\2\2\u0080\u0082\5\30\r\2\u0081\u0080\3\2\2\2"+
		"\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7:\2\2\u0087\27\3\2\2\2\u0088"+
		"\u00b6\5\26\f\2\u0089\u00b6\5\f\7\2\u008a\u008b\7\16\2\2\u008b\u008c\7"+
		"\65\2\2\u008c\u008d\5\32\16\2\u008d\u008e\7\66\2\2\u008e\u0091\5\30\r"+
		"\2\u008f\u0090\7\17\2\2\u0090\u0092\5\30\r\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u00b6\3\2\2\2\u0093\u0094\7\20\2\2\u0094\u0096\7"+
		"\65\2\2\u0095\u0097\5\32\16\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u009a\7\3\2\2\u0099\u009b\5\32\16\2\u009a\u0099"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\7\3\2\2\u009d"+
		"\u009f\5\32\16\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u00a1\7\66\2\2\u00a1\u00b6\5\30\r\2\u00a2\u00a3\7\21\2\2"+
		"\u00a3\u00a4\7\65\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00a6\7\66\2\2\u00a6"+
		"\u00a7\5\30\r\2\u00a7\u00b6\3\2\2\2\u00a8\u00a9\7\13\2\2\u00a9\u00b6\7"+
		"\3\2\2\u00aa\u00ab\7\f\2\2\u00ab\u00b6\7\3\2\2\u00ac\u00ae\7\r\2\2\u00ad"+
		"\u00af\5\32\16\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3"+
		"\2\2\2\u00b0\u00b6\7\3\2\2\u00b1\u00b3\5\32\16\2\u00b2\u00b1\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\7\3\2\2\u00b5\u0088\3\2"+
		"\2\2\u00b5\u0089\3\2\2\2\u00b5\u008a\3\2\2\2\u00b5\u0093\3\2\2\2\u00b5"+
		"\u00a2\3\2\2\2\u00b5\u00a8\3\2\2\2\u00b5\u00aa\3\2\2\2\u00b5\u00ac\3\2"+
		"\2\2\u00b5\u00b2\3\2\2\2\u00b6\31\3\2\2\2\u00b7\u00b8\b\16\1\2\u00b8\u00b9"+
		"\7\65\2\2\u00b9\u00ba\5\32\16\2\u00ba\u00bb\7\66\2\2\u00bb\u011d\3\2\2"+
		"\2\u00bc\u011d\7\27\2\2\u00bd\u011d\5\34\17\2\u00be\u00bf\7\22\2\2\u00bf"+
		"\u011d\5\24\13\2\u00c0\u00c1\7\22\2\2\u00c1\u00c2\5\24\13\2\u00c2\u00c3"+
		"\7\65\2\2\u00c3\u00c4\7\66\2\2\u00c4\u011d\3\2\2\2\u00c5\u00c6\7\22\2"+
		"\2\u00c6\u00c7\5\24\13\2\u00c7\u00c8\7\65\2\2\u00c8\u00cd\5\32\16\2\u00c9"+
		"\u00ca\7\4\2\2\u00ca\u00cc\5\32\16\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3"+
		"\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00d0\u00d1\7\66\2\2\u00d1\u011d\3\2\2\2\u00d2\u00d3\7"+
		"\22\2\2\u00d3\u00d8\5\24\13\2\u00d4\u00d5\7\67\2\2\u00d5\u00d6\5\32\16"+
		"\2\u00d6\u00d7\78\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00e0\3\2\2\2\u00dc"+
		"\u00dd\7\67\2\2\u00dd\u00df\78\2\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u011d\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00e4\7\22\2\2\u00e4\u00e9\5\24\13\2\u00e5\u00e6"+
		"\7\67\2\2\u00e6\u00e7\5\32\16\2\u00e7\u00e8\78\2\2\u00e8\u00ea\3\2\2\2"+
		"\u00e9\u00e5\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00f1\3\2\2\2\u00ed\u00ee\7\67\2\2\u00ee\u00f0\78\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f8\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7\67\2\2\u00f5"+
		"\u00f6\5\32\16\2\u00f6\u00f7\78\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f4\3"+
		"\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u011d\3\2\2\2\u00fc\u00fd\t\3\2\2\u00fd\u011d\5\32\16\22\u00fe\u00ff"+
		"\t\4\2\2\u00ff\u011d\5\32\16\21\u0100\u0101\t\5\2\2\u0101\u011d\5\32\16"+
		"\20\u0102\u0103\7\67\2\2\u0103\u0104\7/\2\2\u0104\u0105\78\2\2\u0105\u0111"+
		"\7\65\2\2\u0106\u0107\5\22\n\2\u0107\u010e\7\27\2\2\u0108\u0109\7\4\2"+
		"\2\u0109\u010a\5\22\n\2\u010a\u010b\7\27\2\2\u010b\u010d\3\2\2\2\u010c"+
		"\u0108\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0106\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\7\66\2\2\u0114\u0118\7"+
		"9\2\2\u0115\u0117\5\30\r\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011b\u011d\7:\2\2\u011c\u00b7\3\2\2\2\u011c\u00bc\3\2\2\2\u011c"+
		"\u00bd\3\2\2\2\u011c\u00be\3\2\2\2\u011c\u00c0\3\2\2\2\u011c\u00c5\3\2"+
		"\2\2\u011c\u00d2\3\2\2\2\u011c\u00e3\3\2\2\2\u011c\u00fc\3\2\2\2\u011c"+
		"\u00fe\3\2\2\2\u011c\u0100\3\2\2\2\u011c\u0102\3\2\2\2\u011d\u015b\3\2"+
		"\2\2\u011e\u011f\f\17\2\2\u011f\u0120\t\6\2\2\u0120\u015a\5\32\16\20\u0121"+
		"\u0122\f\16\2\2\u0122\u0123\t\4\2\2\u0123\u015a\5\32\16\17\u0124\u0125"+
		"\f\r\2\2\u0125\u0126\t\7\2\2\u0126\u015a\5\32\16\16\u0127\u0128\f\f\2"+
		"\2\u0128\u0129\t\b\2\2\u0129\u015a\5\32\16\r\u012a\u012b\f\13\2\2\u012b"+
		"\u012c\t\t\2\2\u012c\u015a\5\32\16\f\u012d\u012e\f\n\2\2\u012e\u012f\t"+
		"\n\2\2\u012f\u015a\5\32\16\13\u0130\u0131\f\t\2\2\u0131\u0132\7/\2\2\u0132"+
		"\u015a\5\32\16\n\u0133\u0134\f\b\2\2\u0134\u0135\7\60\2\2\u0135\u015a"+
		"\5\32\16\t\u0136\u0137\f\7\2\2\u0137\u0138\7\61\2\2\u0138\u015a\5\32\16"+
		"\b\u0139\u013a\f\6\2\2\u013a\u013b\7\62\2\2\u013b\u015a\5\32\16\7\u013c"+
		"\u013d\f\5\2\2\u013d\u013e\7\63\2\2\u013e\u015a\5\32\16\6\u013f\u0140"+
		"\f\4\2\2\u0140\u0141\7\64\2\2\u0141\u015a\5\32\16\4\u0142\u0143\f\26\2"+
		"\2\u0143\u0144\7\5\2\2\u0144\u015a\7\27\2\2\u0145\u0146\f\25\2\2\u0146"+
		"\u0147\7\67\2\2\u0147\u0148\5\32\16\2\u0148\u0149\78\2\2\u0149\u015a\3"+
		"\2\2\2\u014a\u014b\f\24\2\2\u014b\u0154\7\65\2\2\u014c\u0151\5\32\16\2"+
		"\u014d\u014e\7\4\2\2\u014e\u0150\5\32\16\2\u014f\u014d\3\2\2\2\u0150\u0153"+
		"\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0154\u014c\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u015a\7\66\2\2\u0157\u0158\f\23\2\2\u0158\u015a\t\3\2\2\u0159"+
		"\u011e\3\2\2\2\u0159\u0121\3\2\2\2\u0159\u0124\3\2\2\2\u0159\u0127\3\2"+
		"\2\2\u0159\u012a\3\2\2\2\u0159\u012d\3\2\2\2\u0159\u0130\3\2\2\2\u0159"+
		"\u0133\3\2\2\2\u0159\u0136\3\2\2\2\u0159\u0139\3\2\2\2\u0159\u013c\3\2"+
		"\2\2\u0159\u013f\3\2\2\2\u0159\u0142\3\2\2\2\u0159\u0145\3\2\2\2\u0159"+
		"\u014a\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\33\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f"+
		"\t\13\2\2\u015f\35\3\2\2\2%!)\61\63CFVYdkpx{\u0083\u0091\u0096\u009a\u009e"+
		"\u00ae\u00b2\u00b5\u00cd\u00da\u00e0\u00eb\u00f1\u00fa\u010e\u0111\u0118"+
		"\u011c\u0151\u0154\u0159\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}