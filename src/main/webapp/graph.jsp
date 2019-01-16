<div id="container" class="w-100 h-100">
<script  type="text/javascript">
    status = '${requestScope.error}';
    mol_old = '${requestScope.mol_old}';
    var builder = $('#t');
    var saver = $('#savingMolecule')


    if (status !== "true") {
        builder.addClass('is-invalid');
        saver.attr("disabled", true)


    } else {
        saver.attr("disabled", false)
        builder.removeClass('is-invalid');
        var G = new jsnx.Graph();
        G.addNodesFrom(${requestScope.nodes});
        G.addEdgesFrom(${requestScope.edges});
        jsnx.draw(G, {
            element: '#container',
            withLabels: true,
            labels: labelFunc = function (d) {
                return d.node;

            },
            nodeStyle: {
                fill: function(d) {
                    return d.data.color || '#AAA';
                }
            },
            nodeAttr: {
                r: 10
            },
            layoutAttr: {
                charge: -200,
                linkDistance: 25
            }
        });
    }


</script>

</div>
${requestScope.AttributeLists}
<script src="js/nodeHover.js"></script>



