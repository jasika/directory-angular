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
    $scope.deleteContact = function (contact) {
      var command = { "commandName": "Contact.DELETE", "data": contact };
      ContactsFactory.delete(command)
        .$promise.then(function(){
          $scope.contacts = ContactsFactory.query();
        });
    };

    $scope.contacts = ContactsFactory.query();
  }]);

app.controller('ContactDetailCtrl', ['$scope', '$routeParams', 'ContactFactory', 'ContactsFactory', '$location',
  function ($scope, $routeParams, ContactFactory, ContactsFactory, $location) {

    /* callback for ng-click 'cancel': */
    $scope.cancel = function () {
      $location.path('/contacts/all');
    };

    /* callback for ng-click 'saveContact': */
    $scope.saveContact = function (contact) {
        var command = { "commandName": "Contact.SAVE", "data": $scope.contact };
        ContactsFactory.save(command)
          .$promise.then(function(){
            $location.path('/contacts/all');
          });
    };

    if($routeParams.contactId) {
      $scope.contact = ContactFactory.show({contactId: $routeParams.contactId});
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

