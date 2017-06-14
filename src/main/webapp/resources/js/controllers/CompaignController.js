SmsApp.controller(
    'CompaignController',
    function ($scope, $http, $cookies, $compile, $location, $timeout, Compaign) {
        $scope.account = false;
        $scope.comp = null;
        $scope.limit = 160;
        $scope.nbMsg = 1;
        $scope.phones = Compaign.getPhones().then(function (phones) {
            $scope.phones = phones;
            console.log(phones)
        }, function (error) {
            console.log("error")
        });
        $scope.update = function () {
            console.log($scope.selected)
        };
        $scope.template = null;
        $scope.selected = [];
        var req = {
            method: 'POST',
            url: "../account/user"
        };
        $scope.setTemplate = function () {
            console.log('heere');
            var template = JSON.parse($scope.template);
            $scope.comp.message = template.smsTemplate;
            console.log($scope.comp.message)

        };
        $scope.contacts = [];
        $scope.changeItsPLace = function (phone) {
            $("#" + phone.idPhone).hide();
            $scope.contacts.push(phone);
            console.log($scope.contacts);
            var el = $('#selectedPhones');
            angular.element(el).append($compile('<option id="added_' + phone.idPhone + '" ng-click="returnItToItsPlace(' + phone.idPhone + ')" value="' + phone.idPhone + '" >' + phone.clientName + ':>' + phone.phoneNumber + '</option>')($scope))
        };
        $scope.returnItToItsPlace = function (id) {
            $("#added_" + id).remove();
            console.log("cool");
            for (var i = 0; i < $scope.contacts.length; i++) {
                if ($scope.contacts[i].idPhone === parseInt(id)) {
                    $scope.contacts.splice(i, 1);

                }

            }

            $("#" + id).show();
        };
        $scope.normal = function () {
            $scope.limit = 160;
            $scope.rest = $scope.limit;
            $scope.nbMsg = 1
        };
        $scope.ToArabic = function () {
            $scope.limit = 70;
            $scope.rest = $scope.limit;
            $scope.nbMsg = 1
        };
        $http(req).then(
            function (response) {
                $scope.phones = Compaign.getPhones().then(
                    function (phones) {
                        $scope.phones = phones

                    }, function (msg) {
                        alert(msg)
                    });


                $scope.templates = Compaign.getTemplates().then(
                    function (templates) {
                        $scope.templates = templates

                    }, function (msg) {
                        alert(msg)
                    });
                $scope.account = response.data

            }, function (error) {

                console.log(error)
            });

        $scope.saveCompaign = function () {
            var date = $scope.comp.date;
            $scope.comp.date = new Date($scope.comp.date).getTime();

            var data = $scope.comp;
            $scope.comp.numbers = $scope.contacts;
            var req = {
                method: 'POST',
                url: "../campaign/add",
                data: data
            };

            $http(req).then(function (response) {
                $scope.comp.date = date;
                $.notify(response.data.success, "success");


            }, function (error) {
                $.notify(error.data.error, "error");

            });
        }

    }).factory('Compaign', function ($http, $q) {
    var factory = {
        phones: false,
        getPhones: function () {

            var deffered = $q.defer();
            var req = {
                method: 'POST',
                url: "../phoneNumber/getAllPhoneNumberByPhoneBookAndAccount"

            };

            $http(req).then(function (response) {
                factory.phones = response.data;
                deffered.resolve(factory.phones);
            }, function (error) {
                deffered.reject(error);
            });
            return deffered.promise;
        },
        simCards: false,
        templates: false,
        getSimCards: function () {

            var deffered = $q.defer();
            var req = {
                method: 'POST',
                url: "../simcard/getAll",

            };

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

            };

            $http(req).then(function (response) {
                factory.templates = response.data;
                deffered.resolve(factory.templates);
            }, function (error) {
                deffered.reject(error);
            });
            return deffered.promise;
        },

    };

    return factory;
});
