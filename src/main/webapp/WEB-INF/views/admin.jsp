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

<
</head>
<body>
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
                            <li><a href="<c:url value="#" />"><span class="icon mdi mdi-face"></span> Account</a></li>
                            <li><a href="#"><span class="icon mdi mdi-settings"></span> Settings</a></li>
                            <li><a href="<c:url value="#" />"><span class="icon mdi mdi-power"></span>
                                recharger mon compte</a></li>
                            <li><a href="<c:url value="/logout" />"><span class="icon mdi mdi-power"></span> Logout</a>
                            </li>
                            <li><a href="<c:url value="#" />"><span
                                    class="icon mdi mdi-assignment-account"></span> Create sub account</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="page-title"><span>Dashboard</span></div>

                <ul class="nav navbar-nav navbar-right be-icons-nav">

                    <li class="dropdown"><a href="" data-toggle="dropdown" role="button" aria-expanded="false"
                                            class="dropdown-toggle"><span class="badge badge-warning">  </span></a>
                    </li>
                    <li class="dropdown"><a href="" data-toggle="dropdown" role="button" aria-expanded="false"
                                            class="dropdown-toggle"><span class="badge badge-success"> </span></a>
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
                            <li class="active"><a href="#"><i class="icon mdi mdi-home"></i><span>Home</span></a>
                            </li>
                            <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>CARTE SIM</span></a>
                                <ul class="sub-menu">
                                    <li><a href="#"><i class="icon mdi mdi-comment-edit"></i> Cartes disponibles </a>
                                    </li>
                                    <li><a href="#"><i class="icon mdi mdi-format-line-spacing"></i> Demandes </a>
                                    </li>

                                </ul>
                            </li>
                            <li class="parent"><a href=""><i
                                    class="icon mdi mdi-comment-edit"></i><span>RECHARGES</span></a>
                                <ul class="sub-menu">
                                    <li><a href="#e"> <i class="icon mdi mdi-comment-edit"></i> Demandes reçues</a>
                                    </li>

                                    <li><a href="#"><i class="icon mdi mdi-receipt"></i>Packs</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="parent"><a href="#"><i
                                    class="icon mdi mdi-dot-circle"></i><span>LOG</span></a>
                                <ul class="sub-menu">
                                    <li><a href="#"> <i class="icon mdi mdi-accounts-list"></i> Historique</a>
                                    </li>

                                </ul>
                            </li>
                            <li class=""><a href="#"><i
                                    class="icon mdi mdi-view-headline"></i><span>ACCOUNTS</span></a>

                            </li>


                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="be-content">
        <div class="main-content container-fluid">

            <button ng-click="showAddModal()" class="btn btn-space btn-primary"><i
                    class="icon icon-left mdi mdi-cloud-done"></i>add New Template
            </button>


            <div class="row">
                <!--Responsive table-->
                <div class="col-sm-12">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">Responsive Table
                            <div class="tools"><span class="icon mdi mdi-download"></span><span
                                    class="icon mdi mdi-more-vert"></span></div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive noSwipe">
                                <c:if test="${!empty cities}">
                                <table id="table" class="table table-striped table-hover">
                                    <thead>
                                    <tr>


                                        <th style="width:20%;">name</th>
                                        <th style="width:50%;">template</th>
                                        <th style="width:30%;"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${cities}" var="city">
                                    <tr  id="<c:out value="${city.idCity}"/>">

                                        <td class="cell-detail"><span><c:out value="${city.cityName}"/></span></td>
                                        <td><span></span></td>
                                        <td class="text-right">
                                            <div class="btn-group btn-space">
                                                <button  type="button"
                                                        class="btn btn-danger"><i class="icon mdi mdi-delete"></i>
                                                </button>
                                                <button type="button" class="btn btn-warning"
                                                        ><i
                                                        class="icon mdi mdi-edit"></i></button>
                                                <button type="button" class="btn btn-primary" >
                                                    <i
                                                            class="icon mdi mdi-eye"></i></button>
                                            </div>

                                        </td>
                                    </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="exampleModalLabel"> Edit</h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="recipient-name" class="control-label">Name</label>
                                    <input type="text" ng-model="templateNameEdit" class="form-control"
                                           id="recipient-name"
                                           placeholder="Name">
                                </div>
                                <div class="form-group">
                                    <label for="error-text" class="control-label">Template</label>
                                    <textarea ng-model="templateEdit" class="form-control" id="error-text"
                                              placeholder="Template"></textarea>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" ng-click="editSmsTemplate()" class="btn btn-success">Edit</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id=""> Edit</h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="recipient-name" class="control-label">Name</label>
                                    <input type="text" ng-model="name" class="form-control" id="recipient-name"
                                           placeholder="Name">
                                </div>
                                <div class="form-group">
                                    <label for="error-text" class="control-label">Template</label>
                                    <textarea ng-model="template" class="form-control" id="error-text"
                                              placeholder="Template"></textarea>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" ng-click="addSmsTemplate()" class="btn btn-success">Create</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="eyeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="exampleModalLabel"> Edit</h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="recipient-name" class="control-label">Name</label>
                                    <input type="text" disabled="" ng-model="templateNameShow" class="form-control"
                                           id="recipient-name" placeholder="Name">
                                </div>
                                <div class="form-group">
                                    <label for="error-text" class="control-label">Template</label>
                                    <textarea ng-model="templateShow" disabled="" class="form-control" id="error-text"
                                              placeholder="Template"></textarea>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>

</div>

<script src="<c:url value="/resources/assets/lib/jquery/jquery.min.js" />"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script src="<c:url value="/resources/assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" />"></script>
<script src="<c:url value="/resources/assets/js/main.js" />"></script>
<script src="<c:url value="/resources/assets/lib/bootstrap/dist/js/bootstrap.min.js" />"></script>
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