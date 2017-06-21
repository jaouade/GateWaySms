<%@ page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href=" <c:url value="/resources/assets/img/logo-fav.png" />">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/datetimepicker/css/bootstrap-datetimepicker.min.css" />">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/daterangepicker/css/daterangepicker.css" />">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/material-design-icons/css/material-design-iconic-font.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/jquery.vectormap/jquery-jvectormap-1.2.2.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/lib/jqvmap/jqvmap.min.css" />"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/assets/lib/datetimepicker/css/bootstrap-datetimepicker.min.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/css/style.css" />"/>
    <link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet"
          href="<c:url value="/resources/js/bower_components/angularjs-datetime-picker/angularjs-datetime-picker.css" />"/>

    <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<c:url value="/resources/css/autocomplete/css/normalize.min.css" />">
    <link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/autocomplete/css/main.css" />">
    <script type="text/javascript" async="" src="http://www.google-analytics.com/ga.js"></script>
    <script src="<c:url value="/resources/js/autocomplete/js/vendor/modernizr-2.6.2.min.js" />"></script>

</head>
<body  ng-app="SmsApp">
<div class="be-wrapper be-fixed-sidebar">
    <nav class="navbar navbar-default navbar-fixed-top be-top-header">

        <div class="container-fluid">
            <div class="navbar-header"><a href="#" class="navbar-brand"></a>
            </div>
            <div class="be-right-navbar">
                <ul class="nav navbar-nav navbar-right be-user-nav">


                    <li class="dropdown">
                        <a href="" data-toggle="dropdown" role="button" aria-expanded="false" class="dropdown-toggle">
                            <img src="<c:url value="/resources/assets/img/avatar.png" />" alt="Avatar">
                            <span class="user-name">Túpac Amaru</span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li>
                                <div class="user-info">
                                    <div class="user-name">Túpac Amaru</div>
                                    <div class="user-position online">Available</div>
                                </div>
                            </li>
                            <li><a href="<c:url value="#!/profile" />"><span class="icon mdi mdi-face"></span> Account</a></li>
                            <li><a href="#"><span class="icon mdi mdi-settings"></span> Settings</a></li>
                            <li><a href="<c:url value="#!/recharge" />"><span class="icon mdi mdi-power"></span>
                                recharger mon compte</a></li>
                            <li><a href="<c:url value="/logout" />"><span class="icon mdi mdi-power"></span> Logout</a>
                            </li>
                            <li><a href="<c:url value="#!/sub-account" />"><span
                                    class="icon mdi mdi-assignment-account"></span> Create sub account</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="page-title"><span>Dashboard</span></div>

                <ul class="nav navbar-nav navbar-right be-icons-nav">

                    <li class="dropdown"><a href="" data-toggle="dropdown" role="button" aria-expanded="false"
                                            class="dropdown-toggle"><span class="badge badge-warning"> {{$root.account.client.remaining_credit}} $ </span></a>
                    </li>
                    <li class="dropdown"><a href="" data-toggle="dropdown" role="button" aria-expanded="false"
                                            class="dropdown-toggle"><span class="badge badge-success"> {{$root.account.smsCredit}} message(s)</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="be-left-sidebar">
        <div class="left-sidebar-wrapper"><a href="#" class="left-sidebar-toggle">Dashboard</a>
            <div class="left-sidebar-spacer">
                <div class="left-sidebar-scroll">
                    <div class="left-sidebar-content">
                        <ul class="sidebar-elements">
                            <li class="divider">Menu</li>
                            <li class="active"><a href="#!/home"><i class="icon mdi mdi-home"></i><span>Home</span></a>
                            </li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>Compaigns</span></a>
                                <ul class="sub-menu">
                                    <li><a href="#!/compaings"><i class="icon mdi mdi-comment-edit"></i> Create Compaing</a>
                                    </li>
                                    <li><a href="#"><i class="icon mdi mdi-format-line-spacing"></i> Compaings list</a>
                                    </li>

                                </ul>
                            </li>
                            <li class="parent"><a href="charts.html"><i class="icon mdi mdi-comment-edit"></i><span>Send SMS</span></a>
                                <ul class="sub-menu">
                                    <li><a href="#!/message"> <i class="icon mdi mdi-comment-edit"></i> Compose SMS</a>
                                    </li>

                                    <li><a href="#!/sms-template"><i class="icon mdi mdi-receipt"></i> SMS Template</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent"><a href="#"><i
                                    class="icon mdi mdi-dot-circle"></i><span>Phone Book</span></a>
                                <ul class="sub-menu">
                                    <li><a href="#!/phoneBook/edit/1"> <i class="icon mdi mdi-accounts-list"></i> Contacts</a>
                                    </li>

                                </ul>
                            </li>
                            <li class="parent"><a href="#"><i
                                    class="icon mdi mdi-view-headline"></i><span>Reports</span></a>
                                <ul class="sub-menu">
                                    <li><a href="tables-general.html"><i class="icon mdi mdi-time"></i> Messages Status</a>
                                    </li>
                                    <li><a href="tables-datatables.html"></a>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-layers"></i><span>Pages</span></a>
                                <ul class="sub-menu">
                                    <li><a href="pages-blank.html">Blank Page</a>
                                    </li>
                                    <li><a href="pages-blank-header.html">Blank Page Header</a>
                                    </li>
                                    <li><a href="pages-login.html">Login</a>
                                    </li>
                                    <li><a href="pages-login2.html">Login v2</a>
                                    </li>
                                    <li><a href="pages-404.html">404 Page</a>
                                    </li>
                                    <li><a href="pages-sign-up.html">Sign Up</a>
                                    </li>
                                    <li><a href="pages-forgot-password.html">Forgot Password</a>
                                    </li>
                                    <li><a href="pages-profile.html">Profile</a>
                                    </li>
                                    <li><a href="pages-pricing-tables.html">Pricing Tables</a>
                                    </li>
                                    <li><a href="pages-pricing-tables2.html">Pricing Tables v2</a>
                                    </li>
                                    <li><a href="pages-timeline.html"><span
                                            class="label label-primary pull-right">New</span>Timeline</a>
                                    </li>
                                    <li><a href="pages-timeline2.html"><span
                                            class="label label-primary pull-right">New</span>Timeline v2</a>
                                    </li>
                                    <li><a href="pages-invoice.html"><span
                                            class="label label-primary pull-right">New</span>Invoice</a>
                                    </li>
                                    <li><a href="pages-calendar.html">Calendar</a>
                                    </li>
                                    <li><a href="pages-gallery.html">Gallery</a>
                                    </li>
                                </ul>
                            </li>




                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="be-content">
        <div class="main-content container-fluid" ng-controller="HomeController">

            <div ng-view>
            </div>

        </div>
    </div>

</div>

<script src="<c:url value="/resources/assets/lib/jquery/jquery.min.js" />"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script src="<c:url value="/resources/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" />"></script>
<script src="<c:url value="/resources/assets/js/main.js" />"></script>
<script src="<c:url value="/resources/assets/lib/bootstrap/dist/js/bootstrap.min.js" />"></script>
<script src=" <c:url value="/resources/js/autocomplete/jquery.autocomplete.multiselect.js" />"></script>
<%--
<script src=" <c:url value="/resources/js/autocomplete/js/main.js" />"></script>
--%>

<script src="<c:url value="/resources/assets/lib/jquery-flot/jquery.flot.js" />"></script>
<script src="<c:url value="/resources/assets/lib/jquery-flot/jquery.flot.pie.js" />"></script>
<script src="<c:url value="/resources/assets/lib/jquery-flot/jquery.flot.resize.js" />"></script>
<script src="<c:url value="/resources/assets/lib/jquery-flot/plugins/jquery.flot.orderBars.js" />"></script>
<script src="<c:url value="/resources/assets/lib/jquery-flot/plugins/curvedLines.js" />"></script>
<script src="<c:url value="/resources/assets/lib/jquery.sparkline/jquery.sparkline.min.js" />"></script>
<script src="<c:url value="/resources/assets/lib/countup/countUp.min.js" />"></script>
<script src="<c:url value="/resources/assets/lib/jquery-ui/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/assets/lib/jqvmap/jquery.vmap.min.js" />"></script>
<script src="<c:url value="/resources/assets/lib/jqvmap/maps/jquery.vmap.world.js" />"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.js" type="text/javascript"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-cookies.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-route.js"></script>
<script src="https://use.fontawesome.com/2dd1cc9e08.js"></script>
<script src="http://momentjs.com/downloads/moment.js"></script>


<script src=" <c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>

<script src="<c:url value="/resources/js/app.js" />"></script>
<script src="<c:url value="/resources/js/controllers/smsTemplateController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/PhoneBookController.js" />"></script>

<script src="<c:url value="/resources/js/controllers/PhoneNumberController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/SMSController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/SubAccountController.js" />"></script>

<script src="<c:url value="/resources/js/controllers/RechargeController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/CompaignController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/ProfileController.js" />"></script>


<script src="<c:url value="/resources/js/bower_components/angularjs-datetime-picker/angularjs-datetime-picker.js" />"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //initialize the javascript
        App.init();
        App.dashboard();

    });
</script>

</body>

<!-- Mirrored from foxythemes.net/preview/products/beagle2/ by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 09 Apr 2017 14:52:15 GMT -->
</html>
