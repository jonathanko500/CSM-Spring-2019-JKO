/**
 * Joseph Edradan
 * <p>
 * This file is the FX version of an Edge
 */

package StandardAnimation;

class FXShapeEdge extends FXShape {

    private Arrow arrow;

    private PaneGraph paneGraph;

    private FXShapeWrapper fxShapeWrapperParent;

    private FXShapeWrapper fxShapeWrapperChild;

    private EdgeAnimationDataContainer edgeAnimationDataContainer;

    private FXAnimationShapeEdge fxAnimationShapeEdgeForward;

    private FXAnimationShapeEdge fxAnimationShapeEdgeBackward;


    public FXShapeEdge(PaneGraph paneGraph, FXShapeWrapper fxShapeWrapperParent, FXShapeWrapper fxShapeWrapperChild, EdgeAnimationDataContainer edgeAnimationDataContainer) {
        this.paneGraph = paneGraph;

        this.fxShapeWrapperParent = fxShapeWrapperParent;
        this.fxShapeWrapperChild = fxShapeWrapperChild;

        this.edgeAnimationDataContainer = edgeAnimationDataContainer;

        arrow = new Arrow(edgeAnimationDataContainer);

        fxAnimationShapeEdgeForward = new FXAnimationShapeEdge(this, false);
        fxAnimationShapeEdgeBackward = new FXAnimationShapeEdge(this, true);

    }

    // Update the Starting and Ending position of the lineConnecting
    public void updateEdge() {

        arrow.updateArrow(fxShapeWrapperParent.getPoint2D(), fxShapeWrapperChild.getPoint2D());

        // Update FXAnimationShapeEdge animation position
        fxAnimationShapeEdgeForward.updatePoint2D();
        fxAnimationShapeEdgeBackward.updatePoint2D();
    }

    public FXShapeWrapper getFXShapeWrapperParent() {
        return fxShapeWrapperParent;
    }

    public FXShapeWrapper getFXShapeWrapperChild() {
        return fxShapeWrapperChild;
    }

    public EdgeAnimationDataContainer getEdgeAnimationDataContainer() {
        return edgeAnimationDataContainer;
    }

    public FXAnimationShapeEdge getFXAnimationShapeEdgeForward() {
        return fxAnimationShapeEdgeForward;
    }

    public FXAnimationShapeEdge getFXAnimationShapeEdgeBackward() {
        return fxAnimationShapeEdgeBackward;
    }

    public PaneGraph getPaneGraph() {
        return paneGraph;
    }

    @Override
    public void addToPaneGraph() {
        paneGraph.getChildren().add(arrow.getGroupArrowLines());

        paneGraph.getChildren().add(fxAnimationShapeEdgeForward.getLineToBeAnimated());
        paneGraph.getChildren().add(fxAnimationShapeEdgeBackward.getLineToBeAnimated());

        paneGraph.getChildren().add(arrow.getGroupArrowLinesText());

    }

    @Override
    public String toString() {
        String string = String.format("%s %s %s", fxShapeWrapperParent, fxShapeWrapperChild, edgeAnimationDataContainer.getWrapperPseudo().getEdge());
        return string;
    }
}
