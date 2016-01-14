<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" scope="request" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
		<bootstrap:submenuList />

		<bootstrap:messages />

		<bootstrap:table>
			<thead>
				<tr>
					<th><g:message code="person.firstName.label" default="First Name" /></th>
					<th><g:message code="person.lastName.label" default="Last Name" /></th>
					<th><g:message code="person.email.label" default="E-mail" /></th>
					<th><g:message code="person.dateOfBirth.label" default="Date Of Birth" /></th>
					<th><g:message code="person.age.label" default="Age" /></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${personList}" var="person">
					<tr onclick="">
						<td><g:link action="show" id="${person.id}">${person.firstName}</g:link></td>
						<td>${person.lastName}</td>
						<td>${person.email}</td>
						<td>${person.dateOfBirth}</td>
						<td>${person.age}</td>
						<td class="actions"></td>
					</tr>
				</g:each>
			</tbody>
		</bootstrap:table>

		<div class="pagination">
			<bootstrap:paginate total="${personCount ?: 0}" />
		</div>
    </body>
</html>