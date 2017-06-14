SmsApp
    .directive("limitTo", [function () {
        // skip
        return {
            restrict: "A",
            link: function (scope, elem, attrs) {
                var limit = parseInt(attrs.limitTo);
                angular.element(elem).on("keypress", function (e) {

                    if (this.value.length == limit) ;
                });
            }
        }
    }])


    .controller('SMSController',
        function ($scope, $http, $cookies, $location, $timeout,$compile,$rootScope, SMS) {
            var phoneRe = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;
            $scope.limit = 160;
            $scope.nbMsg = 1;
            $scope.phoneFromInput = "";
            $scope.checkNumber = function () {
                $scope.error = !phoneRe.test($scope.phoneFromInput);

            };

            var isCorrect = function () {
                if ($scope.phoneFromInput !== "") {
                    return phoneRe.test($scope.phoneFromInput);
                } else {
                    return false
                }

            };
            $scope.normal = function () {
                $scope.normalMessage = true;
                $scope.limit = 160;
                $scope.rest = $scope.limit;
                var messageLength = $('#message').val().length;
                $scope.nbMsg = Math.floor(messageLength / $scope.limit) + 1;
                $scope.rest = $scope.nbMsg * $scope.limit - messageLength;
            };
            $scope.ToArabic = function () {
                $scope.limit = 70;
                $scope.rest = $scope.limit;
                $scope.normalMessage = false;
                var messageLength = $('#message').val().length;
                $scope.nbMsg = Math.floor(messageLength / $scope.limit) + 1;
                $scope.rest = $scope.nbMsg * $scope.limit - messageLength;
            };

            $scope.setTemplate = function () {
                var template = JSON.parse($scope.template);
                $scope.message = template.smsTemplate;


            };
            $scope.showRest = function () {
                var messageLength = $('#message').val().length;
                $scope.nbMsg = Math.floor(messageLength / $scope.limit) + 1;
                $scope.rest = $scope.nbMsg * $scope.limit - messageLength;
            };
            $scope.account = false;

            var req = {
                method: 'POST',
                url: "../account/user"


            };
            $scope.contacts = [];
            $scope.changeItsPLace =function (phone) {
                $("#"+phone.idPhone).hide();
                $scope.contacts.push(phone);
                console.log($scope.contacts);
                var el =$('#selectedPhones');
                angular.element(el).append( $compile('<option id="added_'+phone.idPhone+'" ng-click="returnItToItsPlace('+phone.idPhone+')" value="'+phone.idPhone+'" >'+phone.clientName+':>'+phone.phoneNumber+'</option>')($scope) )
            };
            $scope.returnItToItsPlace= function (id) {
                $("#added_"+id).remove();
                console.log("cool");
                for (var i = 0; i < $scope.contacts.length; i++) {
                    if ($scope.contacts[i].idPhone === parseInt(id)) {
                        $scope.contacts.splice(i, 1);

                    }

                }

                $("#"+id).show();
            };
            $http(req).then(function (response) {
                $scope.account = response.data;
                $scope.phones = SMS.getPhones().then(function (phones) {
                    $scope.phones = phones

                }, function (msg) {
                    alert(msg)
                });

                $scope.simCards = SMS.getSimCards().then(function (simcards) {
                    $scope.simCards = simcards

                }, function (msg) {
                    alert(msg)
                });
                $scope.templates = SMS.getTemplates().then(function (templates) {
                    $scope.templates = templates

                }, function (msg) {
                    alert(msg)
                })
            }, function (error) {

                console.log(error)
            });
            $scope.date3 = null;
            $scope.sendSMS = function () {
                    if($scope.sms.$invalid){
                        alert("you should fill all fields that are required");
                        $scope.errFrm = true;
                        window.scrollTo(0, 0);
                    }
                    else{


                    var data = {};
                    if (isCorrect()) {

                        data = {
                            nbMessages: $scope.nbMsg,
                            message: $scope.message,
                            receivers: $scope.contacts.push($scope.phoneFromInput),
                            simCard: {
                                idSimCard: $scope.idSimCard
                            }
                        }
                    } else {
                        data = {
                            nbMessages: $scope.nbMsg,
                            message: $scope.message,
                            receivers: $scope.contacts,
                            simCard: {
                                idSimCard: $scope.idSimCard
                            }

                        }
                    }
                    var req = {
                        method: 'POST',
                        url: "../sms/create",
                        data: data

                    };

                        $http(req).then(function (response) {
                            $rootScope.account = response.data.object.account;
                            console.log(response.data);
                            $.notify(response.data.success, "success");

                        }, function (error) {
                        $.notify(error.data.error, "error");
                    });
                    }


            };


        }).factory('SMS', function ($http, $q) {
    var factory = {
        simCards: false,
        phones: false,
        templates: false,
        getSimCards: function () {

            var deferred = $q.defer();
            var req = {
                method: 'POST',
                url: "../simcard/getAll",

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
		