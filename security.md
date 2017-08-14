# Security

### Cookie-based vs token-based authentication
![cookie-token](images/cookie-token-auth.png)

#### Cookie-based authentication
* Cookie-based authentication is **stateful**. Meaning that an authentication record(session) must be kept on both client side and server side
* Flow of cookie-based auth
    * User posts credentials to server
    * Server verify credentials and create session which is stored on db
    * A cookie with the **session ID** is placed in user browser
    * On subsequence requests, user must post session ID to server and it will be verified against db
    * Once user logouts the session will be destroyed on both side, client and server


#### Token-based authentication
* Token-based authentication is **stateless**. Meaning that server does not keep a record of which users logged in or which tokens issued.
* Flow of token-based authentication
    * User posts credentials to server
    * Server verifies credentials are correct and return a *signed token*
    * This token is stored only on client side
    * On subsequence requests, user must include this token to *Authorization* header
    * Server decode token and verifies if it **signed** this token and then process the request
    * Once the user logouts, the token is destroyed on client side, no interaction with server is necessary
    
    
#### Advantages of token-based authentication

### JSON Web Token (JWT)

### Spring security
