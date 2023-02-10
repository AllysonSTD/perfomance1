package perf

import io.gatling.commons.stats.assertion.MeanRequestsPerSecondTarget
import io.gatling.http.Predef._
import io.gatling.core.Predef._


class TestSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://webtours.load-test.ru:1090")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .disableFollowRedirect

  <!-- setUp(
    CommonScenario().inject(atOnceUsers(users = 1)

     incrementUsersPerSec(6)
        .times(10)
        .eachLevelLasting(60)
        .separatedByRampsLasting(60)
        .startingFrom(0)

    )
  ).protocols(httpProtocol)
}-->
setUp(
CommonScenario().inject(atOnceUsers(users = 2)
)
).protocols(httpProtocol)
}

