import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        Game game = new Game(400,400);
        HBox box = new HBox(game);

        Scene scene = new Scene(box);
        game.start(scene);
        stage.setScene(scene);
        stage.show();


    }
    public static void main(String[] args){
        Application.launch(args);
    }
}
