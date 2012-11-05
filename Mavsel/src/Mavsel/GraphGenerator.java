package Mavsel;

import com.uah.graph.MavselEdge;
import com.uah.graph.MavselVertex;
import edu.uci.ics.jung.graph.Graph;
import java.util.HashMap;
import java.util.Map;
import org.gephi.io.generator.spi.Generator;
import org.gephi.io.generator.spi.GeneratorUI;
import org.gephi.io.importer.api.ContainerLoader;
import org.gephi.io.importer.api.EdgeDraft;
import org.gephi.io.importer.api.NodeDraft;
import org.gephi.utils.progress.ProgressTicket;
import org.openide.util.lookup.ServiceProvider;


/**
 *
 * @author Pablo Sicilia
 * @version Gephi Mavsel module 1.0
 */
 @ServiceProvider(service = Generator.class)
public class GraphGenerator implements Generator{
    protected ProgressTicket progress;
    protected boolean cancel = false;
    private Graph<MavselVertex, MavselEdge> graph;

    @Override
    public void generate(ContainerLoader container) {
               
        //forumTable and userTable control vertex object in the graph
        Map<String, NodeDraft> forumTable = new HashMap<String, NodeDraft>();
        Map<String, NodeDraft> userTable =  new HashMap<String, NodeDraft>();
        
        // edgeTable map store edges of the graph for checking duplicate relations
        // In MAVSEL are not duplicate because generation time (they are different posts indeed)
        // but in Ghepi graphs we need to check this kind of edges.        
        Map<String, MavselEdge> edgeTable =  new HashMap<String, MavselEdge>();
        
        for(MavselVertex vertex: graph.getVertices()){
            NodeDraft newNode;
            StringBuilder nodeLabel = new StringBuilder();
            
            // create nodes
            newNode = container.factory().newNodeDraft();
            
            if (vertex.getType()==MavselVertex.IS_FORUM){
               
                nodeLabel.append("Forum[");
                nodeLabel.append(vertex.getId()+"]");
                        
                // set node labels
                newNode.setLabel(nodeLabel.toString());
                
                //add to forum table to control duplicate values
                forumTable.put(vertex.getId(),newNode);
            }else if (vertex.getType()==MavselVertex.IS_USER){
                
                nodeLabel.append("User[");
                nodeLabel.append(vertex.getId()+"]");
                        
                // set node labels
                newNode.setLabel(nodeLabel.toString());
                
                //add to user table to control duplicate values
                userTable.put(vertex.getId(),newNode);
            }

            // fill in the graph
            container.addNode(newNode);
        }        

        EdgeDraft e;

        for(MavselEdge edge: graph.getEdges()){                   
          
            //Check if edge is duplicate or not
            if(!edgeTable.containsKey(edge.toString())){
                // create edge
                e = container.factory().newEdgeDraft();
                e.setSource(userTable.get(edge.getUser().getId()));
                e.setTarget(forumTable.get(edge.getForum().getId()));
                                
                // fill in the graph            
                container.addEdge(e);

                //add to edge table to control duplicate values
                edgeTable.put(edge.toString(), edge);
            }            
        }           
    }
    
    @Override
    public String getName() {
        return "Hello World";
    }
 
    @Override
    public GeneratorUI getUI() {
        return null;
    }
 
    @Override
    public boolean cancel() {
        cancel = true;
        return true;
    }
 
    @Override
    public void setProgressTicket(ProgressTicket progressTicket) {
        this.progress = progressTicket;
    }
    
    public void setGraph(Graph<MavselVertex, MavselEdge> graph){
        this.graph = graph;
    }
    
    
    
}
