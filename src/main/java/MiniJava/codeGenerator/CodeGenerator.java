//package MiniJava.codeGenerator;
//
//import MiniJava.Log.Log;
//import MiniJava.errorHandler.ErrorHandler;
//import MiniJava.scanner.token.Token;
//import MiniJava.semantic.symbol.Symbol;
//import MiniJava.semantic.symbol.SymbolTable;
//import MiniJava.semantic.symbol.SymbolType;
//
//import java.util.Scanner;
//import java.util.Stack;
//
///**
// * Created by Alireza on 6/27/2015.
// */
//public class CodeGenerator {
//    private SemanticStackFacade stackFacade;
//    private Memory memory;
//    private Scanner scanner;
//    private SymbolTable symbolTable;
//
//    public CodeGenerator() {
//        this.stackFacade = new SemanticStackFacade();
//        this.memory = new Memory();
//        this.scanner = new Scanner(System.in);
//        this.symbolTable = new SymbolTable(memory);
//    }
//
//    /**
//     * Validates that both operands are integers for arithmetic operations
//     */
//    private void validateIntegerOperands(Address operand1, Address operand2, String operationName) {
//        if (operand1.getVarType() != varType.Int || operand2.getVarType() != varType.Int) {
//            ErrorHandler.printError("Type mismatch in " + operationName + " operation");
//        }
//    }
//
//    /**
//     * Performs a binary arithmetic operation and pushes result to semantic stack
//     */
//    private void performBinaryArithmeticOperation(Operation operation, String operationName) {
//        SemanticStackFacade.BinaryOperationContext context = stackFacade.popBinaryOperation();
//
//        validateIntegerOperands(context.getFirstOperand(), context.getSecondOperand(), operationName);
//
//        Address tempResult = new Address(memory.getTemp(), varType.Int);
//        memory.add3AddressCode(operation, context.getFirstOperand(), context.getSecondOperand(), tempResult);
//        stackFacade.pushAddress(tempResult);
//    }
//
//    /**
//     * Performs a binary comparison operation and pushes result to semantic stack
//     */
//    private void performBinaryComparisonOperation(Operation operation, String operationName) {
//        SemanticStackFacade.BinaryOperationContext context = stackFacade.popBinaryOperation();
//
//        validateIntegerOperands(context.getFirstOperand(), context.getSecondOperand(), operationName);
//
//        Address tempResult = new Address(memory.getTemp(), varType.Bool);
//        memory.add3AddressCode(operation, context.getFirstOperand(), context.getSecondOperand(), tempResult);
//        stackFacade.pushAddress(tempResult);
//    }
//
//    public void printMemory() {
//        memory.pintCodeBlock();
//    }
//
//    public void semanticFunction(int func, Token next) {
//        Log.print("codegenerator : " + func);
//        switch (func) {
//            case 0:
//                return;
//            case 1:
//                checkID();
//                break;
//            case 2:
//                pid(next);
//                break;
//            case 3:
//                fpid();
//                break;
//            case 4:
//                kpid(next);
//                break;
//            case 5:
//                intpid(next);
//                break;
//            case 6:
//                startCall();
//                break;
//            case 7:
//                call();
//                break;
//            case 8:
//                arg();
//                break;
//            case 9:
//                assign();
//                break;
//            case 10:
//                add();
//                break;
//            case 11:
//                sub();
//                break;
//            case 12:
//                mult();
//                break;
//            case 13:
//                label();
//                break;
//            case 14:
//                save();
//                break;
//            case 15:
////                _while();
//                whileLabel();
//                break;
//            case 16:
//                jpf_save();
//                break;
//            case 17:
//                jpHere();
//                break;
//            case 18:
//                print();
//                break;
//            case 19:
//                equal();
//                break;
//            case 20:
//                less_than();
//                break;
//            case 21:
//                and();
//                break;
//            case 22:
//                not();
//                break;
//            case 23:
//                defClass();
//                break;
//            case 24:
//                defMethod();
//                break;
//            case 25:
//                popClass();
//                break;
//            case 26:
//                extend();
//                break;
//            case 27:
//                defField();
//                break;
//            case 28:
//                defVar();
//                break;
//            case 29:
//                methodReturn();
//                break;
//            case 30:
//                defParam();
//                break;
//            case 31:
//                lastTypeBool();
//                break;
//            case 32:
//                lastTypeInt();
//                break;
//            case 33:
//                defMain();
//                break;
//        }
//    }
//
//    private void defMain() {
//        //ss.pop();
//        memory.add3AddressCode(ss.pop().num, Operation.JP, new Address(memory.getCurrentCodeBlockAddress(), varType.Address), null, null);
//        String methodName = "main";
//        String className = symbolStack.pop();
//
//        symbolTable.addMethod(className, methodName, memory.getCurrentCodeBlockAddress());
//
//        symbolStack.push(className);
//        symbolStack.push(methodName);
//    }
//
//    //    public void spid(Token next){
////        symbolStack.push(next.value);
////    }
//    public void checkID() {
//        symbolStack.pop();
//        if (ss.peek().varType == varType.Non) {
//            //TODO : error
//        }
//    }
//
////    public void pid(Token next) {
////        if (symbolStack.size() > 1) {
////            String methodName = symbolStack.pop();
////            String className = symbolStack.pop();
////            try {
////
////                Symbol s = symbolTable.get(className, methodName, next.value);
////                varType t = varType.Int;
////                switch (s.type) {
////                    case Bool:
////                        t = varType.Bool;
////                        break;
////                    case Int:
////                        t = varType.Int;
////                        break;
////                }
////                ss.push(new Address(s.address, t));
////
////
////            } catch (Exception e) {
////                ss.push(new Address(0, varType.Non));
////            }
////            symbolStack.push(className);
////            symbolStack.push(methodName);
////        } else {
////            ss.push(new Address(0, varType.Non));
////        }
////        symbolStack.push(next.value);
////    }
//    public void pid(Token next) {
//        stackFacade.pushSymbol(next.value);
//    }
//
//    public void pClass() {
//        stackFacade.pushSymbol("class");
//    }
//
//    public void fpid() {
//        ss.pop();
//        ss.pop();
//
//        Symbol s = symbolTable.get(symbolStack.pop(), symbolStack.pop());
//        varType t = varType.Int;
//        switch (s.type) {
//            case Bool:
//                t = varType.Bool;
//                break;
//            case Int:
//                t = varType.Int;
//                break;
//        }
//        ss.push(new Address(s.address, t));
//
//    }
//
//    public void kpid(Token next) {
//        ss.push(symbolTable.get(next.value));
//    }
//
//    public void intpid(Token next) {
//        ss.push(new Address(Integer.parseInt(next.value), varType.Int, TypeAddress.Imidiate));
//    }
//
//    public void startCall() {
//        //TODO: method ok
//        ss.pop();
//        ss.pop();
//        String methodName = symbolStack.pop();
//        String className = symbolStack.pop();
//        symbolTable.startCall(className, methodName);
//        callStack.push(className);
//        callStack.push(methodName);
//
//        //symbolStack.push(methodName);
//    }
//
//    public void call() {
//        //TODO: method ok
//        String methodName = callStack.pop();
//        String className = callStack.pop();
//        try {
//            symbolTable.getNextParam(className, methodName);
//            ErrorHandler.printError("The few argument pass for method");
//        } catch (IndexOutOfBoundsException e) {
//        }
//        varType t = varType.Int;
//        switch (symbolTable.getMethodReturnType(className, methodName)) {
//            case Int:
//                t = varType.Int;
//                break;
//            case Bool:
//                t = varType.Bool;
//                break;
//        }
//        Address temp = new Address(memory.getTemp(), t);
//        ss.push(temp);
//        memory.add3AddressCode(Operation.ASSIGN, new Address(temp.num, varType.Address, TypeAddress.Imidiate), new Address(symbolTable.getMethodReturnAddress(className, methodName), varType.Address), null);
//        memory.add3AddressCode(Operation.ASSIGN, new Address(memory.getCurrentCodeBlockAddress() + 2, varType.Address, TypeAddress.Imidiate), new Address(symbolTable.getMethodCallerAddress(className, methodName), varType.Address), null);
//        memory.add3AddressCode(Operation.JP, new Address(symbolTable.getMethodAddress(className, methodName), varType.Address), null, null);
//
//        //symbolStack.pop();
//    }
//
//    public void arg() {
//        //TODO: method ok
//
//        String methodName = callStack.pop();
////        String className = symbolStack.pop();
//        try {
//            Symbol s = symbolTable.getNextParam(callStack.peek(), methodName);
//            varType t = varType.Int;
//            switch (s.type) {
//                case Bool:
//                    t = varType.Bool;
//                    break;
//                case Int:
//                    t = varType.Int;
//                    break;
//            }
//            Address param = ss.pop();
//            if (param.varType != t) {
//                ErrorHandler.printError("The argument type isn't match");
//            }
//            memory.add3AddressCode(Operation.ASSIGN, param, new Address(s.address, t), null);
//
////        symbolStack.push(className);
//
//        } catch (IndexOutOfBoundsException e) {
//            ErrorHandler.printError("Too many arguments pass for method");
//        }
//        callStack.push(methodName);
//
//    }
//    public void assign() {
//        Address s1 = stackFacade.popAddress();
//        Address s2 = stackFacade.popAddress();
//        // Type checking
//        if (s1.getVarType() != s2.getVarType()) {
//            ErrorHandler.printError("The type of operands in assign is different");
//        }
//        memory.add3AddressCode(Operation.ASSIGN, s1, s2);
//    }
////    public void assign() {
////        Address s1 = ss.pop();
////        Address s2 = ss.pop();
//////        try {
////        if (s1.varType != s2.varType) {
////            ErrorHandler.printError("The type of operands in assign is different ");
////        }
//////        }catch (NullPointerException d)
//////        {
//////            d.printStackTrace();
//////        }
////        memory.add3AddressCode(Operation.ASSIGN, s1, s2, null);
////    }
//
////    public void add() {
////        Address temp = new Address(memory.getTemp(), varType.Int);
////        Address s2 = ss.pop();
////        Address s1 = ss.pop();
////
////        if (s1.varType != varType.Int || s2.varType != varType.Int) {
////            ErrorHandler.printError("In add two operands must be integer");
////        }
////        memory.add3AddressCode(Operation.ADD, s1, s2, temp);
////        ss.push(temp);
////    }
//
////    public void sub() {
////        Address temp = new Address(memory.getTemp(), varType.Int);
////        Address s2 = ss.pop();
////        Address s1 = ss.pop();
////        if (s1.varType != varType.Int || s2.varType != varType.Int) {
////            ErrorHandler.printError("In sub two operands must be integer");
////        }
////        memory.add3AddressCode(Operation.SUB, s1, s2, temp);
////        ss.push(temp);
////    }
//
////    public void mult() {
////        Address temp = new Address(memory.getTemp(), varType.Int);
////        Address s2 = ss.pop();
////        Address s1 = ss.pop();
////        if (s1.varType != varType.Int || s2.varType != varType.Int) {
////            ErrorHandler.printError("In mult two operands must be integer");
////        }
////        memory.add3AddressCode(Operation.MULT, s1, s2, temp);
//////        memory.saveMemory();
////        ss.push(temp);
////    }
//    // Refactored arithmetic methods
//    public void add() {
//        performBinaryArithmeticOperation(Operation.ADD, "addition");
//    }
//
//    public void sub() {
//        performBinaryArithmeticOperation(Operation.SUB, "subtraction");
//    }
//
//    public void mult() {
//        performBinaryArithmeticOperation(Operation.MULT, "multiplication");
//    }
//
//    public void label() {
//        ss.push(new Address(memory.getCurrentCodeBlockAddress(), varType.Address));
//    }
//
//    public void save() {
//        ss.push(new Address(memory.saveMemory(), varType.Address));
//    }
//
//    public void _while() {
//        memory.add3AddressCode(ss.pop().num, Operation.JPF, ss.pop(), new Address(memory.getCurrentCodeBlockAddress() + 1, varType.Address), null);
//        memory.add3AddressCode(Operation.JP, ss.pop(), null, null);
//    }
//
//    // Update usage in CodeGenerator
//    public void whileLabel() {
//        callStack.push(String.valueOf(getCurrentCodeAddress()));
//    }
//
//    public void jpf_save() {
//        Address save = ss.pop();
//        int currentAddress = memory.getCurrentCodeAddress();
//        memory.reserveCodeSlot();
//        memory.add3AddressCode(Operation.JPF, save, new Address(currentAddress, varType.Address));
//        callStack.push(String.valueOf(currentAddress));
//    }
//
//    public void jpHere() {
//        int currentAddress = memory.getCurrentCodeAddress();
//        memory.reserveCodeSlot();
//        callStack.push(String.valueOf(currentAddress));
//    }
//
//
////    public void jpf_save() {
////        Address save = new Address(memory.saveMemory(), varType.Address);
////        memory.add3AddressCode(ss.pop().num, Operation.JPF, ss.pop(), new Address(memory.getCurrentCodeBlockAddress(), varType.Address), null);
////        ss.push(save);
////    }
//
////    public void jpHere() {
////        memory.add3AddressCode(ss.pop().num, Operation.JP, new Address(memory.getCurrentCodeBlockAddress(), varType.Address), null, null);
////    }
//
//    public void print() {
//        memory.add3AddressCode(Operation.PRINT, ss.pop(), null, null);
//    }
//
////    public void equal() {
////        Address temp = new Address(memory.getTemp(), varType.Bool);
////        Address s2 = ss.pop();
////        Address s1 = ss.pop();
////        if (s1.varType != s2.varType) {
////            ErrorHandler.printError("The type of operands in equal operator is different");
////        }
////        memory.add3AddressCode(Operation.EQ, s1, s2, temp);
////        ss.push(temp);
////    }
////
////    public void less_than() {
////        Address temp = new Address(memory.getTemp(), varType.Bool);
////        Address s2 = ss.pop();
////        Address s1 = ss.pop();
////        if (s1.varType != varType.Int || s2.varType != varType.Int) {
////            ErrorHandler.printError("The type of operands in less than operator is different");
////        }
////        memory.add3AddressCode(Operation.LT, s1, s2, temp);
////        ss.push(temp);
////    }
//    // Refactored comparison methods
//    public void less_than() {
//        performBinaryComparisonOperation(Operation.LT, "less than comparison");
//    }
//
//    public void equal() {
//        performBinaryComparisonOperation(Operation.EQ, "equality comparison");
//    }
//
//    public void and() {
//        Address temp = new Address(memory.getTemp(), varType.Bool);
//        Address s2 = ss.pop();
//        Address s1 = ss.pop();
//        if (s1.varType != varType.Bool || s2.varType != varType.Bool) {
//            ErrorHandler.printError("In and operator the operands must be boolean");
//        }
//        memory.add3AddressCode(Operation.AND, s1, s2, temp);
//        ss.push(temp);
//    }
//
//    public void not() {
//        Address temp = new Address(memory.getTemp(), varType.Bool);
//        Address s2 = ss.pop();
//        Address s1 = ss.pop();
//        if (s1.varType != varType.Bool) {
//            ErrorHandler.printError("In not operator the operand must be boolean");
//        }
//        memory.add3AddressCode(Operation.NOT, s1, s2, temp);
//        ss.push(temp);
//    }
//
//    public void defClass() {
//        ss.pop();
//        symbolTable.addClass(symbolStack.peek());
//    }
//
//    public void defMethod() {
//        ss.pop();
//        String methodName = symbolStack.pop();
//        String className = symbolStack.pop();
//
//        symbolTable.addMethod(className, methodName, memory.getCurrentCodeBlockAddress());
//
//        symbolStack.push(className);
//        symbolStack.push(methodName);
//    }
//
//    public void popClass() {
//        symbolStack.pop();
//    }
//
//    public void extend() {
//        ss.pop();
//        symbolTable.setSuperClass(symbolStack.pop(), symbolStack.peek());
//    }
//
//    public void defField() {
//        ss.pop();
//        symbolTable.addField(symbolStack.pop(), symbolStack.peek());
//    }
//
//    public void defVar() {
//        ss.pop();
//
//        String var = symbolStack.pop();
//        String methodName = symbolStack.pop();
//        String className = symbolStack.pop();
//
//        symbolTable.addMethodLocalVariable(className, methodName, var);
//
//        symbolStack.push(className);
//        symbolStack.push(methodName);
//    }
//
//    public void methodReturn() {
//        //TODO : call ok
//
//        String methodName = symbolStack.pop();
//        Address s = ss.pop();
//        SymbolType t = symbolTable.getMethodReturnType(symbolStack.peek(), methodName);
//        varType temp = varType.Int;
//        switch (t) {
//            case Int:
//                break;
//            case Bool:
//                temp = varType.Bool;
//        }
//        if (s.varType != temp) {
//            ErrorHandler.printError("The type of method and return address was not match");
//        }
//        memory.add3AddressCode(Operation.ASSIGN, s, new Address(symbolTable.getMethodReturnAddress(symbolStack.peek(), methodName), varType.Address, TypeAddress.Indirect), null);
//        memory.add3AddressCode(Operation.JP, new Address(symbolTable.getMethodCallerAddress(symbolStack.peek(), methodName), varType.Address), null, null);
//
//        //symbolStack.pop();
//    }
//
//    public void defParam() {
//        //TODO : call Ok
//        ss.pop();
//        String param = symbolStack.pop();
//        String methodName = symbolStack.pop();
//        String className = symbolStack.pop();
//
//        symbolTable.addMethodParameter(className, methodName, param);
//
//        symbolStack.push(className);
//        symbolStack.push(methodName);
//    }
//
//    public void lastTypeBool() {
//        symbolTable.setLastType(SymbolType.Bool);
//    }
//
//    public void lastTypeInt() {
//        symbolTable.setLastType(SymbolType.Int);
//    }
//
//    public void main() {
//
//    }
//}

package MiniJava.codeGenerator;

import MiniJava.Log.Log;
import MiniJava.codeGenerator.semantic.SemanticAction;
import MiniJava.codeGenerator.semantic.SemanticActionFactory;
import MiniJava.errorHandler.ErrorHandler;
import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.Symbol;
import MiniJava.semantic.symbol.SymbolTable;
import MiniJava.semantic.symbol.SymbolType;

import java.util.Scanner;

/**
 * Created by Alireza on 6/27/2015.
 */
public class CodeGenerator {
    private SemanticStackFacade stackFacade;
    private CodeGenerationFacade codeFacade;
    private Scanner scanner;
    private SymbolTable symbolTable;

    public CodeGenerator() {
        this.stackFacade = new SemanticStackFacade();
        Memory memory = new Memory();
        this.codeFacade = new CodeGenerationFacade(memory);
        this.scanner = new Scanner(System.in);
        this.symbolTable = new SymbolTable(memory);
    }

    /**
     * Validates that both operands are integers for arithmetic operations
     */
    private void validateIntegerOperands(Address operand1, Address operand2, String operationName) {
        if (operand1.getVarType() != varType.Int || operand2.getVarType() != varType.Int) {
            ErrorHandler.printError("Type mismatch in " + operationName + " operation");
        }
    }

    /**
     * Performs a binary arithmetic operation and pushes result to semantic stack
     */
    private void performBinaryArithmeticOperation(Operation operation, String operationName) {
        SemanticStackFacade.BinaryOperationContext context = stackFacade.popBinaryOperation();

        validateIntegerOperands(context.getFirstOperand(), context.getSecondOperand(), operationName);

        Address result = codeFacade.generateArithmeticOperation(operation,
                context.getFirstOperand(),
                context.getSecondOperand());
        stackFacade.pushAddress(result);
    }

    /**
     * Performs a binary comparison operation and pushes result to semantic stack
     */
    private void performBinaryComparisonOperation(Operation operation, String operationName) {
        SemanticStackFacade.BinaryOperationContext context = stackFacade.popBinaryOperation();

        validateIntegerOperands(context.getFirstOperand(), context.getSecondOperand(), operationName);

        Address result = codeFacade.generateComparisonOperation(operation,
                context.getFirstOperand(),
                context.getSecondOperand());
        stackFacade.pushAddress(result);
    }

    public void printMemory() {
        memory.pintCodeBlock();
    }

    public void semanticFunction(int func, Token next) {
        try {
            SemanticAction action = SemanticActionFactory.getAction(func);
            action.execute(next, stackFacade, codeFacade, symbolTable);
        } catch (IllegalArgumentException e) {
            ErrorHandler.printError("Unknown semantic action: " + func);
        } catch (Exception e) {
            ErrorHandler.printError("Error executing semantic action " + func + ": " + e.getMessage());
        }
    }

    private void defMain() {
        memory.add3AddressCode(stackFacade.popAddress().num, Operation.JP,
                new Address(memory.getCurrentCodeAddress(), varType.Address), null, null);
        String methodName = "main";
        String className = stackFacade.popSymbol();

        symbolTable.addMethod(className, methodName, memory.getCurrentCodeAddress());

        stackFacade.pushSymbol(className);
        stackFacade.pushSymbol(methodName);
    }

    @Deprecated
    public void checkID() {
        SemanticActionFactory.getAction(1).execute(null, stackFacade, codeFacade, symbolTable);
    }

    @Deprecated
    public void pid(Token next) {
        SemanticActionFactory.getAction(2).execute(next, stackFacade, codeFacade, symbolTable);
    }

    public void pClass() {
        stackFacade.pushSymbol("class");
    }

    public void fpid() {
        stackFacade.popAddress();
        stackFacade.popAddress();

        Symbol s = symbolTable.get(stackFacade.popSymbol(), stackFacade.popSymbol());
        varType t = varType.Int;
        switch (s.type) {
            case Bool:
                t = varType.Bool;
                break;
            case Int:
                t = varType.Int;
                break;
        }
        stackFacade.pushAddress(new Address(s.address, t));
    }

    public void kpid(Token next) {
        stackFacade.pushAddress(symbolTable.get(next.value));
    }

    public void intpid(Token next) {
        stackFacade.pushAddress(new Address(Integer.parseInt(next.value), varType.Int, TypeAddress.Imidiate));
    }

    public void startCall() {
        stackFacade.popAddress();
        stackFacade.popAddress();
        String methodName = stackFacade.popSymbol();
        String className = stackFacade.popSymbol();
        symbolTable.startCall(className, methodName);
        stackFacade.pushCall(className);
        stackFacade.pushCall(methodName);
    }

    public void call() {
        String methodName = stackFacade.popCall();
        String className = stackFacade.popCall();
        try {
            symbolTable.getNextParam(className, methodName);
            ErrorHandler.printError("The few argument pass for method");
        } catch (IndexOutOfBoundsException e) {
        }
        varType t = varType.Int;
        switch (symbolTable.getMethodReturnType(className, methodName)) {
            case Int:
                t = varType.Int;
                break;
            case Bool:
                t = varType.Bool;
                break;
        }
        Address temp = new Address(memory.getTemp(), t);
        stackFacade.pushAddress(temp);
        memory.add3AddressCode(Operation.ASSIGN, new Address(temp.num, varType.Address, TypeAddress.Imidiate),
                new Address(symbolTable.getMethodReturnAddress(className, methodName), varType.Address), null);
        memory.add3AddressCode(Operation.ASSIGN,
                new Address(memory.getCurrentCodeAddress() + 2, varType.Address, TypeAddress.Imidiate),
                new Address(symbolTable.getMethodCallerAddress(className, methodName), varType.Address), null);
        memory.add3AddressCode(Operation.JP,
                new Address(symbolTable.getMethodAddress(className, methodName), varType.Address), null, null);
    }

    public void arg() {
        String methodName = stackFacade.popCall();
        try {
            Symbol s = symbolTable.getNextParam(stackFacade.peekCall(), methodName);
            varType t = varType.Int;
            switch (s.type) {
                case Bool:
                    t = varType.Bool;
                    break;
                case Int:
                    t = varType.Int;
                    break;
            }
            Address param = stackFacade.popAddress();
            if (param.getVarType() != t) {
                ErrorHandler.printError("The argument type isn't match");
            }
            memory.add3AddressCode(Operation.ASSIGN, param, new Address(s.address, t), null);

        } catch (IndexOutOfBoundsException e) {
            ErrorHandler.printError("Too many arguments pass for method");
        }
        stackFacade.pushCall(methodName);
    }

    public void assign() {
        Address source = stackFacade.popAddress();
        Address destination = stackFacade.popAddress();

        // Type checking
        if (source.getVarType() != destination.getVarType()) {
            ErrorHandler.printError("The type of operands in assign is different");
        }

        codeFacade.generateAssignment(source, destination);
    }

    // Refactored arithmetic methods
    @Deprecated
    public void add() {
        SemanticActionFactory.getAction(3).execute(null, stackFacade, codeFacade, symbolTable);
    }

    public void sub() {
        performBinaryArithmeticOperation(Operation.SUB, "subtraction");
    }

    public void mult() {
        performBinaryArithmeticOperation(Operation.MULT, "multiplication");
    }

    public void label() {
        stackFacade.pushAddress(new Address(memory.getCurrentCodeAddress(), varType.Address));
    }

    public void save() {
        stackFacade.pushAddress(new Address(memory.saveMemory(), varType.Address));
    }

    public void _while() {
        Address jumpAddress = stackFacade.popAddress();
        Address condition = stackFacade.popAddress();
        Address loopStart = stackFacade.popAddress();
        memory.add3AddressCode(jumpAddress.num, Operation.JPF, condition,
                new Address(memory.getCurrentCodeAddress() + 1, varType.Address), null);
        memory.add3AddressCode(Operation.JP, loopStart, null, null);
    }

    public void whileLabel() {
        stackFacade.pushCall(String.valueOf(memory.getCurrentCodeAddress()));
    }

    public void jpf_save() {
        Address condition = stackFacade.popAddress();
        int jumpAddress = codeFacade.generateConditionalJump(condition);
        stackFacade.pushCall(String.valueOf(jumpAddress));
    }

    public void jpHere() {
        int jumpAddress = codeFacade.generateUnconditionalJump();
        stackFacade.pushCall(String.valueOf(jumpAddress));
    }

    public void print() {
        Address value = stackFacade.popAddress();
        codeFacade.generatePrint(value);
    }

    // Refactored comparison methods
    public void less_than() {
        performBinaryComparisonOperation(Operation.LT, "less than comparison");
    }

    public void equal() {
        performBinaryComparisonOperation(Operation.EQ, "equality comparison");
    }

    public void and() {
        Address temp = new Address(memory.getTemp(), varType.Bool);
        Address s2 = stackFacade.popAddress();
        Address s1 = stackFacade.popAddress();
        if (s1.getVarType() != varType.Bool || s2.getVarType() != varType.Bool) {
            ErrorHandler.printError("In and operator the operands must be boolean");
        }
        memory.add3AddressCode(Operation.AND, s1, s2, temp);
        stackFacade.pushAddress(temp);
    }

    public void not() {
        Address temp = new Address(memory.getTemp(), varType.Bool);
        Address s1 = stackFacade.popAddress();
        if (s1.getVarType() != varType.Bool) {
            ErrorHandler.printError("In not operator the operand must be boolean");
        }
        memory.add3AddressCode(Operation.NOT, s1, null, temp);
        stackFacade.pushAddress(temp);
    }

    public void defClass() {
        stackFacade.popAddress();
        symbolTable.addClass(stackFacade.peekSymbol());
    }

    public void defMethod() {
        stackFacade.popAddress();
        String methodName = stackFacade.popSymbol();
        String className = stackFacade.popSymbol();

        symbolTable.addMethod(className, methodName, memory.getCurrentCodeAddress());

        stackFacade.pushSymbol(className);
        stackFacade.pushSymbol(methodName);
    }

    public void popClass() {
        stackFacade.popSymbol();
    }

    public void extend() {
        stackFacade.popAddress();
        symbolTable.setSuperClass(stackFacade.popSymbol(), stackFacade.peekSymbol());
    }

    public void defField() {
        stackFacade.popAddress();
        symbolTable.addField(stackFacade.popSymbol(), stackFacade.peekSymbol());
    }

    public void defVar() {
        stackFacade.popAddress();

        String var = stackFacade.popSymbol();
        String methodName = stackFacade.popSymbol();
        String className = stackFacade.popSymbol();

        symbolTable.addMethodLocalVariable(className, methodName, var);

        stackFacade.pushSymbol(className);
        stackFacade.pushSymbol(methodName);
    }

    public void methodReturn() {
        String methodName = stackFacade.popSymbol();
        Address s = stackFacade.popAddress();
        SymbolType t = symbolTable.getMethodReturnType(stackFacade.peekSymbol(), methodName);
        varType temp = varType.Int;
        switch (t) {
            case Int:
                break;
            case Bool:
                temp = varType.Bool;
        }
        if (s.getVarType() != temp) {
            ErrorHandler.printError("The type of method and return address was not match");
        }
        memory.add3AddressCode(Operation.ASSIGN, s,
                new Address(symbolTable.getMethodReturnAddress(stackFacade.peekSymbol(), methodName), varType.Address,
                        TypeAddress.Indirect),
                null);
        memory.add3AddressCode(Operation.JP,
                new Address(symbolTable.getMethodCallerAddress(stackFacade.peekSymbol(), methodName), varType.Address),
                null, null);
    }

    public void defParam() {
        stackFacade.popAddress();
        String param = stackFacade.popSymbol();
        String methodName = stackFacade.popSymbol();
        String className = stackFacade.popSymbol();

        symbolTable.addMethodParameter(className, methodName, param);

        stackFacade.pushSymbol(className);
        stackFacade.pushSymbol(methodName);
    }

    public void lastTypeBool() {
        symbolTable.setLastType(SymbolType.Bool);
    }

    public void lastTypeInt() {
        symbolTable.setLastType(SymbolType.Int);
    }

    public void main() {
        // Main method implementation if needed
    }
}
