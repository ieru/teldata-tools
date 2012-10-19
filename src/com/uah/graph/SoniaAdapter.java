
package com.uah.graph;

import edu.uci.ics.jung.graph.Graph;
import java.util.Collection;


/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class SoniaAdapter {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    public static final String columsNode[] = {"NodeId", "Label", "StartTime", "EndTime", "NodeSize", "NodeShape", "ColorName", "BorderWidth", "BorderColor"};
    public static final String columsFrom[] = {"FromId","ToId","StartTime", "EndTime", "ArcWeight", "ArcWidth", "ColorName"};
    
    
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    public static void export(String fileName, Graph<MavselVertex,String> graph){
        StringBuffer file = new StringBuffer();
        try{
            
            //Exporting nodes
            Collection<MavselVertex> vertices = graph.getVertices();            
            
            
            //Header -> node columns
            file.append(columsNode[0]);
            for(int i = 1; i< columsNode.length; i++){
                file.append('\t');
                file.append(columsNode[i]);                                             
            }
            
            //Rows -> nodes
            for(MavselVertex vertice: vertices){
                file.append('\n');
                
                //NodeId
                file.append(vertice.getId());
                file.append('\t');
                
                //Label
                file.append(vertice.getDescription());
                file.append('\t');
                
                //StratTime
                file.append("0.0");
                file.append('\t');
                
                //EndTime
                file.append("0.0");
                file.append('\t');
                
                //NodeSize
                file.append("5.0");
                file.append('\t');
                
                //NodeShape
                if (vertice.getType() == vertice.IS_FORUM){
                    file.append("rect");
                }else{
                    file.append("ellipse");
                }                
                file.append('\t');
                
                //ColorName
                if (vertice.getType() == vertice.IS_FORUM){
                    file.append("gray");
                }else{
                    file.append("lightGray");
                }                
                file.append('\t');
                
                
                //BorderWidth
                file.append("1.5");
                file.append('\t');
                
                //BorderColor
                file.append("black");
                file.append('\t');
            }
            
            
            Collection<String> edges = graph.getEdges();  
            
            System.out.println("edges::"+edges.size());
            
            //Header -> relations columns
            file.append("\n");
            file.append(columsFrom[0]);
            for(int i = 1; i< columsFrom.length; i++){
                file.append('\t');
                file.append(columsFrom[i]);                                             
            }
            
            
            
            for(String relation: edges){
                file.append('\n');
                //System.out.println("Relation::"+relation);
                
                //FromId
                file.append(extractForumId(relation));
                file.append('\t');
                
                //ToId
                file.append(extractParticipantId(relation));
                file.append('\t');
                
                //StrartTime
                //lo guardo en el mismo string de edge                
                file.append(extractStratTime(relation));
                file.append('\t');
                
                //EndTime
                file.append("0.0");
                file.append('\t');
                
                //ArcWeight
                file.append("0.2");
                file.append('\t');
                
                //ArcWidth
                file.append("1.6");
                file.append('\t');
                
                //ColorName
                file.append("black");
                file.append('\t');
            }
            
            
           /* 
            PajekNetWriter<MavselVertex, String> pajekWriter = new PajekNetWriter<MavselVertex, String>();
            Layout<MavselVertex, GraphEvent.Edge> layout = new ISOMLayout(graph);
            BasicVisualizationServer<MavselVertex, GraphEvent.Edge> vv = new BasicVisualizationServer<MavselVertex, GraphEvent.Edge>(layout);
            vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());


            pajekWriter.save(graph , fileName, vv.getRenderContext().getVertexLabelTransformer(), null);


            System.out.println("Grafo["+graph.toString()+"]");*/

        } catch(Exception e){
           e.printStackTrace();
        }
        
        System.out.println("File SoNIA["+file.toString()+"] SoNIA format");
    }
    

    
    /**************************************************************************
    *                              PRIVATE METHODS
    ***************************************************************************/
    
    /**
     * 
     * @param edgeDescription
     * @return 
     */
    private static String extractStratTime(String edgeDescription){   
        int ini = edgeDescription.indexOf(MavselGraphManager.INIT_CREATEDTIME)+MavselGraphManager.INIT_CREATEDTIME.length(); 
        int fin = edgeDescription.indexOf(MavselGraphManager.END_CREATEDTIME); 
        
        return edgeDescription.substring(ini, fin);
    }
    
    /**
     * 
     * @param edgeDescription
     * @return 
     */
    private static String extractForumId(String edgeDescription){
        int ini = edgeDescription.indexOf(MavselVertex.FORUM_TOSTRING_INIT)+MavselVertex.FORUM_TOSTRING_INIT.length(); 
        int fin = edgeDescription.indexOf(MavselVertex.FORUM_LABEL); 
        
        return edgeDescription.substring(ini, fin);
    }
    
    /**
     * 
     * @param edgeDescription
     * @return 
     */
    private static String extractParticipantId(String edgeDescription){        
        int ini = edgeDescription.indexOf(MavselVertex.USER_TOSTRING_INIT)+MavselVertex.USER_TOSTRING_INIT.length(); 
        int fin = edgeDescription.indexOf(MavselVertex.USER_LABEL); 

        return edgeDescription.substring(ini, fin);
    }
}
