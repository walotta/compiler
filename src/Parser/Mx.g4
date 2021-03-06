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
    :   retType funcName=Identifier '(' (type Identifier (',' type Identifier)*)? ')' statementBlock
    ;

varBlock
    :   type singleVarBlock(',' singleVarBlock)* ';'
    ;

retType
    :   type
    |   Void
    ;

singleVarBlock
    :   Identifier ('=' experssion)?
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

forInitExpr
    :   (experssion?';'|varBlock)
    ;

statement
    :   statementBlock                                                                          #stateBlock
    |   varBlock                                                                                #varDefine
    |   If'('experssion')' trueStatement=statement (Else falseStatement=statement)?             #if
    |   For'('initExp=forInitExpr finishExp=experssion?';'stepExp=experssion?')'statement       #for
    |   While'('finishExp=experssion')'statement                                                #while
    |   Break';'                                                                                #break
    |   Continue';'                                                                             #continue
    |   Return experssion?';'                                                                   #retStatement
    |   experssion ';'                                                                          #expStatement
    |   ';'                                                                                     #emptyStatement
    ;

experssion
    :   '('experssion')'                                                              #atomExpr
    |   Identifier                                                                    #atomExpr
    |   constValue                                                                    #atomExpr
    |   New singleType('['experssion']')+('['']')+('['experssion']')+                 #newArrayErr
    |   New singleType('['experssion']')+('['']')*                                    #newArray
    |   New singleType'('(experssion(','experssion)*)?')'                             #newInitObject
    |   New singleType                                                                #newObject
    |   experssion'.'Identifier                                                       #classMember
    |   array=experssion'['index=experssion']'                                        #arrayMember
    |   funcName=experssion'('(experssion(','experssion)*)?')'                        #funcCall
    |   experssion op=(SelfAdd|SelfSub)                                               #postFixIncDec
    |   <assoc=right> op=(SelfAdd|SelfSub) experssion                                 #unaryExpr
    |   <assoc=right> op=(Add|Sub) experssion                                         #unaryExpr
    |   <assoc=right> op=(LogicNot|BitNot) experssion                                 #unaryExpr
    |   left=experssion op=(Mul|Div|Mod) right=experssion                             #binaryExpr
    |   left=experssion op=(Add|Sub) right=experssion                                 #binaryExpr
    |   left=experssion op=(BitLeft|BitRight) right=experssion                        #binaryExpr
    |   left=experssion op=(SmallThan|BigThan) right=experssion                       #binaryExpr
    |   left=experssion op=(SmallEqual|BigEqual) right=experssion                     #binaryExpr
    |   left=experssion op=(IsEqual|IsNotEqual) right=experssion                      #binaryExpr
    |   left=experssion op=BitAnd right=experssion                                    #binaryExpr
    |   left=experssion op=BitXor right=experssion                                    #binaryExpr
    |   left=experssion op=BitOr right=experssion                                     #binaryExpr
    |   left=experssion op=LogicAnd right=experssion                                  #binaryExpr
    |   left=experssion op=LogicOr right=experssion                                   #binaryExpr
    |   <assoc=right> left=experssion op=Equal right=experssion                       #assign
    |   '[''&'']''('(type Identifier (',' type Identifier)*)?')''-''>'statementBlock  #lambdaExpr
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