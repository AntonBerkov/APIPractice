Feature: test feature

  Scenario Outline: Check wowhead

    Given user is on the website page
    When user enters search "<text>" in the text field
    And clicks on the first link
    Then page's title matches expected "<title>"
    Examples:
      | text        | title       |
      | Непобедимый | Непобедимый |
      | Гневион     | Гневион     |