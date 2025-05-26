package MiniJava.codeGenerator.semantic;

import java.util.HashMap;
import java.util.Map;

public class SemanticActionFactory {
    private static final Map<Integer, SemanticAction> actions = new HashMap<>();

    static {
        actions.put(1, new CheckIdAction());
        actions.put(2, new PidAction());
        actions.put(3, new AddAction());
        actions.put(4, new SubAction());
        actions.put(5, new MultAction());
        actions.put(6, new AssignAction());
        actions.put(7, new LessThanAction());
        actions.put(8, new EqualAction());
        actions.put(9, new JpfSaveAction());
        actions.put(10, new JpHereAction());
        actions.put(11, new PrintAction());
        actions.put(12, new DefClassAction());
        actions.put(13, new DefMethodAction());
        actions.put(14, new PClassAction());
        actions.put(15, new DefVarAction());
        actions.put(16, new MethodReturnAction());
        actions.put(17, new PnumAction());
        actions.put(18, new WhileLabelAction());
        actions.put(19, new PtypeAction());
        actions.put(20, new DefParamAction());
        actions.put(21, new LastTypeBoolAction());
        actions.put(22, new LastTypeIntAction());
        actions.put(23, new DefMainAction());
        actions.put(24, new DefVarMainAction());
        actions.put(25, new MethodCallAction());
        actions.put(26, new DefFieldAction());
        actions.put(27, new DefVarFieldAction());
        actions.put(28, new BeginAction());
        actions.put(29, new CallAction());
        actions.put(30, new RetAction());
        actions.put(31, new AssignAction());
        actions.put(32, new SpNumAction());
        actions.put(33, new JpAction());
        actions.put(34, new JpfAction());
    }

    public static SemanticAction getAction(int actionNumber) {
        SemanticAction action = actions.get(actionNumber);
        if (action == null) {
            throw new IllegalArgumentException("Unknown semantic action: " + actionNumber);
        }
        return action;
    }
}