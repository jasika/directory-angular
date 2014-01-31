angular.module("directory.services", ["ngResource"]).
    factory('Contact', function ($resource) {
        var Contact = $resource('/contacts/:contactId', {contactId: '@id'});
        Story.prototype.isNew = function(){
            return (typeof(this.id) === 'undefined');
        }
        return Story;
    });

angular.module("directory", ["directory.services"]).
    config(function ($routeProvider) {
        $routeProvider
            .when('/', {templateUrl: 'views/contacts/list.html', controller: ContactListController})
            .when('/contacts/new', {templateUrl: 'views/contacts/create.html', controller: ContactCreateController})
            .when('/contacts/:contactId', {templateUrl: 'views/contacts/detail.html', controller: ContactDetailController});
    });

function ContactListController($scope, Contact) {
    $scope.contacts = Contact.query();
    
}

function ContactCreateController($scope, $routeParams, $location, Contact) {

    $scope.contact = new Contact();

    $scope.save = function () {
    	$scope.contact.$save(function (contact, headers) {
    		toastr.success("Contact Saved");
            $location.path('/');
        });
    };
}

function ContactDetailController($scope, $routeParams, $location, Contact) {
    var contactId = $routeParams.contactId;
    
    $scope.contact = Contact.get({contactId: contactId});

}
