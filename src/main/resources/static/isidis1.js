/*
YANLIN QU
05/01/2018
 */
//vps507764.ovh.net:8080/projet_isidis/
//localhost:8080/
var connection="http://localhost:8080/";
var connectionws="ws://localhost:8080/";
/*
se connecter à web socket pour enregistrer le nom de restaurateur quand ouvrir cette page
 */
$(function(){
    $("#wrapper").toggleClass("toggled");
    var audioEle = document.getElementById("audio");
    $.ajax({
        url:connection+'websocket/login/SuShiKan',
        type:"GET",
        cache : false,
        dataType : "json",
        success:function(data) {
            var websocket=null;
            if ('WebSocket' in window) {
                websocket = new WebSocket(connectionws+"webSocketIMServer");
            } else if ('MozWebSocket' in window) {
                websocket = new MozWebSocket(connectionws+"webSocketIMServer");
            } else {
                websocket = new SockJS(connection+"webSocketIMServer");
            }
            websocket.onopen = onOpen;
            websocket.onmessage = onMessage;
            websocket.onerror = onError;
            websocket.onclose = onClose;

            function onOpen(openEvt) {
                //alert("open");
                //alert(openEvt.Data);
            }
            // récupérer les message de commande s'il y a un client passer une commande
            function onMessage(evt) {
                $("#contenu_commandes").hide();
                $.ajax({
                    url:connection+'commande/1',
                    type:"GET",
                    cache : false,
                    dataType : "json",
                    success:function(data) {
                        if(!$("#contenu_commandes").is(":visible")){
                            $("#commandes tr:not(:first)").empty();//enlever toutes ligne dans la table sauf que la premiere
                            divShowAndHide("contenu_commandes");
                            $.each(data, function(i,item){
                                commandecontenu(item);
                            });
                            //var audio = new Audio("music/son.mp3");
                            audioEle.play();
                            swal({
                                title: "Vous avez reçu une nouvelle commande ！",
                                text: "",
                                timer: 2000,
                                showConfirmButton: false
                            });
                        }
                    },
                    error: function(){
                        //message d'error
                    }
                });
            }
            function onError() {}
            function onClose() {}
        },
        error: function(){
            //message d'error
        }
    });

});
//open wapper
$("#menu-toggle-right").click(function(e) {
    $("#right").hide();
    $("#left").show();
    e.preventDefault();//do nothing
    $("#wrapper").toggleClass("toggled");
});
//close wapper
$("#menu-toggle-left").click(function(e){
    $("#right").show();
    $("#left").hide();
    e.preventDefault();//do nothing
    $("#wrapper").toggleClass("toggled");
});
//open les actions
$("#open-actions").click(function(e){
    $("#nom_restaurateur").text($("#id_resto").text());
    $("#actions").show();
    e.preventDefault();//do nothing
    //accordion slideup
    $(".list_dt").removeAttr("id").siblings("dd").slideUp();
});
//Dropdown Restaurateur
$(".list_dt").on("click",function () {
    $('.list_dd').stop();
    $(this).siblings("dt").removeAttr("id");
    if($(this).attr("id")=="open"){
        $(this).removeAttr("id").siblings("dd").slideUp();
    }else{
        $(this).attr("id","open").next().slideDown().siblings("dd").slideUp();
    }
});

//resto_tables on click pour afficher les tables dans un resto
function afficherTables(){

    $.ajax({
        url: connection + 'tables/1',
        type: "GET",
        cache: false,
        dataType: "json",
        success: function (data) {
            if (!$("#contenu_tables").is(":visible")) {
                $("#tab tr:not(:first)").empty();//enlever toutes ligne dans la table sauf que la premiere
                divShowAndHide("contenu_tables");
                $.each(data, function (i, item) {
                    tablecontenu(item);
                });
            }
        },
        error: function () {
            //message d'error
        }
    });
}

$("#resto_tables").click(function(e){
    afficherTables();
    e.preventDefault();//do nothing
});

//resto_tables on click pour afficher les tables dans un resto
function afficherMenus(){

    //web
    //url:connection+'menus/3',
    //local
    //url:connection+'menus/1',
    $.ajax({
        url:connection+'menus/1',
        type:"GET",
        cache : false,
        dataType : "json",
        success:function(data) {

            if(!$("#contenu_menus").is(":visible")){
                $("#menu tr:not(:first)").empty();//enlever toutes ligne dans la table sauf que la premiere
                divShowAndHide("contenu_menus");
                var trHtml="";
                $.each(data, function(i,item){
                    menuscontenu(item);
                });
            }
        },
        async: false,
        error: function(){
            //message d'error
        }
    });

}
    $("#resto_menus").click(function(e){
        afficherMenus();
        e.preventDefault();//do nothing
    });

//resto_tables on click pour afficher les tables dans un resto
$("#resto_commande").click(function(e){
    $.ajax({
        url:connection+'commande/1',
        type:"GET",
        cache : false,
        dataType : "json",
        success:function(data) {
            if(!$("#contenu_commandes").is(":visible")){
                $("#commandes tr:not(:first)").empty();//enlever toutes ligne dans la table sauf que la premiere
                divShowAndHide("contenu_commandes");
                $.each(data, function(i,item){
                    commandecontenu(item);
                });
            }
        },
        error: function(){
            //message d'error
        }
    });
    e.preventDefault();//do nothing
});
//compléter la table de tables d'un resto
function tablecontenu(item){
    var trHtml=
        "<tr>" +
        "<td>"+item.numero+"</td>" +
        "<td><a href="+item.qr+">Télécharger</a></td>" +
        "<td> <button type=\"button\" class=\"btn btn-danger\">Supprimer</button></td>" +
        "</tr>";
    var $tr=$("#tab tr:last");
    $tr.after(trHtml);
}

//compléter la table de menus d'un resto
function menuscontenu(item){

    var prix =  parseFloat(item.prix).toFixed(2).toString() + " €";

    if(item.activite==true)
        var disponible = "<td class='table-success modifyActivity'></td>"
        //var disponible =  "<td class='table-success'>Oui <button type=\"button\" class=\"btn btn-danger modifyActivity\">Modifier</button></td>";
    else
        var disponible = "<td class='table-danger modifyActivity'></td>"
        //var disponible = "<td class='table-danger'>Non <button type=\"button\" class=\"btn btn-danger modifyActivity\">Modifier</button></td>";

    var trHtml=
        "<tr id='"+item.id +"'>" +
        "<td>"+item.nomme+"</td>" +
        "<td><img src="+item.imageadresse+" height=\"100\" width=\"100\" ></td>" +
        "<td>"+prix+"</td>" +
        disponible+
        "</tr>";
    var $tr=$("#menu thead");
    $tr.after(trHtml);
}

//compléter la table de commandes
function commandecontenu(item){

    if(item.paiement==true)
        var paye = "<td class='table-success'>Effectué</td>";
    else
        var paye = "<td class='table-danger'>Non effectué</td>";

    if(item.valider==true) {
        var statusCommande = "<tr class='terminee'>";
        var valider = "<td class='table-success'>Oui</td>";
    }
    else {
        var statusCommande ="<tr>";
        var valider = "<td class='table-danger'>Non</td>";
    }


    var prix =  parseFloat(item.montant).toFixed(2).toString() + " €";
    var trHtml=
        statusCommande +
        "<td>"+item.id_table+"</td>" +
        "<td>"+item.datecommande+"</td>" +
        "<td>"+item.id_client+"</td>" +
        "<td>"+item.menu_name+"</td>" +
        "<td>"+prix+"</td>" +
        paye +
        valider +
        "</tr>";
    var $tr=$("#commandes tr:last");
    $tr.after(trHtml);
}

/*
 les div existent invisible si la paramètre est vide sinon le div de la paramètre est visibilité
 */
function divShowAndHide(divShow){
    $("#intro").children().hide();
    $("#contenu_tables").hide();
    $("#contenu_menus").hide();
    $("#contenu_commandes").hide();

    $("#"+divShow).show();
}

$('.commandesValidees').change(function(){
        $('.terminee').each(function () {
            $(this).toggle();
        });
});

$("body").on('click', '.modifyActivity', function (){
    var idMenu = $(this).parent().attr('id');
    $.ajax({
        url:connection+'menus/'+idMenu+'/modifyActivity',
        type:"POST",
        async: false,
        success:function(data) {
            $("#contenu_menus").hide();
                afficherMenus();

        },
        error: function(){
            //message d'error
        }
    });
    e.preventDefault();//do nothing
});

$("body").on('click', '.ajoutTables', function (e){
    var nbTables = $(this).parent().children("div").children("input").val();
    $.ajax({
        url:connection+'tables/1/ajout/'+nbTables,
        type:"POST",
        async: false,
        success:function(data) {
            $("#contenu_tables").hide();
            afficherTables();

        },
        error: function(){
            //message d'error
        }
    });
    e.preventDefault();//do nothing
});

