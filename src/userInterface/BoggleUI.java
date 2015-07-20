package userInterface;

import core.Board;
import core.Die;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

/**
 *
 * @author Juan
 */
public class BoggleUI 
{
    private Board board;
    private ArrayList<String> dictionary;
    
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu game;
    private JMenuItem exit;
    private JMenuItem newGame;
    
    // Boggle board
    private JPanel bogglePanel;
    private ArrayList<JButton> diceButtons = new ArrayList<JButton>();  

    // Enter found words
    private static JPanel wordsPanel;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JLabel timeLabel;
    private JButton shakeDice;
    
    private static JPanel playerPanel;
    private JLabel currentWord;
    private JButton submitWord;
    private JLabel currentScore;
    
    private Timer gameTime = new Timer(1000, null);
    private int buttonsUsed = 0;
    
    
    public BoggleUI(Board inBoard)
    {
        board = inBoard;
        initComponents();
    }
    
    public BoggleUI(Board inBoard, ArrayList<String> dictData)
	{
    	this(inBoard);
        dictionary = dictData;
	}

	private void initComponents()
    {
        // Initialize the JFrame
        frame = new JFrame("Boggle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(660, 500);
        
        // Initialize the JMenuBar and add to the JFrame
        createMenu();
        // Initialize the JPanel for the Boggle dice
        setupBogglePanel();
        // Initialize the JPanel for the word entry
        setupWordPanel();
        // Init playerPanel
        setupPlayerPanel();
        
        // Add everything to the JFrame
        frame.setJMenuBar(menuBar);
        frame.add(bogglePanel, BorderLayout.WEST);
        frame.add(wordsPanel, BorderLayout.CENTER);
        frame.add(playerPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    private void createMenu()
    {
        menuBar = new JMenuBar();
        game = new JMenu("Boggle");
        game.setMnemonic('B');
        
        newGame = new JMenuItem("New Game");
        newGame.setMnemonic('N');
        newGame.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
        		newGame();
        	}
        });

        exit = new JMenuItem("Exit");
        exit.setMnemonic('E');
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                    System.exit(0);
            }
        });
        
        game.add(newGame);    
        game.add(exit);    
        
        menuBar.add(game);
    }
    
    protected void newGame()
	{
    	/*
    	 * Write an ActionListener that is registered to the JMenuItem with the text New Game; it should 
		 *	a.clear all text in the JTextArea
		 *	b. reset the time on the JLabel to 3:00
		 *	c. reenable the JButton with text Shake Dice
		 */
    	gameTime.stop();
    	buttonsUsed = 0;
    	textArea.setText(null);
    	timeLabel.setText("3:00");
    	shakeDice.setEnabled(true);
    	submitWord.setEnabled(true);
		
	}

	private void setupBogglePanel()
    {   
        bogglePanel = new JPanel(new GridLayout(4, 4));
        bogglePanel.setMinimumSize(new Dimension(400, 400));
        bogglePanel.setPreferredSize(new Dimension(400, 400));
        bogglePanel.setBorder(BorderFactory.createTitledBorder("Boggle Board"));

        ArrayList<Die> dice = board.shakeDice();
        
        Collections.shuffle(dice);
       
        int counter = 0;
        
        for(int row = 0; row < 4; row++)
            for(int col = 0; col < 4; col++)
        {    
            JButton dieButton = new JButton();
            String dieLetter = dice.get(counter).getLetter();
            dieButton.setText(dieLetter);
            dieButton.putClientProperty("letter", dieLetter);           
            dieButton.putClientProperty("row", row);
            dieButton.putClientProperty("col", col);
            
            // die position on the board needs to be randomized

            bogglePanel.add(dieButton);
            counter++;
        }
    }

    private void setupWordPanel()
    {
        wordsPanel = new JPanel();
        wordsPanel.setLayout(new BoxLayout(wordsPanel, BoxLayout.Y_AXIS));
        wordsPanel.setBorder(BorderFactory.createTitledBorder("Enter Words Found"));
        
        textArea = new JTextArea();
        textArea.setLineWrap(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(180, 330));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        timeLabel = new JLabel("3:00");
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 48));
        timeLabel.setPreferredSize(new Dimension(240, 100));
        timeLabel.setMinimumSize(new Dimension(240, 100));
        timeLabel.setMaximumSize(new Dimension(240, 100));
        timeLabel.setBorder(BorderFactory.createTitledBorder("Time Left"));
        
        shakeDice = new JButton("Shake Dice");
        shakeDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 5.	Write and ActionListener that is registered to the JButton with text Shake Dice; it should
						a.	Call method shake dice from class Board to get new letters for each die
						b.	Randomize the placement of each die on the UI representation of the Boggle Board
						c.	Reset the data for 
							i.	the JLabel representing the user’s score to the value of 0
							ii.	the JLabel representing the current word to empty text
							iii.	the JLabel representing the amount of time left to 3:00 
						d.	Disable JButton Shake Dice
						e.	Starts a Thread to keep track of the timer counting down from 3:00 to 0
				 */
				
				ArrayList<Die> dice = board.shakeDice();
				Collections.shuffle(dice);
				
				bogglePanel.removeAll();
				
				int counter = 0;
				for(int row = 0; row < 4; row++)
		            for(int col = 0; col < 4; col++)
		        {    
		            final JButton dieButton = new JButton();
		            dieButton.addActionListener(new ActionListener() {
		                public void actionPerformed(ActionEvent ev) {
		                    /*
		                     * 7.	Write an ActionListener that is registered to the JButtons that
		                     * represent the dice on the board; when the JButton is clicked it should
									a.	Update the JLabel representing the current word with the letter on the die and concatenate it to existing text
									b.	Update the UI so only the available letters are enabled, all other letters are disabled
		                     */
		                	currentWord.setText(currentWord.getText() + dieButton.getText());
		                	dieButton.setEnabled(false);
		                	buttonsUsed++;
		            }
		        });
		            String dieLetter = dice.get(counter).getLetter();
		            dieButton.setText(dieLetter);
		            dieButton.putClientProperty("letter", dieLetter);           
		            dieButton.putClientProperty("row", row);
		            dieButton.putClientProperty("col", col);
		            
		            // die position on the board needs to be randomized

		            bogglePanel.add(dieButton);
		            counter++;
		        }
				
				currentScore.setText("0");
				currentWord.setText("");
				timeLabel.setText("3:00");
				shakeDice.setEnabled(false);
				
				//int delay = 1000; //1 second
				//final Timer gameTime = new Timer(1000, null);
				gameTime.restart();
				//gameTime.start();
				gameTime.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent ev) {
						String temptime = timeLabel.getText();
						String[] splittime = temptime.split(":");
						int minute = Integer.parseInt(splittime[0]);
						int second = Integer.parseInt(splittime[1]);
				
						if(second == 0) {
							minute--;
							second = 59;
						} else {
							second--;
						}
						temptime = minute + ":" + String.format("%02d", second);
						timeLabel.setText(temptime);
						
						if(minute == 0 && second == 00) {
							gameTime.stop();
							submitWord.doClick();
							endGame();
						}
		            }
		        });
			}
        });
        
        shakeDice.setPreferredSize(new Dimension(240, 100));
        shakeDice.setMinimumSize(new Dimension(240, 100));
        shakeDice.setMaximumSize(new Dimension(240, 100));
        
        wordsPanel.add(scrollPane);
        wordsPanel.add(timeLabel);
        wordsPanel.add(shakeDice);
    }
    
    private void setupPlayerPanel()
    {
    	playerPanel = new JPanel();
    	playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.X_AXIS));
    	playerPanel.setBorder(BorderFactory.createTitledBorder("Current Word"));
    	
    	currentWord = new JLabel("");
    	currentWord.setHorizontalAlignment(SwingConstants.LEFT);
    	currentWord.setFont(new Font("Serif", Font.PLAIN, 24));
    	currentWord.setPreferredSize(new Dimension(300, 50));
    	currentWord.setMinimumSize(new Dimension(300, 50));
    	currentWord.setMaximumSize(new Dimension(300, 50));
    	currentWord.setBorder(BorderFactory.createTitledBorder("Current Word"));

    	
    	submitWord = new JButton("Submit Word");
    	submitWord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
            	/*
            	 * 6.	Write an ActionListener that is registered to the JButton with text Submit Word; it should
            	 * a.	Validate if the word can be used based on the dictionary text file provided
            	 * b.	Update the JTextArea by adding the word in the JLabel representing the Current Word
            	 * c.	Clear the JLabel representing the Current Word
            	 */
            	
            	if(validateWord(currentWord.getText(),dictionary)) {
            		textArea.setText(textArea.getText() + currentWord.getText() + "\n");
            		scoreWord(currentWord.getText());
            	}
            	currentWord.setText("");
            	if(buttonsUsed == 16) {
            		endGame();
            	}
            }
        });
    	submitWord.setPreferredSize(new Dimension(120, 50));
    	submitWord.setMinimumSize(new Dimension(120, 50));
    	submitWord.setMaximumSize(new Dimension(120, 50));
    	
    	currentScore = new JLabel("0");
    	currentScore.setHorizontalAlignment(SwingConstants.CENTER);
    	currentScore.setFont(new Font("Serif", Font.PLAIN, 24));
    	currentScore.setPreferredSize(new Dimension(120, 50));
    	currentScore.setMinimumSize(new Dimension(120, 50));
    	currentScore.setMaximumSize(new Dimension(120, 50));
    	currentScore.setBorder(BorderFactory.createTitledBorder("Score"));
    	
    	playerPanel.add(currentWord);
    	playerPanel.add(submitWord);
    	playerPanel.add(currentScore);

    }

	protected boolean validateWord(String text, ArrayList<String> dict)
	{
		return dict.contains(text.toLowerCase());
		
	}
	
	private void endGame()
	{
		submitWord.setEnabled(false);
		gameTime.stop();
		
	}
	
	private void scoreWord(String word) {
		Integer score = Integer.parseInt(currentScore.getText());
		int[] pointValues = {1,1,2,3,5,11};
		score = score + pointValues[word.length()];
		currentScore.setText(score.toString());
	}
}