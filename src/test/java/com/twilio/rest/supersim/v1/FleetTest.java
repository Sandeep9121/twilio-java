/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.supersim.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class FleetTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.SUPERSIM.toString(),
                                          "/v1/Fleets");
            request.addPostParam("NetworkAccessProfile", serialize("HAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Fleet.creator("HAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique_name\",\"data_enabled\": true,\"data_limit\": 1000,\"data_metering\": \"payg\",\"date_created\": \"2019-07-30T20:00:00Z\",\"date_updated\": \"2019-07-30T20:00:00Z\",\"commands_enabled\": true,\"commands_method\": \"GET\",\"commands_url\": \"https://google.com\",\"network_access_profile_sid\": \"HAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sid\": \"HFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://supersim.twilio.com/v1/Fleets/HFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Fleet.creator("HAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SUPERSIM.toString(),
                                          "/v1/Fleets/HFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Fleet.fetcher("HFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique_name\",\"data_enabled\": true,\"data_limit\": 1000,\"data_metering\": \"payg\",\"date_created\": \"2019-07-30T20:00:00Z\",\"date_updated\": \"2019-07-30T20:00:00Z\",\"commands_enabled\": true,\"commands_method\": \"POST\",\"commands_url\": null,\"network_access_profile_sid\": \"HAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sid\": \"HFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://supersim.twilio.com/v1/Fleets/HFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Fleet.fetcher("HFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SUPERSIM.toString(),
                                          "/v1/Fleets");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Fleet.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"fleets\": [],\"meta\": {\"first_page_url\": \"https://supersim.twilio.com/v1/Fleets?NetworkAccessProfile=HAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa&PageSize=50&Page=0\",\"key\": \"fleets\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://supersim.twilio.com/v1/Fleets?NetworkAccessProfile=HAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa&PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Fleet.reader().read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"first_page_url\": \"https://supersim.twilio.com/v1/Fleets?NetworkAccessProfile=HAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa&PageSize=50&Page=0\",\"key\": \"fleets\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://supersim.twilio.com/v1/Fleets?NetworkAccessProfile=HAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa&PageSize=50&Page=0\"},\"fleets\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"Pilot Fleet\",\"data_enabled\": true,\"data_limit\": 1000,\"data_metering\": \"payg\",\"date_created\": \"2019-10-15T20:00:00Z\",\"date_updated\": \"2019-10-15T20:00:00Z\",\"commands_enabled\": true,\"commands_method\": \"POST\",\"commands_url\": null,\"network_access_profile_sid\": \"HAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sid\": \"HFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://supersim.twilio.com/v1/Fleets/HFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}]}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Fleet.reader().read());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.SUPERSIM.toString(),
                                          "/v1/Fleets/HFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Fleet.updater("HFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateUniqueNameResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique_name\",\"data_enabled\": true,\"data_limit\": 1000,\"data_metering\": \"payg\",\"date_created\": \"2019-10-15T20:00:00Z\",\"date_updated\": \"2019-10-15T20:00:00Z\",\"commands_enabled\": true,\"commands_method\": \"POST\",\"commands_url\": null,\"network_access_profile_sid\": \"HAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sid\": \"HFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://supersim.twilio.com/v1/Fleets/HFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Fleet.updater("HFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
    }
}