package bootstrap

import groovy.xml.MarkupBuilder
import org.grails.taglib.GrailsTagException

class ModalTagLib {
    static namespace = 'bootstrap'

    def confirmDialog = {attrs, body ->
        if (!attrs.message) throw new GrailsTagException("Attribute 'message' is required for tag 'bootstrap:confirmation'")
        if (!attrs.styleId) throw new GrailsTagException("Attribute 'styleId' is required for tag 'bootstrap:confirmation'")
        if (!attrs.onconfirm && !attrs.href && !attrs.action) throw new GrailsTagException("At least one of the following attribute is required is required for tag 'bootstrap:confirmation': onconfirm, href, action")

        if (!attrs.title) attrs.title = g.message(code: 'default.modal.title', default: 'Confirmation')
        if (!attrs.noText) attrs.noText = g.message(code: 'default.no.label', default: 'No')
        if (!attrs.yesText) attrs.yesText = g.message(code: 'default.yes.label', default: 'Yes')
        if (!attrs.href && attrs.action) attrs.href = g.createLink(controller: attrs.remove('controller'), action: attrs.remove('action'), id: attrs.remove('id'), params: attrs.remove('params'))
        if (!attrs.class) attrs.class = 'primary'
        if (!attrs.noClass) attrs.noClass = 'default'
        if (!attrs.yesClass) attrs.yesClass = 'primary'

        out << bootstrap.button(class: attrs.remove('class'), icon: attrs.remove('icon'), 'data-toggle': 'modal', 'data-target': '#' + attrs.styleId, body())

        StringWriter output = new StringWriter()
        def builder = new MarkupBuilder(output)
        builder.div(class: 'modal fade', id: attrs.styleId, tabindex: -1, role: 'dialog') {
            div(class: 'modal-dialog', role: 'document') {
                div(class: 'modal-content') {
                    div(class: 'modal-header') {
                        h4(class: 'modal-title', attrs.remove('title'))
                    }
                    div(class: 'modal-body') {
                        p(attrs.remove('message'))
                    }
                    div(class: 'modal-footer') {
                        mkp.yieldUnescaped(bootstrap.button('data-dismiss': 'modal', attrs.noText))
                        if (attrs.href) {
                            mkp.yieldUnescaped(bootstrap.linkAsButton(href: attrs.remove('href'), class: attrs.remove('noClass'), attrs.yesText))
                        } else {
                            mkp.yieldUnescaped(bootstrap.button(class: attrs.remove('yesClass'), onclick: attrs.remove('onconfirm'), attrs.yesText))
                        }
                    }
                }
            }
        }

        out << output.toString()
    }
}
