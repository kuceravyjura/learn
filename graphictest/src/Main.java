import java.awt.*;



    public class Main {
    public static void main(String[] args) {
        AWTExample1 f = new AWTExample1();


    }
        static class AWTExample1 extends Frame {

            // initializing using constructor
            AWTExample1() {

                // creating a button
                Button b = new Button("Click Me!!");

                // setting button position on screen
                b.setBounds(30,100,80,30);

                // adding button into frame
                add(b);

                // frame size 300 width and 300 height
                setSize(300,300);

                // setting the title of Frame
                setTitle("This is our basic AWT example");

                // no layout manager
                setLayout(null);

                // now frame will be visible, by default it is not visible
                setVisible(true);
            }

            public void paint(Graphics g)            {

        int[] arrayX = {20, 100, 100, 250, 250, 20, 20, 50};
        int[] arrayY = {180, 180, 200, 200, 220, 200, 200, 190};
        Polygon poly = new Polygon(arrayX, arrayY, 8);
        g.drawPolygon(poly);
        Point aPoint = new Point(50, 190);
        if(poly.contains(aPoint))
        {
            g.drawString("Yes", 50, 190);
        }

        Font font = new Font("Tahoma", Font.BOLD|Font.ITALIC, 40);
        Font oldFont = g.getFont();
        g.setFont(font);
        g.drawString("SBP", 270, 220);
        g.setFont(oldFont);

        // Draw axes;
        // g.drawLine(20, 220, 20, 350);
        // g.drawLine(20, 350, 360, 350);
        // g.drawString(«Y», 25, 230);
        // g.drawString(«X», 350, 346);
        // Draw a curve;
        // int[] xArray = {20, 40, 60, 80, 100, 120, 130, 140, 280, 332};
        // int[] yArray = {350, 345, 340, 310, 290, 280, 275, 273, 271, 269};
        // int nPoint = 10;
        // g.setColor(newColor);
        // g.drawPolyline(xArray, yArray, nPoint);
        // g.setColor(oldColor);
        // g.drawString(«y = f(x)», 180, 267);
        // }
}
}}