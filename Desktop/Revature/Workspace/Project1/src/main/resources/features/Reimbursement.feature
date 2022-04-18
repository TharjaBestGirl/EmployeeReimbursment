Feature: Reimbursement Action

#Scenario: Successful Login with Valid Credentials
Scenario Outline: Adding a new reimbursement
    Given User is on Home Page
    When User Navigate to LogIn Page
   	And User enters "<username>" and "<password>"
   	
   	Then User is on Employee Home Page
   	When User Navigates to Reimbursements Page
   	And User enters "<type>" and "<description>" and "<amount>"

    Then Message states that Reimbursement is added
    
    Examples:
    | username  | password | type | description | amount |
    | Employee  | 12345    | food | pizza time  |   45   |

    