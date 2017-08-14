# Security

### Cookie-based vs token-based authentication
![cookie-token](images/cookie-token-auth.png)

#### Cookie-based authentication
* Cookie-based authentication is **stateful**. Meaning that an authentication record(session) must be kept on both client side and server side
* Flow of cookies-based auth
    * User posts credentials to server
    * Server verify credentials and create session which is stored on db
    * A cookie with the **session ID** is placed in user browser
    * On subsequence requests, user must post session ID to server and it will be verified against db
    * Once user logouts the session will be destroyed on both side, client and server


#### Token-based authentication

### JSON Web Token (JWT)

### Spring security
