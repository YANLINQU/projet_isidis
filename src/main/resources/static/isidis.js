/*
YANLIN QU
05/01/2018
 */
$(function(){
    $("#wrapper").toggleClass("toggled");
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
                $("#contenu_tables tr:not(:first)").empty();
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
                $("#contenu_menus tr:not(:first)").empty();
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

function tablecontenu(item){
    trHtml=
        "<tr>" +
        "<td>"+item.id+"</td>" +
        "<td>"+item.qr+"</td>" +
        "<td> <button type=\"button\" class=\"btn btn-success\">Créer</button> </td>" +
        "<td> <button type=\"button\" class=\"btn btn-danger\">Supprimer</button></td>" +
        "</tr>";
    var $tr=$("#tab tr:last");
    $tr.after(trHtml);
}
function menuscontenu(item){

    trHtml=
        "<tr>" +
        "<td>"+item.nomme+"</td>" +
        "<td>"+item.imageadresse+"</td>" +
        "<td>"+item.prix+"</td>" +
        "<td>"+item.activite+"</td>" +
        "</tr>";
    var $tr=$("#menu tr:last");
    $tr.after(trHtml);
}

function divShowAndHide(divShow){
    $("#contenu_tables").hide();
    $("#contenu_menus").hide();

    $("#"+divShow).show();
}