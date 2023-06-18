Feature: To verify RESTCountries api endpoint

  Scenario: To verify INDIA country details present on API endpoint and verify Republic of India is present in api response
    When user use GET method to API endpoint to search details of "INDIA" they receives valid response

  Scenario: To verify if xyz country details are serched through api then received 400 error
    When user use GET method to to search "xyz" country details they received 404 error
    
   Scenario: To verify norway country deatils are present on API endpoint and Capital of noray is present in response
   	When user use GET method to search "norway" country deatils they able to see capital in response
