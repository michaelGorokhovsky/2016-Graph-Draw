import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 *  @author Michael Gorokhovsky
 * 
 */

public class RectangleNode extends GraphElement
	{
		private static Rectangle rec;
		private Color color;
		private String label;
		
		/**
		 * constructor
		 * @param setting coordinates
		 * @param setting color
		 */
		
		public RectangleNode(double x, double y)
		{
			super.moveTo(x,y);
			color = Color.BLACK;
		}
		
		/**
		 * checking if rectangle has been clicked
		 */
		
				boolean isClicked(double x, double y) {
			if (rec.contains(x,y))
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
		 * method to draw rectangle
		 */
				
		void draw(Graphics2D g2) {
			rec = new Rectangle((int)super.getXPos(), (int) super.getYPos(), 100, 80);
			g2.setColor(color);
			g2.draw(rec);
			
		}

		
		boolean applyLabel() {
			// TODO Auto-generated method stub
			return false;
		}
		
}

