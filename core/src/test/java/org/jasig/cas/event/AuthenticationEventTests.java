/*
 * Copyright 2004 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.uportal.org/license.html
 */
package org.jasig.cas.event;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;

import junit.framework.TestCase;

/**
 * 
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.0
 *
 */
public class AuthenticationEventTests extends TestCase {

    private AuthenticationEvent authenticationEvent;
    
    private Credentials credentials = new UsernamePasswordCredentials();

    public void testGetCredentials() {
        this.authenticationEvent = new AuthenticationEvent(this.credentials, true);
        
        assertEquals(this.credentials, this.authenticationEvent.getCredentials());
    }
    
    public void testIsSuccessful() {
        this.authenticationEvent = new AuthenticationEvent(this.credentials, true);
        assertTrue(this.authenticationEvent.isSuccessfulAuthentication());
    }
    
    public void testIsNotSuccessful() {
        this.authenticationEvent = new AuthenticationEvent(this.credentials, false);
        assertFalse(this.authenticationEvent.isSuccessfulAuthentication());
    }
    
    public void testPublishedDate() {
        this.authenticationEvent = new AuthenticationEvent(this.credentials, false);
        assertEquals(new Date(), this.authenticationEvent.getPublishedDate());
    }
    
    public void testToString() {
        this.authenticationEvent = new AuthenticationEvent(this.credentials, true);
        assertEquals(ToStringBuilder.reflectionToString(this.authenticationEvent), this.authenticationEvent.toString());
    }
}