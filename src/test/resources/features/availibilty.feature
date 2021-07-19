Feature: Checking flights

  @wip
  Scenario: Going to Flight Booking App
    Given I am on the page



  Scenario Outline: Unavailable flights
  Given I am on SkyScanner website
  When I search for direct from <location 1> and <location 2>  to Leeds Bradford Airport
  Then No flight available should appear
    Examples:
      | location1  |  | location 2 |
      | Humberside |  | Liverpool  |
      | Manchester |  | Doncaster  |
      | Bristol    |  | Birmingham |


  Scenario Outline: Available flights
    When I search for direct flights from <location 3>  to New York with <cost> , <class>, <date> and <airline>
    Then Window seat is available message should appear
    Examples:
      | location 3 |  | cost |  | class    |  | date          |  | airline         |
      | London     |  | 500  |  | Economy  |  | 1 August 2021 |  | British Airways |
      | Paris      |  | 600  |  | Business |  | 2 August 2021 |  | Air France      |
      | Berlin     |  | 700  |  | Economy  |  | 3 August 2021 |  | Lufthansa       |





