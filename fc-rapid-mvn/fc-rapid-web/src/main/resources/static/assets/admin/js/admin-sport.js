var csrf_token = $('meta[name="_csrf"]').attr('content');
var csrf_header_name = $('meta[name="_csrf_header"]').attr('content');

var ROUNDS_URI = "/api/rounds"
function createRoundsBundle() {
	var round = {}
	round["roundsNumber"] = $("#rounds_number").val();
	var league = {};
	league["leagueId"] = $('#selected_league option:selected').val();
	round["league"] = league;

	var status;
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : ROUNDS_URI,
		data : JSON.stringify(round),
		dataType : 'json',
		async : false,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrf_header_name, csrf_token);
		},
		success : function(data, textStatus, xhr) {
			status = xhr.status;
		},
		error : function(data, textStatus, xhr) {
			status = xhr.status;
		}
	});
}

var TEAM_URI = "/api/team"
function createTeam() {
	var team = {}
	team["teamName"] = $("#team_name").val();
	team["team_logo"] = $("#league_country").val();
	var league = {};
	league["leagueId"] = $('#selected_league option:selected').val();
	team["league"] = league;

	var status;
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : TEAM_URI,
		data : JSON.stringify(team),
		dataType : 'json',
		async : false,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrf_header_name, csrf_token);
		},
		success : function(data, textStatus, xhr) {
			status = xhr.status;
		},
		error : function(data, textStatus, xhr) {
			status = xhr.status;
		}
	});
}

var LEAGUE_URI = "/api/league";
var LEAGUES_URI = "/api/leagues";

function createLeague() {
	var league = {}
	league["leagueName"] = $("#league_name").val();
	league["country"] = $("#league_country").val();

	var status;
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : LEAGUE_URI,
		data : JSON.stringify(league),
		dataType : 'json',
		async : false,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrf_header_name, csrf_token);
		},
		success : function(data, textStatus, xhr) {
			status = xhr.status;
		},
		error : function(data, textStatus, xhr) {
			status = xhr.status;
		}
	});

	location.reload();
}

function renderLeagues() {
	var leagues = get_leagues();
	$('#leaguesList').empty();

	for (var i = 0; i < leagues.length; ++i) {
		var league = leagues[i];
		var liValue = '<li class="list-group-item">' + league.leagueName
				+ " - " + league.country + '</li>';
		$("#leaguesList").append(liValue);
	}
}
function get_leagues() {
	var leagues;
	$.ajax({
		type : "GET",
		contentType : "application/json",
		async : false,
		url : LEAGUES_URI,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrf_header_name, csrf_token);
		},
		success : function(data, textStatus, xhr) {
			leagues = data;
		}
	});
	return leagues;
}

renderLeagues();