# Hands-on Exercise 1

## Tasks

1. Define a package named `xy.module4.exercises.exercise1`.
2. Download the existing shape application given in `/module4/inheritance/` here.
3. Make the necessary adjustments to include a new Square class.
4. Modify the shape classes to support positioning in a 3-dimensional space. Add a new instance
   variable z for the third dimension and make any necessary changes to methods and constructors.
5. Add a method that calculates the perimeter.
6. Modify the `main()` method accordingly.


***

# Hands-on Exercise 2: Inheritance with User, Customer, and Employee

## Learning Objective
- Understand and practice **inheritance** in Java.
- Model real-world entities into classes and implement relationships.
- Observe how subclasses can extend functionality of a superclass.



## Requirement List
We want to design a system that keeps information about **users**, **customers**, and **employees**.

- A **User** has:
    - `id`
    - `name`
    - `email`
    - `username`
    - `password`
    - `role`

- A **Customer** is a **User** who additionally has:
    - `loyaltyPoints`

- An **Employee** is a **User** who additionally has:
    - `salary`
    - `department`

<img src="../../resources/inheritance-exercise.png" width="800">

## Tasks

1. Define a package named `cc.ku.ict.module4.exercises.exercise2`.

2. **Define Classes**
    - `User` (base class)
    - `Customer` (derived class)
    - `Employee` (derived class)

3. **Constructor Chaining**
    - Define constructors.
    - Use `super(...)` in `Customer` and `Employee` to initialize inherited attributes.

4. **Method Overriding**
    - Override `toString()` in `User`, `Customer`, and `Employee` to display relevant object's data.

5. **Testing**
    - Instantiate objects of `User`, `Customer`, and `Employee` in a main method.
    - Print their details.
    - Observe **inheritance** and **method overriding** in action.

## Additional Challenge
- Add a new method in `Customer` to update loyalty points.
- Add a new method in `Employee` to increase salary by a given percentage.
- Test these methods in your main class.
- Generate a UML class diagram that visualizes the classes and their interactions. 

***






# Hands-on Exercise 3: Extending Exercise 2 (User, Customer, and Employee with Associations)

## Learning Objective
- Apply **inheritance** concepts from Exercise 2.
- Practice **association** relationships between classes.
- Understand how objects interact in real-world scenarios.



## Requirement List
Extend the system from **Hands-on Exercise 2** to include additional entities and relationships:

1. Extend the `User` class from Exercise 2 as `ExtendedUser` without modifying the original User class.

2. **Address**
    - Each User has one Address.
    - Use a **unidirectional one-to-one** association: User knows Address, but Address does not know User.

3. **Image**
    - Each User can have multiple images (profile pictures, gallery).
    - Use a **unidirectional one-to-many** association: User knows its Images.

<img src="../../resources/relationships-exercise.png" width="800">


## Tasks

1. Define a package named `cc.ku.ict.module4.exercises.exercise3`.
2. Extend the `User` class from Exercise 2 as `ExtendedUser` without modifying the original User class.

2. **Enhance Classes**
    - Add `Address` class.
    - Update `ExtendedUser` to include a single `Address`.
    - Add `Image` class with attributes id,url,title, and size, including relevant methods.
    - Update `ExtendedUser` to include multiple `Image` objects.

2. **Constructor and toString**
    - Use constructor chaining with `super(...)` for derived class.
    - Override `toString()` methods to include association info.

3. **Testing**
    - Instantiate an ExtendedUser object.
    - Assign an Address to the user.
    - Assign multiple Images to the user.
    - Print all objects to show inherited properties and associations.
   
4. Debug your application using an appropriate debugger. Your debugging should include:

- At least one **breakpoint** 
- Use of **Step Over**, **Step Into**, and **Step Out**
- Inspection of variables using the **Variables panel** or **Watches**



## Additional Challenge
- Add methods to add/remove Images from a ExtendedUser.
- Print ExtendedUser details to see all associated Address and Images.








# Hands-on Exercise 4: Building an Extensible User Profile System with Interfaces

## Scenario

You are working on a **user profile module** for a social platform. Each user has a home address and a collection of 
profile images. The product team has already announced that new kinds of addresses (home, office) and new kinds of 
images (encrypted, cloud-hosted, ...) will be added over the next releases.

Your job is to design the module so that **these features can be added later without modifying existing, tested code**.

![](../../resources/images/exercise4.png)

## Learning Objectives

After completing this exercise, you should be able to:

- Reinforce inheritance and association from Exercise 3.
- Apply the **Dependency Inversion Principle (DIP)**: high-level classes depend on interfaces, not on concrete classes.
- Use **polymorphism** to treat different implementations through one interface type.
- Extend the system using the **Open/Closed Principle (OCP)**: open for extension, closed for modification.

## Part 1: Refactor Exercise 3

1. Copy all files from Exercise 3 into the package `cc.ku.ict.module4.exercises.exercise4`.

2. Define the interfaces and make the existing classes implement them:

   | Interface | Methods | Implemented by |
      |---|---|---|
   | `IAddress` | `String getInfo()` | `Address` |
   | `IImage` | `String getInfo()`, `String getFileName()` | `Image` |

   Use the same method name (`getInfo()`) in the interface and all implementing classes.

3. Update `ExtendedUser` so that it depends **only on the interfaces**:
   - One-to-one, unidirectional association with `IAddress`.
   - One-to-many, unidirectional association with `List<IImage>`.
   - No import or mention of `Address` or `Image` anywhere in `ExtendedUser`.
4. Add `addImage(IImage image)` and `removeImage(IImage image)` to `ExtendedUser`.
5. Use constructor chaining: call `super(...)` for inherited properties, and initialize `address` and the `images` list in the derived class.

6. Override `toString()` in all classes. In `ExtendedUser`, build the output by calling `getInfo()` on the associated `IAddress` and on every `IImage`; do not check the concrete type.

## Part 2: Add Behaviour Using the Interfaces

Define a new class `ProfileReport` that generates a text summary of a user:

```java
public class ProfileReport {
    public String generate(ExtendedUser user) { ... }
}
```

The report must list the user's name, the address info, and the info of each image. It must work for **any** `IAddress` 
and `IImage` implementation through polymorphism, with no `instanceof` checks and no casting.

## Part 3: Extend Without Modifying (OCP)

The product team requests the following features. Implement them **only by adding new classes**.

1. `EncryptedImage` implements `IImage`
   - Attributes: `encryptionAlgorithm`, `encryptionKey`.
   - `getInfo()` must show the file name and the algorithm. **Do not print the full key** (show only a masked version, 
   e.g. `****a9f2`).

2. `HomeAddress` and `OfficeAddress` implement `IAddress`
   - `HomeAddress`: street, city, postal code.
   - `OfficeAddress`: company name, building, floor, city.


> **Rule:** `ExtendedUser`, `ProfileReport`, `Address`, `Image`, and both interfaces must remain **unchanged** while 
you add Part 3. 

## Part 4: Testing

Write a `Main` (or test) class that:

1. Define  `ExtendedUser` objects.
2. Assigns different address types to them, declared with the interface type:
   ```java
   IAddress home = new HomeAddress(...);
   IAddress office = new OfficeAddress(...);
   ```
3. Gives each user a **mix** of `Image` and `EncryptedImage` objects, declared as `IImage`.
4. Prints each user with `toString()` and with `ProfileReport.generate(...)`.
5. Calls `removeImage()` on one user and prints the report again to show the change.

**Expected output (example format only):**

```text
User: Ali Karimov (ali@example.com)
Address: Home - 12 Abay St, Petropavl, 150000
Images (2):
  1. photo1.jpg - 1920x1080, 340 KB
  2. passport.png - encrypted (AES-256), key: ****a9f2
```
