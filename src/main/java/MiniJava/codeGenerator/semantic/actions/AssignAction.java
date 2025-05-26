package MiniJava.codeGenerator.semantic.actions;

import MiniJava.codeGenerator.*;
import MiniJava.codeGenerator.semantic.SemanticAction;
import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.SymbolTable;

public class AssignAction implements SemanticAction {
    @Override
    public void execute(Token lookAhead, SemanticStackFacade stackFacade, 
                       CodeGenerationFacade codeFacade, SymbolTable symbolTable) {
        Address source = stackFacade.popAddress();
        Address destination = stackFacade.popAddress();
        
        // Type checking
        if (source.getVarType() != destination.getVarType()) {
            ErrorHandler.printError("The type of operands in assign is different");
        }
        
        codeFacade.generateAssignment(source, destination);
    }
}

content_copy
