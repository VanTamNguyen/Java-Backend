package com.tamco.jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;

public class SignAndVerify {

    // This is a JWK (Json Web Key) that contains both public and private key.
    public static final String KEY_PAIR = "{\n" +
            "  \"kty\": \"RSA\",\n" +
            "  \"d\": \"ado0TfvBufRDUOKTsjpOxfo0srvc3XosaF1xHZFnYOOVN-mcnjhU368iei68xqwaxb5WdDdO54JihNpRTqD5OIMxUhwUAYGuBBvhX2IQG3e_5COU0aCYrIWVL-Eb2-HQjd6nGRz_DKMsIhga9nt-xrOpHJJMylt_ujuyhEZlEoE\",\n" +
            "  \"e\": \"AQAB\",\n" +
            "  \"use\": \"sig\",\n" +
            "  \"kid\": \"1234\",\n" +
            "  \"alg\": \"RS256\",\n" +
            "  \"n\": \"stT13V4GX33lh_wEknA_Wuscb5xtWJUoFnMngpPAWFg0-dC541ABANGAnabt0layqx0rkn1avum78WhqSAbPO_6_qBBkBlwkbEGR5HvwNz7tUl2vKppyuRMIw4KphM3hAvRWpBg2HOZHjsLVJoJRFOJ5fK66gtzjsWUX5h0NBDc\"\n" +
            "}";

    public static void main(String[] args) {
        try {
            // Parse standard Java RSAPublicKey and RSAPrivateKey from the Json Web Key plain text
            RSAKey rsaKey = RSAKey.parse(KEY_PAIR);
            RSAPrivateKey privateKey = rsaKey.toRSAPrivateKey();
            RSAPublicKey publicKey = rsaKey.toRSAPublicKey();

            // Sign using the private key
            JWSSigner signer = new RSASSASigner(privateKey);
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                                                .subject("tamco")
                                                .issuer("https://tamco.com")
                                                .build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), claimsSet);
            signedJWT.sign(signer);
            String jwt = signedJWT.serialize();
            System.out.println("JWT: " + jwt);


            // Verify the signed JWT
            signedJWT = SignedJWT.parse(jwt);
            JWSVerifier verifier = new RSASSAVerifier(publicKey);
            System.out.println("Verify signed JWT: " + signedJWT.verify(verifier));

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JOSEException e) {
            e.printStackTrace();
        }
    }
}
