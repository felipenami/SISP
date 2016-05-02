(function(angular) {
  'use strict';
  /**
   * 
   */
  angular.module('sisp')
  	.controller('PopupMilestoneController', function ($scope, $mdDialog, $q, $http, $mdToast, listActivities ) {
  		
  		$scope.activities = listActivities;
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
  		  $scope.add = function(milestone) {
  		    $mdDialog.hide(milestone);
  		    
  		  };
  		  
  		  
  	});	
})(window.angular);