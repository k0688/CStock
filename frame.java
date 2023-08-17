import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public class frame implements Runnable{
	
	public static JFrame window;
	public static JPanel panel;
	public static JTextField pathfield;
	public static JTextField filefield;
	public static JComboBox<String> fileformat;
	public static String path;
	
	@Override
	public void run()
	{
		window = CreateWindow();
		window.setVisible(true);
		path = "notpath";
		
	}
	public JFrame CreateWindow()
	{
		window = new JFrame();
		window.setSize(500, 500);
		window.setTitle("CStock");
		window.setDefaultCloseOperation(window.DISPOSE_ON_CLOSE);
		ImageIcon img = new ImageIcon("assets\\logoscreenshot.png");
		window.setIconImage(img.getImage());
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		panel = new JPanel();
		//panel.add(CreateFileNameTextField());
		//panel.add(CreatePathTextField());
		//panel.add(CreatePathButton("Path"));
		//panel.add(CreateFileTypeComboBox());
        panel.add(CreateLabel("List", 0, 0));
        panel.add(AddButton());
        panel.add(RemoveButton());
        panel.add(SetButton());
        panel.add(CreateToolBar());
		panel.setLayout(null);
		window.add(panel);
		return window;
	}


    public JButton AddButton()
    {
        JButton button = new JButton("Add");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame();
                frame.setSize(500, 200);
                frame.setTitle("CStock");
		        frame.setLocationRelativeTo(null);
		        frame.setResizable(false);
                frame.setVisible(true);
                JPanel jpanel = new JPanel();
                JLabel l1 = new JLabel("Name");
                l1.setBounds(50, 20, 50, 20);
                jpanel.add(l1);
                JTextField name = new JTextField();
                name.setBounds(50, 50, 100, 50);
                jpanel.add(name);
                JLabel l2 = new JLabel("Stock");
                l2.setBounds(200, 20, 50, 20);
                jpanel.add(l2);
                JTextField stock = new JTextField();
                stock.setBounds(200, 50, 100, 50);
                jpanel.add(stock);
                JButton submit = new JButton("Submit");
                submit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            master.WriteFile(name.getText(), Integer.parseInt(stock.getText()));
                            frame.setVisible(false);
                            frame.dispose();
                            window.setVisible(false);
                            window.dispose();
                            run();
                        } catch(Exception exception) {}
                    }
                });
                submit.setBounds(350, 50, 100, 50);
                jpanel.add(submit);
                jpanel.setLayout(null);
                frame.add(jpanel);
            }
        });
        button.setBounds(400, 0, 100, 50);
        return button;
    }

    public JButton RemoveButton()
    {
        JButton button = new JButton("Remove");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame();
                frame.setSize(500, 200);
                frame.setTitle("CStock");
		        frame.setLocationRelativeTo(null);
		        frame.setResizable(false);
                frame.setVisible(true);
                JPanel jpanel = new JPanel();
                JLabel l1 = new JLabel("Index");
                l1.setBounds(100, 20, 50, 20);
                jpanel.add(l1);
                JTextField index = new JTextField();
                index.setBounds(100, 50, 100, 50);
                jpanel.add(index);
                JButton submit = new JButton("Submit");
                submit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            master.RemoveFile(Integer.parseInt(index.getText()));
                            frame.setVisible(false);
                            frame.dispose();
                            window.setVisible(false);
                            window.dispose();
                            run();
                        } catch(Exception exception) {}
                    }
                });
                submit.setBounds(250, 50, 100, 50);
                jpanel.add(submit);
                jpanel.setLayout(null);
                frame.add(jpanel);
            }
        });
        button.setBounds(400, 50, 100, 50);
        return button;
    }

    public JButton SetButton()
    {
        JButton button = new JButton("Set");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame();
                frame.setSize(500, 200);
                frame.setTitle("CStock");
		        frame.setLocationRelativeTo(null);
		        frame.setResizable(false);
                frame.setVisible(true);
                JPanel jpanel = new JPanel();
                JLabel l1 = new JLabel("Index");
                l1.setBounds(50, 20, 50, 20);
                jpanel.add(l1);
                JTextField index = new JTextField();
                index.setBounds(50, 50, 100, 50);
                jpanel.add(index);
                JLabel l2 = new JLabel("Stock");
                l2.setBounds(200, 20, 50, 20);
                jpanel.add(l2);
                JTextField stock = new JTextField();
                stock.setBounds(200, 50, 100, 50);
                jpanel.add(stock);
                JButton submit = new JButton("Submit");
                submit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            master.SetStock(Integer.parseInt(index.getText()), Integer.parseInt(stock.getText()));
                            frame.setVisible(false);
                            frame.dispose();
                            window.setVisible(false);
                            window.dispose();
                            run();
                        } catch(Exception exception) {}
                    }
                });
                submit.setBounds(350, 50, 100, 50);
                jpanel.add(submit);
                jpanel.setLayout(null);
                frame.add(jpanel);
            }
        });
        button.setBounds(400, 100, 100, 50);
        return button;
    }
    public JLabel CreateLabel(String text, int x, int y)
    {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 30, 30);
        return label;
    }
    
    public JToolBar CreateToolBar()
    {
        JToolBar bar = new JToolBar();
        bar.setOrientation(1);
        bar.setFloatable(false);
        bar.setBounds(0, 30, 250, 470);
        ArrayList<String> arraylist = new ArrayList<String>();
        try {
            arraylist = UnpackToolBar();
        } catch(FileNotFoundException e) {}
        for(int i = 0; i < arraylist.size(); i++)
        {
            JLabel label = new JLabel(arraylist.get(i));
            bar.add(label);
        }
        return bar;
    }

    public ArrayList<String> UnpackToolBar() throws FileNotFoundException
    {
        File file = new File("stock.cstock");
        Scanner reader = new Scanner(file);
        String content = "";
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            content = content + data;
        }
        String[] parts = content.split("%");
        ArrayList<String> arraylist = new ArrayList<String>();
        for(int i = 1; i < parts.length; i += 2)
        {
            arraylist.add((i / 2 + 1) + "# " + parts[i] + " - " + parts[i + 1]);
        }
        reader.close();
        return arraylist;
    }
}
