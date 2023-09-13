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

@CompileStatic
class HtmxResponse {

    private HttpServletResponse response

    HtmxResponse(HttpServletResponse response) {
        this.response = response
    }

    void setLocation(String location) {
        setHeaderValue('HX-Location', location)
    }

    void setPushUrl(String pushUrl) {
        setHeaderValue('HX-Push-Url', pushUrl)
    }

    void setRedirect(String redirect) {
        setHeaderValue('HX-Redirect', redirect)
    }

    void setRefresh(boolean refresh) {
        setHeaderValue('HX-Refresh', refresh)
    }

    void setReplaceUrl(String replaceUrl) {
        setHeaderValue('HX-Replace-Url', replaceUrl)
    }

    void setReswap(String reswap) {
        setHeaderValue('HX-Reswap', reswap)
    }

    void setRetarget(String retarget) {
        setHeaderValue('HX-Retarget', retarget)
    }

    void setReselect(String reselect) {
        setHeaderValue('HX-Reselect', reselect)
    }

    void setTrigger(String trigger) {
        setHeaderValue('HX-Trigger', trigger)
    }

    void setTriggerAfterSettle(String triggerAfterSettle) {
        setHeaderValue('HX-Trigger-After-Settle', triggerAfterSettle)
    }

    void setTriggerAfterSwap(String triggerAfterSwap) {
        setHeaderValue('HX-Trigger-After-Swap', triggerAfterSwap)
    }

    void setHeaderValue(String name, Object value) {
        this.response.setHeader(name, String.valueOf(value))
    }

}
