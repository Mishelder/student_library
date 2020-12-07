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
            <tr><th>Name</th><th>Genre</th></tr>
            <c:forEach var="book" items="${books}">
                <tr><td>${book.name}</td><td>${book.genre}</td></tr>
            </c:forEach>
        </table>
        <div align="center">
            <c:forEach var="link" items="${links}">
                <a class="hyperlink" name="link-${link}" href="/BookServlet?link=${link}">${link+1}</a>
            </c:forEach>
        </div>
        <a href="/MainServlet"><h3>Back</h3></a>
        <jsp:include page="footer.jsp" />
    </body>
</html>