Feature: Scraping Van Heusen T-shirts from Myntra

  Scenario: Extract discounted Van Heusen T-shirts
    Given I am on the Myntra homepage
    When I navigate to the Men T-shirts section
    And I filter by brand "Van Heusen"
    And I filter for discounted T-shirts
    Then I extract the discounted T-shirts data and print them sorted by discount