import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * A paint class with customizable colors
 *
 *
 * @author Rama Deshpande
 * @version Nov 11, 2020
 */
public class Paint extends JComponent implements Runnable {
    private Image image; // the canvas
    private Graphics2D graphics2D;  // this will enable drawing
    private int curX; // current mouse x coordinate
    private int curY; // current mouse y coordinate
    private int oldX; // previous mouse x coordinate
    private int oldY; // previous mouse y coordinate

    JButton clearButton;
    JButton blueButton; // a button to change paint color
    JButton redButton; // a button to change paint color
    JButton blackButton; // a button to change paint color
    
    JTextField hexText;
    JButton hex;
    JTextField rText;
    JTextField gText;
    JTextField bText;
    JButton rgb;

    Paint paint; // variable of the type ColorPicker

    /* action listener for buttons */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == blueButton) {
                paint.blue();
                Color color = Color.blue;
                rText.setText(String.valueOf(color.getRed()));
                gText.setText(String.valueOf(color.getGreen()));
                bText.setText(String.valueOf(color.getBlue()));
                hexText.setText(String.format("#%02x%02x%02x", Integer.valueOf(rText.getText()), Integer.valueOf(gText.getText()), Integer.valueOf(rText.getText())));
            }
            if (e.getSource() == redButton) {
                paint.red();
                Color color = Color.red;
                rText.setText(String.valueOf(color.getRed()));
                gText.setText(String.valueOf(color.getGreen()));
                bText.setText(String.valueOf(color.getBlue()));
                hexText.setText(String.format("#%02x%02x%02x", Integer.valueOf(rText.getText()), Integer.valueOf(gText.getText()), Integer.valueOf(rText.getText())));
            }
            if (e.getSource() == blackButton) {
                paint.black();
                Color color = Color.black;
                rText.setText(String.valueOf(color.getRed()));
                gText.setText(String.valueOf(color.getGreen()));
                bText.setText(String.valueOf(color.getBlue()));
                hexText.setText(String.format("#%02x%02x%02x", Integer.valueOf(rText.getText()), Integer.valueOf(gText.getText()), Integer.valueOf(rText.getText())));
            }
            if (e.getSource() == clearButton) {
            	paint.clear();
            	hexText.setText("#");
                rText.setText(null);
                gText.setText(null);
                bText.setText(null);
            }
            if (e.getSource() == hex)
            {
            	try {
                    Color colorCheck = Color.decode(String.valueOf(hexText.getText()));
                    paint.graphics2D.setPaint(colorCheck);
                    rText.setText(String.valueOf(colorCheck.getRed()));
                    gText.setText(String.valueOf(colorCheck.getGreen()));
                    bText.setText(String.valueOf(colorCheck.getBlue()));
                    } catch (NumberFormatException e1){
                    	JOptionPane.showMessageDialog(null, "Not a valid hex value", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
            }
            if (e.getSource() == rgb)
            {
            	if (rText.getText().isBlank())
            	{
            		rText.setText("0");
            	}
            	if (gText.getText().isBlank())
            	{
            		gText.setText("0");
            	}
            	if (bText.getText().isBlank())
            	{
            		bText.setText("0");
            	}
            	try {
            		Color color2 = Color.decode(String.format("#%02x%02x%02x", Integer.valueOf(rText.getText()), Integer.valueOf(gText.getText()), Integer.valueOf(rText.getText())));
                	hexText.setText(String.format("#%02x%02x%02x", Integer.valueOf(rText.getText()), Integer.valueOf(gText.getText()), Integer.valueOf(rText.getText())));
                	paint.graphics2D.setPaint(color2);
            	} catch (NumberFormatException e1)
            	{
            		JOptionPane.showMessageDialog(null, "Not a valid RGB value", "Error",
                            JOptionPane.ERROR_MESSAGE);
            	}
            	
            }
        }
    };
    
    /* set up paint colors */
    public void clear() {
    	 graphics2D.setPaint(Color.white);
         graphics2D.fillRect(0, 0, getSize().width, getSize().height);
         graphics2D.setPaint(Color.black);
         repaint();
    }
    public void blue() {
        graphics2D.setPaint(Color.blue);
    }

    public void red() {
        graphics2D.setPaint(Color.red);
    }

    public void black() {
        graphics2D.setPaint(Color.black);
    }

    public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /* set oldX and oldY coordinates to beginning mouse press*/
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /* set current coordinates to where mouse is being dragged*/
                curX = e.getX();
                curY = e.getY();

                /* draw the line between old coordinates and new ones */
                graphics2D.drawLine(oldX, oldY, curX, curY);

                /* refresh frame and reset old coordinates */
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());
    }

    public void run() {
        /* set up JFrame */
        JFrame frame = new JFrame("Paint");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        clearButton = new JButton("Clear");
        panel.add(clearButton);
        clearButton.addActionListener(actionListener);
        blueButton = new JButton("Blue");
        panel.add(blueButton);
        blueButton.addActionListener(actionListener);
        redButton = new JButton("Red");
        panel.add(redButton);
        redButton.addActionListener(actionListener);
        blackButton = new JButton("Black");
        panel.add(blackButton);
        blackButton.addActionListener(actionListener);
        content.add(panel, BorderLayout.NORTH);
        
        JPanel panelBot = new JPanel();
        hexText = new JTextField(10);
        panelBot.add(hexText);
        hex = new JButton("Hex");
        panelBot.add(hex);
        hex.addActionListener(actionListener);
        rText = new JTextField(5);
        panelBot.add(rText);
        gText = new JTextField(5);
        panelBot.add(gText);
        bText = new JTextField(5);
        panelBot.add(bText);
        rgb = new JButton("RGB");
        panelBot.add(rgb);
        rgb.addActionListener(actionListener);
        
        content.add(panelBot, BorderLayout.SOUTH);
        
        
        
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
    
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            /* this lets us draw on the image (ie. the canvas)*/
            graphics2D = (Graphics2D) image.getGraphics();
            /* gives us better rendering quality for the drawing lines */
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            /* set canvas to white with default paint color */
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);

    }
}