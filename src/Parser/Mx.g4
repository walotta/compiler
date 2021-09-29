grammar Mx;

program
    :   programBlock* EOF
    ;

programBlock
    :   classBlock
    |   funcBlock
    |   varBlock
    ;

classBlock
    :   Class Identifier '{' (buildFuncBlock|funcBlock|varBlock)* '}' ';'
    ;

buildFuncBlock
    :   funcName=Identifier '(' (type Identifier (',' type Identifier)*)? ')' statementBlock
    ;

funcBlock
    :   funcType=retType funcName=Identifier '(' (type Identifier (',' type Identifier)*)? ')' statementBlock
    ;

varBlock
    :   type singleVarBlock(',' singleVarBlock)* ';'
    ;

retType
    :   type
    |   Void
    ;

singleVarBlock
    :   Identifier ('=' expersion)?
    ;

type
    :   singleType
    |   singleType ('[' ']')*
    ;

singleType
    :   Int
    |   Bool
    |   String
    |   Identifier
    ;

statementBlock
    :   '{' statement* '}'
    ;

statement
    :   statementBlock
    |   varBlock
    |   ifStatement
    |   forStatement
    |   whileStatement
    |   Break';'
    |   Continue';'
    |   Return expersion?';'
    |   expersion? ';'
    ;

ifStatement
    :   If'('expersion')' trueStatement=statement (Else falseStatement=statement)?
    ;

forStatement
    :   For'('initExp=expersion?';'finishExp=expersion?';'stepExp=expersion?')'statement
    ;

whileStatement
    :   While'('finishExp=expersion')'statement
    ;

expersion
    :   '('expersion')'
    |   Identifier
    |   constValue
    |   New singleType
    |   New singleType'('')'
    |   New singleType'('expersion(','expersion)*')'
    |   New singleType('['expersion']')+('['']')*
    |   New singleType('['expersion']')+('['']')*('['expersion']')+
    |   expersion'.'Identifier
    |   array=expersion'['index=expersion']'
    |   funcName=expersion'('(expersion(','expersion)*)?')'
    |   expersion op=(SelfAdd|SelfSub)
    |   <assoc=right> op=(SelfAdd|SelfSub) expersion
    |   <assoc=right> op=(Add|Sub) expersion
    |   <assoc=right> op=(LogicNot|BitNot) expersion
    |   expersion op=(Mul|Div|Mod) expersion
    |   expersion op=(Add|Sub) expersion
    |   expersion op=(BitLeft|BitRight) expersion
    |   expersion op=(SmallThan|BigThan) expersion
    |   expersion op=(SmallEqual|BigEqual) expersion
    |   expersion op=(IsEqual|IsNotEqual) expersion
    |   expersion op=BitAnd expersion
    |   expersion op=BitXor expersion
    |   expersion op=BitOr expersion
    |   expersion op=LogicAnd expersion
    |   expersion op=LogicOr expersion
    |   <assoc=right> expersion op=Equal expersion
    ;

constValue
    :   This
    |   True
    |   False
    |   Null
    |   IntegerConstant
    |   StringConstant
    ;

Int:'int';
Bool:'bool';
String:'string';
Class:'class';
Void:'void';
Break:'break';
Continue:'continue';
Return:'return';
If:'if';
Else:'else';
For:'for';
While:'while';
New:'new';
This:'this';
True:'true';
False:'false';
Null:'null';

Identifier
    : [a-zA-Z] [a-zA-Z_0-9]*
    ;

IntegerConstant
    : [1-9] [0-9]*
    | '0'
    ;

StringConstant
    : '"' ('\\n' | '\\\\' | '\\"' | .)*? '"'
    ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;

SelfAdd:'++';
SelfSub:'--';
Add:'+';
Sub:'-';
LogicNot:'!';
BitNot:'~';
Mul:'*';
Div:'/';
Mod:'%';
BitLeft:'<<';
BitRight:'>>';
SmallThan:'<';
BigThan:'>';
SmallEqual:'<=';
BigEqual:'>=';
IsEqual:'==';
IsNotEqual:'!=';
BitAnd:'&';
BitXor:'^';
BitOr:'|';
LogicAnd:'&&';
LogicOr:'||';
Equal:'=';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';