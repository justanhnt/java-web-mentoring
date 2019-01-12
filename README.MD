# Java Web Mentoring

For mentoring my student/mentee to provide them more information of Java Web Technology.

Learning from ground up:

### Java Core
+ Setting up environment for learning Java:
* Install JDK or OpenJDK for developing Java project.
* Some early problem is mainly used Text Editor, javac tool, to make sure student understanding what to do without IDE.
* Install very good IDE: Intellij CE.

+ Mostly following on NTU open resources for learning Java Core: http://www.ntu.edu.sg/home/ehchua/programming/java/j2_basics.html#zz-10.


### OOP
* Brief concept of OOP: I always tell my student that: OOP is a philosophy, just apply it in the right way.
- Encapsulation (hiding properties/field)
- Inheritance
- Abstraction
- Polymorphism (i.e Father extends Person, Person extends Object : f -> Father; f is Father, either Person and Object at the same time).

* Java OOP: some limitation of Java OOP implementation versus OOP concept.
* Assignment: OOPList interface support Generic type, and sh*tty implementation of OOPLinkedList.

### Concurrent Programing in Java:
*



### Exception Handling in Java
* International Support for Error see more at `com.mentoring.exception.ExceptionCodeHelper`
* Main Class for running in exception in `com.mentoring.exception`
* Using default Logging utils from Java, you can extends to use SFL4J or another lib as well.
```bash
    # Only support VN, EN, you can add more
    sh bin/test_exception.sh <country_code>
    # Input your number to Standard Input
    # i.e: 0 or 1 or another for working normally
```

### Data Structure utils in Java
Java support a lot of beautiful Data Structure such as:
* Collections:
    - `List` interface: `ArrayList`, `LinkedList` as problem in OOP part, ...
    - `Set` interface: `TreeSet`, `HashSet`, ...
* `Map`: `TreeMap`, `HashMap`, `ConcurrentMap`, `ConcurrentHashMap` ...

I already implemented Binary Search in `com.mentoring.searching.SearchCountry`
