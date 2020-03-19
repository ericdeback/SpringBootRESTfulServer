package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class DemoApplication {

	private static final String VERSION = "0.0.4";
	private static final String APPNAME = "Spring Boot RESTFul Server";

	public static void main(String[] args) {

/*		JFrame frame = new JFrame(APPNAME + " " + VERSION);
		GridBagConstraints c = new GridBagConstraints();
		frame.setLayout(new GridBagLayout());

		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 3;

		JButton ok_button = new JButton("Shutdown!");
		ok_button.setSize(new Dimension (50, 20));

		ok_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		frame.add(ok_button, c);
		frame.setPreferredSize(new Dimension (400, 200));
		frame.pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);*/


		SpringApplication.run(DemoApplication.class, args);

		//frame.setVisible(true);
	}
}
