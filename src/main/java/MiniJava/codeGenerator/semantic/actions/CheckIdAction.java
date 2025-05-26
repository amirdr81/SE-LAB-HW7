package MiniJava.codeGenerator.semantic.actions;

import MiniJava.codeGenerator.*;
import MiniJava.codeGenerator.semantic.SemanticAction;
import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.SymbolTable;

public class CheckIdAction implements SemanticAction {
    @Override
    public void execute(Token lookAhead, SemanticStackFacade stackFacade,
            CodeGenerationFacade codeFacade, SymbolTable symbolTable) {
        String className = stackFacade.popSymbol();
        String methodName = stackFacade.popSymbol();
        String variableName = stackFacade.popSymbol();

        if (symbolTable.lookupVariable(variableName, className, methodName) == null) {
            ErrorHandler.printError("Variable '" + variableName + "' not declared");
        }
    }
}