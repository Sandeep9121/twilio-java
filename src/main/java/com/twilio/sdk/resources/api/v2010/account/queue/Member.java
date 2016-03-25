/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.resources.api.v2010.account.queue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.MarshalConverter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.api.v2010.account.queue.MemberFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.api.v2010.account.queue.MemberReader;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.SidResource;
import com.twilio.sdk.updaters.api.v2010.account.queue.MemberUpdater;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Member extends SidResource {
    private static final long serialVersionUID = 27782479642114L;

    /**
     * Create a MemberFetcher to execute fetch.
     * 
     * @param accountSid The account_sid
     * @param queueSid The Queue in which to find the members
     * @param callSid The call_sid
     * @return MemberFetcher capable of executing the fetch
     */
    public static MemberFetcher fetch(final String accountSid, 
                                      final String queueSid, 
                                      final String callSid) {
        return new MemberFetcher(accountSid, queueSid, callSid);
    }

    /**
     * Create a MemberUpdater to execute update.
     * 
     * @param accountSid The account_sid
     * @param queueSid The Queue in which to find the members
     * @param callSid The call_sid
     * @param url The url
     * @param method The method
     * @return MemberUpdater capable of executing the update
     */
    public static MemberUpdater update(final String accountSid, 
                                       final String queueSid, 
                                       final String callSid, 
                                       final URI url, 
                                       final HttpMethod method) {
        return new MemberUpdater(accountSid, queueSid, callSid, url, method);
    }

    /**
     * Create a MemberReader to execute read.
     * 
     * @param accountSid The account_sid
     * @param queueSid The Queue in which to find members
     * @return MemberReader capable of executing the read
     */
    public static MemberReader read(final String accountSid, 
                                    final String queueSid) {
        return new MemberReader(accountSid, queueSid);
    }

    /**
     * Converts a JSON String into a Member object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Member object represented by the provided JSON
     */
    public static Member fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Member.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Member object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Member object represented by the provided JSON
     */
    public static Member fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Member.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String callSid;
    private final DateTime dateEnqueued;
    private final Integer position;
    private final String uri;
    private final Integer waitTime;

    @JsonCreator
    private Member(@JsonProperty("call_sid")
                   final String callSid, 
                   @JsonProperty("date_enqueued")
                   final String dateEnqueued, 
                   @JsonProperty("position")
                   final Integer position, 
                   @JsonProperty("uri")
                   final String uri, 
                   @JsonProperty("wait_time")
                   final Integer waitTime) {
        this.callSid = callSid;
        this.dateEnqueued = MarshalConverter.rfc2822DateTimeFromString(dateEnqueued);
        this.position = position;
        this.uri = uri;
        this.waitTime = waitTime;
    }

    /**
     * Returns The Unique string that identifies this resource.
     * 
     * @return Unique string that identifies this resource
     */
    public final String getSid() {
        return this.getCallSid();
    }

    /**
     * Returns The Unique string that identifies this resource.
     * 
     * @return Unique string that identifies this resource
     */
    public final String getCallSid() {
        return this.callSid;
    }

    /**
     * Returns The The date the member was enqueued.
     * 
     * @return The date the member was enqueued
     */
    public final DateTime getDateEnqueued() {
        return this.dateEnqueued;
    }

    /**
     * Returns The This member's current position in the queue..
     * 
     * @return This member's current position in the queue.
     */
    public final Integer getPosition() {
        return this.position;
    }

    /**
     * Returns The The uri.
     * 
     * @return The uri
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The The number of seconds the member has been in the queue..
     * 
     * @return The number of seconds the member has been in the queue.
     */
    public final Integer getWaitTime() {
        return this.waitTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Member other = (Member) o;
        
        return Objects.equals(callSid, other.callSid) && 
               Objects.equals(dateEnqueued, other.dateEnqueued) && 
               Objects.equals(position, other.position) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(waitTime, other.waitTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callSid,
                            dateEnqueued,
                            position,
                            uri,
                            waitTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("callSid", callSid)
                          .add("dateEnqueued", dateEnqueued)
                          .add("position", position)
                          .add("uri", uri)
                          .add("waitTime", waitTime)
                          .toString();
    }
}