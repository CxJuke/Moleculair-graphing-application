<script  type="text/javascript">
    var G = new jsnx.Graph();
    G.addNodesFrom(${requestScope.nodes});
    G.addEdgesFrom(${requestScope.edges});

    jsnx.draw(G, {
        element: '#container',
        withLabels: true,
        nodeStyle: {
            fill: function(d) {
                return d.data.color || '#AAA';
            }
        }
    });
</script>