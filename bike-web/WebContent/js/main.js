var urlRaiz = "http://localhost:8080/bike-web";
var perfil = "/gerenciadorPerfil";
var roteiro = "/gerenciadorRoteiro";
var perfilId;

$('#btnLogar').click(function() {
	login();
	return false;
});

$('#btnCriarPerfil').click(function() {
	criarPerfil();
	return false;
});

$('#btnSalvarRoteiro').click(function() {
	criarRoteiro();
	return false;
});

$('#btnNovoRoteiro').click(function() {
	initialize();
	mostrar("novoRoteiroDiv");
	return false;
});

$('#btnCalcularRota').click(function() {
	calcRoute();
	$('div[id="directionsPanel"]').attr('style', 'float: left; width: 30%; height: 50%; display:show; overflow:auto;');
	return false;
});

$('#btnMeusRoteiros').click(function() {
	carregarRoteiros();
	return false;
});

$('#btnDesfazer').click(function() {
	desfazer();
	return false;
});

$('#origem').blur(function() {
	if($('#origem').val()!=""){
		codeAddress("origem", $('#origem').val());
	}
	return false;
});

$('#destino').blur(function() {
	if($('#destino').val()!=""){
		codeAddress("destino", $('#destino').val());
	}
	return false;
});

function mostrar(div){
	$('div[id*="Div"]').each(function(i){
		if(this.id == div){
			$(this).attr('style', 'display:show;');
		}else{
			$(this).attr('style', 'display:none;');
		}
	});
}

function criarPerfil(){
	$.ajax({
		type: 'GET',
		contentType: 'application/json',
		url: urlRaiz + perfil + '/criarPerfil',
		dataType: "json",
		success: function(data, textStatus, jqXHR){
			alert('Perfil Criado com sucesso...');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Erro ao criar Perfil...');
		}
	});
}

function login(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: urlRaiz + perfil + '/login',
		dataType: "json",
		data: loginParaJSON(),
		success: function(data, textStatus, jqXHR){
			console.log(data);
			alert('Logado com sucesso...');
			perfilId = data.id;
			renderPerfil(data);
			mostrar("perfilDiv");
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Erro ao logar...');
		}
	});
}

function criarRoteiro(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: urlRaiz + roteiro + '/criarRoteiro',
		dataType: "json",
		data: googleMapParaJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Roteiro criado com sucesso...');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Erro ao criar roteiro...');
		}
	});
}

function carregarRoteiros(){
	$.ajax({
		type: 'GET',
		contentType: 'application/json',
		url: urlRaiz + roteiro + '/carregarRoteiros/' + perfilId,
		dataType: "json",
		data: perfilId,
		success: function(data, textStatus, jqXHR){
			console.log(data);
			alert('Roteiros carregados com sucesso...');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Erro ao carregar roteiro...');
		}
	});
}



function loginParaJSON() {
	return JSON.stringify({
		"email": $('#email').val(), 
		"senha": $('#senha').val(),
	});
}

function googleMapParaJSON(){
	var googleMap={};
	var w=[];
	var rleg = directionsDisplay.directions.routes[0].legs[0];
	googleMap.id = perfilId;
	googleMap.latitudeInicial = rleg.start_location.lat(); 
	googleMap.longitudeInicial = rleg.start_location.lng();

	googleMap.latitudeFinal = rleg.end_location.lat();
	googleMap.longitudeFinal = rleg.end_location.lng();
	var wp = rleg.via_waypoints;

	for(var i=0; i < wp.length; i++){
		var way_point = {'ordem': i, 'latitude' : wp[i].lat(), 'longitude' : wp[i].lng()};
		w.push(way_point);
	}

	googleMap.wayPoints = w;
	console.log(googleMap);
	return JSON.stringify(googleMap);
}

function renderPerfil(perfil) {
	$('#apelido').val(perfil.usuario.apelido);
}

////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
//FUNÇÕES MAPS
//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
var map;
var geocoder;
var directionsDisplay;
var directionsService;
var stepDisplay;
var markerArray = [];
var oldDirections = [];
var currentDirections = null;
var origem = new google.maps.LatLng();
var destino = new google.maps.LatLng();
var opcoesDeEndereco=[];
var origemDestino;

function initialize() {
	var pracaDaSe = new google.maps.LatLng(-23.5505, -46.6344);
	directionsService = new google.maps.DirectionsService();
	geocoder = new google.maps.Geocoder();

	var mapOptions = {
			center: pracaDaSe,
			zoom: 15,
			mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
	
	//Create a renderer for directions and bind it to the map.
	var rendererOptions = {draggable: true, map: map};

	directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);
	directionsDisplay.setPanel(document.getElementById("directionsPanel"));

	// Instantiate an info window to hold step text.
	stepDisplay = new google.maps.InfoWindow();

	google.maps.event.addListener(directionsDisplay, 'directions_changed', function() {
		if (currentDirections) {
			oldDirections.push(currentDirections);
			setDesfazerDisabled(false);
		}
		currentDirections = directionsDisplay.getDirections();
	});
	
	setDesfazerDisabled(true);
}

function calcRoute() {
	// First, remove any existing markers from the map.
	for (var i = 0; i < markerArray.length; i++) {
		markerArray[i].setMap(null);
	}

	// Now, clear the array itself.
	markerArray = [];

	var request = {
			origin: origem,
			destination: destino,
			optimizeWaypoints: true,
	        avoidHighways: true,
	        avoidTolls: true,
			travelMode: google.maps.TravelMode.DRIVING,
			region: 'BR'
	};

	directionsService.route(request, function(result, status) {
		if (status == google.maps.DirectionsStatus.OK) {
			var warnings = document.getElementById('warnings_panel');
			warnings.innerHTML = '<b>' + result.routes[0].warnings + '</b>';
			directionsDisplay.setDirections(result);
		}
	});
}

function showSteps(directionResult) {
	//No meu caso para cada participante vou inserir um marker
	
	// For each step, place a marker, and add the text to the marker's
	// info window. Also attach the marker to an array so we
	// can keep track of it and remove it when calculating new
	// routes.
	var myRoute = directionResult.routes[0].legs[0];

	for (var i = 0; i < myRoute.steps.length; i++) {
		var marker = new google.maps.Marker({
			position: myRoute.steps[i].start_point,
			map: map
		});
		attachInstructionText(marker, myRoute.steps[i].instructions);
		markerArray[i] = marker;
	}
}

function attachInstructionText(marker, text) {
	google.maps.event.addListener(marker, 'click', function() {
		// Open an info window when the marker is clicked on,
		// containing the text of the step.
		stepDisplay.setContent(text);
		stepDisplay.open(map, marker);
	});
}

function desfazer() {	
	currentDirections = null;
	directionsDisplay.setDirections(oldDirections.pop());
	if (!oldDirections.length) {
		setDesfazerDisabled(true);
	}
}

function setDesfazerDisabled(value) {
	document.getElementById("btnDesfazer").disabled = value;
}

function montarLinkDeOpcoesDeEndereco(){
	var html="";
	for(var i=0; i < opcoesDeEndereco.length; i++){
		html +="<a onclick='setOrigemDestino("  + i +  ")';>" + opcoesDeEndereco[i].formatted_address + "</a> <br>";
	}
	return html;
}

function setOrigemDestino(indice){
	if(origemDestino == "origem"){
		origem = opcoesDeEndereco[indice].geometry.location;
	}else{
		destino = opcoesDeEndereco[indice].geometry.location;
	}
	$('#addressOptions').dialog( "close" );
}

function codeAddress(origDest, address) {
	opcoesDeEndereco=[];
	origemDestino = origDest;
	geocoder.geocode( {'address':address, 'region':'BR'}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			if(results.length > 1){
				for(var i=0; i < results.length; i++){

					opcoesDeEndereco.push(results[i]); 

				}
				$('#addressOptions').html(montarLinkDeOpcoesDeEndereco());
				$('#addressOptions').dialog({show: "slow", modal: true, height: 'auto', width : 'auto'});
			}else{
				if(origemDestino == "origem"){
					origem = results[0].geometry.location;
				}else{
					destino = results[0].geometry.location;
				}
			}

		} else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	});
}
