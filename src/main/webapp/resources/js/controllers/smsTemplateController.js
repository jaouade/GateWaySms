SmsApp.controller('SmsTemplateController',
    function ($scope, $http, $cookies, $location, $timeout, Template) {
        $scope.account = false;
        var req = {
            method: 'POST',
            url: "../account/user",


        }

        $http(req).then(function (response) {
            $scope.account = response.data
            $scope.templates = Template.getTemplates().then(function (templates) {
                $scope.templates = templates

            }, function (msg) {
                alert(msg)
            })

        }, function (error) {

            console.log(error)
        });

        $scope.templates = Template.getTemplates().then(function (templates) {
            $scope.templates = templates

        }, function (msg) {
            alert(msg)
        })

        $scope.addSmsTemplate = function () {
            var req = {
                method: 'POST',
                url: "../smsTemplate/create",
                data: {
                    name: $scope.name,
                    smsTemplate: $scope.template,

                }


            }
            console.log(req.data);
            $http(req).then(function (response) {
                $("#addModal").modal('hide')
                $.notify("the template has been created successfully ", "success");
                $scope.templates = Template.getTemplates().then(function (templates) {
                    $scope.templates = templates

                }, function (msg) {
                    alert(msg)
                })
            }, function (error) {
                $.notify("we cannot create the template for the moment ", "error");
            });


        }
        $scope.deleteSmsTemplate = function (st) {
            var c = confirm('voulez vous continuez ! ')
            if (c) {
                var req = {
                    method: 'POST',
                    url: "../smsTemplate/delete",
                    data: {
                        idSmsTemplate: st.idSmsTemplate
                    }


                }

                $http(req).then(function (response) {
                    $("#" + st.idSmsTemplate).hide();
                    $.notify("the template has been deleted ", "success");
                }, function (error) {
                    $.notify("we cannot delete the template for the moment ", "error");
                });
            }


        }
        $scope.showEdit = function (st) {
            $("#editModal").modal('show')
            $scope.st = st
            $scope.templateNameEdit = st.name
            $scope.templateEdit = st.smsTemplate

        }
        $scope.showAddModal = function () {
            $("#addModal").modal('show')

        }
        $scope.show = function (st) {
            $("#eyeModal").modal('show')
            $scope.st = st
            $scope.templateNameShow = st.name
            $scope.templateShow = st.smsTemplate

        }
        $scope.editSmsTemplate = function () {


            var req = {
                method: 'POST',
                url: "../smsTemplate/edit",
                data: {
                    idSmsTemplate: $scope.st.idSmsTemplate,
                    name: $scope.templateNameEdit,
                    smsTemplate: $scope.templateEdit,
                }


            }
            console.log(req.data)

            $http(req).then(function (response) {
                $scope.templates = Template.getTemplates().then(function (templates) {
                    $scope.templates = templates

                }, function (msg) {
                    alert(msg)
                })
                $("#editModal").modal('hide')
                $.notify("the template has been edited successfully ", "success");
            }, function (error) {
                $("#editModal").modal('hide')
                $.notify("we cannot edit the template for the moment ", "error");
            });


        }


    }).factory('Template', function ($http, $q) {
    var factory = {
        templates: false,
        getTemplates: function () {

            var deffered = $q.defer();
            var req = {
                method: 'POST',
                url: "../smsTemplate/getAll",

            }

            $http(req).then(function (response) {
                factory.templates = response.data;
                deffered.resolve(factory.templates);
            }, function (error) {
                deffered.reject(error);
            });
            return deffered.promise;
        },
        getTemplate: function (id) {

        }

    };

    return factory;
})
		