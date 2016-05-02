(function(angular) {
  'use strict';
  /**
   * 
   */
  angular.module('sisp')
  	.controller('PopupAtividadeController', function ($scope, $mdDialog, $q, $http, $mdToast, activity ) {
  		
  		/**
  		 * 
  		 */
  		 $scope.hide = function() {
  		    $mdDialog.hide();
  		  };
  		  /**
  		   * 
  		   */
  		  $scope.close = function() {
  		    $mdDialog.cancel();
  		  };
  		  /**
  		   * 
  		   */
  		  $scope.add = function(activity) {
		 	activity.status = "OPEN";
  		    $mdDialog.hide(activity);
  		    
  		  };
  		  
          $scope.activities = [];
          $scope.responsible = {};
          if(activity){
        	  $scope.activity = activity;
        	  var beginDate = new Date(activity.date);
				activity.date = beginDate;
          }else{
        	  $scope.activity = {};  
          }
           
          $scope.listActivities = [];
          
          /**
           * 
           */
          function querySearchResponsible(filters) {
              var deferred = $q.defer();
              $http.get('/UserList').success( function(data)  {
              	deferred.resolve(data);
      		})
              return deferred.promise;
          }
          $scope.querySearchResponsible = querySearchResponsible;
          
  		  
  	});	
})(window.angular);