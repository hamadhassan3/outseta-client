package com.outseta.client.endpoint_client;

import com.outseta.client.endpoint_client.crm.PeopleClient;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.model.result.Person;
import org.junit.jupiter.api.Test;

class AuthenticationClientTest {

    private String outsetaKey = System.getenv("OUTSETA_KEY");
    private String outsetaUrl = System.getenv("OUTSETA_URL");

//    @Test
//    public void testGetPerson() throws OutsetaClientBuildException {
//
//        PeopleClient peopleClient = PeopleClient.newPeopleClientBuilder(outsetaUrl)
//                .withApiKey(outsetaKey)
//                .withDefaultParser()
//                .withDefaultRequestMaker()
//                .build();
//
//        Person person = null;
//        try {
//            person = peopleClient.getPerson("a123mRGPLpQ");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(person);
//    }
}
