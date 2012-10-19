package com.uah.graph;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEvent.Edge;
import edu.uci.ics.jung.io.PajekNetWriter;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class PajekAdapter {

    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/

    /**
     *
     * @param fileName
     * @param graph
     */
    public static void export(String fileName, Graph<MavselVertex,String> graph){
        
        try{
            PajekNetWriter<MavselVertex, String> pajekWriter = new PajekNetWriter<MavselVertex, String>();
            Layout<MavselVertex, Edge> layout = new ISOMLayout(graph);
            BasicVisualizationServer<MavselVertex, Edge> vv = new BasicVisualizationServer<MavselVertex, Edge>(layout);
            vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());


            pajekWriter.save(graph , fileName, vv.getRenderContext().getVertexLabelTransformer(), null);


            System.out.println("Grafo["+graph.toString()+"]");

        } catch(Exception e){
           e.printStackTrace();
        }

    }


}
