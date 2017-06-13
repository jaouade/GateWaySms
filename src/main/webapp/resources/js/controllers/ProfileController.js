SmsApp
    .controller('ProfileController',
        function ($scope, $http) {
            $scope.account = null;

            var req = {
                method: 'POST',
                url: "../account/user"
            };
            $http(req).then(function (response) {
                $scope.account = response.data;
            });

    })
    .factory('Profile', function ($http, $q) {
    var factory = {
        simCards: false,
        phones: false,
        templates: false,
        getSimCards: function () {

            var deferred = $q.defer();
            var req = {
                method: 'POST',
                url: "../simcard/getAll"

            };

            $http(req).then(function (response) {
                factory.simCards = response.data;
                deferred.resolve(factory.simCards);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        },
        getPhones: function () {

            var deferred = $q.defer();
            var req = {
                method: 'POST',
                url: "../phoneNumber/getAllPhoneNumberByPhoneBookAndAccount",

            };

            $http(req).then(function (response) {
                factory.phones = response.data;
                deferred.resolve(factory.phones);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        },
        getTemplates: function () {

            var deferred = $q.defer();
            var req = {
                method: 'POST',
                url: "../smsTemplate/getAll",

            };

            $http(req).then(function (response) {
                factory.templates = response.data;
                deferred.resolve(factory.templates);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        }


    };

    return factory;
});
		