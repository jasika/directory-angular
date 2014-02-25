'use strict';

/* Controllers */

var directoryControllers = angular.module('directoryControllers', []);

directoryControllers.controller('ContactListCtrl', ['$scope', 'Contact',
  function($scope, Contact) {
    $scope.contacts = Contact.query();
  }]);

directoryControllers.controller('ContactDetailCtrl', ['$scope', '$routeParams', 'Contact',
  function($scope, $routeParams, Contact) {
    $scope.contact = Contact.get({contactId: $routeParams.contactId}, function(contact) {
    });
  }]);

directoryControllers.controller('MainCtrl', function($scope) {});

directoryControllers.controller('AboutCtrl', function($scope) {});

directoryControllers.controller('HelpCtrl', function($scope) {});
