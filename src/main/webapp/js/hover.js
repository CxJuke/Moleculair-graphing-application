$(document).ready(function () {
    $('#tooltip').hover(function () {
        $( this ).append( $( "<span>Type your molecule here</span>" ) );
    }, function() {
        $( this ).find( "span:last" ).remove();
    }

    );}

