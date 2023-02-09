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


  val ReservationsPl = http(requestName = "/cgi-bin/reservations.pl/")
    .post("/cgi-bin/reservations.pl/")
    .formParam("advanceDiscount", "0")
    .formParam("depart","${depart}")
    .formParam("departDate", "${departDate}")
    .formParam("arrive","${depart}")
    .formParam("returnDate", "${departDate}")
    .formParam("numPassengers", "${numPassengers}")
    .formParam("seatPref", "${seatPref}")
    .formParam("seatType","${seatType}")
    .formParam("findFlights.x","37")
    .formParam("findFlights.y","12")
    .check(status is 200)
    .check(regex("""name="outboundFlight" value="(.+)"""").saveAs("outboundFlight"))

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
.formParam("firstName", "${outboundFlight}")
.formParam("lastName", "${numPassengers}")
.formParam("address1", "0")
.formParam("address2","${seatType}")
.formParam("pass1", "${seatPref}")
.formParam("creditCard","42")
.formParam("expDate","8")
  .formParam("oldCCOption", "nil")
    .formParam("numPassengers", "${numPassengers}")
    .formParam("advanceDiscount", "0")
    .formParam("seatType","${seatType}")
    .formParam("seatPref", "${seatPref}")
  .formParam("outboundFlight", "${outboundFlight}")
  .formParam("advanceDiscount", "${outboundFlight}")
  .formParam("returnFlight", "${outboundFlight}")
  .formParam("JSFormSubmit", "${outboundFlight}")
    .formParam("buyFlights.x","42")
    .formParam("buyFlights.y","8")
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