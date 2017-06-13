<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/img/logo-fav.png">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/material-design-icons/css/material-design-iconic-font.min.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/css/style.css" />"/>
</head>
<body class="be-splash-screen">
<div class="be-wrapper be-error be-error-404">
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="error-container">
                <div class="error-number text-sucess">SUCCESS</div>
                <div class="error-description text-warning">Your account has been successfully activated</div>
                <div class="error-goback-text">Would you like to go home?</div>
                <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
                <div class="error-goback-button"><a href="${contextPath}/login" class="btn btn-xl btn-primary">Let's go
                    home</a></div>
                <div class="footer">&copy; 2017 SMS Company</div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/assets/lib/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/resources/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js" />"></script>
<script src="<c:url value="/resources/assets/lib/bootstrap/dist/js/bootstrap.min.js" />"></script>

<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();
    });

</script>
</body>

</html>