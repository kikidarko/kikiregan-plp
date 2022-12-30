package PLP6content

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

/*
* I know that this task manager could be far more functional in style, but there were
* so many little things that I got caught up on. This is very much a blend of functional
* and object oriented programming (and probably ended up much more object oriented) but
* still, it's been a good introduction to functional programming!
*
* Also, I left some big chunks of comments in here from thoughts I had as I wrote this.
* Although some aren't relevant to the way I've written this project, I thought it might
* be interesting to leave in just to see my thought process.
*/


object Main {

  class Task {
    private var title: String = "";
    private var dueDate: String = "";
    private var priority: Int = 0;
    private var description: String = "";
    private var category: String = "";

    def this(title:String, dueDate:String, priority:Int, description:String, category:String){
      this()
      this.title = title
      this.dueDate = dueDate
      this.priority = priority
      this.description = description
      this.category = category
    }

    def this(dueDate:String){
      this()
      this.dueDate = dueDate
    }

    def getTitle(): String = return title;
    def getDueDate(): String = return dueDate;
    def getPriority(): Int = return priority;
    def getDescription(): String = return description;
    def getCategory(): String = return category;

    def setTitle(t: String): Unit = title = t
    def setDueDate(d: String): Unit = dueDate = d
    def setPriority(p: Int): Unit = priority = p
    def setDescription(d: String): Unit = description = d
    def setCategory(c: String): Unit = category = c

    override def toString(): String ={
      return "Title: " + title + "\nDescription: " + description + "\nDue Date: " + dueDate + "\nCategory: " + category + "\nPriority: " + priority
    }
  }

  //class Tasks() {
    // arraybuffers are mutable and indexed
    // thanks geeksforgeeks!!
    //private var tasks = new ArrayBuffer[Task]()

    // instantiate
    //def this(){
    //  this()
    //  this.tasks = tasks
    //}

    // add new task
    //def add(task:Task): Unit ={
    //  tasks += task
    //}

    //override def toString(): String ={
    //  var s = ""
    //  for (task <- tasks) {
    //    s = s + task.getTitle() + "\n"
    //  }
    //  return s
    //}
  //}

  def runProgram(): ArrayBuffer[Task] = {
    var tasks = new ArrayBuffer[Task]()

    // this is a sample list of tasks for debugging purposes... feel free to delete!
    var task = new Task("PLP6", "Dec 22", 1, "PLP 6 is due!", "CS 330");
    var task2 = new Task(title = "Fly to FL", dueDate = "Dec 17", priority = 2, description = "Fly to FL!", category = "Life")
    var task3 = new Task(title = "Sam's Birthday", dueDate = "Dec 29", priority = 3, description = "Ivor's dad's birthday", category = "Life")
    var task4 = new Task(title = "Christmas", dueDate = "Dec 25", priority = 2, description = "Merry Christmas!", category = "Life")
    var task5 = new Task(title = "Final Project Presentation", dueDate = "Dec 17", priority = 2, description = "Final presentation", category = "CS 330")
    tasks += task += task2 += task3 += task4 += task5

    val desc = "Here are your options:\n" +
      "type A to view all tasks\n" + // print task list
      "type V to view or modify a specific task\n" + // view specific task based on ??
      "type N to create a new task\n" + // enter func to add new task
      "type Q to query: organize and search tasks\n" + // enter func to query based on option from user
      "type D to delete a task\n" + // delete a task
      "type X to exit"
    println("Welcome to Kiki's Awesome Task Manager!")

    // loop until X
    var input = ""
    //breakable {
    while (input.toLowerCase() != 'x') {
      println("\n"+desc+"\n")
      input = readLine()
      input.toLowerCase() match {
        case "a" => viewAllTasks(tasks)
        case "v" => viewTask(tasks) //println("t") // will call viewTask() func
        case "n" => tasks += newTask() // will create new task
        case "q" => query(tasks) //println("q") // will call query() func
        case "d" => delete(tasks)
        case "x" => return tasks//this will bring me ALL the way outside loop... perhaps that is what i want?
        case other => println("Please enter a valid command.")
      }
    }
    //println("Thanks for using Kiki's Awesome Task Manager!\nHere is a list of your tasks: \n" + tasks +"\nGoodbye!")
    return tasks
  }

  def viewTask(tasks:ArrayBuffer[Task]): Unit = {
    if (tasks.isEmpty) {
      println("Oops! Your task list is empty.")
    } else {
      for (x <- tasks) {
        println(tasks.indexOf(x)+1 + ". " + x.getTitle())
      }
      println("Which task do you want to view? Please enter the task number. ")
      var taskNum = readInt()-1
      print(tasks(taskNum))
      println("\nWould you like to modify this task?\n1. yes\n2. no\n ")
      if (readInt() == 1) { modify(tasks, taskNum) } else { return }
      var yno = 1
      while (yno == 1) {
        println("Would you like to continue modifying this task?\n1. yes\n2. no\n ")
        yno = readInt()
        if(yno == 1){modify(tasks, taskNum)}
      }

    }
  }

  def modify(tasks:ArrayBuffer[Task], taskNum: Int): Unit = {
    println("What would you like to modify?\n1. title\n2. due date\n3. priority\n4. description\n5. category\n")
    var mint = readInt()
    if (mint ==1) {
      println("The current title is " + tasks(taskNum).getTitle() + ". What would you like to change it to? ")
      tasks(taskNum).setTitle(readLine())
      println("The new title of this task is " + tasks(taskNum).getTitle())
    } else if (mint == 2) {
      println("The current due date is " + tasks(taskNum).getDueDate() + ". What would you like to change it to? ")
      tasks(taskNum).setDueDate(readLine())
      println("The new due date of this task is " + tasks(taskNum).getDueDate())
    } else if (mint == 3) {
      println("The current priority is " + tasks(taskNum).getPriority() + ". What would you like to change it to? ")
      tasks(taskNum).setPriority(readInt())
      println("The new priority of this task is " + tasks(taskNum).getPriority())
    } else if (mint == 4) {
      println("The current description is " + tasks(taskNum).getDescription() + ". What would you like to change it to? ")
      tasks(taskNum).setDescription(readLine())
      println("The new description of this task is " + tasks(taskNum).getDescription())
    } else if (mint == 5) {
      println("The current category is " + tasks(taskNum).getCategory() + ". What would you like to change it to? ")
      tasks(taskNum).setCategory(readLine())
      println("The new category of this task is " + tasks(taskNum).getCategory())
    } else {
      println("Oops! I don't understand that command.")
    }
    /*
    mint match {
      case 1 => println("The current title is " + tasks(taskNum).getTitle() + ". What would you like to change it to? " + tasks(taskNum).setTitle(readLine()) + "The new title of this task is " + tasks(taskNum).getTitle())
      case 2 => println("The current due date is " + tasks(taskNum).getDueDate() + ". What would you like to change it to? " + tasks(taskNum).setDueDate(readLine()) + "The new due date of this task is " + tasks(taskNum).getDueDate())
      case 3 => println("The current priority is " + tasks(taskNum).getPriority() + ". What would you like to change it to? " + tasks(taskNum).setPriority(readInt()) + "The new priority of this task is " + tasks(taskNum).getPriority())
      case 4 => println("The current description is " + tasks(taskNum).getDescription() + ". What would you like to change it to? " + tasks(taskNum).setDescription(readLine()) + "The new description of this task is " + tasks(taskNum).getDescription())
      case 5 => println("The current category is " + tasks(taskNum).getCategory() + ". What would you like to change it to? " + tasks(taskNum).setCategory(readLine()) + "The new category of this task is " + tasks(taskNum).getCategory())
      case _ => println("Oops! I don't understand that command.")
    }
     */
  }

  def delete(tasks:ArrayBuffer[Task]): Unit ={
    if (tasks.isEmpty) {
      println("Oops! Your task list is empty.")
    } else {
      for (x <- tasks) {
        println(tasks.indexOf(x)+1 + ". " + x.getTitle())
      }
      println("Which task do you want to delete? Please enter the task number. ")
      tasks -= tasks(readInt()-1)
    }
  }

  def query(tasks:ArrayBuffer[Task]): Unit ={
    println("Would you like to sort or filter?\ntype S to sort\ntype F to filter\n")
    var sfinput = readLine()
    sfinput.toLowerCase() match {
      case "s" => sort(tasks)
      case "f" => filter(tasks) //println("t") // will call viewTask() func
      case other => println("Please enter a valid command.")
    }

  }

  def sort(tasks:ArrayBuffer[Task]): Unit ={
    println("What would you like to sort by?\n1. title\n2. due date\n3. priority\n4. description\n5. category\nPlease type the number of the command.\n")
    var sinput = readInt()
    /*
    if (sinput == 1){
      //tasks.sortBy(_.getCategory())
      println("Sorting alphabetically by category: \n")
      viewAllTasks(tasks.sortBy(_.getCategory()))
      // call query(sortFunc(), priority)
    } else if (sinput == 2) {
      //tasks.sortBy(_.getPriority())
      println("Sorting by priority: \n")
      viewAllTasks(tasks.sortBy(_.getPriority()))
      // call query(sortFunc(), category)
    } else {
      println("Oops! I don't understand that command.")
    }
     */
    sinput match {
      case 1 => viewAllTasks(tasks.sortBy(_.getTitle()))
      case 2 => viewAllTasks(tasks.sortBy(_.getDueDate()))
      case 4 => viewAllTasks(tasks.sortBy(_.getPriority()))
      case 3 => viewAllTasks(tasks.sortBy(_.getDescription()))
      case 5 => viewAllTasks(tasks.sortBy(_.getCategory()))
      case other => println("Oops! I don't understand that command.")
    }
  }

  //def sortFunc(): Unit ={}

  def filter(tasks:ArrayBuffer[Task]): Unit ={
    println("What would you like to filter by?\n1. category\n2. priority\nPlease type the number of the command.\n")
    var finput1 = readInt()
    if (finput1 == 1){
      println("Please type the category you would like to filter: \n")
      var finput2 = readLine()
      for (x <- tasks) {
        if (x.getCategory().toLowerCase() == finput2.toLowerCase()) {
          println(x + "\n")
        }
      }
    } else if (finput1 == 2) {
      println("Please type the priority you would like to filter (1-3): \n")
      var finput = readInt()
      for (x <- tasks) {
        if (x.getPriority() == finput) {
          println(x + "\n")
        }
      }
    } else {
      println("Oops! I don't understand that command.")
    }
  }

  def newTask(): Task ={
    var title:String = readLine("Enter the task's title: ")
    var dueDate: String = readLine("Enter the task's due date: ")
    print("Enter the task's priority (1-3) ")
    var priority: Int = readInt()
    var description: String = readLine("Enter the task's description: ")
    var category: String = readLine("Enter the task's category: ")
    val tempTask = new Task(title, dueDate, priority, description, category)
    return tempTask
  }

  def viewAllTasks(tasks:ArrayBuffer[Task]): Unit ={
    if (tasks.isEmpty) {
      println("Oops! Your task list is empty.")
    } else {
      //println(tasks)
      for (x <- tasks) {
        println(x+"\n")
      }
    }
  }



  def main(args: Array[String]): Unit = {

    val tasks = runProgram()
    println("Thanks for using Kiki's Awesome Task Manager!\nHere is a list of your tasks: \n")
    viewAllTasks(tasks)
    println("Goodbye!")

  }

}
