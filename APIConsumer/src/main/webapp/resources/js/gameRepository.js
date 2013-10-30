var application = angular.module("gameRepository", ["ngResource"]);

application.value("apiUrl", "/api/");

application.config(function($routeProvider){
	$routeProvider.
		when("/", {
			templateUrl:"partials/list.html",
			controller:MainCtrl
		}).
		when("/game/add", {
			templateUrl:"partials/addGame.html",
			controller:AddCtrl
		}).
		when("/game/:name", {
			templateUrl:"partials/addGame.html",
			controller:EditCtrl
		}

	);
});

application.factory("Games", function($resource, apiUrl){
	return $resource(
		apiUrl + "game/:id",
		{id: "@id"},
		{
			create: {method: "POST"},
			update: {method: "PUT"}
		}
	);
});
application.factory("GameByName", function($resource, apiUrl){
	return $resource(
		apiUrl + "game/search/findByNameIgnoreCase?name=:name",
		{name: "@name"}
	);
});

application.directive("clickable", function(){
	return{
		restrict: "A",
		link: function(scope, elem){
			$(elem).tableRowClickable();
		}
	}
});

function MainCtrl($scope, Games, $http){
	$scope.data = {};

	$scope.loading = true;
	$scope.loaded = false;

	Games.get(function(response){
		$scope.data.games = response.content;
		$scope.loading = false;
		$scope.loaded = true;
	});
	$scope.deleteGame = function(game){
		$scope.loaded = false;
		$scope.loading = true;
		$http.delete(game.links[0].href)
			.success(function(){
				Games.get(function(response){
					$scope.data.games = response.content;
					$scope.loading = false;
					$scope.loaded = true;
				});
			}
		)
		.error(function(){
			$scope.loading = false;
			$scope.loaded = true;
		});
	}
}
function AddCtrl($scope, Games){
	$scope.game = {};

	$scope.title = "Add Game";
	$scope.buttonText = "Add";

	$scope.submit = function (){
		Games.create($scope.game, function(){
			$scope.error = false;
			$scope.success = true;
		},function(error){
			if(error.status === 500){
				$scope.error = true;
				$scope.success = false;
			}
		});
	}
	$scope.hideFeedback = function(){
		$scope.error = false;
		$scope.success = false;
	};
}
function EditCtrl($scope, GameByName, $routeParams, Games){
	$scope.game = {};

	$scope.title = "Edit Game: ";
	$scope.buttonText = "Edit";

	GameByName.get(
		{name: $routeParams.name},
		function(response){
			var game = response.content[0];
			$scope.game = game;
			$scope.title += $scope.game.name;
		},
		function(error){
			console.log(error);
		}
	);

	$scope.submit = function (){
		//hvorfor sette links til undefined? Dunno, men det funker
		$scope.game.links = undefined;
		Games.update(
			$scope.game,
			function(success){
				$scope.error = false;
				$scope.success = true;
			}
		);
	}
	$scope.hideFeedback = function(){
		$scope.error = false;
		$scope.success = false;
	};
}