package cc.ku.ict.module2.typeconversion;

public class TypeConversionDemoMain {
    public static void main(String[] args) {

        // 1. Implicit Conversion (Type Promotion / Widening):
        // Done automatically by the compiler. the compiler always tries to avoid data loss.
        // Happens when assigning a smaller type to a larger type (no data loss) or
        // when different types appear in the same expression.
        // Smaller type is automatically promoted to a larger type (no data loss).
        // The order of Java numeric types from smallest to largest:
        // byte → short → int → long → float → double
        int i = 100;          // int is 32-bit
        double d = i;         // int → double (automatic widening)
        System.out.println("Implicit Conversion:");
        System.out.println("i = " + i); // 100
        System.out.println("d = " + d); // 100.0

        // 2. Explicit Conversion (Narrowing / Casting)
        // Done manually by the programmer using a cast operator (type).
        // Required when assigning a larger type to a smaller type (possible data loss).
        // The programmer is responsible for any potential data loss.
        double d2 = 9.78;
        int i2 = (int) d2;    // explicit cast double → int
        System.out.println("\nExplicit Conversion:");
        System.out.println("d2 = " + d2); // 9.78
        System.out.println("i2 = " + i2); // 9 (fractional part is lost after converting to int)

        // 3. Mixed Expressions and Promotion
        // In arithmetic, byte/short/char are promoted to int before calculation.
        byte a = 10;
        byte b = 20;
        // byte result = a + b; //  Compile error: a+b is promoted to int
        int result = a + b;    //  must be stored in int
        System.out.println("\nMixed Expression Promotion:");
        System.out.println("result = " + result); // 30

        // 4. Casting with Overflow
        // Narrowing to a smaller type can cause overflow (value wraps around).
        int big = 130;
        byte small = (byte) big;  // narrowing with overflow
        System.out.println("\nCasting with Overflow:");
        System.out.println("big = " + big);     // 130
        System.out.println("small = " + small); // -126 (overflow)

        // 5. Numeric Literals with Suffix
        // Suffixes define literal type: F for float, L for long, D optional for double.
        float f = 3.14F;        // 'f' or 'F' required (otherwise 3.14 is double)
        long l = 3000000000L;  // 'L' required (otherwise too big for int)
        double d3 = 2.5d;       // 'd' or 'D' optional (double is default)
        System.out.println("\nNumeric Literals with Suffix:");
        System.out.println("f = " + f); // 3.14
        System.out.println("l = " + l); // 10000000000
        System.out.println("d3 = " + d3); // 2.5

        // 6. Length of types
        // The order of Java numeric types from smallest to largest: byte → short → int → long → float → double


        // int / int → integer division first, then widened if assigned to double.
        int num1 = 5;
        int num2 = 2;
        double div1 = (float)num1 / num2;      // int division → 2, then widened → 2.0
        double div2 =  num1 / num2; // cast before division → 2.5
        System.out.println("\nInteger Division stored in Double:");
        System.out.println("num1 / num2 (as double) = " + div1); // 2.0
        System.out.println("(double)num1 / num2 = " + div2);     // 2.5


        // Mixed int and long
        long l1 = 10L;
        int i1 = 4;
        long result1 = l1 + i1;              // int promoted to long → 14
        System.out.println("\nMixed int + long:");
        System.out.println("l1 + i1 = " + result1);

        // Mixed int and float
        float f1 = 3.5f;
        int ii2 = 2;
        float result2 = f1 + i2;             // int promoted to float → 5.5
        System.out.println("\nMixed int + float:");
        System.out.println("f1 + i2 = " + result2);

        // Mixed long and double
        double d1 = 2.5;
        long l2 = 4L;
        double result3 = d1 + l2;            // long promoted to double → 6.5
        System.out.println("\nMixed long + double:");
        System.out.println("d1 + l2 = " + result3);

        // Mixed float and double
        float f2 = 1.2f;
        double dd2 = 3.4;
        double result4 = f2 + dd2;            // float promoted to double → 4.6
        System.out.println("\nMixed float + double:");
        System.out.println("f2 + d2 = " + result4);
    }
}