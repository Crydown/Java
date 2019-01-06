/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author Ciprian
 */

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

class Fereastra extends Frame implements ActionListener, ItemListener, TextListener{
    
    private Label label1, label2;
	private Checkbox cbx1, cbx2, cbx3;
        private Label label3, label4;
	private Choice culori;
        private CheckboxGroup cbg;
        private List culori2;
        
        private Scrollbar scroll;
	private Label valoare;
        
        private TextField nume, parola;
	private Label acces;
	private static final String UID="Ion", PWD="java" ;
        
        
        private TextArea text;
	private TextField nume2;
	private Button save;
        
	public Fereastra(String titlu) {
		super(titlu);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
        	
        
        public void initializare() {
		setLayout(new GridLayout(10, 2));
                
 
               JPanel p = new JPanel();
                p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
                
                JPanel p3 = new JPanel();
                p3.setLayout(new BoxLayout(p3, BoxLayout.PAGE_AXIS));
                
                JPanel p4 = new JPanel();
                p4.setLayout(new BoxLayout(p4, BoxLayout.PAGE_AXIS));
                               
                
                
                Button b1 = new Button("OK");
		b1.setBounds(30, 30, 50, 70);
		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.setBackground(java.awt.Color.orange);
		add(b1);
                
                Button b2 = new Button("Cancel");
		b2.setBounds(100, 30, 70, 50);
		b2.setForeground(java.awt.Color.blue);
		add(b2);
              

                
		label1 = new Label("Ingrediente Pizza:", Label.CENTER);
                label1.setBounds(100, 30, 50, 70);
		label1.setBackground(Color.orange);
		label2 = new Label("");
		label2.setBackground(Color.lightGray);

		cbx1 = new Checkbox("cascaval");
                cbx1.setBounds(30, 30, 50, 70);
		cbx2 = new Checkbox("sunca");
                cbx2.setBounds(30, 30, 50, 70);
		cbx3 = new Checkbox("ardei");
                cbx3.setBounds(30, 30, 50, 70);
                
                
                
                
                
                
                label3 = new Label("Alegeti culoarea");
		label3.setBackground(Color.red);
                
                label4 = new Label("Alegeti culoarea", Label.CENTER);
		label4.setBackground(Color.red);
                

		culori = new Choice();
		culori.add("Rosu");
		culori.add("Verde");
		culori.add("Albastru");
		culori.select("Rosu");
                
                
                
               
                
                culori2 = new List(3);
		culori2.add("Rosu2");
		culori2.add("Verde2");
		culori2.add("Albastru2");
		culori2.select(3);
                

//              add(label3);
//		add(culori);
                
                p.add(label3);
                p.add(culori);
                add(p);
                
                p3.add(label1);
                p3.add(label2);
                p3.add(cbx1);
                p3.add(cbx2);
                p3.add(cbx3);
                add(p3);
                
                
                
//		add(label1);
//                add(label2);
//		add(cbx1);
//		add(cbx2);
//		add(cbx3);
                add(label4);
                add(culori2);
                
                
                
                
                //ScrollBar
                valoare = new Label("", Label.CENTER);
		valoare.setBackground(Color.lightGray);

		scroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 101);
		add(valoare);
		add(scroll);
                
                //TextField
                
                nume = new TextField("", 30);
		parola = new TextField("", 10);
		parola.setEchoChar('*');
		
                
                //TextArea
                text = new TextArea("", 30, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
		nume2 = new TextField("", 12);
		save = new Button("Salveaza text");
		save.setActionCommand("save");
		save.setEnabled(false);
		
		Panel fisier = new Panel();
		fisier.add(new Label("Fisier:"));
		fisier.add(nume2);
		
                p4.add(nume2);
                p4.add(save);
                p4.add(text);
                
                
                
//		add(fisier, BorderLayout.NORTH);
//		add(text, BorderLayout.CENTER);
//		add(save, BorderLayout.SOUTH);
                
                
		Panel p1 = new Panel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(new Label("Nume:"));
		p1.add(nume);
		
                
//		Panel p2 = new Panel();
//		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
//		p2.add(new Label("Parola:"));
//		p2.add(parola);
                
                acces = new Label("Introduceti numele si parola!", Label.CENTER);

                p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(new Label("Parola:"));
		p1.add(parola);
                p1.add(acces);
		
		
		add(p1);
                add(p4);
//		add(p2);
//		add(acces);
                
                
                
		pack();
		setSize(1000, 1000);

		cbx1.addItemListener(this);
		cbx2.addItemListener(this);
		cbx3.addItemListener(this);
                b1.addActionListener(this);
		b2.addActionListener(this);
                culori.addItemListener(this);
                culori2.addItemListener(this);
            //    scroll.addAdjustmentListener(this);
               
               nume.addTextListener(this);
               parola.addTextListener(this);
               
               text.addTextListener(this);
	       save.addActionListener(this);
	}
        //metoda interfetei ActionListener
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(e.toString());
		if (command.equals("OK"))
			setTitle("Confirmare!");
		if (command.equals("Cancel"))
			setTitle("Anulare!");
            
                //TextArea
                String continut = text.getText();
		int len = continut.length();
		char buffer[] = new char[len];
		
		try {
			FileWriter out = new FileWriter(nume.getText());
			continut.getChars(0, len-1, buffer, 0);
			out.write(buffer);
			out.close();
			text.requestFocus();
		} 
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
        
        
        //metoda interfetei ActionListener
	
        
        
        //metoda interfetei ItemListener
	public void itemStateChanged(ItemEvent e) {
            
            
                switch (culori2.getSelectedIndex()) {
			case 0:
				label4.setBackground(Color.red);
				break;
			case 1:
				label4.setBackground(Color.green);
				break;
			case 2:
				label4.setBackground(Color.blue);
		}
            
            
            
		StringBuffer ingrediente = new StringBuffer();
		if (cbx1.getState() == true)
			ingrediente.append(" cascaval ");
		if (cbx2.getState() == true)
			ingrediente.append(" sunca ");
		if (cbx3.getState() == true)
			ingrediente.append(" ardei ");
		label2.setText(ingrediente.toString());
                
                switch (culori.getSelectedIndex()) {
			case 0:
				label3.setBackground(Color.red);
				break;
			case 1:
				label3.setBackground(Color.green);
				break;
			case 2:
				label3.setBackground(Color.blue);
                
                
	}   
                
                
           
}
        //metoda interfetei ItemListener
	public void adjustmentValueChanged(AdjustmentEvent e) {
		valoare.setText(scroll.getValue() + " %");
	}

    //metoda interfetei TextListener
	public void textValueChanged(TextEvent e) {
            
                if ((text.getText().length() == 0) || (nume2.getText().length() == 0))
			save.setEnabled(false);
		else
			save.setEnabled(true);
                
            
		if ((nume.getText().length() == 0) ||(parola.getText().length() == 0)) {
			acces.setText("");
			return;
		}
		if ((nume.getText().equals(UID)) && (parola.getText().equals(PWD)))
			acces.setText("Acces permis!");
		else	
			acces.setText("Acces interzis!");
                
                
                
		
	}
    
    
}

public class TestButton {
	public static void main(String args[]) {
		Fereastra f = new Fereastra("Button");
		f.initializare();
		f.show();
	}
}



