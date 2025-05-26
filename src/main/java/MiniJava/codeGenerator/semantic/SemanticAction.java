package MiniJava.codeGenerator.semantic;

import MiniJava.codeGenerator.*;
import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.SymbolTable;

public interface SemanticAction {
    void execute(Token lookAhead, SemanticStackFacade stackFacade,
            CodeGenerationFacade codeFacade, SymbolTable symbolTable);
}