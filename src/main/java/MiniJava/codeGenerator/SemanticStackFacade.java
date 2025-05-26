package MiniJava.codeGenerator;

import java.util.Stack;

/**
 * Facade for managing semantic stacks in code generation
 */
public class SemanticStackFacade {
    private Stack<Address> semanticStack;
    private Stack<String> symbolStack;
    private Stack<String> callStack;

    public SemanticStackFacade() {
        this.semanticStack = new Stack<>();
        this.symbolStack = new Stack<>();
        this.callStack = new Stack<>();
    }

    // Semantic Stack Operations
    public void pushAddress(Address address) {
        semanticStack.push(address);
    }

    public Address popAddress() {
        return semanticStack.pop();
    }

    public Address peekAddress() {
        return semanticStack.peek();
    }

    public boolean isSemanticStackEmpty() {
        return semanticStack.isEmpty();
    }

    // Symbol Stack Operations
    public void pushSymbol(String symbol) {
        symbolStack.push(symbol);
    }

    public String popSymbol() {
        return symbolStack.pop();
    }

    public String peekSymbol() {
        return symbolStack.peek();
    }

    // Call Stack Operations
    public void pushCall(String call) {
        callStack.push(call);
    }

    public String popCall() {
        return callStack.pop();
    }

    public String peekCall() {
        return callStack.peek();
    }

    // High-level coordinated operations
    public void pushMethodContext(String className, String methodName) {
        pushSymbol(className);
        pushSymbol(methodName);
    }

    public MethodContext popMethodContext() {
        String methodName = popSymbol();
        String className = popSymbol();
        return new MethodContext(className, methodName);
    }

    public BinaryOperationContext popBinaryOperation() {
        Address secondOperand = popAddress();
        Address firstOperand = popAddress();
        return new BinaryOperationContext(firstOperand, secondOperand);
    }

    // Helper classes for coordinated operations
    public static class MethodContext {
        private final String className;
        private final String methodName;

        public MethodContext(String className, String methodName) {
            this.className = className;
            this.methodName = methodName;
        }

        public String getClassName() { return className; }
        public String getMethodName() { return methodName; }
    }

    public static class BinaryOperationContext {
        private final Address firstOperand;
        private final Address secondOperand;

        public BinaryOperationContext(Address firstOperand, Address secondOperand) {
            this.firstOperand = firstOperand;
            this.secondOperand = secondOperand;
        }

        public Address getFirstOperand() { return firstOperand; }
        public Address getSecondOperand() { return secondOperand; }
    }
}
