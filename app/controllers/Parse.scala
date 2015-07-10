package controllers

import javax.inject.Inject

import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.api.mvc.Controller

import scala.concurrent.Future


/**
 * Created by CraigDavies on 08/07/2015.
 */
class Parse @Inject() (ws: WSClient) extends Controller {
    val request: WSRequest = ws.url("https://api.parse.com/1/Todo")
    val complexRequest: WSRequest =
      request.withHeaders("nVVTfcLwuU5OgI6zB1E72KQGvwKJex8XRzvNZWJ0" -> "apVhmOkUvHr4ixlYnbE3ryhap79YRts4lgE3Mtlh")
    val futureResponse: Future[WSResponse] = complexRequest.get()
}

