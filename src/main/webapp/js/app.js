'use strict'

angular.module('directoryApp', [
    'ngResource',
    'ngRoute',
    'directoryControllers',
    'contactServices'
])

    .config(function ($routeProvider) {
        $routeProvider
        .when('/', {templateUrl: 'views/contacts/list.html', controller: 'ContactListCtrl'})
        .when('/about', {templateUrl: 'views/about.html', controller: 'AboutCtrl'})
        .when('/help', {templateUrl: 'views/help.html', controller: 'HelpCtrl'})
        .otherwise({redirect: '/'});
    });