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

    private HttpServletRequest request

    HtmxRequest(HttpServletRequest request) {
        this.request = request
    }

    boolean isBoosted() {
        getHeaderValue('HX-Boosted') == 'true'
    }

    String getCurrentUrl() {
        getHeaderValue('HX-Current-URL')
    }

    boolean isHistoryRestoreRequest() {
        getHeaderValue('HX-History-Restore-Request')
    }

    String getPrompt() {
        getHeaderValue('HX-Prompt')
    }

    String getTarget() {
        getHeaderValue('HX-Target')
    }

    String getTrigger() {
        getHeaderValue('HX-Trigger')
    }

    String getTriggerName() {
        getHeaderValue('HX-Trigger-Name')
    }

    String getHeaderValue(String name) {
        this.request.getHeader(name)
    }

    boolean asBoolean() {
        getHeaderValue('HX-Request') == 'true'
    }

}
