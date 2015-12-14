<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
	<div class="row-fluid">
		<div class="span3">
			<div class="well">
				<ul class="nav nav-pills">
					<li role="presentation">
						<g:link action="list">
							<i class="fa fa-list"></i>
							<g:message code="default.list.label" args="[entityName]" />
						</g:link>
					</li>
					<li role="presentation" class="active">
						<g:link action="create">
							<i class="fa fa-plus"></i>
							<g:message code="default.create.label" args="[entityName]" />
						</g:link>
					</li>
				</ul>
			</div>
		</div>

		<div class="span9">
			<div class="page-header">
				<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			</div>

			<g:if test="\${flash.message}">
				<bootstrap:alert class="alert-info">\${flash.message}</bootstrap:alert>
			</g:if>

			<g:hasErrors bean="\${this.${propertyName}}">
				<bootstrap:alert class="alert-error">
					<ul>
						<g:eachError bean="\${this.${propertyName}}" var="error">
							<li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>><g:message error="\${error}"/></li>
						</g:eachError>
					</ul>
				</bootstrap:alert>
			</g:hasErrors>
		</div>
	</div>
    </body>
</html>
