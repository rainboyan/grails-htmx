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
package org.rainboyan.plugins.htmx;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import org.grails.web.util.GrailsApplicationAttributes;

/**
 * {@link OncePerRequestFilter} to check current request whether from htmx or not,
 * and will set attribute content and response format.
 *
 * @author Michael Yan
 * @since 1.0
 */
public class HtmxRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (Boolean.parseBoolean(request.getHeader(HtmxRequest.HX_REQUEST))) {
            request.setAttribute(GrailsApplicationAttributes.CONTENT_FORMAT, HtmxMimeType.HTMX_FORMAT);
            request.setAttribute(GrailsApplicationAttributes.RESPONSE_FORMAT, HtmxMimeType.HTMX_FORMAT);
            request.setAttribute(GrailsApplicationAttributes.RESPONSE_MIME_TYPE, HtmxMimeType.HTMX);
        }
        filterChain.doFilter(request, response);
    }

}
