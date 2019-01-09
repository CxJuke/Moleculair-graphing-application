<script  type="text/javascript">
    var status = ${requestScope.error};

    if (!status) {
        $('#t').addClass('border-danger')

    } else {
        $('#t').removeClass('border-danger')
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



