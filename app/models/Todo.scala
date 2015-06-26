package models

/**
 * Created by nwillia2 on 26/06/2015.
 */
class Todo(passedTitle: String, passedDescription: String) {
  var title: String = passedTitle
  var description: String = passedDescription
  var completed: Boolean = false
}
