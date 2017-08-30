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
* Because token-based authentication is **stateless** so it helps to *scale* the server easily. It also helps to *decouple* client and server. 

### JSON Web Token (JWT)
JSON Web Token is a open, industry standard [RFC 7519](https://tools.ietf.org/html/rfc7519) method for representing claims securely between two parties. JWT contains 3 pieces separated by dot character (*xxx.yyy.zzz*). They are header, payload and signature respectively. JWT can be signed using a secret (**HMAC** algorithm) or a pair of private/public key (**RSA**). Because of that the JWT can be verified and trusted between parties.
* **Header**
    * Consists 2 parts: type of token (which is JWT) and signature algorithm
    * Example
    ``` JSON
    {
        "alg": "HS256",
        "typ": "JWT"
    }
    ```
        
* **Payload**
    * Contains claims (statement about an entity typically an user or anything we want to transfer between parties)
    * Example
    ``` JSON
    {
        "username": "Tam-CO",
        "user_id": "1234567890",
        "super_dev": true
    }
    ```
    
* **Signature**
    * Sign on a combination of header and payload
    * Example
    ``` java
    HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  secret)
    ````


### Spring security

### Single sign on (SSO)
* Login one time access to serveral services
* Centralize identity (known as *federated identity*). Federated identity systems handle
serveral concerns:
    * **Authentication** deals with validating user credentials and establishing the identity of the user
    * **Authorization** is related to access restrictions (e.g is the user **allowed** to access resource X?)
    * **User attributes exchange** deals with data sharing across different user management systems
    * **User management** is related to administration (creation, deletion, update) of user accounts

### OAuth2

### OpenID connect
#### Overview
``` java
+--------+                                   +--------+
|        |                                   |        |
|        |---------(1) AuthN Request-------->|        |
|        |                                   |        |
|        |  +--------+                       |        |
|        |  |        |                       |        |
|        |  |  End-  |<--(2) AuthN & AuthZ-->|        |
|        |  |  User  |                       |        |
|   RP   |  |        |                       |   OP   |
|        |  +--------+                       |        |
|        |                                   |        |
|        |<--------(3) AuthN Response--------|        |
|        |                                   |        |
|        |---------(4) UserInfo Request----->|        |
|        |                                   |        |
|        |<--------(5) UserInfo Response-----|        |
|        |                                   |        |
+--------+                                   +--------+

```
#### Concepts
* Endpoints
* Claims
* ID Token
* Some request parameters
    * **state**
    * **scope**
    * **client_id**
    * **response_type**
    * **redirect_uri**
#### Flows
* [Authorisation code flow](https://openid.net/specs/openid-connect-core-1_0.html#CodeFlowAuth)
    ``` java
    1. Client prepares an Authentication Request containing the desired request parameters.
    2. Client sends the request to the Authorization Server.
    3. Authorization Server Authenticates the End-User.
    4. Authorization Server obtains End-User Consent/Authorization.
    5. Authorization Server sends the End-User back to the Client with an Authorization Code.
    6. Client requests a response using the Authorization Code at the Token Endpoint.
    7. Client receives a response that contains an ID Token and Access Token in the response body.
    8. Client validates the ID token and retrieves the End-User's Subject Identifier.
    ```
* [Implicit flow](https://openid.net/specs/openid-connect-core-1_0.html#ImplicitFlowAuth)
    ``` java
    1. Client prepares an Authentication Request containing the desired request parameters.
    2. Client sends the request to the Authorization Server.
    3. Authorization Server Authenticates the End-User.
    4. Authorization Server obtains End-User Consent/Authorization.
    5. Authorization Server sends the End-User back to the Client with an ID Token and, if requested, an Access Token.
    6. Client validates the ID token and retrieves the End-User's Subject Identifier.
    ```
* [Hybrid flow](https://openid.net/specs/openid-connect-core-1_0.html#HybridFlowAuth)
