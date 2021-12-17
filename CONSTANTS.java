import com.badlogic.gdx.graphics.Texture;
public class CONSTANTS{
    public static final int WHITE_PAWN = 0;
    public static final int WHITE_ROOK = 1;
    public static final int WHITE_HORSE = 2;
    public static final int WHITE_BISHOP = 3;
    public static final int WHITE_QUEEN = 4;
    public static final int WHITE_KING = 5;
    
    public static final int BLACK_PAWN = 6;
    public static final int BLACK_ROOK = 7;
    public static final int BLACK_HORSE = 8;
    public static final int BLACK_BISHOP = 9;
    public static final int BLACK_QUEEN = 10;
    public static final int BLACK_KING = 11;
    
    public static final Texture[] PIECE_TEXTURES = {
        new Texture("white pawn.png"),
        new Texture("white rook.png"),
        new Texture("white horse.png"),
        new Texture("white bishop.png"),
        new Texture("white queen.png"),
        new Texture("white king.png"),
        
        new Texture("black pawn.png"),
        new Texture("black rook.png"),
        new Texture("black horse.png"),
        new Texture("black bishop.png"),
        new Texture("black queen.png"),
        new Texture("black king.png")
    };
    
    public static final float WORLD_WIDTH = 800; 
    public static final float WORLD_HEIGHT = 800;
    public static final float SQUARE_SIZE = 100;
}