Feature: Title of your feature
  I want to use this template for my feature file

  @smoke @wip
  Scenario Outline: Verify that user is able to setup/create a new single flow offer
    Given user wants to create offer with data "<RowNumber>"

    Examples: 
      | Source | Destination |
      | NY     | Bom         |
      | Bom    | Pune        |
      | Cal    | NY          |
    #Given user opens website
    #When user search with keyword "Sony TV"
