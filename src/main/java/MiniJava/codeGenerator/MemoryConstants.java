package MiniJava.codeGenerator;

public final class MemoryConstants {
    // Memory layout constants
    public static final int TEMP_MEMORY_START_ADDRESS = 500;
    public static final int DATA_MEMORY_START_ADDRESS = 200;
    public static final int WORD_SIZE = 4;

    // Memory allocation sizes
    public static final int DEFAULT_TEMP_SIZE = 4;
    public static final int DEFAULT_DATA_SIZE = 4;

    // Prevent instantiation
    private MemoryConstants() {
        throw new AssertionError("Utility class should not be instantiated");
    }
}
