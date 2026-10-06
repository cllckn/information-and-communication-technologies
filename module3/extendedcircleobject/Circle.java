package cc.ku.ict.module3.extendedcircleobject;

public class Circle {
    // ============================
    // Fields (Attributes / Properties)
    // ============================
    // These describe the state of a Circle object.
    // They are kept private to follow the principle of "encapsulation".
    // Access is provided through getters and setters.
    private int x;        // X coordinate of the circle's center
    private int y;        // Y coordinate of the circle's center
    private int radius;   // Radius of the circle
    private String color; // Color of the circle
    private String label; // NEW: Name/label of the circle

    // ============================
    // Constructors
    // ============================

    // i) No-parameter constructor (Default constructor)
    // Sets default values for all fields, including the new 'label' field.
    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
        this.color = "Black";
        this.label = "Unnamed"; // NEW: default label when none is provided
    }

    // ii) Constructor with x and y only
    // radius, color, and label all fall back to sensible defaults.
    // NEW: 'label' defaults to "Unnamed" here too, via the setter (see below).
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = 1;
        this.color = "Black";
        setLabel(null); // setLabel() will turn a null into "Unnamed" (see setLabel below)
    }

    // iii) Full constructor: initializes all attributes, including label.
    public Circle(int x, int y, int radius, String color, String label) {
        // "this" refers to the current object.
        // Since the parameters and member variables have the same name,
        // we must use "this" to prevent ambiguity (parameter shadowing the field).
        this.x = x;
        this.y = y;
        // Reusing the setters here (instead of direct field assignment) means
        // the same validation rules apply whether a value is set at
        // construction time or changed later.
        setRadius(radius);
        setColor(color);
        setLabel(label);
    }

    // ============================
    // Getters and Setters
    // ============================

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    // Basic validation: a circle can't have a zero or negative radius.
    public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Invalid radius (" + radius + "). Keeping previous value: " + this.radius);
        }
    }

    public String getColor() {
        return color;
    }

    // Guard against null/empty color instead of silently accepting bad data.
    public void setColor(String color) {
        if (color != null && !color.isBlank()) {
            this.color = color;
        } else {
            System.out.println("Invalid color. Keeping previous value: " + this.color);
        }
    }

    // NEW: getter for label
    public String getLabel() {
        return label;
    }

    // NEW: setter for label.
    // Requirement: check for null before assigning, and store the label
    // in uppercase.
    public void setLabel(String label) {
        if (label == null || label.isBlank()) {
            // Falls back to a default instead of storing a null/blank label,
            // the same way setRadius()/setColor() protect against bad state.
            this.label = "UNNAMED";
        } else {
            this.label = label.toUpperCase();
        }
    }

    // ============================
    // Other Behaviors
    // ============================

    // Calculates the area of the circle using the formula: pi * r^2
    public double calculateArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    // Calculates the circumference (perimeter) of the circle: 2 * pi * r
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        // UPDATED: now includes 'label' in the output.
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}