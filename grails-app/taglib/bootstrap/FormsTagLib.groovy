package bootstrap

import groovy.xml.MarkupBuilder
import org.grails.taglib.GrailsTagException
import org.springframework.validation.Errors
import org.springframework.validation.FieldError

class FormsTagLib {

	static namespace = "bootstrap"
	
	def fieldError = { attrs ->
		def bean = attrs.bean
		def field = attrs.field
		Errors errors = bean.errors
		FieldError error = errors.getFieldError(field)
		out << g.hasErrors(bean: bean, field: field) {
			out << '<span class="help-inline">'
			out << g.message(error: error)
			out << '</span>'
		}
		
	}

	def textField = { attrs ->
        out << writeField(attrs, 'text')
	}

    def emailField = { attrs ->
        out << writeField(attrs, 'email')
	}

    def dateField = { attrs ->
        if (!attrs.class) attrs.class = ''
        out << writeWrapperForDateField(attrs, 'date')
	}

    def dateTimeField = { attrs ->
        if (!attrs.class) attrs.class = ''
        attrs.class += ' dateTime'
        out << writeField(attrs, 'text')
	}

    def textFieldLabel = { attrs ->
        if (!attrs.name) throw new GrailsTagException("Attribute 'name' required for tag 'bootstrap:textFieldLabel'")
        if (!attrs.label) throw new GrailsTagException("Attribute 'label' required for tag 'bootstrap:textFieldLabel'")

		out << writeWrapperForTextField(attrs, 'textField')
	}

    def emailFieldLabel = { attrs ->
        if (!attrs.name) throw new GrailsTagException("Attribute 'name' required for tag 'bootstrap:emailFieldLabel'")
        if (!attrs.label) throw new GrailsTagException("Attribute 'label' required for tag 'bootstrap:emailFieldLabel'")

		out << writeWrapperForTextField(attrs, 'emailField')
	}

    def dateFieldLabel = { attrs ->
        if (!attrs.name) throw new GrailsTagException("Attribute 'name' required for tag 'bootstrap:dateFieldLabel'")
        if (!attrs.label) throw new GrailsTagException("Attribute 'label' required for tag 'bootstrap:dateFieldLabel'")

		out << writeWrapperForTextField(attrs, 'dateField')
	}

    def dateTimeFieldLabel = { attrs ->
        if (!attrs.name) throw new GrailsTagException("Attribute 'name' required for tag 'bootstrap:dateFieldLabel'")
        if (!attrs.label) throw new GrailsTagException("Attribute 'label' required for tag 'bootstrap:dateFieldLabel'")

		out << writeWrapperForDateField(attrs, 'date', 'dateTimeField')
	}

    private def writeWrapperForTextField(def attrs, def field) {
        StringWriter output = new StringWriter()
        MarkupBuilder builder = new MarkupBuilder(output)
        builder.div(class: 'form-group') {
            label(class: 'col-sm-2 control-label', for: attrs.name) {
                mkp.yieldUnescaped(g.message(code: "$attrs.label", default: "${attrs.remove('label')}"))
                if (attrs.required) {
                    span(class: 'required', '*')
                }
            }
            div(class: 'col-sm-10') {
                mkp.yieldUnescaped("$field"(attrs))
            }
        }
        return output.toString()
    }

    private def writeField(def attrs, def type) {
        if (!attrs.name) throw new GrailsTagException("Attribute 'name' required for tag 'bootstrap:textField'")

        if (!attrs.class) attrs.class = ''
        attrs.class += ' form-control'
        attrs.type = type
        return g.field(attrs)
    }

    private def writeWrapperForDateField(def attrs, def type) {
        StringWriter output = new StringWriter()
        MarkupBuilder builder = new MarkupBuilder(output)
        builder.div(class: "input-append ${type}") {
            div(class: 'input-group') {
                mkp.yieldUnescaped(writeField(attrs, 'text'))
                span(class: 'input-group-addon add-on') {
                    i(class: 'fa fa-fw fa-calendar', 'data-time-icon': 'fa fa-fw fa-clock-o', 'data-date-icon': 'fa fa-fw fa-calendar') {
                        mkp.yieldUnescaped("&nbsp")
                    }
                }
            }
        }

        return output.toString()
    }
}
