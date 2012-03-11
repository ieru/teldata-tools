/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.graph;

import com.uah.items.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class MavselGraphManager {
   
    public MavselGraphManager(){
        
    }
            
    

   /**
    *
    * @param course
    * @param lms
    * @return
    */
    public Graph<MavselVertex, String> getParticipantForumGraph(Course course, LMS lms){

        List<Forum>forums = lms.getForums(course);
        return getParticipantForumGraph(forums, lms);
    }


    /**
     *
     * @param forums
     * @param lms
     * @return
     */
    public Graph<MavselVertex, String> getParticipantForumGraph(List<Forum>forums, LMS lms){

        return extractGraph(forums, lms);
    }


    /**
     *
     * @param forums
     * @param lms
     * @return
     */
    public Graph<MavselVertex, String> extractGraph(List<Forum> forums, LMS lms){

        MavselVertex forumVertex;
        MavselVertex participantVertex;
        List<Discussion> discussions;
        List<Post> posts;

        Graph<MavselVertex, String> graph  = new SparseMultigraph<MavselVertex, String>();

        for(Forum forum:forums){
            forumVertex = new MavselVertex(forum.getTitle(), MavselVertex.IS_FORUM, forum.getId());
            graph.addVertex(forumVertex);

            discussions = lms.getDiscussions(forum);

            for(Discussion discussion:discussions){
                posts= lms.getPosts(discussion);

                for(Post post:posts){
                    Participant participant = lms.getParticipant(post.getIdParticipant());
                    participantVertex  = new MavselVertex(participant.getUsername(), MavselVertex.IS_USER, participant.getId());

                    if(graph.containsVertex(participantVertex)){
                        //participant vertice alredy exists

                    }else{
                        //add a new participant vertice
                        graph.addVertex(participantVertex);
                    }

                    try{
                        graph.addEdge(forumVertex.toString()+" - "+participantVertex.toString(), forumVertex, participantVertex, EdgeType.DIRECTED);
                        System.out.println("NEW EDGE - "+forumVertex.toString()+" - "+participantVertex.toString());
                    }catch(java.lang.IllegalArgumentException e){
                        // The new edge alredy exists
                        System.out.println("EDGE ALREDY EXISTS - "+forumVertex.toString()+" - "+participantVertex.toString());
                    }
                }
            }
        }

        return graph;
    }



   /**
    *
    * @param fileName
    */
    /*
   public void exportGraphToPajekFormat(String fileName){
       PajekNetWriter<MavselVertex, String> pajekWriter = new PajekNetWriter<MavselVertex, String>();


      try{

        Graph<MavselVertex, String> g = new SparseMultigraph<MavselVertex, String>();

        MavselVertex v1 = new MavselVertex("Foro de un curso", MavselVertex.IS_FORUM, "1");
        MavselVertex v2 = new MavselVertex("alumno", MavselVertex.IS_USER, "2");
        MavselVertex v3 = new MavselVertex("Otro foro", MavselVertex.IS_FORUM, "3");
        MavselVertex v4 = new MavselVertex("Otro alumno", MavselVertex.IS_USER, "4");


        g.addVertex(v1);
        g.addVertex(v2);

        g.addEdge("Miedge", v2, v1, EdgeType.DIRECTED);

        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge("Miedge2", v4, v3, EdgeType.DIRECTED);

        Layout<MavselVertex, Edge> layout = new ISOMLayout(g);
        BasicVisualizationServer<MavselVertex, Edge> vv = new BasicVisualizationServer<MavselVertex, Edge>(layout);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());


        pajekWriter.save(g , fileName, vv.getRenderContext().getVertexLabelTransformer(), null);


        System.out.println("Grafo["+g.toString()+"]");


       } catch(Exception e){
           e.printStackTrace();
       }

   }*/

    
}
