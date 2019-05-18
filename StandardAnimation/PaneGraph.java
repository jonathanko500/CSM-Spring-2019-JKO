/**
 * Joseph Edradan
 *
 * This is a custom made Pane made for the animations and the graph etc...
 *
 */
package StandardAnimation;

import NotMine.FxMath;
import Standard.AdjacencyList;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class PaneGraph extends Pane {

    // Nodes and their position
    private Map<FXShapeWrapper, Point2D> nodeLocations = new HashMap<>();    // R² coordinates for each node

    // Nodes force vector relative to each Node on the nodeLocation
    private Map<FXShapeWrapper, Point2D> nodeTotalForce = new HashMap<>();

    // Gravity between nodes basically
    public static final double SPRING_FORCE = 1;            // force = SPRING_FORCE*Math.log(distance/SPRING_SCALE);

    // How big the spring is between each node (The length of spring or string that holds the nodes together)
    public static final double SPRING_SCALE = 100;

    // The push distance
    public static final double REPULSION_SCALE = 1000;      // repulsion distance = REPULSION_SCALE/distance²;

    // Speed of Animating movement of nodes
    public static final double ANIMATION_SPEED = 200;
    public static final double ANIMATION_SPEED_EDGE = 2;    // This speed can be ignored by the user, look inside of FXAnimationShapeEdge

    // Requires a FXAdjacencyList to draw anything
    private FXAdjacencyList fxAdjacencyList;

    // Simulation movement
    private boolean simulationActive = true;

    // The thing that runs the animation
    private AnimationTimer animationTimer;

    // FPS of the animation
    private double stepsPerFrame = 20;                      //simulation steps computed per rendered frame

    // Current dragged node does not have applied force
    private FXShapeWrapper currentDraggedNode = null;       // Node currently being dragged

    public PaneGraph(AdjacencyList adjacencyList) {

        this.fxAdjacencyList = new FXAdjacencyList(this, adjacencyList);

        // Order in which the shapes will be on the pane
        addFXEdgeToPane();
        addFXWrapperToPane();

        initMouseEvents();

    }

    public void runAnimation() {
        generateInitialSpawns();

        animationTimer = new AnimationTimer() {

            // This Method is called all the time. It's the main game loop basically
            @Override
            public void handle(long now) {
                if (simulationActive) {
                    for (int i = 0; i < stepsPerFrame; i++) {
                        simulateSingleStep(currentDraggedNode);
                    }
                }
                updateFXShapePositions();
            }
        };

        animationTimer.start();

//        fxAdjacencyList.createParallelTransitionChangeTimeBased();
        fxAdjacencyList.createParallelTransitionDFS();
        fxAdjacencyList.getParallelTransition().play();
    }

    ///////////////////////////

    // StackPane Circle and Text
    private void addFXWrapperToPane() {
        for (FXShapeWrapper fxShapeWrapper : fxAdjacencyList.getArrayListFXShapeWrapper()) {
            fxShapeWrapper.addToPaneGraph();
        }
    }

    // StackPane Line and Text
    private void addFXEdgeToPane() {
        for (FXShapeEdge fxShapeEdge : fxAdjacencyList.getArrayListFXShapeEdge()) {
            fxShapeEdge.addToPaneGraph();
        }
    }

    ///////////////////////////

    // Handles Drag, Click, and Release, Move.
    private void initMouseEvents() {
//        setOnMouseDragged(event -> {
//            if (currentDraggedNode != null) { // drag node
////                System.out.println(currentDraggedNode);
//                Point2D location = new Point2D(event.getX(), event.getY());
//                setNodeLocation(currentDraggedNode, location);
//            }
////            else {
////                shiftX = shiftXBuffer + (event.getX() - cursorPressedX);
////                shiftY = shiftYBuffer + (event.getY() - cursorPressedY);
////            }

//        });

//        setOnMousePressed(event -> {
//            currentDraggedNode = get(event.getX(), event.getY());
//            if (currentDraggedNode == null) {
//                cursorPressedX = event.getX();
//                cursorPressedY = event.getY();
//                shiftXBuffer = shiftX;
//                shiftYBuffer = shiftY;
//            }
//        });
//
//        // If you release, then stop dragging
//        setOnMouseReleased(event -> currentDraggedNode = null);
//
//        setOnMouseMoved(event -> {
//            tooltipNode = checkForMouseNodeCollision(event.getX(), event.getY());
//            if (tooltipNode != null) {
//                this.getScene().setCursor(Cursor.HAND);
//            } else {
//                this.getScene().setCursor(Cursor.DEFAULT);
//            }
//        });
//
//        setOnMouseClicked(event -> {
//            Vertex<V> node = checkForMouseNodeCollision(event.getX(), event.getY());
//            if (clickConsumer != null && node != null) {
//                clickConsumer.accept(node);
//            }
//        });
    }

    private void generateInitialSpawns() {
        for (FXShapeWrapper fxShapeWrapper : fxAdjacencyList.getArrayListFXShapeWrapper()) {

//            double widthHalf = this.getPrefWidth() / 2;
//            double heightHalf = this.getPrefHeight() / 2;

//            double locationX = (Math.random() * (((widthHalf + widthHalf / 10) - (widthHalf - widthHalf / 10)) + 1)) + widthHalf;
//            double locationY = (Math.random() * (((heightHalf + heightHalf / 10) - (heightHalf - heightHalf / 10)) + 1)) + heightHalf;

            double locationX = (Math.random() * ((this.getPrefWidth() - 0) + 1) + 0);
            double locationY = (Math.random() * ((this.getPrefHeight() - 0) + 1) + 0);

//            System.out.println(locationX);
//            System.out.println(locationY);
//            System.out.println();

            nodeLocations.put(fxShapeWrapper, new Point2D(locationX, locationY));
        }
    }

    // This method is spam called all the time, it is part of the handle method from the AnimationTimer()
    public void simulateSingleStep(FXShapeWrapper ignoreNode) {
        initForces();
        computeForces();
        applyForce(ignoreNode);
    }

    // This method calculates the initial nodeTotalForce vectors (math/physics definition)
    private void initForces() {
        // Lambda for getting the mapping of FXShapeWrapper, Point2D combination and making a similar mapping for FXShapeWrapper, Point2D combination
        nodeLocations.forEach((fxShapeWrapper, point2D) -> nodeTotalForce.put(fxShapeWrapper, new Point2D(0, 0)));
    }

    // This method is spam called all the time (2), it is part of the handle from the timer
    private void computeForces() {
        for (Map.Entry<FXShapeWrapper, Point2D> outerNode : nodeLocations.entrySet()) {
            for (Map.Entry<FXShapeWrapper, Point2D> innerNode : nodeLocations.entrySet()) {
                // If self then skip (if this wasn't here then you will get not a number)
                if (outerNode.getKey() == innerNode.getKey()) {
                    continue;
                }

                // Calculate force between 2 points in space
                Point2D repellingForce = FxMath.repellingForce(outerNode.getValue(), innerNode.getValue(), REPULSION_SCALE);

                // Get the force vector (math/physics vector) of the outer node
                Point2D outerNodeForce = nodeTotalForce.get(outerNode.getKey());

                // Check if nodes are connected
                if (fxAdjacencyList.getAdjacencyList().areWrappersConnected(outerNode.getKey().getWrapperActualNormal(), innerNode.getKey().getWrapperActualNormal())) {

                    int numberOfVertices = fxAdjacencyList.getAdjacencyList().getArrayListWrapperActual().size();

                    // Only nodes connected have an attraction
                    Point2D attractiveForce = FxMath.attractiveForce(outerNode.getValue(), innerNode.getValue(), numberOfVertices, SPRING_FORCE, SPRING_SCALE);

                    // This is repulsion and attraction vector (math/physics vector) between nodes connected (The attraction should cancel the attraction)
                    nodeTotalForce.replace(outerNode.getKey(), new Point2D(
                            outerNodeForce.getX() + attractiveForce.getX() + repellingForce.getX(),
                            outerNodeForce.getY() + attractiveForce.getY() + repellingForce.getY()
                    ));
                } else {

                    // This is the repulsion vector (math/physics vector) between all nodes if there is no connections between nodes
                    nodeTotalForce.replace(outerNode.getKey(), new Point2D(
                            outerNodeForce.getX() + repellingForce.getX(),
                            outerNodeForce.getY() + repellingForce.getY()
                    ));
                }
            }
        }
    }

    // This method applies the Force Vector from nodeTotalForce to the node's Point2D
    private void applyForce(FXShapeWrapper ignoreNode) {
        Set<Map.Entry<FXShapeWrapper, Point2D>> entries = nodeLocations.entrySet();
        for (Map.Entry<FXShapeWrapper, Point2D> node : entries) {
            FXShapeWrapper currentNode = node.getKey();

            // If node is being dragged then skip physics
            if (currentNode == ignoreNode) {
                continue;
            }

            // Get the Point2D position of FXShapeWrapper
            Point2D point = node.getValue();

            // Get the Point2D force vector of FXShapeWrapper
            Point2D forceVector = nodeTotalForce.get(currentNode);

            double positionX = point.getX() + ANIMATION_SPEED * forceVector.getX();
            double positionY = point.getY() + ANIMATION_SPEED * forceVector.getY();

            double radius = node.getKey().getCircle().getRadius();
            double offset = node.getKey().getCircle().getRadius();

            // Handle border collision by changing the node position
            if (positionX < 0 + radius + offset) {
                positionX = 0 + radius + offset;
            }
            if (positionX > this.getWidth() - (radius + offset)) {
                positionX = this.getWidth() - (radius + offset);
            }
            if (positionY < 0 + radius + offset) {
                positionY = 0 + radius + offset;
            }
            if (positionY > this.getHeight() - (radius + offset)) {
                positionY = this.getHeight() - (radius + offset);
            }

            Point2D point2D = new Point2D(positionX, positionY);

            if (Double.isNaN(positionX) || Double.isNaN(positionY)) {
                generateInitialSpawns();
                System.out.println("Animation can't run properly, try getting a larger window resolution!");
                break;
            }
            node.setValue(point2D);
//            System.out.println(node.getKey().getPoint2D());
        }
    }

    public void updateFXShapePositions() {
        updateFXShapeWrapperPosition();
        updateFXShapeEdge();
    }


    private void updateFXShapeWrapperPosition() {
        // Loop through nodeLocations to get the key
        for (FXShapeWrapper fxShapeWrapper : nodeLocations.keySet()) {

            // For fxShapeWrapper, get the Point2D within the nodeLocations given a fxShapeWrapper
            Point2D point2D = nodeLocations.get(fxShapeWrapper);

            // Replace the fxShapeWrapper Point2D with the one from nodeLocations
            fxShapeWrapper.setPoint2D(point2D);

        }
    }

    private void updateFXShapeEdge() {
        // Loop through fxAdjacencyList.getArrayListFXShapeEdge()
        for (FXShapeEdge fxShapeEdge : fxAdjacencyList.getArrayListFXShapeEdge()) {

            // Update the fxShapeEdge Point2D points
            fxShapeEdge.updateEdge();
        }
    }

    public void setNodeLocation(FXShapeWrapper node, Point2D location) {
        nodeLocations.replace(node, location);
    }

    public void setCurrentDraggedNode(FXShapeWrapper fxShapeWrapper) {
        currentDraggedNode = fxShapeWrapper;
    }

    public FXAdjacencyList getFxAdjacencyList() {
        return fxAdjacencyList;
    }

}
