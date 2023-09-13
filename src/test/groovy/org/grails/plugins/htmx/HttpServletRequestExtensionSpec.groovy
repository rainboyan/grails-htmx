package org.grails.plugins.htmx

import org.springframework.mock.web.MockHttpServletRequest
import spock.lang.Specification

class HttpServletRequestExtensionSpec extends Specification {

    void "Test identification of HTMx requests"() {
        when: "a regular request is used"
        def request = new MockHttpServletRequest()
        then: "it isn't an HTMx request"
        !request.isHtmx()

        when: "A non XHR request is sent with the HX-Request header"
        request.addHeader("HX-Request", "false")

        then: "It is not an HTMx request"
        !request.isHtmx()

        when: "A request is sent with a HX-Request value of true"
        request = new MockHttpServletRequest()
        request.addHeader("HX-Request", "true")

        then: "It is an HTMx request"
        request.isHtmx()
    }

    void "Test details of HTMx requests"() {
        def request = new MockHttpServletRequest()
        request.addHeader("HX-Request", "true")

        when: "A request is sent with a HX-Boosted value of true"
        request.addHeader("HX-Boosted", "true")

        then: "the HTMx request is via an element using hx-boost"
        request.htmx.boosted

        when: "A request is sent with a HX-History-Restore-Request value of true"
        request.addHeader("HX-History-Restore-Request", "true")

        then: "The request is for history restoration after a miss in the local history cache"
        request.htmx.historyRestoreRequest

        when: "A request is sent with a HX-Current-URL value of 'https://example.com/the-hx-example-page'"
        request.addHeader("HX-Current-URL", "https://example.com/the-hx-example-page")

        then: "The current URL of the browser"
        request.htmx.currentURL == 'https://example.com/the-hx-example-page'

        when: "A request is sent with a HX-Prompt value of 'Do you want to Delete it!'"
        request.addHeader("HX-Prompt", "Do you want to Delete it!")

        then: "The user response to an hx-prompt"
        request.htmx.prompt == 'Do you want to Delete it!'

        when: "A request is sent with a HX-Target value of 'hx-target-123'"
        request.addHeader("HX-Target", "hx-target-123")

        then: "The ID of the target element is 'hx-target-123'"
        request.htmx.target == 'hx-target-123'

        when: "A request is sent with a HX-Trigger value of 'hx-trigger-123'"
        request.addHeader("HX-Trigger", "hx-trigger-123")

        then: "The ID of the triggered element is 'hx-trigger-123'"
        request.htmx.triggerId == 'hx-trigger-123'

        when: "A request is sent with a HX-Trigger-Name value of 'hx-trigger-article'"
        request.addHeader("HX-Trigger-Name", "hx-trigger-article")

        then: "The Name of the triggered element is 'hx-trigger-article'"
        request.htmx.triggerName == 'hx-trigger-article'
    }

}
