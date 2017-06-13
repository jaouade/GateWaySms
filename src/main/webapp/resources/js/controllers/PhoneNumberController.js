SmsApp.controller('PhoneNumberController',
    function ($scope, $http, $cookies, $location, $timeout, PhoneNumber, $routeParams) {
        $scope.idPhoneBook = $routeParams.id

        $scope.phoneBook = false;
        var req = {
            method: 'POST',
            url: "../phoneBook/getOne",
            data: {
                idPhoneBook: $scope.idPhoneBook,
            }

        }

        $http(req).then(function (response) {
            $scope.phoneBook = response.data
            console.log($scope.phoneBook)
        }, function (error) {
            console.log(error)
        });

        $scope.phoneNumbers = PhoneNumber.getphoneNumbers($scope.idPhoneBook).then(function (phoneNumbers) {
            $scope.phoneNumbers = phoneNumbers

        }, function (msg) {
            alert(msg)
        })
        $scope.addPhoneNumber = function () {
            var req = {
                method: 'POST',
                url: "../phoneNumber/create",
                data: {
                    clientName: $scope.clientName,
                    phoneNumber: $scope.PhoneNumber,
                    phoneBook: $scope.phoneBook

                }


            }

            $http(req).then(function (response) {
                $("#addModal").modal('hide')
                console.log(response.data);
                $.notify("the phone number has been created successfully ", "success");
                $scope.phoneNumbers = PhoneNumber.getphoneNumbers($scope.idPhoneBook).then(function (phoneNumbers) {
                    $scope.phoneNumbers = phoneNumbers

                }, function (msg) {
                    alert(msg)
                })
            }, function (error) {
                $.notify("we cannot create the phone number for the moment ", "error");
            });


        }
        $scope.deletePhoneNumber = function (pn) {
            var c = confirm('voulez vous continuez ! ')
            if (c) {
                var req = {
                    method: 'POST',
                    url: "../phoneNumber/delete",
                    data: {
                        idPhone: pn.idPhone
                    }


                }

                $http(req).then(function (response) {
                    $("#" + pn.idPhone).hide();
                    $.notify("the Phone number has been deleted ", "success");
                }, function (error) {
                    $.notify("we cannot delete the phone number for the moment ", "error");
                });
            }


        }
        $scope.showEdit = function (pn) {

            $scope.pn = pn
            console.log(pn)
            $scope.clientNameEdit = pn.clientName
            $scope.PhoneNumberEdit = pn.phoneNumber
            $("#editModal").modal('show')

        }

        $scope.showAddModal = function () {
            $("#addModal").modal('show')

        }

        $scope.editPhoneNumber = function () {


            var req = {
                method: 'POST',
                url: "../phoneNumber/edit",
                data: {
                    idPhone: $scope.pn.idPhone,
                    clientName: $scope.clientNameEdit,
                    phoneNumber: $scope.PhoneNumberEdit,
                    phoneBook: $scope.phoneBook


                }


            }
            console.log(req.data)

            $http(req).then(function (response) {
                $scope.phoneNumbers = PhoneNumber.getphoneNumbers($scope.idPhoneBook).then(function (phoneNumbers) {
                    $scope.phoneNumbers = phoneNumbers

                }, function (msg) {
                    alert(msg)
                })
                $("#editModal").modal('hide')
                $.notify("the Phone Number has been edited successfully ", "success");
            }, function (error) {
                $("#editModal").modal('hide')
                $.notify("we cannot edit the Phone Number for the moment ", "error");
            });


        }


    }).factory('PhoneNumber', function ($http, $q) {
    var factory = {
        phoneNumbers: false,
        getphoneNumbers: function (id) {
            var deffered = $q.defer();
            var req = {
                method: 'POST',
                url: "../phoneNumber/getAllByPhoneBook",
                data: {
                    idPhoneBook: id
                }
            };

            $http(req).then(function (response) {
                factory.phoneNumbers = response.data;
                deffered.resolve(factory.phoneNumbers);
            }, function (error) {
                deffered.reject(error);
            });
            return deffered.promise;
        }


    };

    return factory;
})
		