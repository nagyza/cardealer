# Car dealer application

Running and testing the application:
1. Check out the project from the repository: git clone https://github.com/nagyza/cardealer.git
2. Start a command line and change directory into the cardealer root directory. 
     * Use the command ***./gradlew clean bootRun*** on a bash terminal or 
     * ***gradlew.bat clean bootRun*** on a Windows command line.
3. Import the ***Cardealer.postman_collection.json*** into Postman
   * the postman collection contains a request for all the endpoints with sample data in the request body (or query parameter).
4. Starting the application the only preloaded data is the necessary user role, 
   * you need to load test data by using the corresponding POST endpoints in the Postman.
