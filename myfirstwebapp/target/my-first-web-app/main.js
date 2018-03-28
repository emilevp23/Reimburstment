
var helloAjaxApp = angular.module("myApp", []);

helloAjaxApp.controller("myCtrl", [ '$scope', '$http', function($scope, $http) {

   $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
    
$scope.users = "";


   $scope.loginclick = function() {
       
        $http({
           url : 'http://localhost:8080/mfw/login',
           method : "POST",
           data : JSON.stringify($scope.user)
       }).then(function(response) {
           console.log(response.data);
           
           $scope.loginboolean = true;
           
           
           $scope.users = response.data;
           
        }, function(response) {
           //fail case
           console.log(response);
           $scope.message = response.data + " error ";
       });

   };
    

   $scope.reimbursement = {
    amount : "",
    description : "",
    receipt_string : "",
    type : "",
    type_name : ""
}

$scope.isemployee = function(reimbursement) {
   return reimbursement.author == $scope.users.userid; 
}
$scope.isemployeepending = function(reimbursement) {
    return (reimbursement.author == $scope.users.userid) && (reimbursement.status == 1);
}
$scope.isfinance = function(reimbursement) {
    return reimbursement.status == 1;
}

   $scope.eprclick = function() {
       $scope.employeepastreimburst = true;
       $scope.employeepending = false;
       $scope.employeesubmit = false;
       $scope.reimbursements="";
       $http({
        url : 'http://localhost:8080/mfw/hello',
        method : "POST",
    }).then(function(response) {
        console.log(response.data);
        $scope.reimbursements= response.data;
    }, function(response) {
        //fail case
        console.log(response);
        $scope.message = response.data + " error ";
    });

   };

   $scope.epclick = function() {
    $scope.employeepastreimburst = false;
    $scope.employeepending = true;
    $scope.employeesubmit = false;
    $scope.reimbursements="";
    $http({
        url : 'http://localhost:8080/mfw/hello',
        method : "POST",
    }).then(function(response) {
        console.log(response.data);
        $scope.reimbursements= response.data;
    }, function(response) {
        //fail case
        console.log(response);
        $scope.message = response.data + " error ";
    });
   }

   $scope.esclick = function() {
    $scope.employeepastreimburst = false;
    $scope.employeepending = false;
    $scope.employeesubmit = true;
    $scope.reimbursements="";
    $http({
        url : 'http://localhost:8080/mfw/hello',
        method : "POST",
    }).then(function(response) {
        console.log(response.data);
        $scope.reimbursements= response.data;
    }, function(response) {
        //fail case
        console.log(response);
        $scope.message = response.data + " error ";
    });
   }

   $scope.Choices = [{
    value: '2',
    label: 'Approved'
  }, {
    value: '3',
    label: 'Denied'
  }
];




$scope.fpastclick = function() {
    $scope.financepast = true;
    $scope.financepending = false;
    $scope.financesubmit = false;
    $scope.reimbursements="";
    $http({
        url : 'http://localhost:8080/mfw/hello',
        method : "POST",
    }).then(function(response) {
        console.log(response.data);
        $scope.reimbursements= response.data;
    }, function(response) {
        //fail case
        console.log(response);
        $scope.message = response.data + " error ";
    });
}


$scope.fpendingclick = function() {
    $scope.financepast = false;
    $scope.financepending = true;
    $scope.financesubmit = false;
    $scope.reimbursements="";
    $http({
        url : 'http://localhost:8080/mfw/hello',
        method : "POST",
    }).then(function(response) {
        console.log(response.data);
        $scope.reimbursements= response.data;
    }, function(response) {
        //fail case
        console.log(response);
        $scope.message = response.data + " error ";
    });

}


$scope.fsubmitclick = function() {
    $scope.financepast = false;
    $scope.financepending = false;
    $scope.financesubmit = true;
    $scope.reimbursements="";
    
    
}

$scope.logout = function() {
    $scope.financepast = true;
    $scope.financepending = false;
    $scope.financesubmit = false;
    $scope.employeepastreimburst = false;
    $scope.employeepending = false;
    $scope.employeesubmit = false;
    $scope.loginboolean = false;
    $scope.users = "";
    $scope.reimbursements="";
    $scope.message = "";
}

$scope.update =function(reimb,selected) {
    
    reimb.status= selected.value;
    reimb.resolver= $scope.users.userid;
    $http({
        url : 'http://localhost:8080/mfw/update',
        method : "POST",
        data : JSON.stringify(reimb)
    }).then(function(response) {
        console.log(response.data);
        $scope.message= response.data;
    }, function(response) {
        //fail case
        console.log(response);
        $scope.message = response.data + " error ";
    });
    var index = $scope.reimbursements.indexOf(reimb);
    $scope.reimbursements.splice(index, 1);
}

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




//$scope.selected_type = $scope.Types[0];




   $scope.onclick = function(select) {
    $scope.reimbursement.type = select.value;
    $scope.reimbursement.type_name = select.label;
    $scope.reimbursement.author = $scope.users.userid;
    $http({
           url : 'http://localhost:8080/mfw/addreimb',
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