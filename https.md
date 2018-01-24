# HTTPS

### 1. Introduce and some concepts
#### 1.1 Why do we need HTTPS?
To verify whether the website is authenticated/certified or not. Uncertified websites can do evil things. An authenticated website has a unique personal certificate purchased from one of the **CA**’s.

#### 1.2 Who are CA's (Certificate Authorities)
They are global trusted company like GoDaddy, VeriSign, GeoTrust... who provide digital certificates to websites.

#### 1.3 Public/private keys
Please see [reference](https://github.com/VanTamNguyen/Java-Backend/blob/master/security.md#0-asymmetric-public-key-encryption-and-digital-signatures)

#### 1.4 How a website get a certificate?
* First website owner generate pair of public/private key. He keeps the private key secret. He gives a *Certificate Signing Request (CSR)* and his public key to CA.
* CA creates personal certificate based on CSR include domain name, owner name, expiration date etc and also add **CA's digital signature** to certificate. Then CA uses website owner's public key to encrypt the certificate and send back to website owner.
* Website owner receives the encrypted certificate and uses his private key to decrypt certificate. Finally he installs that certificate on his website.

#### 1.5 X509 Certificate

### 2. HTTPS handshake
#### 2.1 Browser validates certificate of a website
* 1. User enters URL facebook.com to browser, FB server gives browser the certificate of the website (which was signed by GeoTrust for example) and FB's public key.
* 2. Now browser has to verify if the certificate of website was signed bt GeoTrust or not. As browsers come with a list of public keys of major CAs, it will pick GeoTrust's public key to verify the certificate FB gave.
* 3. If the verification succeeds the browser proceeds next step else it stops.


#### 2.2 Create secure connection (encrypt incoming and outgoing data)
* 1. As mentioned above, when user enters facebook.com to browser, FB server sends its public key to browser.
* 2. After validating the certificate of website, browser will generate a secret key (symmetric key) (let call it **session key**) and makes 2 copies of it.
* 3. Browser will use facebook's public key to encrypt the **session key** and sends it to facebook.
* 4. Facebook will use its private key to decrypt the message of browser from step iii and get the session key
* 5. Now both sides (FB and browser) have the **session key**. From now they will use session key to encrypt data before sending and decrypt data after receiving.

### 3. References
* [[Long but very very good explaination] MIT OpenCourseWare](https://www.youtube.com/watch?v=S2iBR2ZlZf0)
