SmsApp.controller('RechargeController',
    function ($scope, $http) {
        $scope.recharge = "recharge";
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
        $scope.otherPayementMethod=function () {
            var req = {
                method: 'POST',
                url: "../client/placeOrder",
                data: {
                    quantity: $scope.nbSms,
                    simCard: $scope.account.simCard
                }


            };
            console.log(req.data);
            $http(req).then(function (response) {
                console.log(response.data);
                $.notify(response.data.success, "success");

            }, function (error) {
                $.notify(error.data.error, "error");
            });
        };

        $scope.buy = function (smsCredit) {
            var req = {
                method: 'POST',
                url: "../client/placeOrder",
                data: {
                    quantity: smsCredit,
                    simCard: $scope.account.simCard
                }


            };
            console.log(req.data);
            $http(req).then(function (response) {
                console.log(response.data);
                $.notify(response.data.success, "success");

            }, function (error) {
                $.notify(error.data.error, "error");
            });
        }


    }).factory('PhoneBook', function () {


    return  {};
});
		