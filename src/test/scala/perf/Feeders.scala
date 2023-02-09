package perf

import io.gatling.core.Predef._


object Feeders {

  val users = csv("users.csv").circular
  val depart = csv(fileName = "Depart.csv").random
  val numPassengers = csv(fileName = "numPass.csv").random
  val seatPref = csv(fileName = "SeatPref.csv").random
  val seatType = csv(fileName = "SeatType.csv").random

}

