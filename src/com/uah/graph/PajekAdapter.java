package com.uah.graph;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;

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
    public static void export(String fileName, Graph<MavselVertex,MavselEdge> graph){
        
        try{
            PajekNetWriter<MavselVertex, MavselEdge> pajekWriter = new PajekNetWriter<MavselVertex, MavselEdge>();
            Layout<MavselVertex, MavselEdge> layout = new ISOMLayout(graph);
            BasicVisualizationServer<MavselVertex, MavselEdge> vv = new BasicVisualizationServer<MavselVertex, MavselEdge>(layout);
            vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());

            pajekWriter.save(graph , fileName, vv.getRenderContext().getVertexLabelTransformer(), null);


            //System.out.println("Grafo["+graph.toString()+"]");

        } catch(Exception e){
           e.printStackTrace();
        }

    }


}
