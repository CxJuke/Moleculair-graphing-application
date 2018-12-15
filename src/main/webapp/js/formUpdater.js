$(document).ready(function () {
    $('#t').keyup(function () {
        $.post("graph.draw",
            {
                molecule: $('#t').val()
            },
            function(data){
           $('#dump').text(data);
            });

    });
});

