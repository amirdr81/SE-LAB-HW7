# تمرین شماره ۷

اعضای تیم:

- **امیرمحمد درخشنده**
- **کیان ایزدپناه**
- **مهدی حاجی‌بیگی**

# سوالات تئوری

در این بخش، به پاسخ‌دهی سوالات تئوری خواهیم پرداخت.

## سوال اول - مفاهیم اولیه

- **کد تمیز:** به طور کلی، هر کدی که از فهم و خوانایی بالایی برخوردار باشد و نگهداری آن آسان باشد، کد تمیز نامیده می‌شود. مواردی همچون ساختار منظم، نام‌بندی فایل های مناسب، نام متد های مرتب و مرتبط(به عنوان مثال استفاده از استاندارد CamelCase) می‌تواند همگی منجر به ساخت کد تمیز شود.

- **بدهی فنی:** به هنگام توسعه و پیاده‌سازی یک پروژه، تمامی مشکلات و ضعف ها(اعم از مشکلات ساختاری، فنی و کیفی) و یا انتخاب های نادرست به هنگام برنامه‌ریزی برای پروژه، بعد از آنکه جمع‌آوری بشوند، زمانی را بعدا باید برای حل آن‌ها و رفع‌شان اختصاص داد. به این میزان زمان، بدهی فنی می‌گویند.

- **بوی بد:** به مشکلاتی در ساختار پروژه(به طور عمده، مشکلاتی که در خود کد پروژه وجود دارد)، به طوری که می‌توانند منجر به بد شدن ساختار(فرضا در اتصال کد ها به هم و یا اتصال به دیتابیس)، سخت تر شدن نگهداری کد و ... شوند، بوی بد(بوی بد کد) می‌گویند.

## سوال دوم - دسته‌بندی Code smell ها

با بررسی محتوای سایت https://refactoring.guru/refactoring/smells، دسته بندی زیر برای انواع بوی بد ها وجود دارد:

- **Bloaters (بادکنکی‌ها):** کد های بادکنکی، کد هایی هستند که خیلی بزرگ یا پیچیده شده‌اند، به عنوان مثال، کد هایی که طولانی هستند، درک سختی دارند و یا پیچیدگی درک دارند، مدیریت، تغییر و نگهداری آن‌ها و استفاده در سایر قسمت ها از آن‌ها سخت تر می‌شود. به این نوع از بوی بد، Bloaters می‌گویند.

- **Object-Orientation Abusers (سوءاستفاده از شیءگرایی):** سوءاستفاده یا استفاده نادرست از مفاهیم شیءگرایی زمانی اتفاق می‌افتد که برنامه‌نویس از قابلیت‌هایی مانند وراثت، انتزاع یا الگوهای طراحی بدون نیاز واقعی یا به شکلی غلط استفاده کند که منجر به پیچیدگی غیرضروری و کاهش خوانایی کد می‌شود.

برای مثال، اگر یک کلاس فقط به خاطر داشتن چند ویژگی مشترک، از یک کلاس والد ارث‌بری کند، اما رفتار متفاوتی داشته باشد (وراثت نابجا)، این یک سوءاستفاده از شیءگرایی است.

به این نوع از بوی بد، Object-Orientation Abusers می‌گویند.

- **Change Preventers (جلوگیرها از تغییر):** به طور کلی، مشکلاتی که می‌توانند باعث جلوگیری از تغییر کد تحت شرایط لازم، Change Preventers می‌گویند. به عنوان مثال، وابستگی های زیاد بین متد ها و یا کلاس ها، می‌توانند همگی منجر به این مشکل بشوند و باید تا حد امکان، وابستگی های موجود را کم کرد.

- **Dispensables (اضافی‌ها):** بخش هایی که با حذف آن‌ها از کد، تغییری در کد اتفاق نمی‌اتفد، همگی Dispensables نامیده می‌شوند. به عنوان مثال، کد هایی که از آن‌ها هیچ کجا استفاده نمی‌شود(کد مرده)، توضیحات بیش از حد و یا تولیدات غیرضروری را می‌توان حذف کرد، به طوری که عملکرد کد تغییری نکند.

- **Couplers (جفت‌کننده‌ها):** به طور کلی، Couplers ها، وابستگی بیش از حد بین قسمت‌های مختلف کد (مثل وابستگی زیاد یک کلاس به کلاس دیگر)، که باعث کاهش انعطاف‌پذیری و تست‌پذیری می‌شود را شامل می‌شوند.

## سوال سوم - Feature Envy

- **این بوی بد در کدام دسته قرار می‌گیرد؟**

ابتدا به بررسی تعریف Feature Envy می‌پردازیم. این بوی بد، به طور کلی، زمانی رخ می‌دهد که یک متد یا کلاس، بیش از حد به داده‌ها یا متدهای کلاس دیگری علاقه نشان دهد و به جای کار کردن با داده‌های خودش، مدام سراغ اعضای کلاس‌های دیگر برود. به عبارتی، وابستگی بیش‌از حد به وجود می‌آورد، در نتیجه با توجه به تعاریفی که در پرسش دوم ارائه دادیم، این بوی بد در دسته Object-Orientation Abusers (سوء استفاده‌کنندگان از شیءگرایی) قرار می‌گیرد. شاید این سوال پیش بیاید با توجه به وابستگی بیش از اندازه، چرا این بوی بد در دسته پنجم قرار نمی‌گیرد. پاسخ آن است که تمرکز آن روی استفاده بیش از حد یک متد از داده‌ها یا متدهای کلاس دیگر است (یعنی به جای وابستگی ساختاری، علاقه بیش از حد عملکردی به اعضای یک کلاس دیگر دارد)، در دسته Object-Orientation Abusers قرار می‌گیرد، چون ایراد آن سوءاستفاده از شیءگرایی و اصل “هر شیء باید به داده‌های خودش دسترسی داشته باشد” است، نه لزوماً افزایش coupling (وابستگی بین کلاس‌ها).

به عبارت ساده تر:

- **Couplers:** وابستگی ساختاری و شدید بین کلاس‌ها (ارتباط نزدیک یا زنجیره‌ای).

- **Feature Envy:** سوء رفتار عملکردی متدها نسبت به داده‌های خارجی، که از اصول شیءگرایی خارج شده.

- **کدام روش بازآرایی برای این بوی بد، بهتر است؟**

- **Move Method (انتقال متد):** می‌توان متدی را که بیش از حد به داده‌ها یا متدهای یک کلاس دیگر وابسته است، به همان کلاس منتقل کرد.

- **Extract Method (استخراج متد):** اگر فقط بخشی از یک متد این بو را دارد، آن بخش را به متدی در کلاس مقصد، می‌توان منتقل کرد.

البته باید در نظر داشت که گاهی هم Inline Method یا Extract Class به صورت تکمیلی ممکن است مفید باشند (اگر منطق خیلی گسترده شد).

- **چه زمانی باید این بوی بد را نادیده گرفت؟**

اگر جابجایی متد باعث به هم خوردن نظم مسئولیت‌ها یا منطق کلی برنامه شود، انجام این بازآرایی پیشنهاد نمی‌شود، اما در مواردی که دسترسی متد به داده‌های کلاس دیگر بر اساس نیاز واقعی طراحی برنامه باشد، این وضعیت قابل قبول است. در چنین شرایطی، حذف این بو ممکن است مشکلات جدید ایجاد کند یا باعث به‌هم‌ریختگی بیشتر ساختار گردد، در نتیجه، وجود Feature Envy همیشه به معنای نیاز قطعی به بازآرایی نیست و باید با توجه به شرایط خاص پروژه تصمیم‌گیری شود.

---

# بازآرایی ها

## بازآرایی ۱(کیس اول): الگوی نما (Facade Pattern) برای عملیات پشته‌ها

### توضیح:

کلاس CodeGenerator مستقیماً سه پشته مختلف را مدیریت می‌کرد که باعث درهم‌تنیدگی (Tight Coupling) و افزایش پیچیدگی می‌شد. استفاده از الگوی نما (Facade) این عملیات را ساده‌تر می‌کند؛ بدین صورت که متدهای سطح بالا برای مدیریت پشته‌ها ارائه می‌دهد، همانند یک نقطه ورود واحد برای وظایف مرتبط و هماهنگ‌سازی آن‌ها. این کار باعث کاهش پیچیدگی و بهبود سازماندهی کد می‌شود.

### پیاده‌سازی:

در فایل:

```
java:src/main/java/MiniJava/codeGenerator/SemanticStackFacade.java
```

کلاسی با متدهای سطح بالا برای مدیریت و هماهنگ‌سازی پشته‌های مختلف پیاده‌سازی شده است:

```Java
public class SemanticStackFacade {
    private Stack<Address> semanticStack;
    private Stack<String> symbolStack;
    private Stack<String> callStack;


    // عملیات سطح بالا
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

    // کلاس‌های کمکی برای مدیریت عملیات‌های هماهنگ
    public static class MethodContext { /* ... */ }
    public static class BinaryOperationContext { /* ... */ }
}

```

در فایل:

```
java:src/main/java/MiniJava/codeGenerator/CodeGenerator.java
```

تمام عملیات مرتبط با پشته‌ها به متدهای کلاس نما (Facade) منتقل شده‌اند تا وابستگی به جزئیاتِ مدیریت پشته‌ها کاهش یابد:

```Java
public class CodeGenerator {
    private SemanticStackFacade stackFacade;

    public CodeGenerator() {
        this.stackFacade = new SemanticStackFacade();
    }

    // نمونه استفاده:
    private void performBinaryArithmeticOperation(Operation operation, String operationName) {
        SemanticStackFacade.BinaryOperationContext context = stackFacade.popBinaryOperation();
        validateIntegerOperands(context.getFirstOperand(), context.getSecondOperand(), operationName);
        Address tempResult = new Address(memory.getTemp(), varType.Int);
        memory.add3AddressCode(operation, context.getFirstOperand(), context.getSecondOperand(), tempResult);
        stackFacade.pushAddress(tempResult);
    }

    // سایر متدها مشابه بالا با استفاده از stackFacade بازنویسی شده‌اند
}

```

## بازآرایی ۱(کیس دوم): الگوی نما (Facade Pattern) برای مدیریت حافظه

در کد پروژه، ایجاد وابستگی‌های پیچیده در اثر تعامل مستقیم میان چندین کلاس (مانند Memory، Address، و \_3AddressCode) رخ داده است. یک Facade مدیریت حافظه، واسطی تمیز برای عملیات تولید کد فراهم می‌کند، پیچیدگی را پنهان می‌سازد و عملیات سطح بالایی ارائه می‌دهد که هدف مشخص شده در ابتدای پروژه را به‌روشنی بیان می‌کند.

در فایل:

```
java:src/main/java/MiniJava/codeGenerator/CodeGenerationFacade.java
```

بدین منظور، کلاس CodeGenerationFacade را اضافه می‌کنیم تا متد های بیان شده را generate کرده و وابستگی را کاهش دهد.

```Java
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
```

و همچنین در فایل

```
java:src/main/java/MiniJava/codeGenerator/CodeGeneration.java
```

نیز، تمامی توابعی که در این تغییر مشمول هستند را آپدیت می‌کنیم:

```Java
// ... سایر متد ها مشابه قبل

public class CodeGenerator {
    private SemanticStackFacade stackFacade;
    private CodeGenerationFacade codeFacade;
    private Scanner scanner;
    private SymbolTable symbolTable;

    public CodeGenerator() {
        this.stackFacade = new SemanticStackFacade();
        Memory memory = new Memory();
        this.codeFacade = new CodeGenerationFacade(memory);
        this.scanner = new Scanner(System.in);
        this.symbolTable = new SymbolTable(memory);
    }

    private void performBinaryArithmeticOperation(Operation operation, String operationName) {
        SemanticStackFacade.BinaryOperationContext context = stackFacade.popBinaryOperation();
        validateIntegerOperands(context.getFirstOperand(), context.getSecondOperand(), operationName);
        Address result = codeFacade.generateArithmeticOperation(operation,
            context.getFirstOperand(),
            context.getSecondOperand());
        stackFacade.pushAddress(result);
    }

    private void performBinaryComparisonOperation(Operation operation, String operationName) {
        SemanticStackFacade.BinaryOperationContext context = stackFacade.popBinaryOperation();
        validateIntegerOperands(context.getFirstOperand(), context.getSecondOperand(), operationName);
        Address result = codeFacade.generateComparisonOperation(operation,
            context.getFirstOperand(),
            context.getSecondOperand());
        stackFacade.pushAddress(result);
    }

    public void assign() {
        Address source = stackFacade.popAddress();
        Address destination = stackFacade.popAddress();
        if (source.getVarType() != destination.getVarType())
            ErrorHandler.printError("The type of operands in assign is different");
        codeFacade.generateAssignment(source, destination);
    }

    public void jpf_save() {
        Address condition = stackFacade.popAddress();
        int jumpAddress = codeFacade.generateConditionalJump(condition);
        stackFacade.pushCall(String.valueOf(jumpAddress));
    }

    public void jpHere() {
        int jumpAddress = codeFacade.generateUnconditionalJump();
        stackFacade.pushCall(String.valueOf(jumpAddress));
    }

    public void print() {
        Address value = stackFacade.popAddress();
        codeFacade.generatePrint(value);
    }

    // ... سایر متد ها مشابه قبل
```

---

## بازآرایی ۲: جایگزینی شرطی با Polymorphism

استفاده از یک دستور switch بزرگ در تابع semanticFunction مخالف اصل باز-بسته بودن است و افزودن اقدامات معنایی جدید را دشوار می‌کند. به‌کارگیری الگوی استراتژی با Polymorphism، امکان گسترش آسان اقدامات معنایی را فراهم می‌کند، نگه‌داری را بهبود می‌بخشد و اصول طراحی شی‌گرا را با پوشش‌دهی رفتارهای متغیر رعایت می‌کند.

پیاده‌سازی:

- **در گام اول، دایرکتوری semantic را اضافه می‌کنیم. سپس، با کلاس اول، یعنی SemanticAction شروع می‌کنیم. این کلاس به منظور تعریف یک واسط استراتژی برای اقدامات معنایی ایجاد شده است**

```
java:src/main/java/MiniJava/codeGenerator/semantic/SemanticAction.java
```

```Java
package MiniJava.codeGenerator.semantic;

import MiniJava.codeGenerator.*;
import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.SymbolTable;

public interface SemanticAction {
    void execute(Token lookAhead, SemanticStackFacade stackFacade,
            CodeGenerationFacade codeFacade, SymbolTable symbolTable);
}
```

- **در گام دوم، اقدام به ایجاد کلاس SemanticActionFactory می‌کنیم. این کلاس به منظور ذخیره سازی یک کارخانه برای ایجاد نمونه‌های اقدامات تشکیل شده است.**

```
java:src/main/java/MiniJava/codeGenerator/semantic/SemanticActionFactory.java
```

```Java
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
```

- **در گام سوم، کلاس CheckIdAction را ایجاد می‌کنیم که یک اقدام معنایی را پیاده‌سازی می‌کند که متغیر، متد و کلاس را از پشته معنایی دریافت می‌کند، نام آن‌ها را استخراج می‌کند و بررسی می‌کند که آیا متغیر مورد نظر با توجه به نام کلاس و متد در جدول نمادها تعریف شده است یا نه.**

```
java:src/main/java/MiniJava/codeGenerator/semantic/actions/CheckIdAction.java
```

```Java
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
```

- **در گام چهارم، اقدام به ساخت یک کلاس دیگر برای یک اکشن دیگر می‌کنیم. کلاس AddAction به منظور این ساخته شده است که عملیات جمع (AddAction) را به عنوان یک اقدام معنایی پیاده‌سازی می‌کند.**

```
java:src/main/java/MiniJava/codeGenerator/semantic/actions/AddAction.java
```

```Java
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
```

- **در گام پنجم، کلاس AssignAction نیز برای اکشن دیگری ساخته شده است. این کلاس، بدین منظور ایجاد شده است تا در اقدام معنایی assignment (AssignAction)، ابتدا operand مبدأ و مقصد از پشته معنایی برداشته می‌شوند. نوع داده دو operand بررسی می‌شود و در صورت اختلاف نوع، خطا گزارش می‌شود. در صورت یکی بودن نوع، assignment توسط Facade تولید کد انجام می‌شود.**

```
java:src/main/java/MiniJava/codeGenerator/semantic/actions/AssignAction.java
```

```Java
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
```

- **در نهایت، در گام آخر، در فایل CodeGenerator.java، نیاز است تا متد هایی که مشمول تغییر شده اند را در این بخش نیز تغییر دهیم. توجه داشته باشید که در گام اول، همان متد semanticFunction را باید تغییر دهیم که تمام عملیات به خاطر طولانی بودن آن بوده است. توابع دیگری همچون checkID، pid و add نیز تغییر جزئی خواهند داشت:**

```
java:src/main/java/MiniJava/codeGenerator/CodeGenerator.java
```

```Java
//سایر کد مشابه قبل است...
import MiniJava.codeGenerator.semantic.SemanticActionFactory;

public class CodeGenerator {
    private SemanticStackFacade stackFacade;
    private CodeGenerationFacade codeFacade;
    private Scanner scanner;
    private SymbolTable symbolTable;

    public CodeGenerator() {
        this.stackFacade = new SemanticStackFacade();
        Memory memory = new Memory();
        this.codeFacade = new CodeGenerationFacade(memory);
        this.scanner = new Scanner(System.in);
        this.symbolTable = new SymbolTable(memory);
    }

    public void semanticFunction(int func, Token next) {
        try {
            SemanticAction action = SemanticActionFactory.getAction(func);
            action.execute(next, stackFacade, codeFacade, symbolTable);
        } catch (IllegalArgumentException e) {
            ErrorHandler.printError("Unknown semantic action: " + func);
        } catch (Exception e) {
            ErrorHandler.printError("Error executing semantic action " + func + ": " + e.getMessage());
        }
    }

    @Deprecated
    public void checkID() {
        SemanticActionFactory.getAction(1).execute(null, stackFacade, codeFacade, symbolTable);
    }

    @Deprecated
    public void pid(Token next) {
        SemanticActionFactory.getAction(2).execute(next, stackFacade, codeFacade, symbolTable);
    }

    @Deprecated
    public void add() {
        SemanticActionFactory.getAction(3).execute(null, stackFacade, codeFacade, symbolTable);
    }

    //سایر کد مشابه قبل است...
}
```

---

## بازآرایی ۳: جدا کردن پرس‌وجو از تغییر‌دهنده (Separate Query from Modifier)

### توضیح:

متد saveMemory() همزمان هم وضعیت کد را تغییر می‌داد (با اضافه کردن به codeBlock) و هم یک مقدار (آدرس) برمی‌گرداند. این موضوع اصل «جدا کردن فرمان از پرس‌وجو» (Command-Query Separation) را نقض می‌کند. با جداسازی این موارد، کد قابل پیش‌بینی‌تر، تست‌پذیرتر و بدون عوارض جانبی در متدهای پرس‌وجو خواهد شد.

### پیاده‌سازی:

در فایل:

```
java:src/main/java/MiniJava/codeGenerator/Memory.java
```

دو متد مجزا جایگزین متد ترکیبی شده‌اند:

```Java
/**
 * پرس‌وجو: بازگرداندن شماره فعلی دستور کد بدون تغییر وضعیت
 */
public int getCurrentCodeAddress() {
    return codeBlock.size();
}

/**
 * تغییر‌دهنده: رزرو یک اسلات کد برای استفاده‌ی آینده
 */
public void reserveCodeSlot() {
    codeBlock.add(new _3AddressCode());
}

/**
 * @deprecated استفاده از getCurrentCodeAddress() سپس reserveCodeSlot() به جای این متد توصیه می‌شود
 */
@Deprecated
public int saveMemory() {
    int currentAddress = getCurrentCodeAddress();
    reserveCodeSlot();
    return currentAddress;
}
```

---

## بازآرایی ۴: زمینه خود-کپسوله (Self-Encapsulated Field)

### توضیح:

کلاس \_3AddressCode در ابتدا تمام فیلدهای خود را به صورت عمومی در دسترس قرار می‌داد که این موضوع با اصول کپسوله‌سازی مغایرت دارد. با خصوصی کردن فیلدها و ایجاد متدهای getter و setter، از وضعیت داخلی شیء محافظت می‌شود و امکان اضافه کردن اعتبارسنجی یا منطق تجاری در آینده بدون تغییر کد کاربر فراهم می‌گردد.

### پیاده‌سازی:

در فایل:

```
java:src/main/java/MiniJava/codeGenerator/_3AddressCode.java
```

ساختار کلاس به صورت زیر تغییر داده شده است:

```Java
package MiniJava.codeGenerator;

public class _3AddressCode {
    private Operation operation;
    private Address operand1;
    private Address operand2;
    private Address operand3;

    public _3AddressCode() {
    }

    public _3AddressCode(Operation operation, Address operand1, Address operand2, Address operand3) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
    }

    // متدهای دسترسی (getter)
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

    // متدهای تنظیم مقدار (setter)
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

```

همچنین در کلاس Memory جهت ایجاد نمونه‌های جدید از متدهای سازنده جدید استفاده شده است:

```
java:src/main/java/MiniJava/codeGenerator/Memory.java
```

```Java

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

// ... بقیه متدها بدون تغییر ...

```

---

## بازآرایی ۵: استخراج متد (Extract Method)

### توضیح:

در کلاس CodeGenerator الگوهای تکراری برای عملیات‌های جبری مانند add()، sub() و mult() وجود داشت. با استخراج منطق مشترک به متدهای قابل استفاده‌ی مجدد، تکرار کد کاهش یافته، نگهداری آسان‌تر شده و خوانایی با بیان مستقیم هدف هر متد، بهبود می‌یابد.

### پیاده‌سازی:

در فایل:

```
java:src/main/java/MiniJava/codeGenerator/CodeGenerator.java
```

الگوهای تکراری در متدهای جمع، تفریق و ضرب و همچنین مقایسه‌ها به متد عمومی تبدیل شدند:

```Java
public class CodeGenerator {

    /**
     * اعتبارسنجی صحیح بودن نوع متغیرها برای عملیات جبری
     */
    private void validateIntegerOperands(Address operand1, Address operand2, String operationName) {
        if (operand1.getVarType() != varType.Int || operand2.getVarType() != varType.Int) {
            ErrorHandler.printError("Type mismatch in " + operationName + " operation");
        }
    }

    /**
     * انجام یک عملیات جبری دوتایی و اضافه کردن نتیجه به پشته معنایی
     */
    private void performBinaryArithmeticOperation(Operation operation, String operationName) {
        Address secondOperand = ss.pop();
        Address firstOperand = ss.pop();

        validateIntegerOperands(firstOperand, secondOperand, operationName);

        Address tempResult = new Address(memory.getTemp(), varType.Int);
        memory.add3AddressCode(operation, firstOperand, secondOperand, tempResult);
        ss.push(tempResult);
    }

    /**
     * انجام یک عملیات مقایسه دوتایی و اضافه کردن نتیجه به پشته معنایی
     */
    private void performBinaryComparisonOperation(Operation operation, String operationName) {
        Address secondOperand = ss.pop();
        Address firstOperand = ss.pop();

        validateIntegerOperands(firstOperand, secondOperand, operationName);

        Address tempResult = new Address(memory.getTemp(), varType.Bool);
        memory.add3AddressCode(operation, firstOperand, secondOperand, tempResult);
        ss.push(tempResult);
    }

    // متدهای بازآرایی‌شده
    public void add() {
        performBinaryArithmeticOperation(Operation.ADD, "addition");
    }

    public void sub() {
        performBinaryArithmeticOperation(Operation.SUB, "subtraction");
    }

    public void mult() {
        performBinaryArithmeticOperation(Operation.MULT, "multiplication");
    }

    public void lessThan() {
        performBinaryComparisonOperation(Operation.LT, "less than comparison");
    }

    public void equal() {
        performBinaryComparisonOperation(Operation.EQ, "equality comparison");
    }

}

```

---

## بازآرایی ۶: جایگزینی اعداد جادویی با ثابت‌های نامگذاری‌شده

### توضیح:

وجود اعداد جادویی در کد باعث کاهش خوانایی و نگهداری‌پذیری می‌شود. با استخراج این اعداد به صورت ثابت‌های نامگذاری‌شده، خودمستندسازی کد بهبود می‌یابد و اعمال تغییرات آینده ساده‌تر می‌شود. این بازآرایی به حذف بوی کد “عدد جادویی” کمک می‌کند و اصل DRY را رعایت می‌کند.

### پیاده‌سازی:

در فایل:

```
java:src/main/java/MiniJava/codeGenerator/MemoryConstants.java
```

کلاس جدیدی به نام MemoryConstants اضافه شده است:

```Java
package MiniJava.codeGenerator;

/**
 * ثابت‌ها برای مدیریت حافظه در تولید کد
 */
public final class MemoryConstants {
    // ثابت‌های مربوط به چینش حافظه
    public static final int TEMP_MEMORY_START_ADDRESS = 500;
    public static final int DATA_MEMORY_START_ADDRESS = 200;
    public static final int WORD_SIZE = 4;

    // مقادیر پیش‌فرض تخصیص حافظه
    public static final int DEFAULT_TEMP_SIZE = 4;
    public static final int DEFAULT_DATA_SIZE = 4;

    // جلوگیری از ایجاد نمونه از کلاس
    private MemoryConstants() {
        throw new AssertionError("Utility class should not be instantiated");
    }
}

```

و در فایل:

```
java:src/main/java/MiniJava/codeGenerator/Memory.java
```

به جای اعداد جادویی، از ثابت‌های تعریف‌شده استفاده شده است:

```Java
package MiniJava.codeGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Memory {
    private ArrayList<_3AddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataIndex;

    // استفاده از ثابت‌های نامگذاری‌شده به جای اعداد جادویی
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

}

```
