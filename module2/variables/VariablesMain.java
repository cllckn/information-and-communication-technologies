package cc.ku.ict.module2.variables; // Define the package (namespace) where this class belongs.
// Helps organize code and avoid class name conflicts.

import java.text.DecimalFormat;
// Imports the DecimalFormat class from the Java library.
// Used for formatting numbers (e.g., rounding or custom number formats).

import java.util.Scanner; // Imports the Scanner class from the Java library.
// Used to read user input (e.g., from the keyboard).

public class VariablesMain {
    public static void main(String[] args) {
        System.out.println();


        // Defining a variable.
        // You must define variables before using them as java is a statically typed language
        // Operating system allocates memory for x in RAM and stores the value 5.
        int x = 5;
        System.out.println("Value of x var is:"+x);

        // Operator Precedence
        // x + 2 is calculated first since + has higher precedence than =,
        // and the result is assigned to the newly declared integer variable y.
        int y = x + 2;
        System.out.println("Value of y:"+y);

        // Instantiating an object from the Scanner class for input from keyboard (System.in)
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        int radius = input.nextInt();  // Reading an int value from the keyboard

        /*  Scanner class member methods

        public byte nextByte()
        public short nextShort()
        public int nextInt()
        public long nextLong()

        public float nextFloat()
        public double nextDouble()

        public String next() // Reads until a space
        public String nextLine() // Reads until a new line is encountered
        */


        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle is:"+area);

        // Ensuring that the area of the circle is printed with 4 decimal places
        DecimalFormat fmt = new DecimalFormat("0.####");
        System.out.println("Area of Circle is:"+fmt.format(area));

    }
}
