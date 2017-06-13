<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon"
          href=" <c:url value="/resources/assets/img/logo-fav.png" />">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/material-design-icons/css/material-design-iconic-font.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/jquery.vectormap/jquery-jvectormap-1.2.2.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/jqvmap/jqvmap.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/datetimepicker/css/bootstrap-datetimepicker.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/css/style.css" />"/>
    <title><spring:error code="page.auth.title"/></title>
</head>
<body class="be-splash-screen" ng-app="SignUp"
      ng-controller="SignupController">

<div class="be-wrapper be-login be-signup">
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="splash-container sign-up">
                <div
                        class="panel panel-default panel-border-color panel-border-color-primary">
                    <div class="panel-heading">
                        <img src="<c:url value="/resources/assets/img/logo-xx.png" />" alt="logo" width="102"
                             height="27" class="logo-img"><span
                            class="splash-description">Please enter your user
								information.</span>
                    </div>
                    <div class="panel-body">
                        <form>
                            <span class="splash-title xs-pb-20">Sign Up</span>

                            <div class="form-group row signup-password">
                                <div class="col-xs-6">
                                    <input type="text" ng-model="corp_name" class="form-control"
                                           id="exampleInputEmail1" placeholder="corp name">
                                </div>
                                <div class="col-xs-6">
                                    <input ng-model="name" class="form-control"
                                           id="exampleInputEmail1" placeholder=" name">
                                </div>
                            </div>
                            <div class="form-group row signup-password">
                                <div class="col-xs-6">
                                    <input ng-model="postal_code" class="form-control"
                                           id="exampleInputEmail1" placeholder=" postal code">
                                </div>
                                <div class="col-xs-6">
                                    <input ng-model="email" class="form-control"
                                           id="exampleInputEmail1" placeholder=" email">
                                </div>
                            </div>
                            <div class="form-group row signup-password">
                                <div class="col-xs-6">
                                    <input ng-model="adresse" class="form-control"
                                           id="exampleInputEmail1" placeholder="adresse">
                                </div>
                                <div class="col-xs-6">
                                    <input ng-model="phone" class="form-control"
                                           id="exampleInputEmail1" placeholder=" phone">
                                </div>
                            </div>
                            <div class="form-group">
                                <input ng-model="fax" class="form-control"
                                       id="exampleInputEmail1" placeholder="fax">
                            </div>


                            <div class="form-group row signup-password">
                                <div class="col-xs-6">
                                    <select ng-model="idCity" class="form-control" id="sel1">


                                        <option ng-repeat="city in cities " value="{{city.idCity}}">{{city.cityName}}
                                        </option>


                                    </select>
                                </div>
                                <div class="col-xs-6">
                                    <select ng-model="idSector" class="form-control" id="sel1">

                                        <option ng-repeat="sector in sectors "
                                                value="{{sector.idSector}}">{{sector.sectorName}}
                                        </option>

                                    </select>
                                </div>
                            </div>
                            <div class="form-group row signup-password">
                                <div class="col-xs-6">
                                    <input type="text" ng-model="login" class="form-control"
                                           id="exampleInputEmail1" placeholder="login">
                                </div>
                                <div class="col-xs-6">
                                    <input type="text" ng-model="password" class="form-control"
                                           id="exampleInputEmail1" placeholder="password">
                                </div>
                            </div>
                            <div ng-if="error" role="alert"
                                 class="alert alert-contrast alert-danger alert-dismissible">
                                <div class="icon">
                                    <span class="mdi mdi-close-circle-o"></span>
                                </div>
                                <div class="error">
                                    <button type="button" data-dismiss="alert" aria-label="Close"
                                            class="close">
                                        <span aria-hidden="true" class="mdi mdi-close"> </span>
                                    </button>
                                    <strong>Error!</strong>{{errorMsg}}.
                                </div>
                            </div>
                            <div class="form-group xs-pt-10">
                                <button type="submit" ng-click="signup()"
                                        class="btn btn-block btn-primary btn-xl">Sign Up
                                </button>
                            </div>
                            <div class="title">
                                <span class="splash-title xs-pb-15">Or</span>
                            </div>


                            <div class="form-group xs-pt-10">
                                <div class="be-checkbox">
                                    <input type="checkbox" id="remember"> <label
                                        for="remember">By creating an account, you agree the
                                    <a href="#">terms and conditions</a>.
                                </label>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="splash-footer">&copy; 2016 Beagle</div>
            </div>
        </div>
    </div>
</div>
<script
        src="<c:url value="/resources/assets/lib/jquery/jquery.min.js" />"></script>
<script
        src="<c:url value="/resources/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" />"></script>
<script src="<c:url value="/resources/assets/js/main.js" />"></script>
<script
        src="<c:url value="/resources/assets/lib/bootstrap/dist/js/bootstrap.min.js" />"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.js"></script>


<script
        src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-cookies.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-route.js"></script>
<script src="<c:url value="/resources/js/signup.js" />"></script>

<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();

    });
</script>
</body>
</html>

















