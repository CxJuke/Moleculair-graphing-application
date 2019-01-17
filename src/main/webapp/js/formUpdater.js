function drawMolecule(molecule) {
    var mainContainer = $('#mainContainer');

    $.post("graph.draw",
        {
            molecule: molecule
        },
        function (data) {
            mainContainer.html("");
            mainContainer.append(data);

        });
}

$(document).ready(function () {
    $('#t').on("change paste keyup", function () {
        var mol = $('#t').val();

        if (mol_old !== mol && mol !== "") {

            drawMolecule(mol);



                mol_old = mol
                $('#SaveMolecule').attr("value", mol)
            }
    });

    $('.typeahead').typeahead({
        highlight: true,
        source: function (query, process) {

            return $.post('input.Search', {query: query}, function (results) {

                return process(results)


            }
            )
        },
        afterSelect: function (molecule) {
            $.post("get.molecule",
                {moleculeName: molecule},
                function (data) {
                console.log(data);
                    $('#t').val(data);
                    drawMolecule(data);

                })
        }

        })

})
;

