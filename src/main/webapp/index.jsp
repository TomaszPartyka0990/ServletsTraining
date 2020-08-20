<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<body>
<h2>Servlets 01 - 09.08.2020</h2>
<hr>
<h4>Random Servlet</h4>
<a href="/Server01/randomJson">RandomServlet</a><br>
<a href="/Server01/servletsCommunication">ServletsCommunication - default</a><br>
<a href="/Server01/servletsCommunication?giveRandomNumber=true">ServletsCommunication - with true parameter</a><br>
<hr><br>
<h4>Logowanie</h4>
<a href="/Server01/log">Logowanie domyslne</a><br>
<a href="/Server01/log?valid=hello">Logowanie hello</a><br>
<a href="/Server01/log?valid=xyz">Logowanie xyz</a><br>
<a href="/Server01/log?valid=0">Logowanie wartosc 0</a><br>
<a href="/Server01/log?valid=5">Logowanie wartosc 5</a><br>
<hr><br>
<h4>Redirects</h4>
<a href="/Server01/finalServlet">Strona główna</a><br>
<a href="/Server01/redirect">Przekierowanie po stronie klienta</a><br>
<a href="/Server01/forward">Przekierowanie po stronie serwera - forward</a><br>
<a href="/Server01/include">Przekierowanie po stronie serwera - include</a><br>
<hr><br>
<h4>Names</h4>
<form action="/Server01/getName">
    <label for="name">Provide name to add</label>
    <input id="name" name="name" type="text" required>
    <button>Add Name</button>
</form>
<br>
<a href="/Server01/showAllNames">Lista wszystkich zapisanych imion</a><br>
</body>
</html>
