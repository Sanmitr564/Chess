import com.badlogic.gdx.graphics.Texture;
import java.util.*;
public class GLOBAL{

    public static final int WHITE = 0;
    public static final int BLACK = 1;
    
    public static final int PAWN = 0;
    public static final int ROOK = 1;
    public static final int HORSE = 2;
    public static final int BISHOP = 3;
    public static final int QUEEN = 4;
    public static final int KING = 5;
    
    
    public static final Texture[][] PIECE_TEXTURES = {
        {new Texture("white pawn.png"), new Texture("black pawn.png")},
        {new Texture("white rook.png"), new Texture("black rook.png")},
        {new Texture("white horse.png"), new Texture("black horse.png")},
        {new Texture("white bishop.png"), new Texture("black bishop.png")},
        {new Texture("white queen.png"), new Texture("black queen.png")},
        {new Texture("white king.png"), new Texture("black king.png")}
    };
    
    public static final float WORLD_WIDTH = 800; 
    public static final float WORLD_HEIGHT = 800;
    public static final float SQUARE_SIZE = 100;
    
    public static ArrayList<Piece> PIECE_LIST = new ArrayList<Piece>();
    
    public static int[][] board = new int[8][8];
}