<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<#--<#list users?filter(ele-> !(exclude && ele?contains("baomidou"))) as user>-->
<#--    ${user}-->
<#--</#list>-->
<#assign packages2import=packages?filter(ele-> !(exclude && ele?contains("baomidou")))>
<#assign primaryKeyIsNotId = (table.fields?filter(ele->ele.isPK && ele.name != 'id'))?size gt 0>
<#if primaryKeyIsNotId>
    <#assign packages2import= packages2import+["primaryKey"]>
</#if>
<#list packages2import as package>
    ${package}
</#list>

public class ${table.name}

<#list table.fields as field>
    <#if field.isPK && primaryKeyIsNotId>
        @PrimaryKey
    </#if>
    private ${field.typeName} ${field.name};

</#list>

</body>
</html>