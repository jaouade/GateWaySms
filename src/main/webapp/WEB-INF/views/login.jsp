<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("index/"); %>
</sec:authorize>
<!DOCTYPE>
<html lang="en">

<!-- Mirrored from foxythemes.net/preview/products/beagle2/pages-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 09 Apr 2017 14:57:14 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css"
          href=" <c:url value="/resources/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href=" <c:url value="/resources/assets/lib/material-design-icons/css/material-design-iconic-font.min.css" />"/>
    <link rel="stylesheet" type="text/css" href=" <c:url value="/resources/assets/css/style.css" />"/>


</head>
<body class="be-splash-screen">
<div class="be-wrapper be-login">
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="splash-container">

                <c:if test="${param.error  eq 1}">
                    <div role="alert" class="alert alert-danger alert-dismissible">
                        <button type="button" data-dismiss="alert" aria-label="Close" class="close"><span
                                aria-hidden="true" class="mdi mdi-close"></span></button>
                        <span class="icon mdi mdi-close-circle-o"></span>
                        <strong>Error !</strong>
                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                    </div>
                </c:if>
                <c:if test="${param.logout  eq 1}">
                    <div role="alert" class="alert alert-contrast alert-warning alert-dismissible">
                        <div class="icon"><span class="mdi mdi-alert-triangle"></span></div>
                        <div class="error">
                            <button type="button" data-dismiss="alert" aria-label="Close" class="close">
                                <span aria-hidden="true" class="mdi mdi-close"></span></button>
                            <strong>logout !</strong>vous êtes deconnectés veuillez se connecter !
                        </div>
                    </div>

                </c:if>
                <div class="panel panel-default panel-border-color panel-border-color-success">
                    <div class="panel-heading">
                        <img src="<c:url value="/resources/assets/img/logo-xx.png" />" alt="logo" width="102"
                             height="27" class="logo-img">
                        <span class="splash-description">Please enter your user information.</span></div>
                    <div class="panel-body">
                        <form id="login-form" action="login" method="post" role="form">
                            <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <div class="form-group">
                                <input type="text" name="username" placeholder="Login" autocomplete="off"
                                       class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="password" name="password" type="password" placeholder="Password"
                                       class="form-control">
                            </div>
                            <div class="form-group row login-tools">
                                <div class="col-xs-6 login-remember">
                                    <div class="be-checkbox">
                                        <input type="checkbox" name="rememberMe" id="rememberMe">
                                        <label for="rememberMe">Remember Me</label>
                                    </div>
                                </div>
                                <div class="col-xs-6 login-forgot-password"><a href="#">Forgot Password?</a></div>
                            </div>
                            <div class="form-group login-submit">
                                <button type="submit" name="login-submit" class="btn btn-success btn-xl">Sign me in
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="splash-footer"><span>Don't have an account? <a href="#">Sign Up</a></span></div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/assets/lib/jquery/jquery.min.js" />"></script>

<script src="<c:url value="/resources/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" />"></script>

<script src="<c:url value="/resources/assets/js/main.js" />"></script>

<script src="<c:url value="/resources/assets/lib/bootstrap/dist/js/bootstrap.min.js" />"></script>

<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();
    });

</script>
</body>

<!-- Mirrored from foxythemes.net/preview/products/beagle2/pages-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 09 Apr 2017 14:57:14 GMT -->
</html>