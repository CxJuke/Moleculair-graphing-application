<script  type="text/javascript">
    status = '${requestScope.error}';
    mol_old = '${requestScope.mol_old}';
    var builder = $('#t');


    if (status !== "true") {
        builder.addClass('is-invalid');

    } else {
        builder.removeClass('is-invalid');
        var G = new jsnx.Graph();
        G.addNodesFrom(${requestScope.nodes});
        G.addEdgesFrom(${requestScope.edges});
        jsnx.draw(G, {
            element: '#container',
            withLabels: false,
            nodeStyle: {
                fill: function(d) {
                    return d.data.color || '#AAA';
                }
            }
        });
    }


</script>



