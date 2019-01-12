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
});

