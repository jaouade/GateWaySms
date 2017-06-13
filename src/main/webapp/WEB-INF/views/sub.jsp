<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE>
<html lang="en">

<!-- Mirrored from foxythemes.net/preview/products/beagle2/pages-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 09 Apr 2017 14:57:14 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/img/logo-fav.png">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css"
          href=" <c:url value="/resources/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href=" <c:url value="/resources/assets/lib/material-design-icons/css/material-design-iconic-font.min.css" />"/>
    <link rel="stylesheet" type="text/css" href=" <c:url value="/resources/assets/css/style.css" />"/>


</head>
<body class="be-splash-screen" ng-app="App">
<div class="be-wrapper be-login" ng-controller="SubController">
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="splash-container">

                <div class="panel panel-default panel-border-color panel-border-color-success">
                    <div class="panel-heading">
                        <img src="<c:url value="/resources/assets/img/logo-xx.png" />" alt="logo" width="102"
                             height="27" class="logo-img">
                        <span class="splash-description">Please enter your user information to create your account.</span>
                    </div>
                    <div class="panel-body">
                        <form id="login-form" role="form">


                            <div class="form-group">
                                <input id="password" ng-model="password" type="password" placeholder="Password"
                                       class="form-control">
                            </div>

                            <div class="form-group login-submit">
                                <button ng-click="createSub()" name="login-submit" class="btn btn-success btn-xl">
                                    create
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/assets/lib/jquery/jquery.min.js" />"></script>

<script src="<c:url value="/resources/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" />"></script>

<script src="<c:url value="/resources/assets/js/main.js" />"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.js" type="text/javascript"></script>

<script src="<c:url value="/resources/assets/lib/bootstrap/dist/js/bootstrap.min.js" />"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-cookies.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-route.js"></script>
<script src="<c:url value="/resources/js/sub/signup.js" />"></script>

<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();
    });

</script>
</body>

<!-- Mirrored from foxythemes.net/preview/products/beagle2/pages-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 09 Apr 2017 14:57:14 GMT -->
</html>