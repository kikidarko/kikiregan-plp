# Let's Learn Scala!

Hello! My name is Kiki Regan and this tutorial will walk you through the basics of [Scala](https://scala-lang.org/), a combination of object-oriented and functional programming languages. It can be installed and used on macOS, Windows, and Linux. 

## Why Scala?

Scala has been described as a "compiler-based, multi-paradigm computer programming language" designed to address issues with Java[^1]. Its combination of object-oriented as well as functional programming make it much more scalable than languages like Java, and its ability to handle huge amounts of data makes it an important player in the data science realm. 

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

[^1]: Source: https://www.sdgyoungleaders.org/blog/what-is-scala-a-brief-guide/
[^2]: Source: https://codersera.com/blog/what-is-scala-used-for-a-brief-overview/
[^3]: Source: https://searchteam.eu/what-is-scala-programming-language-used-for/
[^4]: Source: https://docs.scala-lang.org/getting-started/intellij-track/building-a-scala-project-with-intellij-and-sbt.html
[^5]: "sbt is a popular tool for compiling, running, and testing Scala projects of any size" from https://docs.scala-lang.org/getting-started/intellij-track/building-a-scala-project-with-intellij-and-sbt.html
