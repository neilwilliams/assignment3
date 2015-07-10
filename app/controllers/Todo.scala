package controllers

import java.util
import java.util.ArrayList
import javax.inject.Inject
import play.api.libs.json.{JsArray, JsLookupResult, JsValue}
import play.api.libs.ws.{WSClient, WSResponse, WSRequest}
import play.api.mvc.{Action, Controller}

import scala.util.parsing.json.JSONArray

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by nwillia2 on 26/06/2015.
 */
class Todo @Inject() (ws: WSClient) extends Controller {

  def index = Action.async {
    ws.url("https://api.parse.com/1/classes/Todo")
      .withHeaders("X-Parse-Application-Id" -> "nVVTfcLwuU5OgI6zB1E72KQGvwKJex8XRzvNZWJ0",
                   "X-Parse-REST-API-Key" -> "apVhmOkUvHr4ixlYnbE3ryhap79YRts4lgE3Mtlh").get().map {
        response =>
          val todos: ArrayList[models.Todo] = new util.ArrayList[models.Todo]()
          val json: JsValue = response.json
          val lookup: JsLookupResult = json.\("results")
          val results: Seq[JsValue] = json.as[JsArray].value
          for (element: JsValue <- results){
            val todo: models.Todo = new models.Todo()
            todo.title = element.\("title").as[String]
            todo.description = element.\("description").as[String]
            todos.add(todo)
          }
          Ok(views.html.todo.index(todos))
      }
  }
}
