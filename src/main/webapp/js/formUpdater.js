$(document).ready(function () {
    $('#t').keyup(function () {
        $.post("graph.draw",
            {
                molecule: $('#t').val()
            },
            function(data){
           $('#graph').html(data);
            });

    });
});

