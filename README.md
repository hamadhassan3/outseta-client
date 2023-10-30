# outseta-client

A Java SDK for easily accessing the Outseta API.

![GitHub CI](https://github.com/hamadhassan3/outseta-client/actions/workflows/gradle.yml/badge.svg)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/hamadhassan3/outseta-client)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.hamadhassan3/outseta-client.svg)](https://search.maven.org/artifact/io.github.hamadhassan3/outseta-client)
[![codecov](https://codecov.io/github/hamadhassan3/outseta-client/graph/badge.svg?token=1LSVKFYJOS)](https://codecov.io/github/hamadhassan3/outseta-client)
![License](https://img.shields.io/github/license/hamadhassan3/outseta-client)
![GitHub issues](https://img.shields.io/github/issues/hamadhassan3/outseta-client)
![GitHub pull requests](https://img.shields.io/github/issues-pr/hamadhassan3/outseta-client)
![GitHub last commit](https://img.shields.io/github/last-commit/hamadhassan3/outseta-client)

## Code Coverage Graphs
The Code is thoroughly tested to ensure reliable execution of the API endpoints. The architecture, endpoints and models are thoroughly unit tested. Furthermore, integration tests are added for the endpoints to ensure that the API endpoints are working as expected.

![codecov grid](https://codecov.io/github/hamadhassan3/outseta-client/graphs/sunburst.svg?token=1LSVKFYJOS)![codecov sunburst](https://codecov.io/github/hamadhassan3/outseta-client/graphs/tree.svg?token=1LSVKFYJOS)

## About
This library is a Java SDK for easily accessing the Outseta API. It uses Jackson to parse the requests and responses and Apache's HttpClient to make the requests. The models in this library provide a convenient mapping to the Json of the APIs. The library is built using Java 8 and is compatible with Android.

You can also refer to the unit tests in order to see how to use the library.

## Requirements
- Java 8 or higher

## Installation
Install the library using Maven or Gradle. The library is available on [Maven Central](https://central.sonatype.com/artifact/io.github.hamadhassan3/outseta-client).

### Maven
```xml
<dependency>
    <groupId>io.github.hamadhassan3</groupId>
    <artifactId>outseta-client</artifactId>
    <version>2.0.0</version>
</dependency>
```
### Gradle
```groovy
implementation group: 'io.github.hamadhassan3', name: 'outseta-client', version: '2.0.0'
```

## The library provides following API Clients
- [AuthenticationClient](src/main/java/com/outseta/client/endpoint_client/AuthenticationClient.java)
- [MarketingClient](src/main/java/com/outseta/client/endpoint_client/MarketingClient.java)
- [ProfileClient](src/main/java/com/outseta/client/endpoint_client/ProfileClient.java)
- [SupportClient](src/main/java/com/outseta/client/endpoint_client/SupportClient.java)

CRM
- [AccountClient](src/main/java/com/outseta/client/endpoint_client/crm/AccountClient.java)
- [ActivityClient](src/main/java/com/outseta/client/endpoint_client/crm/ActivityClient.java)
- [DealClient](src/main/java/com/outseta/client/endpoint_client/crm/DealClient.java)
- [PeopleClient](src/main/java/com/outseta/client/endpoint_client/crm/PeopleClient.java)

Billing
- [AddOnClient](src/main/java/com/outseta/client/endpoint_client/billing/AddOnClient.java)
- [DiscountClient](src/main/java/com/outseta/client/endpoint_client/billing/DiscountClient.java)
- [InvoiceClient](src/main/java/com/outseta/client/endpoint_client/billing/InvoiceClient.java)
- [PlanClient](src/main/java/com/outseta/client/endpoint_client/billing/PlanClient.java)
- [PlanFamilyClient](src/main/java/com/outseta/client/endpoint_client/billing/PlanFamilyClient.java)
- [SubscriptionClient](src/main/java/com/outseta/client/endpoint_client/billing/SubscriptionClient.java)
- [UpdatePaymentInfoClient](src/main/java/com/outseta/client/endpoint_client/billing/UpdatePaymentInfoClient.java)

## Authentication
The library provides two ways to authenticate with the Outseta API. The first way is to use the [AuthenticationClient](src/main/java/com/outseta/client/endpoint_client/AuthenticationClient.java) to get an auth token and then use that token to make requests to the other APIs. This provides access to user specific APIs like profile endpoints. The second way is to use the API Key. The second way is to use the API key directly in the other API clients. This provides access to most APIs.
Please note that either the API key or the Access Key needs to be specified when creating a Client object. Otherwise, client creation fails. PeopleClient can only be created using an Access Key and AuthenticationClient can be built without any keys.

## Usage:
### Creating a Client (e.g. AuthenticationClient)
```java
AuthenticationClient client = AuthenticationClient.builder(outsetaUrl)
    .apiKey(outsetaKey)
    .defaultParser()
    .defaultRequestMaker()
    .build();
```
### Using Builder to Create a Request Model
```java
GetAuthTokenRequest request = GetAuthTokenRequest.builder()
    .username(username)
    .password(password)
    .build();
```
### Calling the required method to execute corresponding API
```java
AuthToken token = client.getAuthToken(request);
```

### Pagination (Using Marketing Client)
```java
PeopleClient client = PeopleClient.builder(outsetaUrl)
    .apiKey(outsetaKey)
    .defaultParser()
    .defaultRequestMaker()
    .build();
PageRequest request = PageRequest.builder()
    .page(page)
    .pageSize(pageSize)
    .build();
int total = 0;
ItemPage<Person> personPage = null;
do {
    // Keep making requests as long as there are more pages
    personPage = peopleClient.getPersonPage(request);
    total = personPage.getMetadata().getTotal();

    // The current page's items are aggregated
    allPeople.addAll(personPage.getItems());
    request = request.nextPageRequest();
}
while (allPeople.size() < total);
```

#### Pagination Custom Arguments
In addition to the regular pagination request, you can pass custom arguments for filtering, sort, etc. For example, to filter the people by email, you can pass the following custom arguments:
```java
Map<String, Object> customParams = new HashMap<>();
customParams.put("Email", "asd@dummy.com");

PageRequest request = PageRequest.builder()
    .page(page)
    .pageSize(pageSize)
    .customParams(customParams)
    .build();
```

#### Customized Pagination Request
In addition to the regular Pagination request, the following customized requests are available for common use cases:
- [AccountPageRequest](src/main/java/com/outseta/model/request/AccountPageRequest.java)
- [ActivityPageRequest](src/main/java/com/outseta/model/request/ActivityPageRequest.java)
- [TransactionPageRequest](src/main/java/com/outseta/model/request/TransactionPageRequest.java)

Please refer to the javadoc for each client to see the available methods.

## Dependencies
- [Jackson Annotations](https://central.sonatype.com/artifact/com.fasterxml.jackson.core/jackson-annotations)
- [Jackson Core](https://central.sonatype.com/artifact/com.fasterxml.jackson.core/jackson-core)
- [Jackson Databind](https://central.sonatype.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [Apache HttpClient](https://central.sonatype.com/artifact/org.apache.httpcomponents/httpclient)

## Javadoc
The code is thoroughly documented. You can access the javadoc to understand the code and its usage. You can view the javadoc inside the docs folder in root directory.

## The Builder Pattern
The builder pattern is used to create the request and response models. This makes it easy to create the models and also makes the code more readable. This allows the user to create the models in a single line of code without worrying over case sensitivity, spellings, etc. The builder pattern is also used to create the API clients.

## Linting
The code uses Checkstyle to ensure proper formatting of the code. Furthermore, the Sun coding conventions are used in the checkstyle script. This is the recommended coding convention for Java.

## License
This project is licensed under the MIT License - see the [LICENSE](https://opensource.org/license/mit/) for details

## Reference
The Outseta API: https://documenter.getpostman.com/view/3613332/outseta-rest-api-v1/7TNfr6k
