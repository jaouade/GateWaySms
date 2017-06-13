SmsApp
    .controller('SubAccountController',
        function ($scope, $http, $cookies, $location, $timeout, SubAccount) {
            $scope.account = false;
            $scope.client =null;
            $http.get("../ville/villes").then(function (response) {
                $scope.cities = response.data;

            });
            var req = {
                method: 'POST',
                url: "../account/user"
            };

            $http(req).then(function (response) {
                $scope.account = response.data
                $scope.subs = SubAccount.getSubAccounts().then(function (subAccounts) {
                    $scope.subs = subAccounts

                }, function (msg) {
                    console.log(msg)
                })

            }, function (error) {

                console.log(error)
            });

            $scope.createAccount = function () {
                $scope.client.city =JSON.parse($scope.client.city);
                var accToSend  = $scope.account;
                accToSend.client = $scope.client;

                var req = {
                    method: 'POST',
                    url: "../client/sub-account",
                    data: {
                        email: $scope.client.email,
                        whoCreateIt: accToSend,
                        client : $scope.client

                    }

                };


                console.log(req.data);
                $http(req).then(function (response) {
                    console.log(response.data.success);
                    $("#addModal").modal('hide');
                    $.notify(response.data.success, "success");
                    $scope.subs = SubAccount.getSubAccounts().then(function (subAccounts) {
                        $scope.subs = subAccounts

                    }, function (msg) {
                        console.log(msg)
                    })

                }, function (error) {
                    $scope.errorSub = true;
                    $scope.errorMsgSub =error.data.error;
                    console.log(error.data.error);
                });


            };


            $scope.showAddModal = function () {
                $("#addModal").modal('show')

            }

        }).factory('SubAccount', function ($http, $q) {
    var factory = {
        subAccounts: false,
        getSubAccounts: function () {
            var deffered = $q.defer();
            var req = {
                method: 'POST',
                url: "../client/getsubs"

            };

            $http(req).then(function (response) {
                factory.subAccounts = response.data;
                deffered.resolve(factory.subAccounts);
            }, function (error) {
                deffered.reject(error);
            });
            return deffered.promise;
        }
    };

    return factory;
})
