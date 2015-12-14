<%
	def attrs = [name: property, value: value, placeholder: 'dd/mm/yyyy', size: 10]
	if (required) attrs.required = ''
	out << joda.dateField(attrs)
%>