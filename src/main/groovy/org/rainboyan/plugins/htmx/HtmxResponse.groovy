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

import javax.servlet.http.HttpServletResponse

import groovy.transform.CompileStatic

/**
 * Htmx Response Headers {link https://htmx.org/reference/#response_headers}
 *
 * @author Michael Yan
 * @since 1.0
 */
@CompileStatic
class HtmxResponse {

    public static final String HX_LOCATION = 'HX-Location'
    public static final String HX_PUSH_URL = 'HX-Push-Url'
    public static final String HX_REDIRECT = 'HX-Redirect'
    public static final String HX_REFRESH = 'HX-Refresh'
    public static final String HX_REPLACE_URL = 'HX-Replace-Url'
    public static final String HX_RESWAP = 'HX-Reswap'
    public static final String HX_RETARGET = 'HX-Retarget'
    public static final String HX_RESELECT = 'HX-Reselect'
    public static final String HX_TRIGGER = 'HX-Trigger'
    public static final String HX_TRIGGER_AFTER_SETTLE = 'HX-Trigger-After-Settle'
    public static final String HX_TRIGGER_AFTER_SWAP = 'HX-Trigger-After-Swap'

    private final HttpServletResponse response

    HtmxResponse(HttpServletResponse response) {
        this.response = response
    }

    /**
     * Allows you to do a client-side redirect that does not do a full page reload
     * @param location
     */
    void setLocation(String location) {
        setHeaderValue(HX_LOCATION, location)
    }

    /**
     * Pushes a new url into the history stack
     * @param pushUrl
     */
    void setPushUrl(String pushUrl) {
        setHeaderValue(HX_PUSH_URL, pushUrl)
    }

    /**
     * Can be used to do a client-side redirect to a new location
     * @param redirect
     */
    void setRedirect(String redirect) {
        setHeaderValue(HX_REDIRECT, redirect)
    }

    /**
     * If set to “true” the client side will do a a full refresh of the page
     * @param refresh
     */
    void setRefresh(boolean refresh) {
        setHeaderValue(HX_REFRESH, refresh)
    }

    /**
     * Replaces the current URL in the location bar
     * @param replaceUrl
     */
    void setReplaceUrl(String replaceUrl) {
        setHeaderValue(HX_REPLACE_URL, replaceUrl)
    }

    /**
     * Allows you to specify how the response will be swapped. See hx-swap for possible values
     * @param reswap
     */
    void setReswap(String reswap) {
        setHeaderValue(HX_RESWAP, reswap)
    }

    /**
     * A CSS selector that updates the target of the content update to a different element on the page
     * @param retarget
     */
    void setRetarget(String retarget) {
        setHeaderValue(HX_RETARGET, retarget)
    }

    /**
     * A CSS selector that allows you to choose which part of the response is used to be swapped in.
     * Overrides an existing hx-select on the triggering element
     * @param reselect
     */
    void setReselect(String reselect) {
        setHeaderValue(HX_RESELECT, reselect)
    }

    /**
     * Allows you to trigger client side events,
     * see the {link https://htmx.org/headers/hx-trigger/} documentation for more info
     * @param trigger
     */
    void setTrigger(String trigger) {
        setHeaderValue(HX_TRIGGER, trigger)
    }

    /**
     * Allows you to trigger client side events,
     * see the {link https://htmx.org/headers/hx-trigger/} documentation for more info
     * @param triggerAfterSettle
     */
    void setTriggerAfterSettle(String triggerAfterSettle) {
        setHeaderValue(HX_TRIGGER_AFTER_SETTLE, triggerAfterSettle)
    }

    /**
     * Allows you to trigger client side events,
     * see the {link https://htmx.org/headers/hx-trigger/} documentation for more info
     * @param triggerAfterSwap
     */
    void setTriggerAfterSwap(String triggerAfterSwap) {
        setHeaderValue(HX_TRIGGER_AFTER_SWAP, triggerAfterSwap)
    }

    void setHeaderValue(String name, Object value) {
        this.response.setHeader(name, String.valueOf(value))
    }

}
