# Security

### 0. Asymmetric (public key) encryption and digital signatures
    First, note that, here I just provide an abstraction about public key encryption to understand
    something (concepts) below (like JSON Web Token). To fully understand this topic I will 
    study *cryptography* in another github repository(course).
    
    Asymmetric encryption is based on a pair of public/private key. Unlike symmetric encrytion 
    there is only one key and both sides must keep it secret.

#### 0.1 Public key encryption
* Let say that Alice wants to send some messages to Bob and she does not want anybody can read them except Bob. Bob will generate a *pair of public/private key*. Bob gives *public key* to Alice and keep *private key* secret. Now Alice is going to use *public key* to encrypt the message and send it to Bob. Bob will use *private key* to decrypt Alice's message. And only Bob can do that.
* Look at the image below for more visual
![public-key-encryption](images/public_key_cryptography.jpg)

#### 0.2 Digital signatures
* Sign with a secret
* Sign with private key

### 1. Cookie-based vs token-based authentication

#### 1.1 Cookie-based authentication
* Cookie-based authentication is **stateful**. Meaning that an authentication record(session) must be kept on both client side and server side
* Flow of cookie-based auth
    * User posts credentials to server
    * Server verify credentials and create session which is stored on db
    * A cookie with the **session ID** is placed in user browser
    * On subsequence requests, user must post session ID to server and it will be verified against db
    * Once user logouts the session will be destroyed on both side, client and server


#### 1.2 Token-based authentication
* Token-based authentication is **stateless**. Meaning that server does not keep a record of which users logged in or which tokens issued.
* Flow of token-based authentication
    * User posts credentials to server
    * Server verifies credentials are correct and return a *signed token*
    * This token is stored only on client side
    * On subsequence requests, user must include this token to *Authorization* header
    * Server decode token and verifies if it **signed** this token and then process the request
    * Once the user logouts, the token is destroyed on client side, no interaction with server is necessary
    
    
#### 1.3 Advantages of token-based authentication
* Because token-based authentication is **stateless** so it helps to *scale* the server easily. It also helps to *decouple* client and server. 

### 2. JSON Web Token (JWT)
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


### 3. Spring security

### 4. Single sign on (SSO)
* Login one time access to serveral services
* Centralize identity (known as *federated identity*). Federated identity systems handle
serveral concerns:
    * **Authentication** deals with validating user credentials and establishing the identity of the user
    * **Authorization** is related to access restrictions (e.g is the user **allowed** to access resource X?)
    * **User attributes exchange** deals with data sharing across different user management systems
    * **User management** is related to administration (creation, deletion, update) of user accounts

### 5. OAuth2

### 6. OpenID Connect
#### 6.1 Overview
* OpenID Connect = OAuth2 + ID Token (JWT)
* OpenID Connect is a simple identity layer on top of the OAuth2 protocol. It enables Clients to verify the identity of End-User based on the authentication performed by an Authorization Server, as well as to obtain basic profile information about the End-User in an interoperable and REST-like manner.
* OpenID Connect core functionalities: authentication built on top of OAuth2 + the use of Claims to communicate information about the End-User.
* The OpenID Connect protocol, in abstract, follows the following steps
    ``` java
    1. The RP (Client) sends a request to the OpenID Provider (OP).
    2. The OP authenticates the End-User and obtains authorization.
    3. The OP responds with an ID Token and usually an Access Token.
    4. The RP can send a request with the Access Token to the UserInfo Endpoint.
    5. The UserInfo Endpoint returns Claims about the End-User.
    ```
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
    [Reference 1](https://openid.net/specs/openid-connect-core-1_0.html)
    [Reference 2](https://www.youtube.com/watch?v=6DxRTJN1Ffo)
#### 6.2 Concepts
* ID Token is a JWT contains Claims
* Endpoints are the interfaces which Client and End-User interact with OP. They are:
    * Authorization Endpoint
    * Token Endpoint
    * UserInfo Endpoint
* Claims are *statements about an entity typically an user or anything we want to transfer between parties*. Claims include: *sub, name, given_name, family_name, middle_name, preferred_username, nickname, profile, picture, website, email, blah blah blah*
* Some request parameters
    * **state**
    * **scope**
    * **client_id**
    * **response_type**
    * **redirect_uri**
#### 6.3 Flows
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
    ``` java
    1. Client prepares an Authentication Request containing the desired request parameters.
    2. Client sends the request to the Authorization Server.
    3. Authorization Server Authenticates the End-User.
    4. Authorization Server obtains End-User Consent/Authorization.
    5. Authorization Server sends the End-User back to the Client with an Authorization Code and, depending on the Response Type, one or more additional parameters.
    6. Client requests a response using the Authorization Code at the Token Endpoint.
    7. Client receives a response that contains an ID Token and Access Token in the response body.
    8. Client validates the ID Token and retrieves the End-User's Subject Identifier.
    ```
