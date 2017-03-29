import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JComponent ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseEvent ;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *  @author Michael Gorokhovsky
 * 
 */

public class GraphComponent extends JComponent{
	
	private static JButton RButt;
	private static JButton EButt;
	private static JButton EGButt;

	private static JPanel p;
	
	private ActionListener listener;
	private ActionListener eListener;
	private ActionListener eGListener;

	private static ArrayList <GraphElement> shapes;
	
	private int shapeSelected;

	private GraphElement currentSelected;
	/**
	 * constructor
	 * @param making panel
	 * @param Making buttons
	 * 
	 * @param arraylist to hold shapes
	 * 
	 * adds buttons to panel
	 * 
	 * @param action listeners
	 * 
	 * adding listeners to buttons
	 * 
	 * @param mouse listener
	 */
	public GraphComponent()
	{
		p = new JPanel();
		RButt = new JButton("Rectangle");
		EButt = new JButton("Ellipse");
		EGButt = new JButton("Edge");
		
		shapes = new ArrayList<GraphElement>();
		
		p.add(RButt);
		p.add(EButt);
		p.add(EGButt);
		
		listener = new Rect();
		eListener = new Elli();
		eGListener = new Line();
		
		RButt.addActionListener(listener);
		EButt.addActionListener(eListener);		
		EGButt.addActionListener(eGListener);
		
		MouseListener mListener = new MyListener();
		addMouseListener(mListener);
		
		p.setVisible(true);
	}
	/**
	 * get JPanel
	 * @return panel 
	 */
	public JPanel getP() {
		return p;
	}
	
	/**
	 * calls mouselistener when rectangle button is clicked
	 *
	 */
	class Rect implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			MouseListener mlistener = new MyListener();
			addMouseListener(mlistener);
			shapeSelected = 0;
		}
		
	}
	/**
	 * calls mouselistener when ellipse button is clicked
	 *
	 */
	class Elli implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			MouseListener mlistener = new MyListener();
			addMouseListener(mlistener);
			shapeSelected = 1;
		}
		
	}
	/**
	 * calls mouselistener when edge button is clicked
	 *
	 */
	class Line implements ActionListener {
		
	
		public void actionPerformed(ActionEvent event) {
			MouseListener mlistener = new MyListener();
			addMouseListener(mlistener);
			shapeSelected = 2;
		}
	}
	
	
	
	/**
	 * mouselistener to control what happens on the panel when mouse is pressed, clicked, and released.
	 * all other methods are unused
	 */
	class MyListener implements MouseListener
	{
		int x;
		int y;
		int x2;
		int y2;
		public void mousePressed(MouseEvent event)
	    {
			if (shapeSelected == -1) {
				
				for (GraphElement element : shapes) {
					if ( element.isClicked(event.getX(), event.getY())) {
						element.setColor(Color.GREEN);
						currentSelected = element;
					}
					
					else {
						currentSelected = null;
						element.setColor(Color.BLACK);
					}
					
					repaint();
				}
			}

			
			if (shapeSelected == 2)
			{
				x = event.getX();
				y = event.getY();
			}
			MouseMotionListener moListener = new MMListener();
			addMouseMotionListener(moListener);			
			
	    }
	    public void mouseReleased(MouseEvent event)
	    {
	    	if (shapeSelected == 2)
			{
	    	x2 = event.getX();
	    	y2 = event.getY();
	    	
			GraphElement temp = new Edge(x, y, x2, y2);
			shapes.add(temp);
			repaint();
			shapeSelected = -1;
			x=0;
			y=0;
			x2 = 0;
			y2 = 0;
			}
	    }
	    public void mouseClicked(MouseEvent event)
	    {
		x = event.getX();
		y = event.getY();
		if (shapeSelected == 0)
			{
			GraphElement temp = new RectangleNode(x, y);
			shapes.add(temp);
			repaint();
			shapeSelected = -1;
			x=0;
			y=0;
			}
		else if (shapeSelected == 1)
			{
				GraphElement temp = new EllipseNode(x, y);
				shapes.add(temp);
				repaint();
				shapeSelected = -1;
				x=0;
				y=0;
			}
		if (event.isMetaDown()) {
			x = event.getX();
			y = event.getY();
			for (GraphElement element : shapes) {
				if ( (x>= element.getXPos() && x <=element.getXPos() + 100 && y>= element.getYPos() && y <= element.getYPos() + 80)) {
					shapes.remove(element);
					repaint();
					break;
				}	
			}
		}
	    }
	    public void mouseEntered(MouseEvent event)
	    {
		//do nothing
	    }
	    public void mouseExited(MouseEvent event)
	    {
		//do nothing
	    }
	}
	
	/**
	 *paint component method
	 *called in order to draw things
	 */
	public void paintComponent(Graphics g0)
	{
		Graphics2D g2 = (Graphics2D) g0;
		
		for (GraphElement element : shapes) {
			element.draw(g2);
		}
	}
	
	/**
	 *mouse motion listener
	 *used to move shape
	 */
	class MMListener implements MouseMotionListener 
			{
		double x = 0;
		double y = 0;
		double x2 = 0;
		double y2 = 0;
		
		public void mouseDragged(MouseEvent event) {
			if (currentSelected != null)             
			{
				currentSelected.moveTo(event.getX(), event.getY());
				repaint();
			}
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
			}
}
