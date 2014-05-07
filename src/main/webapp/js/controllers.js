'use strict';

/* Controllers */

var app = angular.module('directoryApp.controllers', []);

app.controller('ContactListCtrl', ['$scope', 'ContactsFactory', 'ContactFactory', '$location',
  function ($scope, ContactsFactory, ContactFactory, $location) {

    /* callback for ng-click 'editContact': */
    $scope.editContact = function (contactId) {
      $location.path('/contacts/contact-detail/' + contactId);
    };

    /* callback for ng-click 'deleteContact': */
    $scope.deleteContact = function (contact) {
      var method = { methodName: 'DELETE', payload: contact}
      ContactFactory.delete(method);
      $scope.contacts = ContactsFactory.query();
    };

    $scope.contacts = ContactsFactory.query();
  }]);

app.controller('ContactDetailCtrl', ['$scope', '$routeParams', 'ContactFactory', 'ContactsFactory', '$location',
  function ($scope, $routeParams, ContactFactory, ContactsFactory, $location) {

    /* callback for ng-click 'cancel': */
    $scope.cancel = function () {
      $location.path('/contact-list');
    };

    /* callback for ng-click 'saveContact': */
    $scope.saveContact = function () {
      ContactsFactory.save($scope.contact);
      $scope.contacts = ContactsFactory.query();
      $location.path('/contacts/all');
    };

    $scope.contact = ContactFactory.show({contactId: $routeParams.contactId});
  }]);

app.controller('ContactCreateCtrl', ['$scope', 'ContactsFactory', '$location',
  function ($scope, ContactsFactory, $location) {

  }]);

app.controller('MainCtrl', function($scope) {});

app.controller('AboutCtrl', function($scope) {});

app.controller('HelpCtrl', function($scope) {});

function NavBarController($scope, $location) {
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };
}

