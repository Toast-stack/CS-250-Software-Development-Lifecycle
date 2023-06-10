import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/KamalayaKohSamui.jpg") + "'</body></html>"; //For the first picture which is Kamalaya, Koh Samui, Thailand
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/AroHa.jpg") + "'</body></html>"; //For the second picture which is Aro Ha, Glenorchy, New Zealand
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/RAKxaBangkok.jpg") + "'</body></html>"; //For the third picture  which is RAKxa Wellness, Bangkok, Thailand
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/GoldenDoor.jpg") + "'</body></html>"; //For the fourth picture which is Golden Door, San Marcos, California, United States
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Ananda.jpg") + "'</body></html>"; //For the fifth picture which is Ananda in the Himalayas, Rishikesh, india
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 The Kamalaya Wellness Retreat.</font> <br>famous for its beautiful property and holistic treatments such as Ayurveda, Naturopathy and Traditional Chinese Medicine.</body></html>"; //For the first destination which is Kamalaya, Koh Samui, Thailand
		} else if (i==2){
			text = "<html><body><font size='5'>#2 The Aro Ha Wellness Retreat.</font> <br>intimate eco-friendly retreat surrounded by 8.5 hectares of rugged New Zealand landscape overlooking Lake Wakatipu.</body></html>"; //For the second destination which is Aro Ha, Glenorchy, New Zealand
		} else if (i==3){
			text = "<html><body><font size='5'>#3 The RAKxa Wellness Retreat.</font> <br>nestled along the Chao Phraya River, considered the ‘Green Lung’ of Bangkok.</body></html>"; //For the third destination  which is RAKxa Wellness, Bangkok, Thailand
		} else if (i==4){
			text = "<html><body><font size='5'>#4 The Golden Door Wellness Retreat.</font> <br>Surrounded by 600 acres of rolling hills and hiking trails, Golden Door is just a 40-minute drive north of San Diego.</body></html>"; //For the fourth destination which is Golden Door, San Marcos, California, United States
		} else if (i==5){
			text = "<html><body><font size='5'>#5 The Ananda Wellness Retreat.</font> <br>Located at the foothills of the Himalayas, Ananda is possibly the most authentic Ayurvedic luxury wellness destination in India.</body></html>"; //For the fifth destination which is Ananda in the Himalayas, Rishikesh, india
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}