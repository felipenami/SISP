(function(angular) {
  'use strict';
  /**
   * 
   */
  angular.module('sisp')
  	.controller('PopupAtividadeController', function ($scope, $mdDialog, $q, $http ) {
  		
  		 $scope.hide = function() {
  		    $mdDialog.hide();
  		  };
  		  $scope.close = function() {
  		    $mdDialog.cancel();
  		  };
  		  $scope.answer = function(answer) {
  		    $mdDialog.hide(answer);
  		  };
  		  
          $scope.activities = [];
          $scope.responsibles = {};
          $scope.activity = {}; 
  		  
  	});	
})(window.angular);