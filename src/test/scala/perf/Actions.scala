package perf

import io.gatling.core.Predef._
import io.gatling.core.check.extractor.regex.{RegexCheckBuilder, RegexOfType}
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
    .formParam("login.x", "54")
    .formParam("login.y", "7")
    .formParam("JSFormSubmit", "off")
    .check(status is 200)

  val MenuPage = http(requestName = "/cgi-bin/nav.pl/")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "home")
    .check(status is 200)

  val Intro = http(requestName = "/cgi-bin/login.pl/")
    .get("/cgi-bin/login.pl/")
    .queryParam("intro","true")
    .check(status is 200)

  val Search = http(requestName = "/cgi-bin/welcome.pl/")
    .get(url="/cgi-bin/welcome.pl/")
    .queryParam("page","search")
    .check(status is 200)

  val MenuPage2 = http(requestName = "/cgi-bin/nav.pl/")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "flights")
    .check(status is 200)

  val ReservationsPage = http(requestName = "/cgi-bin/reservations.pl")
    .get("/cgi-bin/reservations.pl")
    .queryParam("page", "welcome")
    .check(status is 200)
    .check(regex("""name="departDate" value="(\d{2}\/\d{2}\/\d{4})"""").saveAs("departDate"))

  val date = "(d{2}/d{2}/d{4})".r

  val ReservationsPl = http(requestName = "/cgi-bin/reservations.pl/")
    .post("/cgi-bin/reservations.pl/")
    .formParam("advanceDiscount", "0")
    .formParam("depart","${depart}")
    .formParam("departDate", "$(date)")
    .formParam("arrive","${depart}")
    .formParam("returnDate", "$(date)")
    .formParam("numPassengers", "${numPassengers}")
    .formParam("seatPref", "${seatPref}")
    .formParam("seatType","${seatType}")
    .formParam("findFlights.x","37")
    .formParam("findFlights.y","12")
    .check(status is 200)
    .check(regex("""name="outboundFlight" value="(\d{3}.;\d{3}.;\d{2}\./d{2}\./d{4})"""").saveAs("outboundFlight"))

val ReservationsPl2 = http(requestName = "/cgi-bin/reservations.pl/")
.post("/cgi-bin/reservations.pl/")
.formParam("outboundFlight", "${outboundFlight}")
.formParam("numPassengers", "${numPassengers}")
  .formParam("advanceDiscount", "0")
  .formParam("seatType","${seatType}")
.formParam("seatPref", "${seatPref}")
.formParam("findFlights.x","42")
.formParam("findFlights.y","8")
.check(status is 200)

  val ReservationsPl3 = http(requestName = "/cgi-bin/reservations.pl/")
    .post("/cgi-bin/reservations.pl/")
    .formParam("outboundFlight", "${outboundFlight}")
    .formParam("numPassengers", "${numPassengers}")
    .formParam("advanceDiscount", "0")
    .formParam("seatType","${seatType}")
    .formParam("seatPref", "${seatPref}")
    .formParam("findFlights.x","42")
    .formParam("findFlights.y","8")
    .check(status is 200)



val ReservationsPl4 = http(requestName = "/cgi-bin/reservations.pl/")
.post("/cgi-bin/reservations.pl/")
.formParam("firstName", "Hungry")
.formParam("lastName", "Always")
.formParam("address1", "London")
.formParam("address2","Baker street")
.formParam("pass1", "Always Hungry")
.formParam("creditCard","1111111111111111")
.formParam("expDate","08/25")
  .formParam("oldCCOption", "on")
    .formParam("numPassengers", "${numPassengers}")
    .formParam("advanceDiscount", "0")
    .formParam("seatType","${seatType}")
    .formParam("seatPref", "${seatPref}")
  .formParam("outboundFlight", "${outboundFlight}")
  .formParam("returnFlight", null)
  .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x","40")
    .formParam("buyFlights.y","11")
.check(status is 200)

  val Itinerary1 = http(requestName = "/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "itinerary")
    .check(status is 200)

  val Itinerary2 = http(requestName = "/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "itinerary")
    .check(status is 200)

  val Itinerary3 = http(requestName = "/cgi-bin/itinerary.pl")
    .get("/cgi-bin/itinerary.pl")
    .check(status is 200)


  val SignOff = http(requestName = "/cgi-bin/welcome.pl" )
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "1")
    .check(status is 200)

}