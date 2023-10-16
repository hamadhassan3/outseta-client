package com.outseta.client.endpoint_client;

import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the AuthenticationClient class.
 */
@ExtendWith(MockitoExtension.class)
public class AuthenticationClientTest {

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The Outseta Key used for testing.
     */
    private static final String OUTSETA_KEY = "dummyKey";

    /**
     * The mock parser facade.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The mock json parser.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * The mock request maker.
     */
    @Mock
    private RequestMaker requestMaker;

    /**
     * This method is used to test the builder of AuthenticationClient class.
     */
    @Test
    public void testBuilder() {

        assertDoesNotThrow(() -> {
            ClientBuilder<AuthenticationClient> builder1 =
                    AuthenticationClient
                            .builder(OUTSETA_URL);
            assertEquals(builder1, builder1.defaultParser());
            assertEquals(builder1, builder1.defaultRequestMaker());
            assertEquals(builder1, builder1.apiKey(OUTSETA_KEY));
            assertEquals(builder1, builder1.baseUrl(OUTSETA_URL));
            assertEquals(builder1, builder1.accessKey("dummy"));
            assertEquals(builder1, builder1
                    .headers(Map.of("Authorization", "dummy")));
            assertEquals(builder1, builder1
                    .requestMaker("DEFAULT"));
            assertEquals(builder1, builder1
                    .requestMaker(RequestMakerType.DEFAULT));
            AuthenticationClient authenticationClient = builder1.build();

            assertNotNull(authenticationClient);
        });

        assertDoesNotThrow(() -> {

            when(parserFacade.getJsonParser()).thenReturn(jsonParser);
            ClientBuilder<AuthenticationClient> builder2 =
                    AuthenticationClient
                            .builder(OUTSETA_URL);
            assertEquals(builder2, builder2.defaultParser());
            assertEquals(builder2, builder2.defaultRequestMaker());
            assertEquals(builder2, builder2.apiKey(OUTSETA_KEY));
            assertEquals(builder2, builder2.baseUrl(OUTSETA_URL));
            assertEquals(builder2, builder2.parser(parserFacade));
            assertEquals(builder2, builder2.requestMaker(requestMaker));

            AuthenticationClient authenticationClient = builder2.build();
            assertNotNull(authenticationClient);
        });
    }

    /**
     * This method tests the failure scenario of the builder method
     * of the AuthenticationClient class.
     */
    @Test
    public void testBuilderFailure() {

        // Testing empty object
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(null)
        );
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder("")
        );

        // Testing null outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(null)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder("")
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing null Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(OUTSETA_URL)
                        .apiKey(null)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(OUTSETA_URL)
                        .apiKey("")
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without parser but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without request maker but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .build()
        );
    }

}
