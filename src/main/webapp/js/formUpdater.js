$(document).ready(function () {
    $('#t').on("change paste keyup", function () {
        var mol = $('#t').val();
        if (mol_old !== mol && mol !== "") {
            $.post("graph.draw",
                {
                    molecule: mol
                },
                function (data) {
                    $('#container').html(data);

                });
                mol_old = mol
                $('#SaveMolecule').attr("value", mol)
            }
    });
});

