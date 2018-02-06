<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib url="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Ot Oil</title>
  </head>
  <body>
    <h3>It is a first Ot Oil Page!</h3>

    <hr/>

    <a ref="<c:url value="/datasources" >">Data Sources</a> |
    <a ref="<c:url value="/business" >">Business</a>
    <a ref="<c:url value="/task" >">Task</a>
  </body>
</html>