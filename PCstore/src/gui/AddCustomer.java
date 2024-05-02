package gui;

import controller.Backend_DAO_List;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddCustomer extends JFrame {



    private JButton jButtonOK;
    //todo
    private JButton jButtonSeelist;
    private JList<Customer> jlitcust;

    private JLabel  jLabelID;
    private JLabel  jLabelName;
    private JLabel  jLabelAddress;
    private JTextField    jTextFieldID;
    private JTextField   jTextFieldName;
    private JTextField   jTextFieldAddress;
    private JOptionPane   jOptionPane;

    Backend_DAO_List bdl = Backend_DAO_List.get();
    DefaultListModel   AllCustomerListModel;

    public AddCustomer() throws Exception {

        jButtonOK = new JButton("OK");
        //todo
        jButtonSeelist = new JButton("seeList");
        jlitcust = new JList();
        jLabelID = new JLabel("ID:");
        jLabelName = new JLabel("Name:");
        jLabelAddress = new JLabel("Address:");
        jTextFieldID = new JTextField();
        jTextFieldAddress = new JTextField();
        jTextFieldName = new JTextField();

        jOptionPane = new JOptionPane();
        jTextFieldID.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (!Character.isDigit(e.getKeyChar()) || jTextFieldID.getText().length()>=9)
                    e.consume();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        AllCustomerListModel =new DefaultListModel();


        jlitcust.setModel(AllCustomerListModel);
        RefreshCustomerList();
        jButtonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long id = Long.parseLong(jTextFieldID.getText().trim());
                    if (jTextFieldName.getText().isBlank())
                        throw new Exception("חובה להכניס שם");
                    if (bdl.getAllCustomers().containsKey(id))
                        throw new Exception("מספר זהות קיים במערכת");

                    Customer c = new Customer(id,jTextFieldName.getText(),jTextFieldAddress.getText());
                    bdl.AddCustomer(c);
                    System.out.println(bdl.getAllCustomers());
                    JOptionPane.showMessageDialog(AddCustomer.this,"הלקוח התווסף בהצלחה");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddCustomer.this,ex.getMessage());
                }
            }
        });

        //todo

        jButtonSeelist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RefreshCustomerList();
            }
        });

        getContentPane().add(jLabelID);
        getContentPane().add(jTextFieldID);
        getContentPane().add(jLabelAddress);
        getContentPane().add(jTextFieldAddress);
        getContentPane().add(jLabelName);
        getContentPane().add(jTextFieldName);
        getContentPane().add(jButtonOK);
        //
        getContentPane().add(jButtonSeelist);
        getContentPane().add(jlitcust);
        this.setPreferredSize(new Dimension(500, 300));
        getContentPane().setLayout(new GridLayout(0,2,10,10));

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();  // סידור הרכבים באופן פורפציונלי

    }
    public void RefreshCustomerList() {
        try {
            AllCustomerListModel.clear();
            AllCustomerListModel.addAll(bdl.getAllCustomers().values());
        } catch (Exception ex) {

        }
    }
}
