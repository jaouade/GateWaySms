SmsApp.controller('RechargeController',
    function ($scope, $http, $cookies, $location, $timeout, PhoneBook) {
        $scope.recharge = "recharge"
        $scope.account = false;
        var req = {
            method: 'POST',
            url: "../account/user",


        }

        $http(req).then(function (response) {
            $scope.account = response.data
        }, function (error) {
            console.log(error)
        });


        $scope.buy = function (smsCredit, mentant) {
            var req = {
                method: 'POST',
                url: "../client/addsc",
                data: {
                    mentantRecharge: mentant,
                    simCard: $scope.account.simCard,
                    equivalentSms: smsCredit
                }


            }
            console.log(req.data);
            $http(req).then(function (response) {
                console.log(response.data)
                $.notify("your order has been placed  successfully ", "success");

            }, function (error) {
                $.notify("we cannot place you order for the moment ", "error");
            });
        }


    }).factory('PhoneBook', function ($http, $q) {
    var factory = {};

    return factory;
})
		