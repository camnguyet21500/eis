
var app = angular.module("myApp", []);
app.controller("proCtrl", function ($scope, $http) {
  //show company
  $http.get("http://localhost:8662/invoices").then(function (reponse) {
    $scope.list_invoices = reponse.data;
  });
});