$(document).ready(function () {
    console.log(1);
    $("#main .main_image").each(function(){
        var keyword=$(this).data("keyword");
        $(this).append("<p class=\"keyword\">"+keyword+"</p>");

    });

   $("#main .main_image").hover(function(){
           $(this).addClass("on");
       },
       function(){
           $(this).removeClass("on");
       });


});