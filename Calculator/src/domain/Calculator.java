/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author korisnik
 */
public class Calculator extends JFrame{
    JPanel panel = new JPanel();
    GroupLayout layout = new GroupLayout(panel);
    
   int a = 0;
   int b = 0;
    JTextField txta = new JTextField();
    JTextField txtb = new JTextField();
    JTextField txtc = new JTextField();
    
    JLabel lbla = new JLabel("a: ");
    JLabel lblb = new JLabel("b: ");
    JLabel lblc = new JLabel("Result: ");
    
    JButton btnSum = new JButton("+");
    JButton btnSub = new JButton("-");
    
    
    
    public Calculator() throws HeadlessException {
        setResizable(false);
        
        lbla.setFont(new Font("Arial", Font.BOLD, 13));
        lblb.setFont(new Font("Arial", Font.BOLD, 13));
        lblc.setFont(new Font("Arial", Font.BOLD, 13));
        txta.setPreferredSize(new Dimension(30,20));
        setPreferredSize(new Dimension(300,200));
        setVisible(true);
        this.add(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        GroupLayout.SequentialGroup sq = layout.createSequentialGroup();
        sq.addGroup(layout.createParallelGroup().addComponent(lbla).addComponent(lblb).addComponent(lblc)
        .addComponent(btnSum));
        sq.addGroup(layout.createParallelGroup().addComponent(txta).addComponent(txtb).addComponent(txtc)
                .addComponent(btnSub));
        layout.setHorizontalGroup(sq);
        
        
        GroupLayout.SequentialGroup sq1 = layout.createSequentialGroup();

        panel.setLayout(layout);
        
        
   sq1.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(lbla).addComponent(txta));
   sq1.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(lblb).addComponent(txtb));
   sq1.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(lblc).addComponent(txtc));
   
   sq1.addGroup(layout.createParallelGroup(Alignment.BASELINE).
            addComponent(btnSum).addComponent(btnSub));
   
   layout.setVerticalGroup(sq1);
   txtc.setEditable(false);
//txta.setText("5");
//txtb.setText("5");

   if(!txta.getText().isEmpty())
   a = Integer.parseInt(txta.getText());
   if(!txtb.getText().isEmpty())
   b = Integer.parseInt(txtb.getText());
   
   
   
    btnSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            boolean lettersA = txta.getText().matches(".*[a-zA-Z]+.*");
            boolean lettersB = txtb.getText().matches(".*[a-zA-Z]+.*");
            if(lettersA || lettersB) 
            JOptionPane.showMessageDialog(null, "Wrong input", "Error", JOptionPane.ERROR_MESSAGE);
            if(!txta.getText().isEmpty() && !lettersA)
            a = Integer.parseInt(txta.getText());
            if(!txtb.getText().isEmpty() && !lettersB)
            b = Integer.parseInt(txtb.getText());
            if(!lettersA && !lettersB)
            txtc.setText((a+b)+"");
            
                
            }
        });
    
    btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            boolean lettersA = txta.getText().matches(".*[a-zA-Z]+.*");
            boolean lettersB = txtb.getText().matches(".*[a-zA-Z]+.*");
            if(lettersA || lettersB) 
            JOptionPane.showMessageDialog(null, "Wrong input", "Error", JOptionPane.ERROR_MESSAGE);
            if(!txta.getText().isEmpty() && !lettersA)
            a = Integer.parseInt(txta.getText());
            if(!txtb.getText().isEmpty() && !lettersB)
            b = Integer.parseInt(txtb.getText());
            if(!lettersA && !lettersB)
            txtc.setText((a-b)+"");    
            
            
            
            }
        });
   
   
   
   
        pack();
        setLocationRelativeTo(null);
    }
    
    
    
    
    
    
    
    
    
}
