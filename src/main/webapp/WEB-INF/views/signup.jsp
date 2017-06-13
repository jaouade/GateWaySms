<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>


<form:form action="signup" modelAttribute="account" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">corp name</label>
        <form:input type="text" path="client.corp_name" class="form-control"
                    id="exampleInputEmail1" placeholder="corp name"/>
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1"> name</label>
        <form:input type="text" path="client.name" class="form-control"
                    id="exampleInputEmail1" placeholder=" name"/>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1"> postal code</label>
        <form:input type="text" path="client.postal_code"
                    class="form-control" id="exampleInputEmail1"
                    placeholder=" postal code"/>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1"> email</label>
        <form:input type="text" path="client.email" class="form-control"
                    id="exampleInputEmail1" placeholder=" email"/>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1"> postal code</label>
        <form:input type="text" path="client.adresse" class="form-control"
                    id="exampleInputEmail1" placeholder="adresse"/>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1"> postal code</label>
        <form:input type="text" path="client.phone" class="form-control"
                    id="exampleInputEmail1" placeholder=" phone"/>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1"> postal code</label>
        <form:input type="text" path="client.fax" class="form-control"
                    id="exampleInputEmail1" placeholder="fax"/>
    </div>
    <div class="form-group">
        <label for="sel1">Select list:</label>
        <form:select path="client.city.idCity" class="form-control" id="sel1">

            <c:forEach var="city" items="${cities}">
                <option value="${city.idCity }">${city.cityName}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label for="sel1">Select list:</label>
        <form:select path="client.sector.idSector" class="form-control"
                     id="sel1">

            <c:forEach var="sec" items="${sectors}">
                <option value="${sec.idSector }">${sec.sectorName}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1"> postal code</label>
        <form:input type="text" path="credential.login" class="form-control"
                    id="exampleInputEmail1" placeholder="login"/>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1"> postal code</label>
        <form:input type="text" path="credential.password"
                    class="form-control" id="exampleInputEmail1" placeholder="password"/>
    </div>

    <button type="submit" class="btn btn-default">Submit</button>
</form:form>

</body>
</html>