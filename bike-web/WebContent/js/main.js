var urlRaiz = "http://localhost:8080/bike-web";
var perfil = "/gerenciadorPerfil";
var roteiro = "/gerenciadorRoteiro";

$('#btnLogar').click(function() {
	login();
	return false;
});

function login(){
	console.log('login');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: urlRaiz + perfil + '/login',
		dataType: "json",
		data: loginFormToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Logado com sucesso...');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Erro ao logar...');
		}
	});
}

function loginFormToJSON() {
	return JSON.stringify({
		"email": $('#email').val(), 
		"senha": $('#senha').val(),
		});
}
