/**
 * Joseph Edradan
 * <p>
 * This file is for all FXShapes
 */
package StandardAnimation;

import javafx.scene.layout.StackPane;

// Base of Every Shape
abstract class FXShape {

    protected StackPane stackPane = new StackPane();

//    protected Text stackPaneText = null;

    abstract public void addToPaneGraph();
}
