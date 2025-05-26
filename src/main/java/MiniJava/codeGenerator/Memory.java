package MiniJava.codeGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mohammad hosein on 6/27/2015.
 */
public class Memory {
    private ArrayList<_3AddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataIndex;

    private final int startTempMemoryAddress = MemoryConstants.TEMP_MEMORY_START_ADDRESS;
    private final int startDataMemoryAddress = MemoryConstants.DATA_MEMORY_START_ADDRESS;
    private final int tempSize = MemoryConstants.DEFAULT_TEMP_SIZE;
    private final int dataSize = MemoryConstants.DEFAULT_DATA_SIZE;

    public Memory() {
        codeBlock = new ArrayList<>();
        lastTempIndex = startTempMemoryAddress;
        lastDataIndex = startDataMemoryAddress;
    }

    public int getTemp() {
        lastTempIndex += MemoryConstants.WORD_SIZE;
        return lastTempIndex - MemoryConstants.WORD_SIZE;
    }

    public int getDateAddress() {
        lastDataIndex += MemoryConstants.WORD_SIZE;
        return lastDataIndex - MemoryConstants.WORD_SIZE;
    }

    public int saveMemory() {
        codeBlock.add(new _3AddressCode());
        return codeBlock.size() - 1;
    }

    public void add3AddressCode(Operation op, Address operand1, Address operand2, Address operand3) {
        _3AddressCode code = new _3AddressCode(op, operand1, operand2, operand3);
        codeBlock.add(code);
    }

    public void add3AddressCode(Operation op, Address operand1, Address operand3) {
        _3AddressCode code = new _3AddressCode(op, operand1, null, operand3);
        codeBlock.add(code);
    }

    public void add3AddressCode(Operation op, Address operand1) {
        _3AddressCode code = new _3AddressCode(op, operand1, null, null);
        codeBlock.add(code);
    }

    public void add3AddressCode(int i, Operation op, Address operand1, Address operand2, Address operand3) {
        _3AddressCode code = new _3AddressCode(op, operand1, operand2, operand3);
        codeBlock.set(i, code);
    }

    public int getCurrentCodeBlockAddress() {
        return codeBlock.size();
    }

    public void pintCodeBlock() {
        System.out.println("Code Block");
        for (int i = 0; i < codeBlock.size(); i++) {
            System.out.println(i + " : " + codeBlock.get(i).toString());
        }
    }
}

//class _3AddressCode {
//    public Operation operation;
//    public Address Operand1;
//    public Address Operand2;
//    public Address Operand3;
//
//    public _3AddressCode() {
//
//    }
//
//    public _3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
//        operation = op;
//        Operand1 = opr1;
//        Operand2 = opr2;
//        Operand3 = opr3;
//    }
//
//    public String toString() {
//        if (operation == null) return "";
//        StringBuffer res = new StringBuffer("(");
//        res.append(operation.toString()).append(",");
//        if (Operand1 != null) res.append(Operand1.toString());
//        res.append(",");
//        if (Operand2 != null) res.append(Operand2.toString());
//        res.append(",");
//        if (Operand3 != null) res.append(Operand3.toString());
//        res.append(")");
//
//        return res.toString();
//    }
//}
