package com.outseta.client.endpoint_client.billing.integration;

import com.outseta.client.endpoint_client.billing.UpdatePaymentInfoClient;
import com.outseta.client.endpoint_client.crm.AccountClient;
import com.outseta.client.endpoint_client.crm.PeopleClient;
import com.outseta.constant.AccountStage;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.UpdatePaymentInfoRequest;
import com.outseta.model.result.Account;
import com.outseta.model.result.Person;
import com.outseta.model.result.PersonAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * This class is used to test the UpdatePaymentInfoClient class.
 * It is an integration test because it uses the actual API.
 */
@Tag("integration")
@ExtendWith(MockitoExtension.class)
public class UpdatePaymentInfoClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * This is the class that is being tested.
     */
    private UpdatePaymentInfoClient updatePaymentInfoClient;

    /**
     * The account that is created for testing.
     */
    private Account createdAccount;

    /**
     * The person that is created for testing.
     */
    private Person createdPerson;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaParseException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {
        updatePaymentInfoClient = UpdatePaymentInfoClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        createdPerson = PeopleClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build().createPerson(Person.builder()
                        .email("hammad-test-outseta-client@outseta-client.com")
                        .firstName("hammad-outseta")
                        .lastName("hammad-client")
                        .build());

        createdAccount = AccountClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build().createAccountWithExistingPerson(Account.builder()
                        .name("hammad-test-outseta-client")
                        .accountStage(AccountStage.Trialing)
                        .personAccount(Arrays.asList(PersonAccount.builder()
                                .person(createdPerson)
                                .primary(true)
                                .build()))
                        .build());
    }

    /**
     * This method is run after each test.
     */
    @AfterEach
    public void tearDown() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        AccountClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build().deleteAccount(createdAccount.getUid());

        PeopleClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build().deletePerson(createdPerson.getUid());
    }

    /**
     * This method tests the updatePaymentInfo method.
     */
    @Test
    void updatePaymentInfo() {

        assertDoesNotThrow(() -> {

            updatePaymentInfoClient.updatePaymentInfo(
                    UpdatePaymentInfoRequest.builder()
                            .account(createdAccount)
                            .paymentToken("test")
                            .customerToken("test")
                            .nameOnCard("test")
                        .build());
        });
    }
}
