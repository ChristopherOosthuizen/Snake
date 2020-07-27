import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Snake {
    private Direction direction;
    private LinkedList<int[]> pixels;
    private int[] head;
    private Screen screen;
    private boolean hit;
    public Snake(Screen screen){
        this.screen = screen;
        this.start();

    }
    public void run(){
        grow();

            int[] last = pixels.removeLast();
            screen.setWhite(last[0], last[1]);

    }
    public boolean isAlive(){
        return !hit&&head[0] >1 &&head[1] >1 && head[0] <screen.getWidth()-2 && head[1] < screen.getHeight()-2;
    }

    //setup the controls
    public void start(){
        this.hit = false;
        head = new int[]{screen.getHeight() / 2, screen.getWidth() / 2};
        pixels = new LinkedList<>();
        pixels.add(head);
        pixels.add(new int[]{screen.getHeight() / 2-1, screen.getWidth() / 2-1});
        this.direction = Direction.SOUTH;
        //setupControls

    }
    public int[] getHead(){
        return head;
    }
    public void grow(){
        direction.updatePos(head);
        for(int[] pos: pixels){
            if(pos[0] == head[0] && pos[1] == head[1]&& pos != head){
                hit = true;
                return;
            }
        }
        screen.setBlack(head[0],head[1]);
        pixels.push(new int[]{head[0],head[1]});
    }
    public void setDirection(Direction direction){
        if(this.direction.canChange(direction)){
            this.direction = direction;
        }

    }
}
