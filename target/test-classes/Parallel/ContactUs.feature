Feature:  coontact us page

  Scenario Outline: Contact us by different set of data
    Given User Navigate to the contact us Page
    When User fill the form from given sheetname "<SheetName>" and rowNum <RowNumber>
    And User click on Send button 
    Then SucessMessage should be genrate as "Your message has been successfully sent to our team."
		Examples:
|SheetName|RowNumber|
|sheet1|0|
|sheet1|1|
