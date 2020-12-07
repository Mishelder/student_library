<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .hyperlink{
            font: 15pt  sans-serif;
        }

        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
    <body>
        <jsp:include page="header.jsp" />
        <table id="customers" border="1" align="center">
                <tr><th>Name</th><th>Group</th><th>Email</th><th>Books</th></tr>
            <c:forEach var="stud" items="${studs}">
                <tr><td>${stud.name}</td><td>${stud.group}</td><td>${stud.email}</td><td><a href="/BookServlet?id=${stud.id}">Books</a></td></tr>
            </c:forEach>
        </table>
        <div align="center">
        <c:forEach var="link" items="${links}">
            <a class="hyperlink" name="link-${link}" href="/MainServlet?link=${link}">${link+1}</a>
        </c:forEach>
        </div>

        <jsp:include page="footer.jsp" />
    </body>
</html>