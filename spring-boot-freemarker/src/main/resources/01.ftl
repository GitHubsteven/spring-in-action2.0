<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<#list users?filter(ele-> !(exclude && ele?contains("baomidou"))) as user>
    ${user}
</#list>
</body>
</html>