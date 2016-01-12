package bootstrap

import groovy.xml.MarkupBuilder

class ButtonsTagLib {
    static namespace = "bootstrap"

    def submitButton = {attrs, body ->
        if (!attrs.class) attrs.class = 'success'
        if (!attrs.icon) attrs.icon = 'check'
        attrs.class = "btn btn-${attrs.class}"

        StringWriter output = new StringWriter()
        def builder = new MarkupBuilder(output)
        builder.button(type: 'submit', class: attrs.remove('class')) {
            i(class: "fa fa-fw fa-${attrs.remove('icon')}") {
                mkp.yieldUnescaped("&nbsp")
            }
            mkp.yieldUnescaped(body())
        }

        out << output.toString()
    }

    def submitButtonInForm = {attrs, body ->
        StringWriter output = new StringWriter()
        def builder = new MarkupBuilder(output)
        builder.div(class: 'form-group') {
            div(class: 'col-sm-offset-2 col-sm-10') {
                mkp.yieldUnescaped(submitButton(attrs, body))
            }
        }

        out << output.toString()
    }
}
