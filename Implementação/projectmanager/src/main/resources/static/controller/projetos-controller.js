(function(angular) {
  'use strict';
  /**
   * 
   */
  angular.module('sisp')
  	.controller('ProjetosController', function ($scope, $rootScope,$state, $mdDialog, $mdSidenav, $mdToast, $timeout, $window, $location, $locale, $http, $q ) {
		
      //----STATES
        /**
         * Representa o estado de listagem de registros.
         */
        $scope.LIST_STATE = "projetos.list";
        /**
         * Representa o estado para a criação de registros.
         */
        $scope.ADD_STATE = "projetos.add";
        /**
         * Representa o estado para a edição de registros.
         */
        $scope.EDIT_STATE = "projetos.edit";
        /**
         * Representa o estado de detalhe de um registro.
         */
        $scope.DETAIL_STATE = "projetos.detail";
        
        $scope.model = {
        		
                filters: {
                    terms: [],
                },
                projects     : [],
                page: {//PageImpl
                    content: null,
                    pageable: {//PageRequest
                        size: 9,
                        page: 0,
                        sort: {//Sort
                            orders: [
                                { direction: 'ASC' }
                            ]
                        }
                    }
                }
            };
        
        
        /**
         * 
         */
        $scope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {

//            $state.current.breadCrumbs = [{'state': $scope.LIST_STATE, 'name': 'Usuários'}];

            //Controle para mudar o botão do menu para o botão voltar da página
            $state.current.currentState = {
                state: $scope.LIST_STATE,
                nameState: $state.current.name == $scope.LIST_STATE ? 'LIST_STATE' : null
            };

            switch ( $state.current.name ) {
                case $scope.LIST_STATE: {
                    $scope.changeToList();
                    break;
                }
                case $scope.DETAIL_STATE: {
//                    $scope.changeToDetail( $state.params.id );
                    break;
                }
                case $scope.ADD_STATE: {
                    $scope.changeToAdd();
                    break;
                }
                case $scope.EDIT_STATE: {
                	 $scope.changeToEdit($state.params.id);
                }
                    
            }
        });
        
        $scope.projects = [];
        $scope.projectManagers = {};
        $scope.project = {}; 
        
        /**
         *  
         */
        $scope.changeToEdit = function (id) {
            console.debug("changeToEdit", id);
            $http.post('/projectFindById', id)
        	.success(function(data){
        		$scope.project = data
        		var beginDate = new Date(data.initialDate);
        		var endDate = new Date(data.finalDate);
        		$scope.project.initialDate = beginDate;
        		$scope.project.finalDate = endDate;
	        })
	        .error(function(data){
	        	$mdToast.showSimple(data);
			})
        }
        /**
         * Realiza os procedimentos iniciais (prepara o estado)
         * para a tela de exclusão.
         * Antes de excluir, o usuário notificado para confirmação e só então o registro é excluido.
         */
        $scope.changeToRemove = function (event, projectId) {
            console.debug("changeToRemove", projectId);

            var confirm = $mdDialog.confirm()
                .title('Tem certeza que deseja excluir este registro?')
                .content('Não será possível recuperar este registro se for excluído.')
                .ok('Sim')
                .cancel('Cancelar')
                .targetEvent(event);

            $mdDialog.show(confirm).then(function (result) {
            	$http.post('/deleteProject', projectId)
        		.success(function(data){
        			if( $state.current.name == $scope.LIST_STATE){
                        $scope.changeToList();
                    } else {
                        $state.go( $scope.LIST_STATE );
                    }
                    $mdToast.showSimple("O registro foi excluído com sucesso!");
        			
        		})
        		.error(function(data){
                    $mdToast.showSimple(data);
                    $state.go($scope.LIST_STATE);
    			})

            });
        };
        
        
        /**
         * 
         */
        $scope.updateProject = function (project){
        	$http.post('/updateProject', project)
        		.success(function(data){
        			$mdToast.showSimple("Projeto editado com sucesso!");
        			$state.go($scope.LIST_STATE);
        			
        		})
        		.error(function(data){
    	        	$mdToast.showSimple(data);
    			})
        	}
        /**
         * 
         */
        $scope.changeToList = function (id) {
            console.debug("changeToList", id);
            
            $scope.listProjects();

        };
        /**
         * 
         */
        $scope.changeToAdd = function(){
        	console.debug("changeToAdd");
        	$scope.project = {};
        	
        }
        /**
         * 
         */
        $scope.changeToDetail = function(){
        	console.debug("changeToDetail");
        }
        /**
         * 
         */
        function querySearchProjecManagers(filters) {
            var deferred = $q.defer();
            $http.get('/UserList').success( function(data)  {
            	deferred.resolve(data);
    		})
            return deferred.promise;
        }
        $scope.querySearchProjecManagers = querySearchProjecManagers;
        
        /**
         * 
         */
        $scope.saveProject = function(project){
        	project.status = "ABERTO";
	        $http.post('/projectSave', project)
        	.success(function(data){
        		$mdToast.showSimple("Projeto salvo com sucesso!");
        		$state.go($scope.LIST_STATE);
	        })
	        .error(function(data){
	        	$mdToast.showSimple(data);
			})
			}
        
        
        /**
         * Realiza a consulta de registros, considerando filtro, paginação e sorting através dos eventos do "Enter" e "Backspace".
         *
         * @param event
         */
        $scope.listProjects = function () {
    		$http.get('/projectList').success( function(data)  {
    			$scope.projects = data;
    		})
    	}
        /**
         * 
         */
        $scope.openPopupAtividade = function(event){

            $mdDialog.show({
            	controller: "PopupAtividadeController",
                templateUrl: 'ui/popup-atividades/popupAtividade.html',
            	targetEvent: event
                	 

            });
        };
        
	});
})(window.angular);
