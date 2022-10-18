# Let's Learn Scala!

Hello! My name is Kiki Regan and this tutorial will walk you through the basics of [Scala](https://scala-lang.org/), a combination of object-oriented and functional programming languages. It can be installed and used on macOS, Windows, and Linux. 

## Why Scala?

Scala has been described as a "compiler-based, multi-paradigm computer programming language" designed to address issues with Java[^1]. Its combination of object-oriented as well as functional programming make it much more scalable than languages like Java, and its ability to handle huge amounts of data makes it an important player in the data science realm. As someone interested in data science with a background in Java, Scala seemed like the perfect language to explore.

Some of the advantages of Scala include:
- JVM (Java Virtual Machine; Java) — Because it runs over JVM, Scala is compatible with all existing Java programs[^2].
- Compiled language — it's fast and efficient[^2]. 
- Object-oriented and functional — leverages both the best parts of Java and the best parts of functional programming languages[^3].
- Big Data — unlike Java, Scala's "concise syntax and immutable data" allow for major data exports involving a huge amount of data[^1].
- Interoperable — Scala can work alongside many different languages[^1].

On the other hand, Scala is extensive and complex with multiple solutions to one issue[^3]. It can be tricky to learn if you aren't coming from an object-oriented programming background. That said, it's a good language to explore, particularly for those in IT or data science fields!

## Installing Scala
To install Scala, you need a few different things
1. Scala itself
2. A compiler to convert the human-readible source code to machine language
3. An IDE (Integrated Development Environment) to type your code in

I used [this tutorial](https://docs.scala-lang.org/getting-started/index.html) to install Scala using Homebrew, which I'll describe in this tutorial. In your computer's terminal, run the following prompt to install the Scala installer, following the on-screen prompts:
```
brew install coursier/formulas/coursier && cs setup
```
If you *don't* use Homebrew, run the following:
```
curl -fL https://github.com/coursier/launchers/raw/master/cs-x86_64-apple-darwin.gz | gzip -d > cs && chmod +x cs && (xattr -d com.apple.quarantine cs || true) && ./cs setup
```
This will install a JVM (Java Virtual Machine) as well as standard Scala tools, including the compiler, taking care of requirements 1 and 2 (and a few other things as well).

Next, you'll need an IDE to actually start programming. I used [IntelliJ](https://www.jetbrains.com/idea/) (as recommended in [this tutorial](https://docs.scala-lang.org/getting-started/intellij-track/building-a-scala-project-with-intellij-and-sbt.html)). Once installed, you can create your first file!

## \"Hello World\" in Scala!

### Creating a project

To print "Hello World" in Scala, you'll first need to create a project[^4]. Open IntelliJ and click "Create New Project". On the *left* panel, select Scala. On the *right* panel, select **sbt**[^5]. Click "Next" and name the project whatever you would like. 

***Note**: make sure the JDK version is 1.8 and the sbt version is at least 0.13.13.*

Choose *use-auto-import* and select *finish*. You now have a Scala project!

### Creating a package and class

Next, you'll need to create a package inside of your project as well as a class inside of your package to type your code in[^4]. 

1. Expand `your_project_name` -> `src` -> `main`
2. Right-click `scala` and select **New** -> **Package**
3. Name the package and click **OK**
4. Right-click the package you just created and select **New** -> **Scala class** (If this isn't an option, right-click your project, click **AddFrameworksSupport**, and select **Scala**)
5. Name the class **Main** and change kind to **Object**

Now you have a class, inside of a package, inside of your very first Scala project! Here's a very basic example of a program that prints "Hello, World!":
```
object Hello extends App {
  println("Hello, World!")
}
```
In the above example, `Hello` is the name of the class and `extend App` is used to turn the object into an executable program. Now that we have the code written, let's execute it!

### Running your code

Right-click on your class (in the above example it's `Hello`) and select **Run**. Now you've written and executed your first bit of Scala code!

## (Some) Scala syntax

A more accurate title to this section might be "Scala VS Java Syntax". Here are some of the key differences between the two languages[^6]:
1. Scala uses both `val` and `var`; 'val' is *immutable*, or cannot be changed, while *var* can be changed. `val` is similar to `final` in Java.
2. Additionally, Scala does require type declaration, but it comes after the variable name. For example:
```
// Java
Animal a = getAnimal();

// Scala
val a: Animal = getAnimal();
```
3. Type declarations can *usually* be omitted. This is why type declaration comes last. Unlike Java, the following would execute just fine:
```
val a = getAnimal();
```
4. Semicolons are not needed to denote the end of a line and are typically used when there are multiple statements on the same line.

There are many, many more syntax notes that could be included here, but this should offer a decent start.

Comments are the same in both Scala and Java (`// to comment single lines, /* */ for multiple`). 

## Data Types and Naming Conventions

Like any programming language, Scala has a total of 40 reserved keywords[^7]. These cannot be used for regular variables, which have their own rules and conventions. 

### Variable name rules and conventions

The following rules and conventions come from Datacamp[^8]:

1. Variable names **must** begin with a letter and cannot begin with a number or any other character
2. White space is **not allowed**
3. They can contain dollar signs ($) and underscores (_) but no other special characters are allowed (&, %, #, etc.), however, underscores are discouraged.
4. They *should* follow camelcase; start with a lowercase character and capitalize the beginning of other words/parts of the variable (for example, nameOfMyVariable)
5. Should not contain reserved words/keywords 

### Statically, strongly typed

In addition, Scala is **statically typed**. This usually means that "variable types are explicitly declared and thus compiled at run time"[^9]. Scala, however, uses **type inference** to create variables without explicitly declaring their type. For example:

```
val x = 10
val y = 4.2
val z = "cat"
```

You also have the option of declaring a variable's data type:

```
val x : Int = 10
val y : Double = 4.2
val z : String = "cat"
```

Although this makes Scala *feel* dynamically typed, it's still considered statically typed because the type of the variable is known at run time. This is nice because type errors are caught by the IDE or compiler rather than at runtime (what happens with dynamically typed languages)[^10].

Scala is also **strongly typed**. Tom Anderson from Stack Overflow said it best: "every expression has a type which can be determined at compile time, and only operations appropriate to that type are allowed"[^11]. This usually goes hand-in-hand with statically typed languages but there are some exceptions. 

### Mutable, immutable and lazy variables

Scala also has both mutable and immutable variables. Variables that begin with `var` are **mutable** and their value can be changed. Those that begin with `val`, however, cannot have their values changed. Here is an example:

```
// This will compile
var a : Int = 0
a++

// This will not
val a : Int = 0
// a++
```

Scala also has **lazy initialization**! Lazy variables are only initialized once, even if the function is run multiple times. It can only be used with immutable variables[^12]. Although it can be used with simple variables as seen above, here's a more complex example where you can see what lazy val is actually doing (code snippet from [IncludeHelp.com](https://www.includehelp.com/scala/lazy-val.aspx#:~:text=Scala%20programming%20language%20allows%20the%20user%20to%20initialize,is%20first%20used%20or%20accessed%20in%20the%20code.)):

```
lazy val newBlock = {
  println("This will be printed only in case of first initialization.")
  "Hello!"
}

println("The block is not initialized yet")

println("First call:")
println(newBlock)

println("Second call:")
println(newBlock)

// Output:
> The block is not initialized yet
> First Call: 
> This will be printed only in case of first initialization.
> Hello!
> Second Call: 
> Hello!
```

The purpose of a lazy variable is to save memory. If something only needs to be used once, why take up memory any more than that?

### Operators and data types

In scala, **all operators are methods**, and the operators themselves are shorthand to call those methods[^13]. When two numbers are added using '+', Scala is actually invoking the '+' method. Operators can be called using '+' alone or using the dot notation, '.+()':

```
assert(1 + 2 == 3)    // True
assert(1.+(2) == 3)   // True
```

Additionally, any method in Scala can be used as an operator using the dot notation[^13]:

```
assert("Scala".charAt(0) == 'S')
```

Scala has all of the same basic operators as Java with slight differences in the way they work[^13]. The following binary oeprators can be used with numeric data types:

- Addition `+`
- Subtraction `-`
- Multiplication `*`
- Division `/`
- Remainder `%`

In addition, Scala has *unary operators* that can determine whether a number is positive or negative:

- `unary_+` (to determine whether it is positive)
- `unary_-` (to determine wheteher it is negative)

You can also include '-' or '+' before a value to make a value positive or negative:

```
val num = 10
assert(-num == -10)
assert(10 + -num == 0)
```

Relational operators in Scala:

- Greater than `>`
- Less than `<`
- Greater than or equal to `>=`
- Less than or equal to `<=`

Negation (!) can also be used before a value.

Logical operators in Scala:

- And `&&`
- Or `||`

Both of these are short-circuit operators. Bitwise operators (& and |) **do not** short circuit. Finally, equality (==) is the same in Scala as in Java.

Scala can also accomodate mixed-type operations. Arithmetic operations can be used with integers and doubles without type casting. Also, much like in Java, integers, doubles, and booleans can be concatenated inside of a print statement with '+' without type casting.

## Conditionals and booleans

In Scala, boolean values are stored as `true` and `false`. Scala uses the followign conditional statements:

- if
- if-else
- nested if-else
- if-else ladder

Many conditionals work the same way in Scala as they do in Java. The following examples are borrowed from [GeeksforGeeks](https://www.geeksforgeeks.org/scala-decision-making-if-if-else-nested-if-else-if-else-if/#:~:text=The%20conditional%20statements%20of%20Scala%20are%3A%20if%3B%20if-else%3B,then%20that%20block%20of%20code%20will%20not%20execute.):

###if

``` cadence
// Scala program to illustrate the if statement
object Test {
      
// Main Method
def main(args: Array[String]) {
      
    // taking a variable
    var a: Int = 50
  
    if (a > 30) 
    {
        // This statement will execute as a > 30
        println("GeeksforGeeks")
    }
}
}
```
Output:
```
GeeksforGeeks
```

### if-else
``` cadence
// Scala program to illustrate the if-else statement
object Test {
      
// Main Method
def main(args: Array[String]) {
      
    // taking a variable
    var a: Int = 650
  
    if (a > 698) 
    {
        // This statement will not execute as a > 698 is false
        println("GeeksforGeeks")
    }
      
    else
    { 
        // This statement will execute
        println("Sudo Placement")
    }
}
}
```
Output
```
Sudo Placement
```

### nested if-else

``` cadence
// Scala program to illustrate the nested if-else statement
object Test {
      
// Main Method
def main(args: Array[String]) {
      
    // taking three variables
    var a: Int = 70
    var b: Int = 40
    var c: Int = 100
  
    // condition_1
    if (a > b) {
        // condition_2
        if(a > c) {
            println("a is largest");
        }  
        else {
            println("c is largest")
        }    
    }
      
    else { 
         // condition_3
        if(b > c) {
            println("b is largest")
        }  
        else {
            println("c is largest")
        }
    }
}
}
```
Output:
```
c is largest
```

### if-else ladder

``` cadence
// Scala program to illustrate the if-else-if ladder 
object Test {
      
// Main Method    
def main(args: Array[String]) {
      
    // Taking a variable
    var value: Int = 50
  
    if (value == 20) 
    {
        // print "value is 20" when above condition is true
        println("Value is 20")
    } 
      
    else if (value == 25) {
        // print "value is 25" when above condition is true
        println("Value is 25")
    } 
    
    else if (value == 40) {
        // print "value is 40" when above condition is true
        println("Value is 40")
    } 
    
    else {
        // print "No Match Found" when all condition is false
        println("No Match Found")
    }
}
}
```
Output:
```
No Match Found
```

Notice that, as with Java, Scala 2 deliminates blocks of code with curly brackets. In Scala 3, curly brackets in if-else statements are replaced with the reserve word `then`; indentation is essential. You can still use Scala 2 formatting in Scala 3, but not the other way around. Here is an example of Scala 3 formatting using the most recent if-else ladder example above:

``` cadence
def main(args: Array[String]) 

    var value: Int = 50
  
    if (value == 20) then
        println("Value is 20")
    else if (value == 25) then
        println("Value is 25")
    else if (value == 40) then
        println("Value is 40")
    else 
        println("No Match Found")
```

## Short-circuiting

Logical operators such as `&&` and `||` are short-circuit operators; expressions with either operator do not always evaluate both of its operands[^13]. Here is an example from [Baeldung](https://www.baeldung.com/scala/operators-intro#:~:text=As%20we%20can%20see%2C%20%26%20evaluates%20both%20sides,data%20types.%20Scala%20has%20the%20following%20bitwise%20operators%3A):

``` cadence
def printTrue() : Boolean = {
  println("true");
  true
}

def printFalse() : Boolean = {
  println("false"); 
  false
}

val result1 = printFalse() && printTrue() // only "false" is printed
assert(result1 == false)
val result2 = printTrue() && printFalse() // "true" and "false" are printed
assert(result2 == false)
```

In the example above, `result1` only prints `false` because the first operand in the *and* statement is false, therefore the entire statement can never be true; there's no need to execute the second function. In the second example, `result2`, both are executed because the first statement is `true`; the program needs to execute the second function as well to ensure that the entire statement is true. 

Bitwise operators (`&` and `|`), on the other hand, **do not** short circuit. If you want to execute both operands in a statement, use bitwise operators.

## Dangling else

According to [GeeksforGeeks](https://www.geeksforgeeks.org/dangling-else-ambiguity/#:~:text=The%20dangling%20else%20problem%20in%20syntactic%20ambiguity.%20It,with%20which%20%E2%80%9C%20if%20%E2%80%9D%20it%20should%20combine.), "the dangling else problem in syntactic [ambiguity](https://www.geeksforgeeks.org/removal-of-ambiguity-converting-an-ambiguos-grammar-into-unambiguos-grammar/)... occurs when we use *nested if*. When there are multiple *'if'* statements, the *'else'* part doesn't get a clear view with which *'if'* it should combine"[^14].

Here's an example[^14]:

``` cadence
if (condition) {
}
if (condition 1) {
}
 if (condition 2) {
}
   else
   {
       }
```

In the example above, it's not clear where the `else` should be applied to. This "dangling else" can lead to issues with your program because it can execute when not appropriate. To avoid the dangling else, be sure to either a) nest your if-statements inside of each other or b) use the if-else ladder. Here are some examples:

a) nesting your if statements

``` cadence
if (condition) {
     if (condition 1) {
          if (condition 2) {}
}
}
 else {
 }
```

b) using the if-else ladder

``` cadence
if(condition) {
}
else if(condition-1) {
}
else if(condition-2){
}
else{
}
```

## Pattern matching

Scala does not have switch statements. Instead, it uses **pattern matching**, a "mechanism for checking a value against a pattern"[^15]. Pattern matching is a more powerful version of the switch statement and can also be used instead of if/else statements. Match expressions have a value, the `match` keyword, and at least one `case` clause. This is what the syntax should look like[^15]:

*Note that Scala 3 will look the same, just without the curly brackets.*

``` cadence
import scala.util.Random

val x: Int = Random.nextInt(10)

x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
}
```

Much like a switch statement, the value of x is sent into this function and compared to each case, returning the value on the right hand side. Scala does not have `break` or `continue`, so loops and pattern matching require some more thinking[^16]. 



[^1]: Source: https://www.sdgyoungleaders.org/blog/what-is-scala-a-brief-guide/
[^2]: Source: https://codersera.com/blog/what-is-scala-used-for-a-brief-overview/
[^3]: Source: https://searchteam.eu/what-is-scala-programming-language-used-for/
[^4]: Source: https://docs.scala-lang.org/getting-started/intellij-track/building-a-scala-project-with-intellij-and-sbt.html
[^5]: "sbt is a popular tool for compiling, running, and testing Scala projects of any size" from https://docs.scala-lang.org/getting-started/intellij-track/building-a-scala-project-with-intellij-and-sbt.html
[^6]: Source: https://itnext.io/scala-syntax-for-java-developers-69734ce17cdf
[^7]: Source: https://scalaexplained.github.io/scala-explained/keywords.html#:~:text=Reserved%20keywords%20are%20words%20that%20have%20a%20special,each%20use%20case%20there%20is%20a%20concise%20explanation.
[^8]: Source: https://www.datacamp.com/tutorial/variables-in-scala
[^9]: Source: https://www.techopedia.com/definition/22321/statically-typed
[^10]: Source: https://blog.insightdatascience.com/a-newbies-guide-to-scala-and-why-it-s-used-for-distributed-computing-979070a9f8
[^11]: Source: https://stackoverflow.com/questions/17072179/difference-between-strongly-and-weakly-typed-languages
[^12]: Source: https://www.includehelp.com/scala/lazy-val.aspx#:~:text=Scala%20programming%20language%20allows%20the%20user%20to%20initialize,is%20first%20used%20or%20accessed%20in%20the%20code.
[^13]: Source: https://www.baeldung.com/scala/operators-intro#:~:text=Scala%20has%20following%20arithmetic%20binary%20operators%20available%20for,Multiplication%20%28%2A%29%204%20Division%20%28%2F%29%205%20Remainder%20%28%25%29
[^14]: Source: https://www.geeksforgeeks.org/dangling-else-ambiguity/#:~:text=The%20dangling%20else%20problem%20in%20syntactic%20ambiguity.%20It,with%20which%20%E2%80%9C%20if%20%E2%80%9D%20it%20should%20combine.
[^15]: Source: https://docs.scala-lang.org/tour/pattern-matching.html
[^16[: Source: https://softwareengineering.stackexchange.com/questions/259883/why-does-scala-have-return-but-not-break-and-continue#:~:text=Scala%20does%20not%20have%20break%20or%20continue%2C%20so,can%20be%20accomplished%20in%20better%2C%20less%20surprising%20ways.
