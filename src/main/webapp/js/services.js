'use strict';

/* Services */

var services = angular.module('directoryApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080';

services.factory('ContactsFactory', function ($resource) {
    return $resource(baseUrl + '/directory/contacts', {}, {
        query: { method: 'GET', isArray: true },
        save: { method: 'POST' }
    })
});

services.factory('ContactFactory', function ($resource) {
    return $resource(baseUrl + '/directory/contacts/:contactId', {}, {
        show: { method: 'GET' },
        delete: { method: 'POST' }
    })
});
