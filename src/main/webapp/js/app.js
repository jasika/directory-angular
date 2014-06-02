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
        .when('/contacts/list', {templateUrl: 'views/contacts/list.html', controller: 'ContactListCtrl'})
        .when('/contacts/contact-detail/:contactId', {templateUrl: 'views/contacts/detail.html', controller: 'ContactDetailCtrl'})
        .when('/contacts/contact-create', {templateUrl: 'views/contacts/create.html',
            resolve: {
                contact: {
                    id: 0,
                    firstName: '',
                    lastName: '',
                    nickname: '',
                    addressList: [{
                        addressType: 'HOME',
                        preferred: true
                    }],
                    phoneList: [{
                        phoneType: 'HOME',
                        preferred: true
                    }]
                }
        }, controller: 'ContactDetailCtrl'})
        .when('/about', {templateUrl: 'views/about.html', controller: 'AboutCtrl'})
        .when('/help', {templateUrl: 'views/help.html', controller: 'HelpCtrl'})
        .otherwise({redirect: '/'});
    });



    // Can also add the resolve object array for dependencies or promises.
