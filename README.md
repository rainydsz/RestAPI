# Automated test cases for performing the User CRUD Operations on Rest API's available at https://reqres.in/ using the Java RestAssured Library

---
## The below endpoints were tested thoroughly:
1) /api/users
2) /api/users/{userId}
---
A total of six REST API's were tested by creating four JUnit test cases.

### Test Case 1:
- An API to create a new user was tested using POST request and it returned a Status Code of 201.

### Test Case 2:
- An API to fetch the user details was tested using GET request and a valid userID. It returned a Status Code of 200.
- Tested using the UserID=2 as given in the API Contract and not using the UserID generated from the first test case. Since it did not support and was throwing the 404 error. Might be becuase it's a dummy API.
- An API to fetch the user details was tested using GET request and a invalid userID. It returned a Status Code of 404.

### Test Case 3:
- An API to modify the user details was tested using PUT request and it returned a Status Code of 200.
- An API to update the user details was tested using PATCH request and it returned a Status Code of 200.

### Test Case 4:
- An API to delete an existing user was tested using DELETE request and it returned a Status Code of 204.
---
### Instructions for execution of test cases:
- Need to have Java and Eclipse IDE installed in the system.
- Download the necessary jars (Rest Assured/JUnit).
- Clone the Repository or Import the project to the workspace.
- Run the Test Case as a JUnit test.
---
