/**
 * Joseph Edradan
 * <p>
 * This file runes the Animation
 */

package StandardAnimation;

import Standard.AdjacencyList;
import Standard.Vertex;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXGraph extends Application {

    private static final int PANE_WIDTH = 1600;

    private static final int PANE_HEIGHT = 1000;

    private Parent createStage(AdjacencyList adjacencyList) {
        PaneGraph paneRoot = new PaneGraph(adjacencyList);

        paneRoot.setPrefSize(PANE_WIDTH, PANE_HEIGHT);
        paneRoot.runAnimation();

        return paneRoot;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        AdjacencyList adjacencyList = new AdjacencyList();

        // Test 1
//        adjacencyList.addVertexToArrayList(new Vertex(0, "Event 0"));
//        adjacencyList.addVertexToArrayList(new Vertex(1, "Event 1"));
//        adjacencyList.addVertexToArrayList(new Vertex(2, "Event 2"));
//        adjacencyList.addVertexToArrayList(new Vertex(3, "Event 3"));
//        adjacencyList.addVertexToArrayList(new Vertex(4, "Event 4"));
//        adjacencyList.addVertexToArrayList(new Vertex(5, "Event 5"));
//        adjacencyList.addVertexToArrayList(new Vertex(6, "Event 6"));
//        adjacencyList.addVertexToArrayList(new Vertex(7, "Event 7"));
//        adjacencyList.addVertexToArrayList(new Vertex(8, "Event 8"));
//
//        adjacencyList.addToArrayListWrapperActual(0, 1, 6);
//        adjacencyList.addToArrayListWrapperActual(0, 2, 4);
//        adjacencyList.addToArrayListWrapperActual(0, 3, 5);
//        adjacencyList.addToArrayListWrapperActual(1, 4, 1);
//        adjacencyList.addToArrayListWrapperActual(2, 4, 1);
//        adjacencyList.addToArrayListWrapperActual(3, 5, 2);
//        adjacencyList.addToArrayListWrapperActual(4, 6, 9);
//        adjacencyList.addToArrayListWrapperActual(4, 7, 7);
//        adjacencyList.addToArrayListWrapperActual(5, 7, 4);
//        adjacencyList.addToArrayListWrapperActual(6, 8, 2);
//        adjacencyList.addToArrayListWrapperActual(7, 8, 4);

        // Test 2
//        adjacencyList.addVertexToArrayList(new Vertex(0, "Event 0"));
//        adjacencyList.addVertexToArrayList(new Vertex(1, "Event 1"));
//        adjacencyList.addVertexToArrayList(new Vertex(2, "Event 2"));
//        adjacencyList.addVertexToArrayList(new Vertex(3, "Event 3"));
//        adjacencyList.addVertexToArrayList(new Vertex(4, "Event 4"));
//        adjacencyList.addVertexToArrayList(new Vertex(5, "Event 5"));
//        adjacencyList.addVertexToArrayList(new Vertex(6, "Event 6"));
//        adjacencyList.addVertexToArrayList(new Vertex(7, "Event 7"));
//        adjacencyList.addVertexToArrayList(new Vertex(8, "Event 8"));
//        adjacencyList.addVertexToArrayList(new Vertex(9, "Event 8"));
//        adjacencyList.addVertexToArrayList(new Vertex(10, "Event 10"));
//        adjacencyList.addVertexToArrayList(new Vertex(11, "Event 11"));
//
//        adjacencyList.addToArrayListWrapperActual(0, 1, 6);
//        adjacencyList.addToArrayListWrapperActual(0, 2, 4);
//        adjacencyList.addToArrayListWrapperActual(0, 3, 5);
//        adjacencyList.addToArrayListWrapperActual(1, 4, 1);
//        adjacencyList.addToArrayListWrapperActual(2, 4, 1);
//        adjacencyList.addToArrayListWrapperActual(3, 5, 2);
//        adjacencyList.addToArrayListWrapperActual(4, 6, 9);
//        adjacencyList.addToArrayListWrapperActual(4, 7, 7);
//        adjacencyList.addToArrayListWrapperActual(5, 7, 4);
//        adjacencyList.addToArrayListWrapperActual(6, 8, 2);
//        adjacencyList.addToArrayListWrapperActual(7, 8, 4);
//        adjacencyList.addToArrayListWrapperActual(8, 9, 1);
//        adjacencyList.addToArrayListWrapperActual(8, 10, 1);
//        adjacencyList.addToArrayListWrapperActual(9, 11, 1);
//        adjacencyList.addToArrayListWrapperActual(10, 11, 1);

        // Test 3
//        adjacencyList.addVertexToArrayList(new Vertex(0, "Event 0"));
//        adjacencyList.addVertexToArrayList(new Vertex(1, "Event 1"));
//        adjacencyList.addVertexToArrayList(new Vertex(2, "Event 2"));
//        adjacencyList.addVertexToArrayList(new Vertex(3, "Event 3"));
//
//        adjacencyList.addToArrayListWrapperActual(0, 1, 1);
//        adjacencyList.addToArrayListWrapperActual(1, 2, 1);
//        adjacencyList.addToArrayListWrapperActual(2, 3, 1);
//        adjacencyList.addToArrayListWrapperActual(3, 0, 1);

        // Test 4
//        adjacencyList.addVertexToArrayList(new Vertex(0, "Event 0"));
//        adjacencyList.addVertexToArrayList(new Vertex(1, "Event 1"));
//        adjacencyList.addVertexToArrayList(new Vertex(2, "Event 2"));
//        adjacencyList.addVertexToArrayList(new Vertex(3, "Event 3"));
//        adjacencyList.addVertexToArrayList(new Vertex(4, "Event 4"));
//
//        adjacencyList.addToArrayListWrapperActual(0, 1, 6);
//        adjacencyList.addToArrayListWrapperActual(0, 2, 5);
//        adjacencyList.addToArrayListWrapperActual(1, 4, 8);
//        adjacencyList.addToArrayListWrapperActual(2, 3, 5);
//        adjacencyList.addToArrayListWrapperActual(1, 3, 5);
//        adjacencyList.addToArrayListWrapperActual(3, 4, 2);

        // Test Custom Big
        adjacencyList.addVertexToArrayList(new Vertex(0, "Event 0"));
        adjacencyList.addVertexToArrayList(new Vertex(1, "Event 1"));
        adjacencyList.addVertexToArrayList(new Vertex(2, "Event 2"));
        adjacencyList.addVertexToArrayList(new Vertex(3, "Event 3"));
        adjacencyList.addVertexToArrayList(new Vertex(4, "Event 4"));
        adjacencyList.addVertexToArrayList(new Vertex(5, "Event 5"));
        adjacencyList.addVertexToArrayList(new Vertex(6, "Event 6"));
        adjacencyList.addVertexToArrayList(new Vertex(7, "Event 7"));
        adjacencyList.addVertexToArrayList(new Vertex(8, "Event 8"));
        adjacencyList.addVertexToArrayList(new Vertex(9, "Event 9"));
        adjacencyList.addVertexToArrayList(new Vertex(10, "Event 10"));
        adjacencyList.addVertexToArrayList(new Vertex(11, "Event 11"));
        adjacencyList.addVertexToArrayList(new Vertex(12, "Event 12"));
        adjacencyList.addVertexToArrayList(new Vertex(13, "Event 13"));
        adjacencyList.addVertexToArrayList(new Vertex(14, "Event 14"));
        adjacencyList.addVertexToArrayList(new Vertex(15, "Event 15"));
        adjacencyList.addVertexToArrayList(new Vertex(16, "Event 16"));
        adjacencyList.addVertexToArrayList(new Vertex(17, "Event 17"));
        adjacencyList.addVertexToArrayList(new Vertex(18, "Event 18"));
        adjacencyList.addVertexToArrayList(new Vertex(19, "Event 19"));
        adjacencyList.addVertexToArrayList(new Vertex(20, "Event 20"));
        adjacencyList.addVertexToArrayList(new Vertex(21, "Event 21"));
        adjacencyList.addVertexToArrayList(new Vertex(22, "Event 22"));
        adjacencyList.addVertexToArrayList(new Vertex(23, "Event 23"));
        adjacencyList.addVertexToArrayList(new Vertex(24, "Event 24"));
        adjacencyList.addVertexToArrayList(new Vertex(25, "Event 25"));
        adjacencyList.addVertexToArrayList(new Vertex(26, "Event 26"));
        adjacencyList.addVertexToArrayList(new Vertex(27, "Event 27"));
        adjacencyList.addVertexToArrayList(new Vertex(28, "Event 28"));

        adjacencyList.addToArrayListWrapperActual(0, 1, 6);
        adjacencyList.addToArrayListWrapperActual(0, 2, 14);
        adjacencyList.addToArrayListWrapperActual(0, 3, 5);
        adjacencyList.addToArrayListWrapperActual(1, 4, 1);
        adjacencyList.addToArrayListWrapperActual(2, 11, 50);
        adjacencyList.addToArrayListWrapperActual(3, 5, 2);
        adjacencyList.addToArrayListWrapperActual(4, 6, 9);
        adjacencyList.addToArrayListWrapperActual(4, 7, 7);
        adjacencyList.addToArrayListWrapperActual(5, 7, 4);
        adjacencyList.addToArrayListWrapperActual(6, 8, 6);
        adjacencyList.addToArrayListWrapperActual(7, 8, 4);
        adjacencyList.addToArrayListWrapperActual(8, 9, 1);
        adjacencyList.addToArrayListWrapperActual(8, 10, 1);
        adjacencyList.addToArrayListWrapperActual(9, 11, 3);
        adjacencyList.addToArrayListWrapperActual(10, 11, 4);
        adjacencyList.addToArrayListWrapperActual(11, 12, 7);
        adjacencyList.addToArrayListWrapperActual(12, 13, 2);
        adjacencyList.addToArrayListWrapperActual(12, 14, 3);
        adjacencyList.addToArrayListWrapperActual(13, 14, 5);
        adjacencyList.addToArrayListWrapperActual(14, 15, 7);
        adjacencyList.addToArrayListWrapperActual(15, 16, 3);
        adjacencyList.addToArrayListWrapperActual(15, 17, 2);
        adjacencyList.addToArrayListWrapperActual(16, 18, 7);
        adjacencyList.addToArrayListWrapperActual(17, 18, 4);
        adjacencyList.addToArrayListWrapperActual(2, 6, 60);
        adjacencyList.addToArrayListWrapperActual(9, 12, 10);
        adjacencyList.addToArrayListWrapperActual(6, 10, 2);
        adjacencyList.addToArrayListWrapperActual(1, 6, 20);
        adjacencyList.addToArrayListWrapperActual(9, 16, 4);
        adjacencyList.addToArrayListWrapperActual(11, 13, 10);
        adjacencyList.addToArrayListWrapperActual(18, 19, 23);
        adjacencyList.addToArrayListWrapperActual(19, 22, 4);
        adjacencyList.addToArrayListWrapperActual(19, 20, 4);
        adjacencyList.addToArrayListWrapperActual(19, 21, 4);
        adjacencyList.addToArrayListWrapperActual(20, 22, 4);
        adjacencyList.addToArrayListWrapperActual(21, 22, 4);
        adjacencyList.addToArrayListWrapperActual(20, 21, 4);
        adjacencyList.addToArrayListWrapperActual(9, 21, 1);
        adjacencyList.addToArrayListWrapperActual(8, 22, 1);
        adjacencyList.addToArrayListWrapperActual(5, 22, 5);
        adjacencyList.addToArrayListWrapperActual(1, 3, 5);
        adjacencyList.addToArrayListWrapperActual(21, 22, 15);
        adjacencyList.addToArrayListWrapperActual(22, 23, 20);
        adjacencyList.addToArrayListWrapperActual(23, 24, 30);
        adjacencyList.addToArrayListWrapperActual(23, 25, 40);
        adjacencyList.addToArrayListWrapperActual(25, 26, 12);
        adjacencyList.addToArrayListWrapperActual(24, 26, 12);
        adjacencyList.addToArrayListWrapperActual(5, 25, 100);
        adjacencyList.addToArrayListWrapperActual(3, 26, 200);
        adjacencyList.addToArrayListWrapperActual(4, 5, 5);
        adjacencyList.addToArrayListWrapperActual(26, 27, 25);
        adjacencyList.addToArrayListWrapperActual(27, 28, 40);
        adjacencyList.addToArrayListWrapperActual(0, 28, 300);
        adjacencyList.addToArrayListWrapperActual(9, 18, 20);
        adjacencyList.addToArrayListWrapperActual(9, 15, 25);
        adjacencyList.addToArrayListWrapperActual(5, 23, 120);
        adjacencyList.addToArrayListWrapperActual(18, 21, 13);
        adjacencyList.addToArrayListWrapperActual(3, 27, 233);
        adjacencyList.addToArrayListWrapperActual(8, 21, 33);


        // Test School
//        adjacencyList.addVertexToArrayList(new Vertex(0, "Start"));
//        adjacencyList.addVertexToArrayList(new Vertex(1, "English 100"));
//        adjacencyList.addVertexToArrayList(new Vertex(2, "English 110"));
//        adjacencyList.addVertexToArrayList(new Vertex(3, "English 168"));
//        adjacencyList.addVertexToArrayList(new Vertex(4, "Math 100"));
//        adjacencyList.addVertexToArrayList(new Vertex(5, "Math 200"));
//        adjacencyList.addVertexToArrayList(new Vertex(6, "Math 250"));
//        adjacencyList.addVertexToArrayList(new Vertex(7, "Math 260"));
//        adjacencyList.addVertexToArrayList(new Vertex(8, "Math 270"));
//        adjacencyList.addVertexToArrayList(new Vertex(9, "Math 275"));
//        adjacencyList.addVertexToArrayList(new Vertex(10, "Math 280"));
//        adjacencyList.addVertexToArrayList(new Vertex(11, "Physics 250"));
//        adjacencyList.addVertexToArrayList(new Vertex(12, "Physics 260"));
//        adjacencyList.addVertexToArrayList(new Vertex(13, "Physics 270"));
//        adjacencyList.addVertexToArrayList(new Vertex(14, "Music 100"));
//        adjacencyList.addVertexToArrayList(new Vertex(15, "Music 200"));
//        adjacencyList.addVertexToArrayList(new Vertex(16, "Music 300"));
//        adjacencyList.addVertexToArrayList(new Vertex(17, "History 100"));
//        adjacencyList.addVertexToArrayList(new Vertex(18, "History 110"));
//        adjacencyList.addVertexToArrayList(new Vertex(19, "Art 100"));
//        adjacencyList.addVertexToArrayList(new Vertex(20, "Art 200"));
//        adjacencyList.addVertexToArrayList(new Vertex(21, "End"));
//
//        adjacencyList.addToArrayListWrapperActual(0, 1, 1);
//        adjacencyList.addToArrayListWrapperActual(1, 2, 1);
//        adjacencyList.addToArrayListWrapperActual(2, 3, 1);
//        adjacencyList.addToArrayListWrapperActual(3, 21, 1);
//        adjacencyList.addToArrayListWrapperActual(0, 4, 1);
//        adjacencyList.addToArrayListWrapperActual(4, 5, 1);
//        adjacencyList.addToArrayListWrapperActual(5, 6, 1);
//        adjacencyList.addToArrayListWrapperActual(6, 7, 1);
//        adjacencyList.addToArrayListWrapperActual(7, 8, 1);
//        adjacencyList.addToArrayListWrapperActual(8, 9, 1);
//        adjacencyList.addToArrayListWrapperActual(8, 10, 1);
//        adjacencyList.addToArrayListWrapperActual(9, 21, 1);
//        adjacencyList.addToArrayListWrapperActual(9, 10, 1);
//        adjacencyList.addToArrayListWrapperActual(10, 21, 1);
//        adjacencyList.addToArrayListWrapperActual(0, 11, 1);
//        adjacencyList.addToArrayListWrapperActual(11, 12, 1);
//        adjacencyList.addToArrayListWrapperActual(12, 13, 1);
//        adjacencyList.addToArrayListWrapperActual(13, 21, 1);
//        adjacencyList.addToArrayListWrapperActual(0, 14, 1);
//        adjacencyList.addToArrayListWrapperActual(14, 15, 1);
//        adjacencyList.addToArrayListWrapperActual(15, 16, 1);
//        adjacencyList.addToArrayListWrapperActual(16, 21, 1);
//        adjacencyList.addToArrayListWrapperActual(0, 17, 1);
//        adjacencyList.addToArrayListWrapperActual(17, 18, 1);
//        adjacencyList.addToArrayListWrapperActual(18, 21, 1);
//        adjacencyList.addToArrayListWrapperActual(0, 19, 1);
//        adjacencyList.addToArrayListWrapperActual(19, 20, 1);
//        adjacencyList.addToArrayListWrapperActual(20, 21, 1);


        adjacencyList.runDFS();

        ///////////////

        Scene primaryScene = new Scene(createStage(adjacencyList));
        primaryStage.setScene(primaryScene);
//        primaryStage.setX(1000);
//        primaryStage.setY(1000);
        primaryStage.show();


    }
}

