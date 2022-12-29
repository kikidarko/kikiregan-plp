package PLP6content
// enumeration for default vals
object Priority {

}

class Task(var title:String, var dueDate:String, var priority:Int, var description:String, var category:String) {

  // category: enumeration
  //enum Priority:
  //  case 1, 2, 3

  //def this(title:String, dueDate:String, priority: Int, description:String, category:String) {
  //  this(title, dueDate, priority, description, category)
  //}

  //def this(title:String) = {

  //}

  //var title: String = "";
  // dateDue... think of data type... date object?
  //var dueDate: String = "";
  //var priority: Int = 0;
  //var description: String = "";
  //var category: String = "";

  def display(): Unit ={
    println("Title: " + title + "\nDescription: " + description + "\nDue Date: " + dueDate + "\nCategory: " + category + "\nPriority: " + priority)
  }

  // get methods
  def getTitle(): String = return title;
  def getDueDate(): String = return dueDate;
  def getPriority(): Int = return priority;
  def getDescription(): String = return description;
  def getCategory(): String = return category;

  // set methods
  //def setTitle(title:String): Unit = this.title = title;
  //def setDueDate(dueDate:String): Unit = this.dueDate = dueDate;
  //def setPriority(priority:Int): Unit = this.priority = priority;
  //def setDescription(description:String): Unit = this.description = description;
  //def setCategory(category:String): Unit = this.category = category;

//override def toString: String = super.toString

}
