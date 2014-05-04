'use strict'

angular.module('directoryApp', [
    'ngResource',
    'ngRoute',
    'directoryApp.controllers',
    'directoryApp.services'
])

    .config(function ($routeProvider) {
        $routeProvider
        .when('/', {templateUrl: 'views/main.html'})
        .when('/contacts/all', {templateUrl: 'views/contacts/list.html', controller: 'ContactListCtrl'})
        .when('/contacts/contact-detail/:contactId', {templateUrl: 'views/contacts/detail.html', controller: 'ContactDetailCtrl'})
        .when('/contacts/create', {templateUrl: 'views/contacts/detail.html', controller: 'ContactDetailCtrl'})
        .when('/about', {templateUrl: 'views/about.html', controller: 'AboutCtrl'})
        .when('/help', {templateUrl: 'views/help.html', controller: 'HelpCtrl'})
        .otherwise({redirect: '/'});
    });