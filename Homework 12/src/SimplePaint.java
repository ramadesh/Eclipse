import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
public class SimplePaint extends JComponent implements Runnable {
	Image image; // the canvas
	Graphics2D graphics2D;  // this will enable drawing
	int curX; // current mouse x coordinate
	int curY; // current mouse y coordinate
	int oldX; // previous mouse x coordinate
	int oldY; // previous mouse y coordinate

	JButton enterButton; // button to enter information
	JTextField strTextField; // text field for input
	
	SimplePaint paint; // variable of the type SimplePaint
	
	public SimplePaint() {
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
	    SwingUtilities.invokeLater(new SimplePaint());
	    
	}
	public void run() {
		JFrame frame = new JFrame("Simple Paint Walkthrough");
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		paint = new SimplePaint();
		content.add(paint, BorderLayout.CENTER);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		strTextField = new JTextField(10);
		enterButton = new JButton("Enter");
		JPanel panel = new JPanel();
		panel.add(strTextField);
		panel.add(enterButton);
		content.add(panel, BorderLayout.NORTH);
		enterButton.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {

		        int size = Integer.valueOf(strTextField.getText());

		        paint.draw(size);

		    }
		});
		
	}
	
	public void draw(int size) {
	    graphics2D.setStroke(new BasicStroke(size));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);

            /* this lets us draw on the image (ie. the canvas)*/
            graphics2D = (Graphics2D) image.getGraphics();

            /* gives us better rendering quality for the drawing lines */
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                        RenderingHints.VALUE_ANTIALIAS_ON);

            /* set canvas to white with default paint color */
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
	}
		
}
