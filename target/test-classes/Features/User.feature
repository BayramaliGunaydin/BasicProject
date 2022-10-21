@UserServiceTest

Feature:User Service Api Test

  @PositiveTest @Regression @AllTest
  Scenario Outline: Login Positive Scenario
    Given Check successful Login with "<username>" and "<password>" parameters
    Examples:
      | username               |password    |
      |bayram                  |1234|

  @NegativeTest @AllTest
  Scenario Outline: Login Negative Scenario
    Given Check failed Login with "<username>" and "<password>" parameters

    Examples:
      | username               |password    |
      |bayram                  |123456      |
      |bayrama                 |1234        |
      |bayrama                 |123455      |
      |                        |            |

  @NegativeTest @AllTest
  Scenario Outline: Login Negative Scenario2
    Given Check failed username with "<username>" parameter

    Examples:
      | username               |
      |bayramaa                |
      |bayrama                 |
      |bayramas                |
      |                        |