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

## بازآرایی ۱: جایگزینی اعداد جادویی با ثابت‌های نامگذاری‌شده

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

---

## بازآرایی ۲: زمینه خود-کپسوله (Self-Encapsulated Field)

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

## بازآرایی ۳: استخراج متد (Extract Method)

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

## بازآرایی ۴: جدا کردن پرس‌وجو از تغییر‌دهنده (Separate Query from Modifier)

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

## بازآرایی ۵: الگوی نما (Facade Pattern) برای عملیات پشته‌ها

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
