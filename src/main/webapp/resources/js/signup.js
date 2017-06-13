var FoodLineApp = angular
    .module('SignUp', ['ngCookies', 'ngRoute'])
    .controller(
        'SignupController',
        function ($scope, $http, $cookies, $location, $timeout) {
            $http.get("ville/villes").then(function (response) {
                $scope.cities = response.data;

            });
            $http.get("ville/sectors").then(function (response) {
                $scope.sectors = response.data;

            });
            $scope.signup = function () {
                var emailRe = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                var phoneRe = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/
                if ($scope.corp_name === undefined
                    || $scope.corp_name === "") {
                    $scope.error = true;
                    $scope.errorMsg = "le nom de corp ne doit pas être vide "
                } else if ($scope.name === undefined
                    || $scope.name === "") {
                    $scope.error = true;
                    $scope.errorMsg = "le name  ne doit pas être vide "
                } else if ($scope.postal_code === undefined
                    || $scope.postal_code === "") {
                    $scope.error = true;
                    $scope.errorMsg = "le code postal  ne doit pas être vide "
                } else if ($scope.email === undefined
                    || !emailRe.test($scope.email)) {
                    $scope.error = true;
                    $scope.errorMsg = "l'email ne doit pas être vide et doit etre  a la forme xyz@abs.xx "
                } else if ($scope.adresse === undefined
                    || $scope.adresse === "") {
                    $scope.error = true;
                    $scope.errorMsg = "l'adresse ne doit pas être vide "
                } else if ($scope.phone === undefined
                    || !phoneRe.test($scope.phone)) {
                    $scope.error = true;
                    $scope.errorMsg = "le phone ne doit pas être vide et doit etre  a la forme 06XXxxXXxx "
                } else if ($scope.fax === undefined
                    || !phoneRe.test($scope.fax)) {
                    $scope.error = true;
                    $scope.errorMsg = "le phone ne doit pas être vide et doit etre  a la forme 05XXxxXXxx "
                }
                else if ($scope.idCity === undefined) {
                    $scope.error = true;
                    $scope.errorMsg = "veuillez choisir un ville "
                }
                else if ($scope.idSector === undefined) {
                    $scope.error = true;
                    $scope.errorMsg = "veuillez choisir une secteur"
                }

                else if ($scope.login === undefined
                    || $scope.login === "") {
                    $scope.error = true;
                    $scope.errorMsg = "le login ne doit pas être vide "
                } else if ($scope.password === undefined || $scope.password === "") {
                    $scope.error = true;
                    $scope.errorMsg = "le password ne doit pas être vide "

                } else {
                    $scope.error = false;
                    var req = {
                        method: 'POST',
                        url: '../client/signup',
                        data: {
                            client: {
                                corp_name: $scope.corp_name,
                                name: $scope.name,
                                postal_code: $scope.postal_code,
                                email: $scope.email,
                                adresse: $scope.adresse,
                                phone: $scope.phone,
                                fax: $scope.fax,
                                city: {
                                    idCity: $scope.idCity
                                },
                                sector: {
                                    idSector: $scope.idSector
                                }
                            },

                            credential: {
                                login: $scope.login,
                                password: $scope.password

                            }

                        }

                    }


                    $http(req).then(function (response) {
                        console.log(response.data)
                        $scope.error = false
                        $location.path('/home/');
                    }, function (error) {
                        $scope.error = true
                        $scope.errorMsg = "un probeleme est survenu lors de la cration de votre compte :("
                    });

                }

            }

        })
