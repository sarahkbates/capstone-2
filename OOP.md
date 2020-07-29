Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation

Encapsulation is the process of wrapping code and data together into a single unit, for example, a capsule of medicine that is mixed from several medicines. You can create a fully encapsulated class in java by making all data members of the class private. You can now use setter and getter methods to set and get the data in it. By providing only getters or only setters, you can make the class read only or write only. So you can skip the getter or setter methods depending on what you want. 

This provides control over the data. So, suppose you want to set the value of id which should be greater than 100 onyl. You can write the logic inside your setter method, and you can write the logic not to store the negative numebrs in the setter method.

You can acheive data hiding in java, because other classes will not be able to access the data through the private data members.

Encapsulation is also easy to test, so it's better for unit testing.

Example:

public class Student{
    private String name; //private data member
    public String getName(){ // getter method
        return name;
        }
     public void setName(String name){ //setter method for name
        this.name = name;
       }
 
 class Test{
    public static void main(String[] args){
        Student s = new Student(); //creating isntance
        s.setName("Sarah"); // getting the encapsulated class value of the name member
        System.out.println(s.getName);
        }

In a read only class, there are only getter methods. If the user tries to change the value of the private data member, a compile time error will occur.

In a write only class, there are onyl setter methods. So, you can onyl set the value of private data members, you cannot read them. If you try to access outside of this class, a compile time error will occur.

Access modifiers specify accessibility (scope) of a data member, method, constructor, or class.
    There are 4 types of java access modifiers...
        private: can be accessed within a class, but not within a packagem, outside a package by a subclass, or outside of a package
        default: can be accessed within a class, within a package, but not outside the package by a subclass or outside the package
        protected: can be accessed within a class, within a package, outside a package by a subclass, but not outside of a package.
        public: can be accessed within a class, within a package, outside a package by a subclass, or outside a package.








********************
2. Inheritance

Inheritance is the mechanism where an object gets all properties and behaviors from a "parent" object. The object taking on the properties of the parent is known as the child or sub-class. You can create new classes by expanding an existing class, and you can reuse methods and fields, or add new ones. This is what is known as an IS-A relationship (i.e. the parent-child relationship).

Inheritance can also be used for method overriding (which means runtime polymorphism can happen), and for code reusability. 

In this, a class is a group of objects that have common properties, and is the blueprint from which objects are created. A subclass or child class is a class which extends another class. This can also be called a derrived class or extended class. The super class, or parent class, is where the subclass inherits its features. This can also be called a base class or parent class. 

Reusuability allows you to reuse the fields and methods of an existing class when you create a new one.

The syntax for inheritance is as follows...

class subclass-name extends superclass-name {
//methods and fields
}

Note that the keyword "extends" indicates that the new class is derived from an existing class.

An example...

Programmer is the subclass and Employee is the superclass. Programmer IS-A Employee, so Programmer is a type of Employee.

class Employee{
    float salary = 40000;
    }

class Programmer extends Employee{
    int bonus = 1000;
    
    public static void main (String[] args){
        Programmer p = new Programmer();
        System.out.println("Programmer salary is " + p.salary");
        System.out.println("Bonus of Programmer is " + p.bonus");
 This program allows you to set a base salary, and then change the bonus amount based on the type of employee. Then you can print out the salary and bonus of the programmer. It is not necessary to call salary directly from the Employee class, because all of its properties are being inherited by the Programmer class.
 
 In java, you can use single, multilevel, and heirachical inheritances. Multiple inheritance and hybird inheritance can only be used if an interface is being used. Single inheritance is when Class B is extending Class A. Multilevel inheritance is when Class C is extending Class B and Class B is extending Class A. Heirarchical inheritance is when Class B and Class C both extends Class A. Multiple inheritance is where Class C extends Class A and Class B. And hybrid inheritance is where Class D extends Classes B and C, and Class B and Class C both extend class A.
 
The reason that multiple inheritance is not supported by Java is because it reduces complexity and simplifies the language. Also compile time errors are better than runtime errors, so Java renders a compile time error if you try to inherit more than one class. This is because it creates ambiguity as to which method should be called.







********************
3. Abstraction

Abstraction is when you hide the implementation details and show only functionality to the user. So, it only shows what is essential to the user. An example of this is sending a text message. The user only sees where to type the text and send send the message. The user doens't know the internal process of the message delivery.

Generalization is when you extract shared characteristics from 2 or more classes and combine them into a generalized superclass. Shared characteristics can be attributes, associations, or methods. An example of this is classes PieceOfLuggage and PieceOfCargo partially share the same attributes. During generalization, the shared characteristics are combined to create a new superclass called Freight. PieceOfLuggage and PieceOfCargo become subclasses of Freight. So, the properties that are common to the classes are placed in the new superclass.

Specialization means creating new subclasses from an existing class. If it turns out that certain attributes, associations, or methods only apply to some of the objects, a subclass can be created.

There are 2 ways to achieve abstraction: an abstract class (0% to 100%) and an interface (100%).
    An abstract class can have abstract and non abstract methods, and needs to be extended, and its method implemented...it cannot be instantiated. An abstract class must be decalred with the abstract keyword, can have constructors and static methods, and can have final methods which will force the subclass not to change the body of the method.
    Example:
        abstract class Bike{
            abstract void run();
           }
        class Honda4 extends Bike{
            void run(){
            System.out.println("running safely");
            }
            public static void main(String[] args){
                Bike obj = new Honda4;
                obj.run();
                }
    








********************
4. Polymorphism

Polymorphism is when an object can take many forms, like when a parent class reference is used to refer to a child class object. It can pass more than one IS-A test.

All java objects are polumorphic, because they will pass IS-A for their own type and for the class Object.

In polymorphism you can use method overloading, which is when a class has multiple methods with the same name, but different parameters. If we have to perform only one operation, having the same method name increases readability. 

An example is that you have to perform the addition of the given numbers, but there can be any number of arguments. If you write a method a(int, int) and b(int, int, int) it could confuse the reader as to understanding the behavior of the method because their names differ. 

To overload a method, you can change the number of arguments
    class Adder{
        static int add (int a, int b)
         return a+b
        } // here you have 2 arguments
        
     class TestOVerlaoding{
        public static void main (String[] args){
            System.out.print(Adder.add(11, 11);
            System.out.println(Added.add(11, 11, 11);
            }
   You can also overload a method by changing the data type.
       class Adder{
        static int add (int a, int b)
        return a + b; // 2 arguments of int
        }
       static double add (double a, double b)
       return a + b; //2 arguments of double
       }
       
       class TestOverlaoding{
       public static void main(String[] args){
       System.out.println(Adder.add(11,11);
       System.out.println(Adder.add(12.3, 12.6);
       }
   You can also overload the main() method in Java. 
   
        class TestOverloading{
        public static void main (String[] args){
        System.out.println("main with String[]");
        }
        public static void main(String args){
        System.out.println("main with String");
        }
        public static void main(){
        System.out.println("main without args");
        }
   Method overriding is also possible with Polymorphism. If a subclass has the same method as declared in the parent class, that is method overriding. It is used to provide specific implementation of a method which is already provided by its superclass and is used for runtime polymorphism. The method must have the same name as in the parent class, and must have the same paramater as in the parent class, and there must be an IS-A relationship. 
   
   An example of is this is...
   
        class ABC{
        //overridden method
            public void disp(){
                System.out.println("disp() method of the parent class");
                }
             class Demo extends ABC{
                //overriding method
                public void disp(){
                    System.out.println("disp() method of child class");
                    }
                public void newMethod(){
                    System.out.println("new method of child class");
                    }
                public static void main(String[] args){
                    ABC obj = new ABC();
                    obj.disp();
                    ABC obj2 = new Demo(); //covariance with reference types
                    obj2.disp();
                   }
                   }
This works because you defined method in subclass as defined by parent class with some specific implementation, named and parameter list of methods are the same, and an IS-A relationship exists.

A static method cannot be overriden, because it can be proved by runtime polymorphism. Static methods are bound with a class, whereas instance methods are bound with objects. Static belongs to the class area, and an instance belongs to the heap area.                   
          
   






Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  



