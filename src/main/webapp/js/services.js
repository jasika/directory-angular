'use strict';

/* Services */

var services = angular.module('directoryApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080';

services.factory('ContactsFactory', function ($resource) {
    return $resource(baseUrl + '/directory/contacts', {}, {
        query: { method: 'GET', isArray: true, cache: false },
//        queryGroup: { method: 'GET', params: {group: ':group'},  isArray: true, cache: false,  },
        save: { method: 'POST' },
        delete: { method: 'POST' }
    })
});

services.factory('ContactFactory', function ($resource) {
    return $resource(baseUrl + '/directory/contacts/:contactId', {}, {
        show: { method: 'GET' }
    })
});
