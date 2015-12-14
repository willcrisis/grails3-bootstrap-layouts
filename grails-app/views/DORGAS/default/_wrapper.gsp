<%@ page defaultCodec="html" %>
<div class="form-group ${invalid ? 'error' : ''}">
    <label class="col-sm-2 control-label" for="${property}">${label}</label>
    <div class="col-sm-10">
        <%= widget %>
        <g:if test="${invalid}"><span class="help-inline">${errors.join('<br>')}</span></g:if>
    </div>
</div>