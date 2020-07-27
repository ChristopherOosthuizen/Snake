import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Screen  extends ImageView{
    private WritableImage img;
    private PixelWriter writer;
    private PixelReader reader;
    private Color[][] mat ;
    public Screen(int width, int height) {
        //writing messy code now so it can  be cleaner late
        super(new WritableImage(width,height));
        this.img = (WritableImage) super.getImage();
        this.writer = img.getPixelWriter();
        this.reader = img.getPixelReader();
        mat = new  Color[getHeight()+1][getWidth()+1];

    }
    public int getWidth(){
        return (int)img.getWidth()/9;
    }
    public int getHeight(){
        return (int)img.getHeight()/9;
    }
    public void setColor(int x, int y, Color c){
        mat[x][y] = c;
        for(int i=x*9;i<x*9+9;i++){
            for(int j=y*9;j<y*9+9;j++){
                writer.setColor(i,j,c);
            }
        }
    }
    public Color getColor(int x, int y){
        return mat[x][y];
    }
    public void setBlack(int x, int y){
       setColor(x,y,Color.BLACK);
    }
    public void setWhite(int x, int y){
        setColor(x,y, Color.WHITE);
    }
}
