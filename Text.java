import greenfoot.*;

/**
 * Add a Text box to the world
 * Choose between no background, different colors and font sizes
   */
public class Text extends Actor {
    private final double P_TO_PX = 4/3;
    private GreenfootImage text;
    private String str;
    private Color color, background;
    private int size;
    
    public Text(int value, Color color, int size) {this(Integer.toString(value), color, new Color(0, 0, 0, 0), size);}
    public Text(String str, Color color, int size) {this(str, color, new Color(0, 0, 0, 0), size);}
    public Text(String str, Color color, Color background, int size) { // Create a greenfoot TextImage (was not able to centre text in a greenfoot image)
        this.str = str;
        this.color = color;
        this.background = background;
        this.size = size;
        text = new GreenfootImage(str, size, color, background);
        setImage(text);
    }
    public Text(String str, Color color, int size, String f) { // Create a greenfoot TextImage (was not able to centre text in a greenfoot image)
        this.str = str;
        this.color = color;
        this.background = background;
        this.size = size;
        Font font = new Font(f, size);
        text = new GreenfootImage((int)(str.length() * font.getSize() * P_TO_PX), size);
        text.setFont(font);
        text.drawString(str, 0, 0);
        setImage(text);
    }
    
    // Used for updating score
    public void updateText(int str) {updateText(Integer.toString(str));}
    public void updateText(String str) {
        this.str = str;
        text = new GreenfootImage(str, size, color, background);
        setImage(text);
    }
    
    public void changeColor(Color color) {
        this.color = color;
        updateText(str);
    }
    
    public void changeBackgroundColor(Color color) {
        this.background = color;
        updateText(str);
    }
    
    // Accessors
    public int fontSize() {return size;}
    public int getWidth() {return getImage().getWidth();}
    public int getHeight() {return getImage().getHeight();}
    public String getString() {return str;}
}
