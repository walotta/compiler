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
    :   type        #typeRet
    |   Void        #voidRet
    ;

singleVarBlock
    :   Identifier ('=' expersion)?
    ;

type
    :   singleType              #single
    |   singleType ('[' ']')*   #array
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
    :   statementBlock                                                                          #stateBlock
    |   varBlock                                                                                #varDefine
    |   If'('expersion')' trueStatement=statement (Else falseStatement=statement)?              #if
    |   For'('initExp=expersion?';'finishExp=expersion?';'stepExp=expersion?')'statement        #for
    |   While'('finishExp=expersion')'statement                                                 #while
    |   Break';'                                                                                #break
    |   Continue';'                                                                             #continue
    |   Return expersion?';'                                                                    #ret
    |   expersion? ';'                                                                          #exp
    ;

expersion
    :   '('expersion')'                                                             #block
    |   Identifier                                                                  #identifier
    |   constValue                                                                  #const
    |   New singleType                                                              #newVarNoValue
    |   New singleType'('')'                                                        #newVarEmptyValue
    |   New singleType'('expersion(','expersion)*')'                                #newVarWithValue
    |   New singleType('['expersion']')+('['']')*                                   #newArray
    |   New singleType('['expersion']')+('['']')*('['expersion']')+                 #newArrayErr
    |   expersion'.'Identifier                                                      #classVar
    |   array=expersion'['index=expersion']'                                        #arrayMember
    |   funcName=expersion'('(expersion(','expersion)*)?')'                         #funcCall
    |   expersion op=(SelfAdd|SelfSub)                                              #selfOpRight
    |   <assoc=right> op=(SelfAdd|SelfSub) expersion                                #selfOpLeft
    |   <assoc=right> op=(Add|Sub) expersion                                        #valuenceOp
    |   <assoc=right> op=(LogicNot|BitNot) expersion                                #logicOp
    |   expersion op=(Mul|Div|Mod) expersion                                        #multiplyDivide
    |   expersion op=(Add|Sub) expersion                                            #addSub
    |   expersion op=(BitLeft|BitRight) expersion                                   #bitMove
    |   expersion op=(SmallThan|BigThan) expersion                                  #compareNoEqual
    |   expersion op=(SmallEqual|BigEqual) expersion                                #compareEqual
    |   expersion op=(IsEqual|IsNotEqual) expersion                                 #equalJudge
    |   expersion op=BitAnd expersion                                               #bitAnd
    |   expersion op=BitXor expersion                                               #bitXor
    |   expersion op=BitOr expersion                                                #bitOr
    |   expersion op=LogicAnd expersion                                             #logicAnd
    |   expersion op=LogicOr expersion                                              #logicOr
    |   <assoc=right> expersion op=Equal expersion                                  #assign
    |   '[''&'']''('(type Identifier (',' type Identifier)*)?')''{'statement*'}'    #lambdaExp
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