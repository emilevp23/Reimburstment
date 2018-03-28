var helloAjaxApp = angular.module("myApp", []);

helloAjaxApp.controller("myCtrl", [ '$scope', '$http', function($scope, $http) {

   $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";


  
  // sort options
  $scope.Types = [{
    value: '1',
    label: 'Lodging'
  }, {
    value: '2',
    label: 'Travel'
  }, {
      value: '3',
      label: 'Food'
  },
     {
      value: '4',
      label: 'Other'  
     }
];

$scope.reimbursement = {
    amount : "",
    description : "",
    receipt_string : "",
    type : "",
    type_name : ""
}


$scope.selected_type = $scope.Types[0];


  $scope.reimbursement.type = $scope.selected_type.value;
  $scope.reimbursement.type_name = $scope.selected_type.label;

   $scope.onclick = function() {

        $http({
           url : 'http://localhost:8085/mfw/addreimb',
           method : "POST",
           data : JSON.stringify($scope.reimbursement)
       }).then(function(response) {
           console.log(response.data);
           $scope.message = response.data;
       }, function(response) {
           //fail case
           console.log(response);
           $scope.message = response;
       });

   };
} ]);