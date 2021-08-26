package fr.romaindu35.pufferjavaapi.api.models;

public class Deployment {

    private String clientID;
    private String clientSecret;
    private String publicKey;

    /**
     * Get client id
     * @return client id
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * Get client secret
     * @return client secret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Get public key
     * @return public key
     */
    public String getPublicKey() {
        return publicKey;
    }

    @Override
    public String toString() {
        return "Deployment{" +
                "clientID='" + clientID + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", publicKey='" + publicKey + '\'' +
                '}';
    }
}
