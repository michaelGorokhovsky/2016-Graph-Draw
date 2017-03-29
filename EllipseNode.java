import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 *  @author Michael Gorokhovsky
 * 
 */

public class EllipseNode extends GraphElement
{
	private static Ellipse2D.Double elli ;
	private Color color;
	private String label;
	
	/**
	 * constructor
	 * @param setting coordinates
	 * @param setting color
	 */
	
	public EllipseNode(double x, double y)
	{
		super.moveTo(x, y);

		color = Color.BLACK;
	}
	
	/**
	 * checking if ellipse has been clicked
	 */
	
	boolean isClicked(double x, double y) {
		if (elli.contains(x,y))
			return true;
		else 
			return false;
	}

	/**
	 * setting color
	 */
	
	public void setColor(Color color)
	{
		this.color = color;
	}
		
	/**
	 * method to draw ellipse
	 */
	
	void draw(Graphics2D g2) {
		elli = new Ellipse2D.Double(super.getXPos(), super.getYPos(), 100, 80);
		g2.setColor(color);
		g2.draw(elli);
		
	}

	
	
	boolean applyLabel() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

