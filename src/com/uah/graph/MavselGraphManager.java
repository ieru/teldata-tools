package com.uah.graph;

import com.uah.items.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class MavselGraphManager {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    public static final String INIT_CREATEDTIME = "CREATED TIME::[";
    public static final String END_CREATEDTIME = "]::";
    public static final String SEPARATOR = " || ";

    
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    public MavselGraphManager() {
    }

    /**
     * Retuns a Jung2 bipartite graph object wich its vertex represent forums
     * and particpants and each edge is a post writen by a participant into that
     * forum.
     *
     * @param course
     * @param lms
     * @return
     */
    public Graph<MavselVertex, MavselEdge> getParticipantForumGraph(Course course, LMS lms) {

        List<Forum> forums = lms.getForums(course);
        return getParticipantForumGraph(forums, lms);
    }

    /**
     * Retuns a Jung2 bipartite graph object wich its vertex represent forums
     * and particpants and each edge is a post writen by a participant into that
     * forum.
     *
     * @param forums
     * @param lms
     * @return
     */
    public Graph<MavselVertex, MavselEdge> getParticipantForumGraph(List<Forum> forums, LMS lms) {

        return extractGraph(forums, lms);
    }

    /**
     * Retuns a Jung2 bipartite graph object wich its vertex represent forums
     * and particpants and each edge is a post writen by a participant into that
     * forum.
     *
     * @param forums
     * @param lms
     * @return
     */
    public Graph<MavselVertex, MavselEdge> extractGraph(List<Forum> forums, LMS lms) {
        MavselVertex forumVertex = new MavselVertex("",false,"");
        MavselVertex participantVertex = new MavselVertex("",false,"");
        MavselEdge edge = new MavselEdge();
        List<Discussion> discussions;
        List<Post> posts;
        HashMap forumNodes = new HashMap();
        HashMap userNodes = new HashMap();

        Graph<MavselVertex, MavselEdge> graph = new SparseMultigraph<MavselVertex, MavselEdge>();

        int temp = 0;
             //Graph<String, String> graphtester = new SparseMultigraph<String, String>();
        for (Forum forum : forums) {
            forumVertex = new MavselVertex(forum.getTitle(), MavselVertex.IS_FORUM, forum.getId());

            //Checking if the new forum node alredy exists
            if (forumNodes.containsKey(forumVertex.getId())) {
                //forum vertice alredy exists
                //System.out.println("Forum alredy exist");
                forumVertex = (MavselVertex) forumNodes.get(forumVertex.getId());
            } else {
                //add a new forum vertice
                graph.addVertex(forumVertex);
                forumNodes.put(forumVertex.getId(), forumVertex);
               // System.out.println("***a new forum has been added--" + forumVertex.toString());
            }

            discussions = lms.getDiscussions(forum);

            for (Discussion discussion : discussions) {
                posts = lms.getPosts(discussion);

                for (Post post : posts) {
                    Participant participant = lms.getParticipant(post.getIdParticipant());
                    participantVertex = new MavselVertex(participant.getUsername(), MavselVertex.IS_USER, participant.getId());

                    //Checking if the new user node alredy exists
                    if (userNodes.containsKey(participantVertex.getId())) {
                        //participant vertice alredy exists
                        //System.out.println("participant alredy exist");
                        participantVertex = (MavselVertex) userNodes.get(participantVertex.getId());
                    } else {
                        //add a new participant vertice
                        graph.addVertex(participantVertex);
                        //System.out.println("***a new participant has been added--" + participantVertex.toString());
                        userNodes.put(participantVertex.getId(), participantVertex);
                        
                    }

                    try {
                   
                        //graph.addEdge(forumVertex.toString() + SEPARATOR + participantVertex.toString() + SEPARATOR + INIT_CREATEDTIME + post.getCreatedTime() + END_CREATEDTIME, forumVertex, participantVertex, EdgeType.DIRECTED);
                        edge = new MavselEdge(post.getCreatedTime(),participantVertex,forumVertex );
                        graph.addEdge(edge, participantVertex, forumVertex, EdgeType.DIRECTED);
                        //System.out.println("NEW EDGE - "+ forumVertex.toString() + participantVertex.toString() + INIT_CREATEDTIME + post.getCreatedTime() + END_CREATEDTIME);
                        
                        
                 /*
                  graphtester.addVertex("1");          
                  graphtester.addVertex("2");   
                  graphtester.addVertex("3");   
                  graphtester.addVertex("3");  
                  graphtester.addVertex("9");  
                  
                  graphtester.addEdge("Edge A", "1", "2", EdgeType.DIRECTED); 
                  graphtester.addEdge("Edge B", "1", "3", EdgeType.DIRECTED); 
                  graphtester.addEdge("Edge C", "2", "3", EdgeType.DIRECTED); 
                graphtester.addEdge("Edge d", "4", "5", EdgeType.DIRECTED); 
                graphtester.addEdge("Edge e", "2", "1", EdgeType.DIRECTED); 
                graphtester.addEdge("Edge f", "1", "3", EdgeType.DIRECTED); 
                */        
                    } catch (java.lang.IllegalArgumentException e) {
                        // The new edge alredy exists
                        System.out.println("EDGE ALREDY EXISTS - " + forumVertex.toString() + " - " + participantVertex.toString());
                    }
                }
            }
            
            
            try {
                   
                        //graph.addEdge(forumVertex.toString() + SEPARATOR + participantVertex.toString() + SEPARATOR + INIT_CREATEDTIME + post.getCreatedTime() + END_CREATEDTIME, forumVertex, participantVertex, EdgeType.DIRECTED);
                        //graph.addEdge(forumVertex.toString()+participantVertex.toString(), forumVertex, participantVertex,EdgeType.DIRECTED);
                       // System.out.println("NEW EDGE - "+ forumVertex.toString() + participantVertex.toString() + INIT_CREATEDTIME + post.getCreatedTime() + END_CREATEDTIME);
                   
                /*
                graph.addVertex("1");        
                graph.addEdge("Edge A - "+temp, forumVertex, participantVertex,EdgeType.UNDIRECTED);

                graph.addEdge("Edge B - "+temp, forumVertex, participantVertex,EdgeType.UNDIRECTED);

                graph.addEdge("Edge C - "+temp, forumVertex, participantVertex,EdgeType.UNDIRECTED);
                */
                
                            
                        
                    } catch (java.lang.IllegalArgumentException e) {
                        // The new edge alredy exists
                        System.out.println("EDGE ALREDY EXISTS - " + forumVertex.toString() + " - " + participantVertex.toString());
                    }
            
            
        }
     /*
        S*ystem.out.println("---------------------------------------------");
        System.out.println("--graph.getVertexCount()"+graph.getVertexCount());
        System.out.println("--graph.getEdgeCount()"+graph.getEdgeCount());
        System.out.println(graph.toString());
        System.out.println("---------------------------------------------");
        */
        return graph;
    }


    /**
     *
     * @param fileName
     */
    /*
     * public void exportGraphToPajekFormat(String fileName){
     * PajekNetWriter<MavselVertex, String> pajekWriter = new
     * PajekNetWriter<MavselVertex, String>();
     *
     *
     * try{
     *
     * Graph<MavselVertex, String> g = new SparseMultigraph<MavselVertex,
     * String>();
     *
     * MavselVertex v1 = new MavselVertex("Foro de un curso",
     * MavselVertex.IS_FORUM, "1"); MavselVertex v2 = new MavselVertex("alumno",
     * MavselVertex.IS_USER, "2"); MavselVertex v3 = new MavselVertex("Otro
     * foro", MavselVertex.IS_FORUM, "3"); MavselVertex v4 = new
     * MavselVertex("Otro alumno", MavselVertex.IS_USER, "4");
     *
     *
     * g.addVertex(v1); g.addVertex(v2);
     *
     * g.addEdge("Miedge", v2, v1, EdgeType.DIRECTED);
     *
     * g.addVertex(v3); g.addVertex(v4); g.addEdge("Miedge2", v4, v3,
     * EdgeType.DIRECTED);
     *
     * Layout<MavselVertex, Edge> layout = new ISOMLayout(g);
     * BasicVisualizationServer<MavselVertex, Edge> vv = new
     * BasicVisualizationServer<MavselVertex, Edge>(layout);
     * vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
     *
     *
     * pajekWriter.save(g , fileName,
     * vv.getRenderContext().getVertexLabelTransformer(), null);
     *
     *
     * System.out.println("Grafo["+g.toString()+"]");
     *
     *
     * } catch(Exception e){ e.printStackTrace(); }
     *
     * }
     */
}
