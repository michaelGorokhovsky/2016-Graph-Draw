
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *  @author Michael Gorokhovsky
 * 
 */

public class GraphDraw extends JFrame {
	
	public static void main(String[] args) {
		//making new frame
		JFrame frame = new JFrame();
        
		//making graph component
		GraphComponent grap = new GraphComponent();
		
		frame.setLayout(new BorderLayout());
		
		frame.add(grap.getP(), BorderLayout.NORTH);
		frame.add(grap, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Graph Draw");	
		frame.setSize(1920, 1080);
	
		frame.setVisible(true);

	}
	
	

}

