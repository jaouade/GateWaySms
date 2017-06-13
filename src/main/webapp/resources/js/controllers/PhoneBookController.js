SmsApp.controller('PhoneBookController',
    function ($scope, $http, $cookies, $location, $timeout, PhoneBook) {
        $scope.bookName = "";
        $scope.account = false;
        var req = {
            method: 'POST',
            url: "../account/user"


        };

        $http(req).then(function (response) {
            $scope.account = response.data
        }, function (error) {
            console.log(error)
        });

        $scope.phoneBooks = PhoneBook.getPhones().then(function (phoneBooks) {
            $scope.phoneBooks = phoneBooks

        }, function (msg) {
            alert(msg)
        });
        $scope.addPhoneBook = function () {
            var req = {
                method: 'POST',
                url: "../phoneBook/create",
                data: {
                    bookName: $scope.bookName,
                }


            };

            $http(req).then(function (response) {
                $("#addModal").modal('hide');
                console.log(response.data);
                $.notify("the template has been created successfully ", "success");
                $scope.phoneBooks = PhoneBook.getPhonesu().then(function (phoneBooks) {
                    $scope.PhoneBookphoneBooks = phoneBooks
                }, function (msg) {
                    alert(msg)
                })
            }, function (error) {
                $.notify("we cannot create the template for the moment ", "error");
            });


        };
        $scope.deletePhoneBook = function (pb) {
            var c = confirm('voulez vous continuez ! ');
            if (c) {
                var req = {
                    method: 'POST',
                    url: "../phoneBook/delete",
                    data: {
                        idPhoneBook: pb.idPhoneBook
                    }


                };

                $http(req).then(function (response) {
                    $("#" + pb.idPhoneBook).hide();
                    $.notify("the template has been deleted ", "success");
                }, function (error) {
                    $.notify("we cannot delete the template for the moment ", "error");
                });
            }


        };
        $scope.showEdit = function (pb) {
            $("#editModal").modal('show');
            $scope.pb = pb;
            $scope.bookNameEdit = pb.bookName

        };
        $scope.view = function (pb) {
            $scope.pb = pb;
            $location.path("/phoneBook/edit");
            $scope.bookNameEdit = pb.bookName

        };
        $scope.showAddModal = function () {
            $("#addModal").modal('show')

        };

        $scope.editPhoneBook = function () {


            var req = {
                method: 'POST',
                url: "../phoneBook/edit",
                data: {
                    idPhoneBook: $scope.pb.idPhoneBook,
                    bookName: $scope.bookNameEdit,
                    account: $scope.pb.account
                }


            };
            console.log(req.data);

            $http(req).then(function (response) {
                $scope.phoneBooks = PhoneBook.getPhones().then(function (phoneBooks) {
                    $scope.phoneBooks = phoneBooks

                }, function (msg) {
                    alert(msg)
                });
                $("#editModal").modal('hide');
                $.notify("the PhoneBook has been edited successfully ", "success");
            }, function (error) {
                $("#editModal").modal('hide');
                $.notify("we cannot edit the PhoneBook for the moment ", "error");
            });


        }


    }).factory('PhoneBook', function ($http, $q) {
    var factory = {
        phoneBooks: false,
        getPhones: function () {

            var deferred = $q.defer();
            var req = {
                method: 'POST',
                url: "../phoneNumber/getAllPhoneNumberByPhoneBookAndAccount"

            };

            $http(req).then(function (response) {
                factory.phones = response.data;
                deferred.resolve(factory.phones);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        },
        getTemplate: function (id) {

        }
    };

    return factory;
});
		