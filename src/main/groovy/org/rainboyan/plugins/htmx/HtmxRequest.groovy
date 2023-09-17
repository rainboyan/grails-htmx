/*
 * Copyright 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rainboyan.plugins.htmx

import javax.servlet.http.HttpServletRequest

import groovy.transform.CompileStatic

/**
 * Htmx Request Headers {link https://htmx.org/reference/#request_headers}
 *
 * @author Michael Yan
 * @since 1.0
 */
@CompileStatic
class HtmxRequest {

    public static final String HX_REQUEST = 'HX-Request'
    public static final String HX_BOOSTED = 'HX-Boosted'
    public static final String HX_HISTORY_RESTORE_REQUEST = 'HX-History-Restore-Request'
    public static final String HX_CURRENT_URL = 'HX-Current-URL'
    public static final String HX_PROMPT = 'HX-Prompt'
    public static final String HX_TARGET = 'HX-Target'
    public static final String HX_TRIGGER = 'HX-Trigger'
    public static final String HX_TRIGGER_NAME = 'HX-Trigger-Name'

    private final HttpServletRequest request

    HtmxRequest(HttpServletRequest request) {
        this.request = request
    }

    /**
     * Indicates that the request is via an element using hx-boost
     */
    boolean isBoosted() {
        Boolean.parseBoolean(getHeaderValue(HX_BOOSTED))
    }

    /**
     * The current URL of the browser
     */
    String getCurrentUrl() {
        getHeaderValue(HX_CURRENT_URL)
    }

    /**
     * True if the request is for history restoration after a miss in the local history cache
     */
    boolean isHistoryRestoreRequest() {
        getHeaderValue(HX_HISTORY_RESTORE_REQUEST)
    }

    /**
     * The user response to an hx-prompt
     */
    String getPrompt() {
        getHeaderValue(HX_PROMPT)
    }

    /**
     * Always true
     */
    boolean getRequest() {
        Boolean.parseBoolean(getHeaderValue(HX_REQUEST))
    }

    /**
     * The id of the target element if it exists
     */
    String getTarget() {
        getHeaderValue(HX_TARGET)
    }

    /**
     * The id of the triggered element if it exists
     */
    String getTrigger() {
        getHeaderValue(HX_TRIGGER)
    }

    /**
     * The name of the triggered element if it exists
     */
    String getTriggerName() {
        getHeaderValue(HX_TRIGGER_NAME)
    }

    /**
     * Get header value from request
     * @param The name of header
     * @return value
     */
    String getHeaderValue(String name) {
        this.request.getHeader(name)
    }

    boolean asBoolean() {
        getRequest()
    }

}
