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
<body class="be-splash-screen" ng-app="Activate" ng-controller="ActivateCtrl">
<div class="be-wrapper be-error be-error-404">
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="error-container">
                <div class="error-number">NOT ACTIVATED</div>
                <div class="error-description">Your account is <strong> not activated</strong> , We have sent you an email to activate it !! <strong>:)</strong> </div>
                <div class="error-goback-text">didn't  get the activation mail?</div><%--
                <c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>
                <div class="error-goback-button">
                    <a ng-click="resendMail()"  <%--href="${contextPath}/login"--%> class="btn btn-xl btn-success">Resend me the activation mail <br>
                        <span ng-show="loading" class="">constructing your email please wait ...</span>
                    </a>
                </div>
                <div class="footer">&copy; 2017 SMS Company </div>
            </div>
        </div>
    </div>
</div>

<div id="full-danger" class="modal-container modal-full-color modal-full-color-danger modal-effect-8" style="perspective: 1300px;">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" data-dismiss="modal" aria-hidden="true" class="close modal-close"><span class="mdi mdi-close"></span></button>
        </div>
        <div class="modal-body">
            <div class="text-center"><span class="modal-main-icon mdi mdi-close-circle-o"></span>
                <h3>Error!</h3>
                <p id="message"></p>
                <div class="xs-mt-50">
                    </div>
            </div>
        </div>
        <div class="modal-footer"></div>
    </div>
</div>
<div id="full-success" class="modal-container modal-full-color modal-full-color-success modal-effect-8" style="perspective: 1300px;">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" data-dismiss="modal" aria-hidden="true" class="close modal-close"><span class="mdi mdi-close"></span></button>
        </div>
        <div class="modal-body">
            <div class="text-center"><span class="modal-main-icon mdi mdi-check"></span>
                <h3>Awesome!</h3>
                <p id="success"></p>
                <div class="xs-mt-50">
                    </div>
            </div>
        </div>
        <div class="modal-footer"></div>
    </div>
</div>
<script src="<c:url value="/resources/assets/lib/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/resources/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/main.js" />"></script>
<script src="<c:url value="/resources/assets/lib/bootstrap/dist/js/bootstrap.min.js" />"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-cookies.js"></script>
<script src="<c:url value="/resources/assets/lib/jquery.niftymodals/dist/jquery.niftymodals.js" />" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.js" type="text/javascript"></script>
<script type="text/javascript">
    $.fn.niftyModal('setDefaults',{
        overlaySelector: '.modal-overlay',
        closeSelector: '.modal-close',
        classAddAfterOpen: 'modal-show',
    });
    $(document).ready(function () {
        //initialize the javascript
        App.init();
    });

</script>

<script type="text/javascript">

    /*var resendMail = function () {
        $.post( "../client/resend", function( data ) {
            console.log(data.status)
        });
    }*/
   angular
        .module('Activate', []).controller('ActivateCtrl',function ($scope,$http) {


           $scope.resendMail=function () {
            $scope.loading = true;
            var req = {
                method: 'POST',
                url: "../client/resend"


            };

            $http(req).then(function (response) {
                $("#success").text(response.data.success);
                $("#full-success").niftyModal("show");

            }, function (error) {
                $("#message").text(error.data.error);
                $("#full-danger").niftyModal("show");
            }).finally(function() {

                $scope.loading = false;
            });
           }
        })

</script>
</body>

</html>