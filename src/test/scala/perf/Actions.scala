package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Actions {

  val webtours = http("/webtours/")
    .get("/webtours/")
    .check(status is 200)

  val welcomePl = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "true")
    .check(status is 200)

  val navPl = http(requestName = "/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(status is 200)
    .check(regex("""name="userSession" value="(.+)"""").saveAs("userSession"))

  val loginPl = http(requestName = "/cgi-bin/login.pl")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "${userSession}")
    .formParam("username", "thebestQA")
    .formParam("password", "QWERTY123")
    .formParam("login.x", "77")
    .formParam("login.y", "14")
    .formParam("JSFormSubmit", "off")
    .check(status is 200)

}

