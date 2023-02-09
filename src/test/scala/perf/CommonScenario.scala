package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import perf.Actions._



object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().mainScenario
}

class CommonScenario {

  val open = group(name = "open") {
    exec(webtours)
      .exec(welcomePl)
      .exec(navPl)
  }

  val login = group(name = "login") {
    exec(loginPl)
      .exec(MenuPage)
      .exec(Intro)
  }

  val flights = group(name = "flights") {
    exec(Search)
      .exec(MenuPage2)
    .exec(ReservationsPage)
  }

  val reservation = group(name="reservation") {

    exec(ReservationsPl)
      .exec(ReservationsPl2)
  }

  val itinerary = group(name = "itinerary"){
    exec(Itinerary1)
      .exec(Itinerary2)
      .exec(Itinerary3)
  }

val signOff = group(name = "SignOff"){
  exec(SignOff)
    .exec(navPl)
}

  val mainScenario = scenario("mainScenario")
    .feed(Feeders.depart)
    .feed(Feeders.numPassengers)
    .feed(Feeders.seatPref)
    .feed(Feeders.seatType)
    .exec(open)
    .exec(login)
    .exec(flights)
    .exec(reservation)
    .exec(itinerary)
    .exec(SignOff)
}
