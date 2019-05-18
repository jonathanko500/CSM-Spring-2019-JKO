/**
 * Joseph Edradan
 * <p>
 * This file is the FX version of a WrapperActual
 */

package StandardAnimation;

import Standard.WrapperActual;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;


class FXShapeWrapper extends FXShape {

    protected double radius = 30;

    private PaneGraph paneGraph;

    private Circle circle;

    private PaneFXShapeWrapperInformation paneFXShapeWrapperInformation;

    protected WrapperActual wrapperActualNormal;

    protected WrapperActual wrapperActualInverse;

    private ArrayList<FXShapeEdge> arrayListFXEdges = new ArrayList();

    private Point2D point2D;

    public FXShapeWrapper(PaneGraph paneGraph, WrapperActual wrapperActual, WrapperActual wrapperActualInverse) {
        this(paneGraph, wrapperActual, wrapperActualInverse, 30);
    }

    public FXShapeWrapper(PaneGraph paneGraph, WrapperActual wrapperActualNormal, WrapperActual wrapperActualInverse, double radius) {
        this.paneGraph = paneGraph;
        this.wrapperActualNormal = wrapperActualNormal;
        this.wrapperActualInverse = wrapperActualInverse;

        this.radius = radius;
        circle = new Circle(radius);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Do not change the Layout, it will effect mouse drag cursor relative to the StackPane
//        stackPane.setLayoutX(0);
//        stackPane.setLayoutY(0);

        stackPane.setOnMouseDragged(eventHandlerMouseDragged());
        stackPane.setOnMouseReleased(eventHandlerMouseReleased());

        paneFXShapeWrapperInformation = new PaneFXShapeWrapperInformation(this);

        paneFXShapeWrapperInformation.setTextCountForward(wrapperActualInverse.getArrayListWrapperPseudo().size());
        paneFXShapeWrapperInformation.setTextCountBackward(wrapperActualNormal.getArrayListWrapperPseudo().size());

        stackPane.getChildren().addAll(circle, paneFXShapeWrapperInformation);

    }

    // When Node is released on the paneGraph then apply the normal vector force onto it
    private EventHandler<MouseEvent> eventHandlerMouseReleased() {
        return new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                paneGraph.setCurrentDraggedNode(null);

            }
        };
    }

    public EventHandler<MouseEvent> eventHandlerMouseDragged() {
        FXShapeWrapper fxShapeWrapperThis = this;

        return new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                // Note that event is a StackPane

                double mouseX = event.getSceneX();
                double mouseY = event.getSceneY();

//                System.out.println(String.format("Mouse Position %s %s", mouseX, mouseY));
                paneGraph.setCurrentDraggedNode(fxShapeWrapperThis);

                paneGraph.setNodeLocation(fxShapeWrapperThis, new Point2D(mouseX, mouseY));
            }
        };
    }

    public void changeColor(Color color) {
        circle.setFill(color);
    }

    public WrapperActual getWrapperActualNormal() {
        return wrapperActualNormal;
    }

    public WrapperActual getWrapperActualInverse() {
        return wrapperActualInverse;
    }

    public Circle getCircle() {
        return circle;
    }

    public void addEdgeFX(FXShapeEdge FXEdge) {
        arrayListFXEdges.add(FXEdge);
    }

    public Point2D getPoint2D() {
        return point2D;
    }

    public void setPoint2D(Point2D point2D) {
        this.point2D = point2D;

        // shiftOffsetWidth because StackPane is bottom left Corner based so you need to
        // shift to get the center of the circle where the mouse is
        double shiftOffsetWidth = stackPane.getWidth() / 2;
        double shiftOffsetHeight = stackPane.getHeight() / 2;

        stackPane.setTranslateX(point2D.getX() - shiftOffsetWidth);
        stackPane.setTranslateY(point2D.getY() - shiftOffsetHeight);

        paneFXShapeWrapperInformation.updateTextPositions();
    }

    public PaneFXShapeWrapperInformation getPaneFXShapeWrapperInformation() {
        return paneFXShapeWrapperInformation;
    }

    public PaneGraph getPaneGraph() {
        return paneGraph;
    }

    @Override
    public void addToPaneGraph() {
        paneGraph.getChildren().add(stackPane);

    }

    @Override
    public String toString() {
        String string = String.format("%s %s", wrapperActualNormal, wrapperActualInverse);
        return string;
    }
}
