# HTTPS

### 1. Introduce and some concepts
#### 1.1 Why do we need HTTPS?
To verify whether the website is authenticated/certified or not. Uncertified websites can do evil things. An authenticated website has a unique personal certificate purchased from one of the **CA**’s.

#### 1.2 Who are CA's (Certificate Authorities)
They are global trusted company like GoDaddy, VeriSign, GeoTrust... who provide digital certificates to websites.

#### 1.3 Public/private keys
Please see [reference](https://github.com/VanTamNguyen/Java-Backend/blob/master/security.md#0-asymmetric-public-key-encryption-and-digital-signatures)

#### 1.4 How a website get a certificate?
* First website owner generate pair of public/private key. He keep the private key secret. He give a *Certificate Signing Request (CSR)* and his public key to CA.
* CA creates personal certificate based on CSR include domain name, owner name, expiration date etc and also add **CA's digital signature** to certificate. Then CA uses website owner's public key to encrypt the certificate and send back to website owner.
* Website owner receives the encrypted certificate and uses his private key to decrypt certificate. Finally he installs that certificate on website.

#### 1.5 X509 Certificate

### 2. HTTPS handshake
#### 2.1 Browser validates certificate of website
#### 2.2 Create secure connection (encrypt incoming and outgoing data)
