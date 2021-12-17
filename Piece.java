import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
class Piece{
    private int piece;
    private Vector2 position;
    public Piece(int piece, Vector2 position){
        this.piece = piece;
        this.position = position;
    }
    
    public int getPiece(){
        return piece;
    }
    
    public Vector2 getPosition(){
        return position;
    }
    
    public void setPostition(Vector2 v){
        position = v;
    }
    
}