(function(angular) {
  'use strict';
  /**
   * 
   */
  angular.module('sisp')
	.controller('HomeController', function($scope, $mdSidenav) {
		
		$scope.openLeftMenu = function () {
            $mdSidenav('left').toggle();
        };
        $scope.closeMenu = function () {
            $mdSidenav('left').close();
        };
		
	})
})(window.angular);
