var App = angular
    .module('App', ['ngCookies', 'ngRoute'])

    .config(function ($routeProvider) {
        $routeProvider.when('/signup', {
            templateUrl: '../resources/partials/signup.html',
            controller: 'SignupController'
        }).otherwise({
            redirectTo: '/home'
        })

    })
    .controller('SubController',
        function ($scope, $http, $cookies, $location, $window) {
            $scope.createSub = function () {
                var data = {
                    password: $scope.password

                };

                var req = {
                    method: 'POST',
                    url: "../client/create_sub",
                    data: data

                };
                console.log(req.data);
                $http(req).then(function (response) {
                    console.log(response.data);
                    $.notify("the account has been saved successfully ", "success");
                    $window.location.href = "http://localhost:9000/login";

                }, function (error) {
                    $.notify("we cannot save the account for the moment ", "error");
                });
            }

        });
		
