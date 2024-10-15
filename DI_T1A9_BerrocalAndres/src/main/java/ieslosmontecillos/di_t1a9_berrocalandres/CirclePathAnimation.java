package ieslosmontecillos.di_t1a9_berrocalandres;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.StrokeType;
import javafx.animation.PathTransition.OrientationType;

public class CirclePathAnimation extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creo el círculo que servirá como ruta
        Circle circle = new Circle(150, Color.TRANSPARENT); // Círculo transparente
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        circle.setStrokeType(StrokeType.OUTSIDE);
        circle.setCenterX(250);
        circle.setCenterY(200);

        // Creo el rectángulo que seguirá la ruta del círculo
        Rectangle rect = new Rectangle(40, 20, Color.ORANGE); // Rectángulo de color naranja

        // Creo el PathTransition (animación)
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000)); // Duración de 4000 ms
        pathTransition.setPath(circle);                    // Definir el círculo como ruta
        pathTransition.setNode(rect);                      // Nodo a mover (el rectángulo)
        pathTransition.setOrientation(OrientationType.NONE); // Sin orientación al círculo, para moverse horizontalmente
        pathTransition.setCycleCount(PathTransition.INDEFINITE); // Ciclos infinitos
        pathTransition.setAutoReverse(false);              // Sin invertir el movimiento
        pathTransition.play();                             // Iniciar la animación

        // Pauso la animación cuando el ratón esté pulsado sobre el círculo
        circle.setOnMousePressed((MouseEvent e) -> pathTransition.pause());

        // Reanudo la animación cuando se suelte la pulsación
        circle.setOnMouseReleased((MouseEvent e) -> pathTransition.play());

        // Creo el panel para mostrar los nodos
        Pane root = new Pane();
        root.getChildren().addAll(circle, rect);

        // Creo la escena
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Animación de Trayectoria en un Círculo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

