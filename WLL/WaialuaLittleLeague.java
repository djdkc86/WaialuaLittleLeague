import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaialuaLittleLeague extends JFrame{

    private JTextField balls,strikes,outs,pitchCount;
    private JLabel ballsLabel,strikesLabel,outsLabel,pitchCountLabel;
    private JPanel pitcherData, pitcherButtons;
    private JButton strike,ball,foul,walk,hit,out;
    private int ballCount=0,strikeCount=0,totalPitchCount =0,outCount=0;

    public WaialuaLittleLeague()
    {
        
        setTitle("Waialua Little League");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());

        buildPitcherData();
        buildPitcherButtons();
        
        add(pitcherData, BorderLayout.CENTER);
        add(pitcherButtons, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        
    }

    private void buildPitcherData()
    {

    	ballsLabel = new JLabel("Balls");
    	strikesLabel = new JLabel("Strikes");
    	outsLabel = new JLabel("Outs");
    	pitchCountLabel = new JLabel("Pitch Count");

    	balls = new JTextField(Integer.toString(ballCount), 3);
    	strikes = new JTextField(Integer.toString(strikeCount), 3);
    	outs = new JTextField(Integer.toString(outCount), 3);
    	pitchCount = new JTextField(Integer.toString(totalPitchCount), 3);

    	balls.setEditable(false);
    	strikes.setEditable(false);
    	outs.setEditable(false);
    	pitchCount.setEditable(false);

    	pitcherData = new JPanel(new GridLayout(4,2));

    	pitcherData.add(pitchCountLabel);
    	pitcherData.add(pitchCount);
    	pitcherData.add(ballsLabel);
    	pitcherData.add(balls);
    	pitcherData.add(strikesLabel);
    	pitcherData.add(strikes);
    	pitcherData.add(outsLabel);
    	pitcherData.add(outs);
    }

    private void buildPitcherButtons()
    {
    	pitcherButtons = new JPanel(new GridLayout(1,6));

    	strike = new JButton("STRIKE");
    	ball = new JButton("BALL");
    	foul = new JButton("FOUL");
    	walk = new JButton("WALK");
    	hit = new JButton("HIT");
    	out = new JButton("OUT");

    	strike.addActionListener(new StrikeButtonListener());
    	ball.addActionListener(new BallButtonListener());
    	foul.addActionListener(new FoulButtonListener());
    	walk.addActionListener(new RunnerButtonListener());
    	hit.addActionListener(new RunnerButtonListener());
    	out.addActionListener(new OutButtonListener());

		pitcherButtons.add(strike);
		pitcherButtons.add(ball);
		pitcherButtons.add(foul);
		pitcherButtons.add(walk);
		pitcherButtons.add(hit);   
		pitcherButtons.add(out); 	

    }

    private void clean()
    {
        strikeCount = 0;
        ballCount = 0;
        outCount = 0;

        strikes.setText(strikeCount +"");
        balls.setText(ballCount +"");
        outs.setText(outCount +"");
    }

    private void noBallsNoStrikes()
    {

        strikeCount = 0;
        ballCount = 0;

        strikes.setText(strikeCount +"");
        balls.setText(ballCount + "");

    }

    private class StrikeButtonListener implements ActionListener
    {

    	public void actionPerformed(ActionEvent e)
    	{
    		pitchCount.setText(++totalPitchCount+"");
    		if(strikeCount < 2){;
                strikes.setText(++strikeCount +"");
    		}
    		else if(strikeCount == 2 && outCount < 2){
    		
                noBallsNoStrikes();
                outs.setText(++outCount+"");
    		}
    		else{
    			clean();
    		}

    	}

    }

    private class BallButtonListener implements ActionListener
    {

    	public void actionPerformed(ActionEvent e)
    	{
    		pitchCount.setText(++totalPitchCount+"");
    		if(ballCount < 3){
                balls.setText(++ballCount+"");
    		}
            else{
                noBallsNoStrikes();
            }
            
    	}

    }

    private class FoulButtonListener implements ActionListener
    {

    	public void actionPerformed(ActionEvent e)
    	{
    		pitchCount.setText(++totalPitchCount+"");
    		if(strikeCount < 2){
    			strikeCount++;
                strikes.setText(strikeCount+"");
    		}

    	}

    }

    private class RunnerButtonListener implements ActionListener
    {

    	public void actionPerformed(ActionEvent e)
    	{
            pitchCount.setText(++totalPitchCount+"");
            noBallsNoStrikes();
    	}

    }

    private class OutButtonListener implements ActionListener
    {

    	public void actionPerformed(ActionEvent e)
    	{
            outs.setText(++outCount+"");

    		if (outCount ==3){
    			clean();
    		}
    	}

    }

    public static void main(String [] args)
    {
    	new WaialuaLittleLeague();
    }
}