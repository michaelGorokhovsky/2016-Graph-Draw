import java.awt.Graphics2D;
import java.awt.geom.Line2D;
	
	/**
	 *  @author Michael Gorokhovsky
	 * 
	 */

public class Edge extends GraphElement
{
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	private Line2D.Double lin;

	/**
	 * constructor
	 * @param setting coordinates
	 */
	
	public Edge(double x1, double y1, double x2, double y2)
	{
		startX = x1;
		startY = y1;
		endX = x2;
		endY = y2;
	}

	/**
	 *empty method
	 */
	
	boolean isClicked(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 *drawing the edge
	 */
		void draw(Graphics2D g2) {
		lin = new Line2D.Double(startX, startY, endX, endY);
		g2.draw(lin);
		
	}

		/**
		 *empty method
		 */
		
	boolean applyLabel() {
		// TODO Auto-generated method stub
		return false;
	}
	
}	