import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Game extends VBox {
    private int score=0;
    private Text scoreBoard;
    private Screen screen;
    private Snake snake;
    private int[] location;
    public Game(int width, int height){
        super();
        this.scoreBoard = new Text(score+"");
        this.screen = new Screen(width,height);
        this.getChildren().add(scoreBoard);
        this.getChildren().add(screen);
        this.snake = new Snake(screen);


    }
    private void placeBait(){
        int x = (int)(Math.random()*screen.getWidth()-4)+2;
        int y = (int)(Math.random()*screen.getHeight()-4)+2;
        location= new int[]{x,y};
        screen.setColor(x,y, Color.RED);
    }

    public void start(Scene scene){
        this.setUpControls(scene);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                placeBait();
                for(int i=0;snake.isAlive();i++){
                    snake.run();
                    if(snake.getHead()[0]== location[0] &&snake.getHead()[1] == location[1]){
                        snake.grow();
                        placeBait();
                        score++;
                        scoreBoard.setText(score+"");
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
    private void setUpControls(Scene scene){
        scene.setOnKeyPressed(s->{

            //change the direction depending on the keys
            switch (s.getCode()) {

                case UP:   snake.setDirection(Direction.NORTH);break;
                case DOWN:   snake.setDirection(Direction.SOUTH);break;
                case RIGHT:   snake.setDirection( Direction.EAST);break;
                case LEFT:   snake.setDirection(Direction.WEST);break;
            }

        });
    }

}
