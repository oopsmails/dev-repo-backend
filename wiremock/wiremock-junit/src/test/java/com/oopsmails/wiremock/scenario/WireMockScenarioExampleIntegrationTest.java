package com.oopsmails.wiremock.scenario;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.Scenario;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

@Ignore("This is for integration test, need server up")
public class WireMockScenarioExampleIntegrationTest {
    private static final String THIRD_STATE = "third";
    private static final String SECOND_STATE = "second";
    private static final String TIP_01 = "finally block is not called when System.exit() is called in the try block";
    private static final String TIP_02 = "keep your code clean";
    private static final String TIP_03 = "use composition rather than inheritance";
    private static final String TEXT_PLAIN = "text/plain";

    static int port = 9999;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(port);

    private static String firstLineOfResponse(HttpResponse httpResponse) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()))) {
            return reader.readLine();
        }
    }

    @Test
    public void changeStateOnEachCallTest() throws IOException {
        createWireMockStub(Scenario.STARTED, SECOND_STATE, TIP_01);
        createWireMockStub(SECOND_STATE, THIRD_STATE, TIP_02);
        createWireMockStub(THIRD_STATE, Scenario.STARTED, TIP_03);

        assertEquals(TIP_01, nextTip());
        assertEquals(TIP_02, nextTip());
        assertEquals(TIP_03, nextTip());
        assertEquals(TIP_01, nextTip());
    }

    @Test
    public void assertWiremockSetup() throws IOException {
        // Arrange - setup wiremock stubs
        configureStubs();

        // execute request through the http client
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/test/abc")
                .get()
                .build();

        // Act - call the endpoint
        Response response = client.newCall(request).execute();

        // Assert - verify the response
        assertEquals("Test success!", response.body().string());
        verify(exactly(1), getRequestedFor(urlEqualTo("/test/abc")));

    }

    // configure stubs for wiremock
    private void configureStubs() {
        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/test/abc"))
                .willReturn(aResponse().withBody("Test success!")));
    }


    private void createWireMockStub(String currentState, String nextState, String responseBody) {
        stubFor(get(urlEqualTo("/java-tip"))
                .inScenario("java tips")
                .whenScenarioStateIs(currentState)
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", TEXT_PLAIN)
                        .withBody(responseBody))
                .willSetStateTo(nextState)
        );
    }

    private String nextTip() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(String.format("http://localhost:%s/java-tip", port));
        HttpResponse httpResponse = httpClient.execute(request);
        return firstLineOfResponse(httpResponse);
    }
}
