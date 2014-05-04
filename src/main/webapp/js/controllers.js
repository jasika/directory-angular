'use strict';

/* Controllers */

var app = angular.module('directoryApp.controllers', []);

app.controller('ContactListCtrl', ['$scope', 'ContactsFactory', '$location',
  function ($scope, ContactsFactory, $location) {

    /* callback for ng-click 'editContact': */
    $scope.editContact = function (contactId) {
      $location.path('/contacts/contact-detail/' + contactId);
    };

    /* callback for ng-click 'deleteContact': */
//    $scope.deleteContact = function (contactId) {
//      ContactFactory.delete({ id: contactId });
//      $scope.contacts = ContactsFactory.query();
//    };

    /* callback for ng-click 'createContact': */
//    $scope.createContact = function () {
//      $location.path('/contact-create');
//    };

    $scope.contacts = ContactsFactory.query();
  }]);

app.controller('ContactDetailCtrl', ['$scope', '$routeParams', 'ContactFactory', '$location',
  function ($scope, $routeParams, ContactFactory, $location) {

    /* callback for ng-click 'updateContact': */
    $scope.updateContact = function () {
      ContactFactory.update($scope.contact);
      $location.path('/contact-list');
    };

    /* callback for ng-click 'cancel': */
    $scope.cancel = function () {
      $location.path('/contact-list');
    };

    $scope.contact = ContactFactory.show({contactId: $routeParams.contactId});
  }]);

app.controller('ContactCreateCtrl', ['$scope', 'ContactsFactory', '$location',
  function ($scope, ContactsFactory, $location) {

    /* callback for ng-click 'createContact': */
    $scope.createContact = function () {
      ContactsFactory.create($scope.contact);
      $location.path('/contacts/all');
    }
  }]);

app.controller('MainCtrl', function($scope) {});

app.controller('AboutCtrl', function($scope) {});

app.controller('HelpCtrl', function($scope) {});

function NavBarController($scope, $location) {
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };
}

