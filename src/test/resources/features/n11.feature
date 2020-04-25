Feature: n11 Test

  Scenario: User should be signed in
    Given Visitor is on the HomePage
    When Customer login with "erencdegerli@gmail.com" email and "a12345" password
    Then Customer should see page title as "alışverişin uğurlu adresi" on Home Page

  Scenario: User should search
    When Customer search with "samsung" word
    Then Customer should see "sonuç bulundu" result message

  Scenario: User should search and visit result pages
    When Customer visit 2nd result page
    Then Customer should see the exact product

  Scenario: User should see added product on Favorite List
    When Customer should add to favorite 3rd product
    Then Customer should see product on Favorite List

  Scenario: User should remove added Favorite product from Favorite List
    When Customer should remove added favorite product from Favorite List
    Then Customer should see "Ürününüz listeden silindi." success message and removed favorite product from Favorite List
