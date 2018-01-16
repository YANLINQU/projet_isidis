/*
YANLIN QU
05/01/2018
 */
$(function(){
    $("#wrapper").toggleClass("toggled");

    $.ajax({
        url:'http://localhost:8080/websocket/login/SuShiKan',
        type:"GET",
        cache : false,
        dataType : "json",
        success:function(data) {
            var websocket=null;
            if ('WebSocket' in window) {
                websocket = new WebSocket("ws://localhost:8080/webSocketIMServer");
            } else if ('MozWebSocket' in window) {
                websocket = new MozWebSocket("ws://localhost:8080/webSocketIMServer");
            } else {
                websocket = new SockJS("http://localhost:8080/webSocketIMServer");
            }
            websocket.onopen = onOpen;
            websocket.onmessage = onMessage;
            websocket.onerror = onError;
            websocket.onclose = onClose;

            function onOpen(openEvt) {
                //alert("open");
                //alert(openEvt.Data);
            }

            function onMessage(evt) {
                $("#contenu_commandes").hide();
                $.ajax({
                    url:'http://localhost:8080/commande/1',
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
                            swal({
                                title: "Vous avez reçu une nouvelle commande ！",
                                text: "",
                                timer: 2000,
                                showConfirmButton: false
                            });
                            var audio = new Audio("music/son.mp3");
                            audio.play();
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
$("#resto_tables").click(function(){
    $.ajax({
        url:'http://localhost:8080/tables/1',
        type:"GET",
        cache : false,
        dataType : "json",
        success:function(data) {
            if(!$("#contenu_tables").is(":visible")){
                $("#tab tr:not(:first)").empty();//enlever toutes ligne dans la table sauf que la premiere
                divShowAndHide("contenu_tables");
                $.each(data, function(i,item){
                    tablecontenu(item);
                });
            }
        },
        error: function(){
            //message d'error
        }
    });
    e.preventDefault();//do nothing
});
//resto_tables on click pour afficher les tables dans un resto
$("#resto_menus").click(function(){
    $.ajax({
        url:'http://localhost:8080/menus/1',
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
        error: function(){
            //message d'error
        }
    });
    e.preventDefault();//do nothing
});
//resto_tables on click pour afficher les tables dans un resto
$("#resto_commande").click(function(){
    $.ajax({
        url:'http://localhost:8080/commande/1',
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

function tablecontenu(item){
    var trHtml=
        "<tr>" +
        "<td>"+item.id+"</td>" +
        "<td><a href="+item.qr+">DownLoad</a></td>" +
        "<td> <button type=\"button\" class=\"btn btn-danger\">Supprimer</button></td>" +
        "</tr>";
    var $tr=$("#tab tr:last");
    $tr.after(trHtml);
}


function menuscontenu(item){
    var trHtml=
        "<tr>" +
        "<td>"+item.nomme+"</td>" +
        "<td><img src="+item.imageadresse+" height=\"100\" width=\"100\" ></td>" +
        "<td>"+item.prix+"</td>" +
        "<td>"+item.activite+"</td>" +
        "</tr>";
    var $tr=$("#menu tr:last");
    $tr.after(trHtml);
}


function commandecontenu(item){
    var trHtml=
        "<tr>" +
        "<td>"+item.id_table+"</td>" +
        "<td>"+item.datecommande+"</td>" +
        "<td>"+item.id_client+"</td>" +
        "<td>"+item.id_menu+"</td>" +
        "<td>"+item.montant+"</td>" +
        "<td>"+item.paiement+"</td>" +
        "<td>"+item.valider+"</td>" +
        "</tr>";
    var $tr=$("#commandes tr:last");
    $tr.after(trHtml);
}

function divShowAndHide(divShow){
    $("#contenu_tables").hide();
    $("#contenu_menus").hide();
    $("#contenu_commandes").hide();

    $("#"+divShow).show();
}
