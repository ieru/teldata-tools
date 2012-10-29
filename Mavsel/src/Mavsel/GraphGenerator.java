/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mavsel;

import com.uah.graph.MavselGraphManager;
import com.uah.graph.MavselVertex;
import edu.uci.ics.jung.graph.Graph;
import java.util.*;
import org.gephi.io.importer.api.ContainerLoader;
import org.gephi.io.importer.api.EdgeDraft;
import org.gephi.io.importer.api.NodeDraft;
import org.gephi.io.generator.spi.Generator;
import org.gephi.io.generator.spi.GeneratorUI;

import org.gephi.utils.progress.ProgressTicket;
import org.openide.util.lookup.ServiceProvider;


/**
 *
 * @author ie
 */
 @ServiceProvider(service = Generator.class)
public class GraphGenerator implements Generator{
    protected ProgressTicket progress;
    protected boolean cancel = false;
    private Graph<MavselVertex, String> graph;

    @Override
    public void generate(ContainerLoader container) {
        // create nodes
      
        Collection<String> edges = graph.getEdges();
        Collection<MavselVertex> vertexs = graph.getVertices();
        
        //ArrayList<MavselVertex> forumVertex = new ArrayList();
        //ArrayList<MavselVertex> userVertex = new ArrayList();
        
        Map<String, NodeDraft> forumTable = new HashMap<String, NodeDraft>();
        Map<String, NodeDraft> userTable =  new HashMap<String, NodeDraft>();
        
        
        System.out.println("graph.getVertexCount()--->" +graph.getVertexCount());
        
        for(MavselVertex vertex:vertexs){
            NodeDraft newNode;
            StringBuilder nodeLabel = new StringBuilder();
            
            // create nodes
            newNode = container.factory().newNodeDraft();
            
            if (vertex.getType()==MavselVertex.IS_FORUM){
               
                nodeLabel.append("Forum[");
                nodeLabel.append(vertex.getId()+"]");
                        
                // set node labels
                newNode.setLabel(nodeLabel.toString());
                
                forumTable.put(vertex.getId(),newNode);
            }else if (vertex.getType()==MavselVertex.IS_USER){
                
                nodeLabel.append("User[");
                nodeLabel.append(vertex.getId()+"]");
                        
                // set node labels
                newNode.setLabel(nodeLabel.toString());
                
                userTable.put(vertex.getId(),newNode);
            }
            
            System.out.println("newNode--->" +nodeLabel);
            // fill in the graph
            container.addNode(newNode);
        }
        
        MavselGraphManager graphManager = new MavselGraphManager();
        EdgeDraft e;
        System.out.println("edges size--->"+edges.size());
        for(String edge: edges){
           
            String nodeUserId = graphManager.extractUserIdFromLabel(edge);
            String nodeForumId = graphManager.extractForumIdFromLabel(edge);
            
            System.out.println("nodeUserId--->" +nodeUserId);
            System.out.println("nodeForumId--->"+nodeForumId);
          
            // create edge
            e = container.factory().newEdgeDraft();
            e.setSource(forumTable.get(nodeForumId));
            e.setTarget(userTable.get(nodeUserId));
            
            // fill in the graph            
            container.addEdge(e);
            
            /*
            String forum = graphManager.extractForumLabel(edge);
            System.out.println("forum--->"+forum);
           ///Vertex-ForumId[3] ForumLabel:: Foro con puntuaciones || Vertex-UserId[2] UserLabel:: admin || CREATED TIME::[1332330665]::
            int fisrt = edge.indexOf(graphManager.SEPARATOR);
            int last = edge.lastIndexOf(graphManager.SEPARATOR);
            System.out.println("separator--->"+graphManager.SEPARATOR+"<--");
            System.out.println("fisrt--->"+fisrt);
            System.out.println("last--->"+last);
            
            String contentNode1 = edge.substring(0,fisrt);
            String contentNode2 = edge.substring(fisrt+graphManager.SEPARATOR.length(),last);
            
            System.out.println("contentNode1Forum--->"+contentNode1);
            System.out.println("contentNode2Forum--->"+contentNode2);
 
            ///
            //System.out.println("    forum->"+forum);
            
            /*
            String user = graphManager.extractUserLabel(edge);
            System.out.println("    user->"+edge);
            fisrt = edge.indexOf(graphManager.SEPARATOR);
            last = edge.lastIndexOf(graphManager.SEPARATOR);
            contentNode1 = edge.substring(0,last);
            contentNode2 = edge.substring(fisrt+graphManager.SEPARATOR.length(),last);
            
            System.out.println("contentNode1User--->"+contentNode1);
            System.out.println("contentNode2User--->"+contentNode2);
            
            */
            /*
            // create nodes
            n1 = container.factory().newNodeDraft();
            n2 = container.factory().newNodeDraft();
            
            // set node labels
            n1.setLabel(contentNode1);
            n2.setLabel(contentNode2);
            
            // create edge
            e = container.factory().newEdgeDraft();
            e.setSource(n1);
            e.setTarget(n2);
        
            // fill in the graph
            container.addNode(n1);
            container.addNode(n2);
            container.addEdge(e);*/
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
    
    public void setGraph(Graph<MavselVertex, String> graph){
        this.graph = graph;
    }
    
    
    
}
