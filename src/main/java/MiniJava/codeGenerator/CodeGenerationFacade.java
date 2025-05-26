package MiniJava.codeGenerator;

public class CodeGenerationFacade {
    private Memory memory;

    public CodeGenerationFacade(Memory memory) {
        this.memory = memory;
    }

    public Address generateArithmeticOperation(Operation operation, Address operand1, Address operand2) {
        Address result = new Address(memory.getTemp(), varType.Int);
        memory.add3AddressCode(operation, operand1, operand2, result);
        return result;
    }

    public Address generateComparisonOperation(Operation operation, Address operand1, Address operand2) {
        Address result = new Address(memory.getTemp(), varType.Bool);
        memory.add3AddressCode(operation, operand1, operand2, result);
        return result;
    }

    public void generateAssignment(Address source, Address destination) {
        memory.add3AddressCode(Operation.ASSIGN, source, destination);
    }

    public int generateConditionalJump(Address condition) {
        int jumpAddress = memory.getCurrentCodeAddress();
        memory.reserveCodeSlot();
        memory.add3AddressCode(Operation.JPF, condition, new Address(jumpAddress, varType.Address));
        return jumpAddress;
    }

    public int generateUnconditionalJump() {
        int jumpAddress = memory.getCurrentCodeAddress();
        memory.reserveCodeSlot();
        memory.add3AddressCode(Operation.JP, new Address(jumpAddress, varType.Address));
        return jumpAddress;
    }

    public void updateJumpTarget(int jumpInstructionAddress, int targetAddress) {
        memory.add3AddressCode(jumpInstructionAddress, Operation.JP,
                new Address(targetAddress, varType.Address), null, null);
    }

    public void generatePrint(Address value) {
        memory.add3AddressCode(Operation.PRINT, value);
    }

    public Address createTempAddress(varType type) {
        return new Address(memory.getTemp(), type);
    }

    public Address createDataAddress(varType type) {
        return new Address(memory.getDateAddress(), type);
    }

    public int getCurrentCodeAddress() {
        return memory.getCurrentCodeAddress();
    }

    public void printGeneratedCode() {
        memory.pintCodeBlock();
    }
}