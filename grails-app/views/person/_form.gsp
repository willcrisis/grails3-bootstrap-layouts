<bootstrap:textFieldLabel label="person.firstName.label" name="firstName" value="${person?.firstName}" required="required" />
<bootstrap:textFieldLabel label="person.lastName.label" name="lastName" value="${person?.lastName}" required="required" />
<bootstrap:emailFieldLabel label="person.email.label" name="email" value="${person?.email}" />
<bootstrap:dateFieldLabel label="person.dateOfBirth.label" name="dateOfBirth" value="${person?.dateOfBirth}" />

<bootstrap:submitButtonInForm class="success"><g:message code="default.button.save.label"/></bootstrap:submitButtonInForm>
