package flappybird;

import flappybird.FlappyBird;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Renderer extends JPanel
{

    //needed this here for some reason...automatically added
    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g)
    {
        //calling super from JPanel
        super.paintComponent(g);

        FlappyBird.flappyBird.repaint(g);
    }

}