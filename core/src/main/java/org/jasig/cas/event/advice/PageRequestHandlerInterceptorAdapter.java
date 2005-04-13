/*
 * Copyright 2005 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.uportal.org/license.html
 */
package org.jasig.cas.event.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.event.PageRequestHttpRequestEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * HandlerInterceptor that will on a successful completion of a page rendering, publish a 
 * PageRequestHttpRequestEvent.
 * 
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.0
 * 
 * @see org.jasig.cas.event.PageRequestHttpRequestEvent
 *
 */
public class PageRequestHandlerInterceptorAdapter extends HandlerInterceptorAdapter implements ApplicationEventPublisherAware {
    
    /** The publisher to publish events. */
    private ApplicationEventPublisher applicationEventPublisher;

    public void setApplicationEventPublisher(final ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        PageRequestHttpRequestEvent event = new PageRequestHttpRequestEvent(request);
        this.applicationEventPublisher.publishEvent(event);
    }
}