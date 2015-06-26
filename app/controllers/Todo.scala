package controllers

import java.util
import java.util.ArrayList
import play.api.mvc.{Action, Controller}

/**
 * Created by nwillia2 on 26/06/2015.
 */
class Todo extends Controller {
  def index = Action {
    val todos: ArrayList[models.Todo] = new util.ArrayList[models.Todo]()
    todos.add(new models.Todo("Help", "Need some help with scala!"))
    todos.add(new models.Todo("Try not to give up", "This is rubbish8"))
    Ok(views.html.todo.index(todos))
  }
}
