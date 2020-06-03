package Chapter4.Additional4point2;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
public class Addrequest extends MouseAdapter implements ActionListener
{
    JFrame jf_AddContact, jf_ViewContact;
    JTextField txt_name;
    JTextArea txt_cno;
    JLabel lbl_name, lbl_cno, name, no, lbl_ct;
    JButton btn_add;
    JList jl_contact;
    JScrollPane scroll;
    DefaultListModel dlm_contact;

    //Collection Variable
    ArrayList<Request> contactList;

    public Addrequest()
    {
        txt_name = new JTextField();
        txt_cno = new JTextArea();
        lbl_name = new JLabel("Enter Name:");
        lbl_cno = new JLabel("Enter details:");
        lbl_ct = new JLabel("Details:");
        btn_add = new JButton("Add");
        jl_contact = new JList();
        jl_contact.addMouseListener(this);
        dlm_contact = new DefaultListModel();

        //Collection Initialization
        contactList = new ArrayList<Request>();

        btn_add.addActionListener(this);

    }

    public void addComponentToAdd()
    {
        jf_AddContact = new JFrame("Log requests or issues");
        jf_AddContact.setLayout(null);
        jf_AddContact.setSize(300, 220);
        jf_AddContact.setVisible(true);
        jf_AddContact.setLocationRelativeTo(null);

        lbl_name.setBounds(10, 20, 100, 20);
        jf_AddContact.add(lbl_name);

        txt_name.setBounds(120, 20, 150, 20);
        jf_AddContact.add(txt_name);

        lbl_cno.setBounds(10, 70, 100, 20);
        jf_AddContact.add(lbl_cno);

        txt_cno.setBounds(120, 70, 150, 60);
        jf_AddContact.add(txt_cno);

        btn_add.setBounds(120, 140, 100, 25);
        jf_AddContact.add(btn_add);

        jf_AddContact.setResizable(false);
    }

    public void addComponentToView()
    {
        jf_ViewContact = new JFrame("View details");
        jf_ViewContact.setLayout(null);
        jf_ViewContact.setSize(300, 220);
        jf_ViewContact.setVisible(true);
        jf_ViewContact.setLocationRelativeTo(null);

        jl_contact.setModel(dlm_contact);
        scroll = new JScrollPane(jl_contact);

        lbl_ct.setBounds(10, 20, 100, 20);
        jf_ViewContact.add(lbl_ct);

        scroll.setBounds(10, 50, 265, 100);
        jf_ViewContact.add(scroll);

    }

    public void actionPerformed(ActionEvent ae)
    {
        //Action Performed Event
        String name = txt_name.getText();
        String cno = txt_cno.getText();

        if (name.equals("") || cno.equals("")) {
            JOptionPane.showMessageDialog(jf_AddContact, "Please fill the details properly",
                    "Warning Message", JOptionPane.WARNING_MESSAGE);
        }
        else{
            Request obj = new Request();
            obj.setName(name);
            obj.setNo(cno);

            contactList.add(obj);
            ArrayList<Request> tempList = new ArrayList<Request>(contactList);
            //Collections.sort(tempList, new NameSort());
            dlm_contact.removeAllElements();
            for (Request c : tempList) {
                dlm_contact.addElement(c);
            }
            txt_name.setText("");
            txt_cno.setText("");

            JOptionPane.showMessageDialog(jf_AddContact, "Details has been added",
                    "Success Message", JOptionPane.INFORMATION_MESSAGE);

            int status = JOptionPane.showConfirmDialog(jf_AddContact, "Do you want to add more details?",
                    "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (status == 0) {
                jf_AddContact.setVisible(true);
            }
            else{
                jf_AddContact.dispose();
            }
        }

    }

    public void mouseClicked(MouseEvent e)
    {
        //Mouse Clicked Event
        if (e.getSource() == jl_contact) {
            JList l = (JList)e.getSource();
            if (e.getClickCount() == 2) {
                Request o = (Request)l.getSelectedValue();
                if (o != null) {
                    String name = o.getName();
                    String no = o.getNo();
                    String info = "Employee Name is: "+name+"\nRequest or issues details are: "+no;
                    JOptionPane.showMessageDialog(jf_AddContact,info,"Employee Details",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }


}