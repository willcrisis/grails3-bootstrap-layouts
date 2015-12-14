<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
	<div class="row-fluid">
		<div class="span3">
			<div class="well">
				<ul class="nav nav-pills">
					<li role="presentation" class="active">
						<g:link action="index">
							<i class="fa fa-list"></i>
							<g:message code="default.list.label" args="[entityName]" />
						</g:link>
					</li>
					<li role="presentation">
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
				<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			</div>
			<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
			</g:if>

			<f:table collection="${personList}" />

			<div class="pagination">
				<bootstrap:paginate total="${personCount ?: 0}" />
			</div>
		</div>
	</div>
    </body>
</html>