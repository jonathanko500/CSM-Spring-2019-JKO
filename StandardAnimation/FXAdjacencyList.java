/**
 * @author Joseph Edradan
 * <p>
 * The FXAdjacencyList of a given AdjacencyList.
 * This file is for graphics and stuff...
 */

package StandardAnimation;

import Standard.AdjacencyList;
import Standard.Edge;
import Standard.WrapperActual;
import Standard.WrapperPseudo;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Map;

class FXAdjacencyList {

    // Animation time stuff
    private EdgeAnimationDataContainer edgeAnimationDataContainerLongest;

    private double edgeAnimationDataContainerLongestAnimationTime = 0; // This is temporary so just use edgeAnimationDataContainerLongest instead

    private double timeOfEntireAnimation;

    // First Backward Pass
    private EdgeAnimationDataContainer edgeAnimationDataContainerBackwardPassFirst; // Should be the same as edgeAnimationDataContainerForwardPassLast

    private double timeUntilBackwardPassFirst = Double.MAX_VALUE;

    // Last Forward Pass
    private EdgeAnimationDataContainer edgeAnimationDataContainerForwardPassLast; // Should be the same as edgeAnimationDataContainerBackwardPassFirst

    private double timeUntilForwardPassLast = 0;

    // sdfsdfsdfsdf
    private PaneGraph paneGraph;

    private AdjacencyList adjacencyList;

    private ArrayList<FXShapeWrapper> arrayListFXShapeWrapper = new ArrayList<>();

    private ArrayList<FXShapeEdge> arrayListFXShapeEdge = new ArrayList<>();

    private ParallelTransition parallelTransition = new ParallelTransition();

    private ArrayList<FXAnimationShapeEdge> arrayListFXAnimationShapeEdge = new ArrayList<>();

    private Map<Edge, EdgeAnimationDataContainer> hashMapEdgeAnimationDataContainer;


    public FXAdjacencyList(PaneGraph paneGraph, AdjacencyList adjacencyList) {
        this.paneGraph = paneGraph;
        this.adjacencyList = adjacencyList;

        // Get the EdgeAnimationDataContainers from the AdjacencyLists
        getHashMapEdgeAnimationDataContainer();

        // Get animation times to do specific animation things
        getAnimationTimes();

        // FX Shape Wrapper
        createFXShapeWrapper();

        // FX Shape Edge
        createFXShapeEdge();

        // FX Animation for each FX Shape Edge
        createArrayListFXAnimationShapeEdge();
    }

    private void getHashMapEdgeAnimationDataContainer() {
        hashMapEdgeAnimationDataContainer = adjacencyList.getHashMapEdgeAnimationDataContainer();
    }

    private void getAnimationTimes() {
        for (EdgeAnimationDataContainer edgeAnimationDataContainer : hashMapEdgeAnimationDataContainer.values()) {
            findEdgeAnimationDataContainerLongest(edgeAnimationDataContainer);
            findEdgeAnimationDataContainerBackwardPassFirst(edgeAnimationDataContainer);
            findEdgeAnimationDataContainerForwardPassLast(edgeAnimationDataContainer);
        }

        // For calculating the time until clearUnmarkedAnimatedLines() is called
        double timePauseBeforeAnimationBackward = edgeAnimationDataContainerLongest.getJavaFXTimePauseBeforeAnimationBackward();
        double durationLengthOfAnimation = edgeAnimationDataContainerLongest.getJavaFXDurationLengthOfAnimation();
        timeOfEntireAnimation = timePauseBeforeAnimationBackward + durationLengthOfAnimation;

    }


    // TODO: FIND ALTERNATIVE THAN USING A FOR LOOP
    private PauseTransition getPauseTransitionUntilFirstBackwardPassAnimation() {
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(timeUntilBackwardPassFirst));
        pauseTransition.setOnFinished(e -> clearUnmarkedAnimatedLines());

        pauseTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                for (FXShapeWrapper fxShapeWrapper : arrayListFXShapeWrapper) {
                    fxShapeWrapper.getPaneFXShapeWrapperInformation().setTextChangeTimeBackward(adjacencyList.getWrapperActual(adjacencyList.getArrayListWrapperActual().size() - 1).getChangeTime());

                }
            }
        });

        return pauseTransition;
    }

    // Basically get the duration of the entire animation
    private void findEdgeAnimationDataContainerLongest(EdgeAnimationDataContainer edgeAnimationDataContainer) {
//        System.out.println("findEdgeAnimationDataContainerLongest " +edgeAnimationDataContainer);
        if (edgeAnimationDataContainer.getJavaFXTimePauseBeforeAnimationBackward() > edgeAnimationDataContainerLongestAnimationTime) {
            edgeAnimationDataContainerLongest = edgeAnimationDataContainer;
            edgeAnimationDataContainerLongestAnimationTime = edgeAnimationDataContainer.getJavaFXTimePauseBeforeAnimationBackward();
//            System.out.println(edgeAnimationDataContainerLongest);
        }
    }

    private void findEdgeAnimationDataContainerBackwardPassFirst(EdgeAnimationDataContainer edgeAnimationDataContainer) {
        if (edgeAnimationDataContainer.getJavaFXTimePauseBeforeAnimationBackward() < timeUntilBackwardPassFirst) {
            // EdgeAnimationDataContainer that is first in the Backward pass
            edgeAnimationDataContainerBackwardPassFirst = edgeAnimationDataContainer;
            timeUntilBackwardPassFirst = edgeAnimationDataContainer.getJavaFXTimePauseBeforeAnimationBackward();
//            System.out.println(edgeAnimationDataContainerBackwardPassFirst);
        }
    }

    private void findEdgeAnimationDataContainerForwardPassLast(EdgeAnimationDataContainer edgeAnimationDataContainer) {
        if (edgeAnimationDataContainer.getJavaFXTimePauseBeforeAnimationForward() > timeUntilForwardPassLast) {
            edgeAnimationDataContainerForwardPassLast = edgeAnimationDataContainer;
            timeUntilForwardPassLast = edgeAnimationDataContainer.getJavaFXTimePauseBeforeAnimationForward();
//            System.out.println(edgeAnimationDataContainerForwardPassLast);
        }
    }

    private void createFXShapeWrapper() {
        for (int i = 0; i < adjacencyList.getArrayListWrapperActual().size(); i++) {

            WrapperActual wrapperActualNormal = adjacencyList.getWrapperActual(i);
            WrapperActual wrapperActualInverse = adjacencyList.getAdjacencyListInverse().getWrapperActual(i);

            FXShapeWrapper fxShapeWrapper = new FXShapeWrapper(paneGraph, wrapperActualNormal, wrapperActualInverse);

            // Don't uncomment because this will just replace the changeTime Text with the actual changeTime it has.
//            fxShapeWrapper.getPaneFXShapeWrapperInformation().setTextChangeTimeForward(wrapperActualNormal.getChangeTime());
//            fxShapeWrapper.getPaneFXShapeWrapperInformation().setTextChangeTimeBackward(adjacencyList.getWrapperActual(adjacencyList.getArrayListWrapperActual().size() - 1).getChangeTime());

            if (i == 0) {
                fxShapeWrapper.getCircle().setFill(Color.ORANGERED);
            }
            if (i == adjacencyList.getArrayListWrapperActual().size() - 1) {
                fxShapeWrapper.getCircle().setFill(Color.LIGHTBLUE);
            }

            arrayListFXShapeWrapper.add(fxShapeWrapper);
        }
    }

    private void createFXShapeEdge() {
        for (int i = 0; i < arrayListFXShapeWrapper.size(); i++) {
            FXShapeWrapper fxShapeWrapperActualParent = arrayListFXShapeWrapper.get(i);

            WrapperActual wrapperActualParent = fxShapeWrapperActualParent.getWrapperActualNormal();

            for (int j = 0; j < wrapperActualParent.getArrayListWrapperPseudo().size(); j++) {

                WrapperPseudo wrapperPseudo = wrapperActualParent.getArrayListWrapperPseudo().get(j);

                Edge edge = wrapperPseudo.getEdge();

                int wrapperPseudoVertexIndex = wrapperPseudo.getVertex().getIndex();

                FXShapeWrapper fxShapeWrapperActualChild = arrayListFXShapeWrapper.get(wrapperPseudoVertexIndex);

                EdgeAnimationDataContainer edgeAnimationDataContainer = adjacencyList.getHashMapEdgeAnimationDataContainer().get(edge);

                // Give the paneGraph
                // Give FXShapeEdge fxShapeWrapperActualParent
                // Give FXShapeEdge the fxShapeWrapperActualChild because wrapperPseudo is a fake
                // Give FXShapeEdge the wrapperPseudo because it had valuable information inside it
                FXShapeEdge fxShapeEdge = new FXShapeEdge(paneGraph, fxShapeWrapperActualParent, fxShapeWrapperActualChild, edgeAnimationDataContainer);

                arrayListFXShapeEdge.add(fxShapeEdge);
            }
        }
    }

    public AdjacencyList getAdjacencyList() {
        return adjacencyList;
    }

    public ArrayList<FXShapeWrapper> getArrayListFXShapeWrapper() {
        return arrayListFXShapeWrapper;
    }

    public ArrayList<FXShapeEdge> getArrayListFXShapeEdge() {
        return arrayListFXShapeEdge;
    }

    public FXShapeWrapper getFXShapeWrapper(int index) {
        return arrayListFXShapeWrapper.get(index);
    }

    public FXShapeEdge getFXShapeEdge(int index) {
        return arrayListFXShapeEdge.get(index);
    }

    private void createArrayListFXAnimationShapeEdge() {
        for (FXShapeEdge fxShapeEdge : arrayListFXShapeEdge) {
            arrayListFXAnimationShapeEdge.add(fxShapeEdge.getFXAnimationShapeEdgeForward());
            arrayListFXAnimationShapeEdge.add(fxShapeEdge.getFXAnimationShapeEdgeBackward());
        }
    }

    public void clearUnmarkedAnimatedLines() {
        for (FXAnimationShapeEdge fxAnimationShapeEdge : arrayListFXAnimationShapeEdge) {
            if (!fxAnimationShapeEdge.isMarked()) {
                fxAnimationShapeEdge.getLineToBeAnimated().setStrokeWidth(0);
            }
        }
    }

    public void clearAnimatedLines() {
        for (FXAnimationShapeEdge fxAnimationShapeEdge : arrayListFXAnimationShapeEdge) {
            fxAnimationShapeEdge.getLineToBeAnimated().setStrokeWidth(0);
        }
    }

    public void createParallelTransitionDFS() {
        parallelTransition = new ParallelTransition();

        for (FXAnimationShapeEdge fxAnimationShapeEdge : arrayListFXAnimationShapeEdge) {
            parallelTransition.getChildren().add(fxAnimationShapeEdge.getSequentialTransitionDFS());
        }

//        System.out.println(arrayListFXShapeEdge);

        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(timeOfEntireAnimation));
        pauseTransition.setOnFinished(e -> clearUnmarkedAnimatedLines());

        parallelTransition.getChildren().add(pauseTransition);
        parallelTransition.getChildren().add(getPauseTransitionUntilFirstBackwardPassAnimation());

    }

    // TODO: DON'T USE ME UNTIL I AM FIXED, WHICH I WAS, BUT NOW I'M NOT!!!
    public void createParallelTransitionChangeTimeBased() {
        parallelTransition = new ParallelTransition();

        for (FXAnimationShapeEdge fxAnimationShapeEdge : arrayListFXAnimationShapeEdge) {
            parallelTransition.getChildren().add(fxAnimationShapeEdge.getSequentialTransitionChangeTimeBased());
        }

        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(timeOfEntireAnimation));
        pauseTransition.setOnFinished(e -> clearAnimatedLines());

        parallelTransition.getChildren().add(pauseTransition);
        parallelTransition.getChildren().add(getPauseTransitionUntilFirstBackwardPassAnimation());

    }

    public EdgeAnimationDataContainer getEdgeAnimationDataContainerLongest() {
        return edgeAnimationDataContainerLongest;
    }

    public EdgeAnimationDataContainer getEdgeAnimationDataContainerForwardPassLast() {
        return edgeAnimationDataContainerForwardPassLast;
    }

    public EdgeAnimationDataContainer getEdgeAnimationDataContainerBackwardPassFirst() {
        return edgeAnimationDataContainerBackwardPassFirst;
    }

    public ParallelTransition getParallelTransition() {
        return parallelTransition;
    }
}
