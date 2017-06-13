SmsApp.controller(
    'CompaignController',
    function ($scope, $http, $cookies, $location, $timeout, Compaign) {
        $scope.account = false;
        $scope.limit = 160;
        $scope.nbMsg = 1;
        $scope.phones = Compaign.getPhones().then(function (phones) {
            $scope.phones = phones;
            console.log(phones)
        }, function (error) {
            console.log("error")
        })
        $scope.update = function () {
            console.log($scope.selected)
        }
        $scope.selected = [];
        var req = {
            method: 'POST',
            url: "../account/user",
        }
        $scope.setTemplate = function () {
            var template = JSON.parse($scope.template)
            $scope.message = template.smsTemplate;
            console.log($scope.message)

        }
        $scope.normal = function () {
            $scope.limit = 160;
            $scope.rest = $scope.limit;
            $scope.nbMsg = 1
        }
        $scope.ToArabic = function () {
            $scope.limit = 70;
            $scope.rest = $scope.limit;
            $scope.nbMsg = 1
        }
        $http(req).then(
            function (response) {
                $scope.phones = Compaign.getPhones().then(
                    function (phones) {
                        $scope.phones = phones

                    }, function (msg) {
                        alert(msg)
                    })

                $scope.simCards = Compaign.getSimCards().then(
                    function (simcards) {
                        $scope.simCards = simcards

                    }, function (msg) {
                        alert(msg)
                    })
                $scope.templates = Compaign.getTemplates().then(
                    function (templates) {
                        $scope.templates = templates

                    }, function (msg) {
                        alert(msg)
                    })
                $scope.account = response.data

            }, function (error) {

                console.log(error)
            });

        $scope.saveCompaign = function () {
            data = {
                message: {
                    date: new Date($scope.date3).getTime(),
                    message: $scope.message,
                    reciever: {
                        PhoneNumber: $scope.phoneFromInput,
                    },
                    simCard: {
                        idSimCard: $scope.idSimCard
                    }
                },
                numbers: $scope.selected,
                compagneDesignation: "desi",
                account: $scope.account
            }
            req = {
                method: 'POST',
                url: "../compaign/add",
                data: data
            }
            console.log(data)
            $http(req).then(function (response) {
                console.log(response.data)
            }, function (error) {
                console.log(error);
            });
        }

    }).factory('Compaign', function ($http, $q) {
    var factory = {
        phones: false,
        getPhones: function () {

            var deffered = $q.defer();
            var req = {
                method: 'POST',
                url: "../phoneNumber/getAllPhoneNumberByPhoneBookAndAccount",

            }

            $http(req).then(function (response) {
                factory.phones = response.data;
                deffered.resolve(factory.phones);
            }, function (error) {
                deffered.reject(error);
            });
            return deffered.promise;
        },
        simCards: false,
        phones: false,
        templates: false,
        getSimCards: function () {

            var deffered = $q.defer();
            var req = {
                method: 'POST',
                url: "../simcard/getAll",

            }

            $http(req).then(function (response) {
                factory.simCards = response.data;
                deffered.resolve(factory.simCards);
            }, function (error) {
                deffered.reject(error);
            });
            return deffered.promise;
        },

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

    }

    return factory;
})
