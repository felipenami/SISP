//(function() {
//  'use strict';
//
//  angular
//    .module('projectManagerApp')
//    .controller('MainController', MainController);
//
//  /** @ngInject */
//  function MainController($location, Project, $log, dataService, $mdSidenav) {
//    var vm = this;
//    console.log("hue");
//    dataService.find("").success(function(data){
//      vm.projects = data;
//    }).error(function(message){
//      $log.debug(message);
//    });
//
//    //vm.projects = Project.all();
//
//    vm.openSidenav = function(){
//      $log.debug("OPEN SIDENAVEE");
//      $mdSidenav('left')
//        .toggle()
//    };
//
//    vm.openProject = function(id){
//      $location.path('project/' + id);
//      $log.debug("project " + id);
//    };
//
//  }
//})();
