package MiniJava.codeGenerator.semantic.actions;

import MiniJava.codeGenerator.*;
import MiniJava.codeGenerator.semantic.SemanticAction;
import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.SymbolTable;

public class AddAction implements SemanticAction {
    @Override
    public void execute(Token lookAhead, SemanticStackFacade stackFacade,
            CodeGenerationFacade codeFacade, SymbolTable symbolTable) {
        SemanticStackFacade.BinaryOperationContext context = stackFacade.popBinaryOperation();

        // Type validation
        if (context.getFirstOperand().getVarType() != varType.Int ||
                context.getSecondOperand().getVarType() != varType.Int) {
            ErrorHandler.printError("Type mismatch in addition operation");
        }

        Address result = codeFacade.generateArithmeticOperation(Operation.ADD,
                context.getFirstOperand(),
                context.getSecondOperand());
        stackFacade.pushAddress(result);
    }
}