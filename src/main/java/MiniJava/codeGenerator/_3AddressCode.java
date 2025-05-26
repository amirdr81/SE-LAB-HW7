package MiniJava.codeGenerator;

public class _3AddressCode {
    private Operation operation;
    private Address operand1;
    private Address operand2;
    private Address operand3;

    public _3AddressCode() {
        // Default constructor
    }

    public _3AddressCode(Operation operation, Address operand1, Address operand2, Address operand3) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
    }

    // Getters
    public Operation getOperation() {
        return operation;
    }

    public Address getOperand1() {
        return operand1;
    }

    public Address getOperand2() {
        return operand2;
    }

    public Address getOperand3() {
        return operand3;
    }

    // Setters
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setOperand1(Address operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(Address operand2) {
        this.operand2 = operand2;
    }

    public void setOperand3(Address operand3) {
        this.operand3 = operand3;
    }

    @Override
    public String toString() {
        if (operation == null) return "";

        switch (operation) {
            case ADD:
            case SUB:
            case MULT:
                return String.format("(%s,%s,%s,%s)", operation, operand1, operand2, operand3);
            case ASSIGN:
                return String.format("(%s,%s,,,%s)", operation, operand1, operand3);
            case EQ:
            case LT:
                return String.format("(%s,%s,%s,%s)", operation, operand1, operand2, operand3);
            case JPF:
            case JP:
                return String.format("(%s,%s,,)", operation, operand1);
            case PRINT:
                return String.format("(%s,%s,,)", operation, operand1);
            default:
                return "";
        }
    }
}
