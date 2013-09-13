Scenario: Transferring money between accounts

Given John wants to transfer some money from account A to account B
And account A with 100 dollars
And account B with 100 dollars
When he transfers 30 dollars from account A to account B
Then account A should contain 70 dollars
And account B should contain 130 dollars