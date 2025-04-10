/**
 * Flood fill app. 
 * 
 * @author John C. Bowers and YOUR NAME HERE
 * @version Dec. 7, 2023
 */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillApp extends JFrame {
    
    Color color; 

    public class FillPanel extends JPanel {
        public BufferedImage theImage; 

        public FillPanel() throws Exception {
            this.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    Point p = e.getPoint();
                    floodFill(p);
                }
            });

            File f = new File("mario.png");
            BufferedImage src = ImageIO.read(f);
            theImage = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
            theImage.getGraphics().drawImage(src, 0, 0, null);
            this.repaint();
        }


        public void floodFill(Point p) {
 
            // Get the integer representation of the color we want to 
            // flood fill: 
            int newColor = color.getRGB();

            // TODO 
            // Implement BFS on the image. We imagine the 
            // image as a graph where each pixel location is
            // a vertex in the graph. 
            //
            // We will *not* explicitly build a graph data structure.
            // Instead, the idea is to rewrite the BFS algorithm to use
            // the image directly as if it were a graph, by reinterpeting 
            // the graph operations as operations on the image itself. 
            //
            // Two pixel locations are neighbors in the graph if they
            // are neighboring pixel coordinates (North, South, East, West)
            // *and* the two pixels have the same color. 
            //
            // To check a pixel's color, call theImage.getRGB(i, j) where
            // (i, j) is the pixel coordinates. To set a pixel's color, 
            // call theImage.setRGB(i, j). 
            //
            // You will need to track which "vertices" have been visited by
            // BFS. How can we do this? If we've set the pixel's color
            // to the newColor value, then that vertex should be considered
            // visited. This way we don't have to maintain an additional structure. 
            //
            // I would also suggest you write a private neighborsOf(Point) 
            // method that returns a LinkedList<Point> of valid neighbors of
            // a particular point (taking into account the proper color value
            // and making sure the Point is within bounds of the image; you 
            // can use theImage.getWidth() and theImage.getHeight() for the 
            // bounds of the image.)
            //
            
           
            // Here is the pseudocode for BFS starting at a vertex u 
            //
            
            int originalColor = theImage.getRGB(p.x, p.y);
            Queue<Point> Q = new LinkedList<>();
            Q.add(p);
            
            while (!Q.isEmpty()) {
              Point v = Q.remove();
              
              if (theImage.getRGB(v.x, v.y) != newColor) {
                theImage.setRGB(v.x, v.y, newColor);
                
                for (Point w : neighborsOf(v, originalColor)) {
                  Q.add(w);
                }
              }
            }
            
            // Q <- initialize a queue data structure
            // add u to the Queue
            // while (the Q is not empty):
            //    remove v from the front of Q
            //    if v is not yet visited: 
            //      visit v
            //      for each neighbor w of v:
            //        add w to the Queue

            // You must call repaint at the end to see your updated drawing: 
            repaint();
        }
        
        private LinkedList<Point> neighborsOf(Point p, int originalColor) {
          Point[] candidates = { 
              new Point(p.x + 1, p.y), 
              new Point(p.x - 1, p.y),
              new Point(p.x, p.y + 1),
              new Point(p.x, p.y - 1),
          };
          
          LinkedList<Point> neighbors = new LinkedList<>();
          for (Point c : candidates) {
            if (c.x >= 0 && c.x < theImage.getWidth() &&
                c.y >= 0 && c.y < theImage.getHeight() &&
                theImage.getRGB(c.x, c.y) == originalColor) {
                neighbors.add(c);
            }
              
          }
          
          return neighbors;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(theImage, 0, 0, this);
        }
    }

    public class FillChooserButton extends JButton {

        public FillChooserButton() {
            super("Select Fill Color");
            
            color = Color.red;
            setBackground(color);
            setOpaque(true);

            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    color = JColorChooser.showDialog(FillChooserButton.this, "Select Fill Color", color);
                    setBackground(color);
                }
            });
        }
    }

    public FloodFillApp() throws Exception {
        super("Flood Fill App");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        FillChooserButton fcb = new FillChooserButton();
        mainPanel.add(fcb, BorderLayout.NORTH);

        FillPanel fp = new FillPanel();
        mainPanel.add(fp, BorderLayout.CENTER);

        setContentPane(mainPanel);
        fp.setPreferredSize(new Dimension(fp.theImage.getWidth(), fp.theImage.getHeight()));
        pack();
        this.setResizable(false);
    }

    public static void main(String[] args) throws Exception {
        FloodFillApp ffApp = new FloodFillApp();
        ffApp.setVisible(true);
    }
}