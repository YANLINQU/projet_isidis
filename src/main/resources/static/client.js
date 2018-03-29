$(function() {

    var lien = "http://localhost:8080/Client/1/1/";
    var menu = 0;
    var total = 0;



    $(".choix").click(function () {
        var $compteur =  $(this).next(".nbChoix");
        $compteur.get(0).value++
        $compteur.show();

        //$(".cacher").hide();
    });

    $(".menus").click(function () {

        var menu = $(this).attr('id');
        alert(menu);
        var lienComplet = lien.concat(menu).concat("/commande");

        $("#menu_commande").prop("href", lienComplet);
        if( $(this).css('background-color') === "LightGrey" ) {
            $(this).css("background-color","");
            $(this).css("border","1px solid black");
            var prix = $(this).children('h4').text().replace("€", "");
            total = total-parseFloat(prix);
        }
        else{
            $(this).css("background-color","LightGrey");
            var prix = $(this).children('h4').text().replace("€", "");
            total = total+parseFloat(prix);
        }
        $(".prix").html("<h3>Prix total: "+total.toFixed(2)+" €");
        //$(".cacher").hide();
    });

    $("#menu_commande").click(function () {


    });

});