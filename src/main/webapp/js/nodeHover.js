$(document).ready(function () {
    $(".node-shape").mouseenter( function () {
        var listId = $(this).attr("id");

        $("ul[id|='{0}']".f(listId)).removeClass("d-none")
        
    })

    $(".node-shape").mouseleave( function () {
        var listId = $(this).attr("id");

        $("ul[id|='{0}']".f(listId)).addClass("d-none")

    })

});
