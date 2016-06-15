/**
 * @author ${Polykarpos Tiftikoglou}
 *
 */
package factorization;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Color;

public class Final1 {

	private JFrame frame;
	private JTextField factor;
	private JLabel answer;
	ArrayList<Long> answer_  = new ArrayList<>();
	JProgressBar progressBar;
	private JButton btnCansel;
	private JLabel lblAnser;
	BigBlackBox1 bbb1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final1 window = new Final1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Final1() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		factor = new JTextField();
		factor.setBounds(145, 11, 86, 20);
		frame.getContentPane().add(factor);
		factor.setColumns(10);
		
		JLabel lblFindFactorization = new JLabel("Find Factorization");
		lblFindFactorization.setBounds(38, 14, 113, 14);
		frame.getContentPane().add(lblFindFactorization);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) 
			{
				progressBar.setIndeterminate(true);
			    bbb1=new BigBlackBox1();
		        bbb1.execute();
			}
		});
		btnStart.setBounds(142, 42, 89, 23);
		frame.getContentPane().add(btnStart);
		
		answer = new JLabel("");
		answer.setBackground(Color.WHITE);
		answer.setForeground(Color.RED);
		answer.setBounds(64, 76, 330, 14);
		frame.getContentPane().add(answer);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 236, 414, 14);
		frame.getContentPane().add(progressBar);
		
		btnCansel = new JButton("Cansel");
		btnCansel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				progressBar.setIndeterminate(false);
				bbb1.cancel(true);
			}
		});
		btnCansel.setBounds(145, 202, 89, 23);
		frame.getContentPane().add(btnCansel);
		
		lblAnser = new JLabel("Answer :");
		lblAnser.setBounds(10, 76, 63, 14);
		frame.getContentPane().add(lblAnser);
	}
	
	public class BigBlackBox1 extends SwingWorker<Integer, Object> 
	{
	    public int doSomeWork()
	    {
	    	
	        return 1;
	    }

	    @Override
	    protected Integer doInBackground() throws FileNotFoundException, InterruptedException 
	    {
	    	answer.setText("");
	    	int num = Integer.parseInt( factor.getText());
	    	factorization(num);
	    	answer.setText(""+answer_);
	    	progressBar.setIndeterminate(false);
		  return 0;
	    }
	}
	
	protected void factorization(long number) throws InterruptedException
	{
		
		answer_.clear();
        for (long i = 2, limit = (long)Math.ceil(Math.sqrt(number)); i <= limit; ) {
            if (number % i == 0) 
            {
				Thread.sleep(100);
                number = number / i;
                limit = (int)Math.ceil(Math.sqrt(number));
                System.out.println(i+" ");
                answer_.add(i);
            }
            else {
                i++;
            }
        }
        if (number > 1)  answer_.add(number);
	}
}
