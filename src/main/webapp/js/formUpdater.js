$(document).ready(function () {
    $('#t').on("change paste keyup", function () {
        var mol = $('#t').val();
        var mainContainer = $('#mainContainer');
        if (mol_old !== mol && mol !== "") {


            $.post("graph.draw",
                {
                    molecule: mol
                },
                function (data) {
                    mainContainer.html("");

                    console.log("should have emptied")
                    mainContainer.append(data);

                });
                mol_old = mol
                $('#SaveMolecule').attr("value", mol)
            }
    });

    $('.typeahead').typeahead({
        source: function(query, process) {

        return $.post('input.Search', { query: query}, function (results) {

            return process(results)


        })
        },
        afterSelect: function (molecule) {
            var mainContainer = $('#mainContainer');

            $.post("graph.draw",
                {
                    molecule: molecule
                },
                function (data) {
                    mainContainer.html("");

                    console.log("should have emptied")
                    mainContainer.append(data);

                });
            mol_old = mol
            $('#SaveMolecule').attr("value", mol)

        }
    })

    $('.typeahead').on()

});

