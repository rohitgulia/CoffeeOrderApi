# CoffeeOrderApi

## How to run

  ### Project Setup:

      Project uses Redis as No-SQL database to store data. Please install Redis on your workstation
      before running anything.

      For Redis on windows below link will be helpful:

      https://github.com/MicrosoftArchive/redis/releases

      Apache Tomcat 9 or above should be used as server. As the project doesn't have server configured
      internally, you have to setup Apache tomcat on your workspace to run the API.
      
      Maven is used to handle project dependencies.
      
      Jersey JAX-RS is used to create rest endpoints and you can find below the detail about all the endpoints.
      
      To run test cases you can go the project from your workspace and right click the project to run as junit test.
      
## Project structure
  
  Project contains src package which contains all the code
  
  There are three main pakages:
    1. Api package which conatins endpoint
    2. Service package which handles all the mid level logic and processing
    3. Repo package which handle interaction with database.
  
  Redis connection is initialized at the start of the api and is injected in the app.
  
  Redisson is used to work with Redis and data is stored as key value pair in database.
   
      
## Tradeoffs
  I am not restricting api to except just two types of coffee name or 5 types of brew method as there can be other
  applications too which can use the api and might have different types of options available for the cofee name or
  brew method. Although as an enhancement, different endpoints can be created to send these various options to applications
  and different applications can subscribe to different endpoints based on there options choice.
      
## Deployment
  
  Project can be exported as .war file and deployed on server.
  
## Future Enhancements
  
  Adding more test cases.
  
  Sending coffee name, brew method options from api.
  
## Api endpoints
      
#GET request:

http://localhost:8080/BlueBottle/api/orders/orderList

#POST request:

http://localhost:8080/BlueBottle/api/orders/addOrder

body:

{
                "coffeeName": "Bella Donovan",
                "brewMethod": "Cold Brew",
                "shipDate": "2019-12-10",
                "numberOfCases": 10,
                "packetsPerCase": 50,
                "notes": "take care please pl",
                "priority": true,
                "orderId": ""
}

#PUT request:

http://localhost:8080/BlueBottle/api/orders/updateOrder

body:

  {
        "brewMethod": "Cold Brew",
        "coffeeName": "Bella Donovan",
        "notes": "take care please pl",
        "numberOfCases": 5,
        "orderId": 1,
        "packetsPerCase": 25,
        "priority": false,
        "shipDate": "2019-12-11"
}
