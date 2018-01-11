
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Haroon Baloch on 12/12/17.
 */
public class GUI extends DataBase implements ActionListener {

    //time is being kept in string array and putting it into comboBox
    String[] TimeList = {"7:30AM", "8:00AM", "11:00AM"};

    JComboBox comboBox = new JComboBox(TimeList);

    JFrame frame;
    JLabel SelectTime = new JLabel("Select Shift-Time");

    JLabel CNIC = new JLabel("CNIC: ");
    JTextArea newCNICT = new JTextArea(30, 10);

    JLabel Name = new JLabel("Name: ");
    JTextArea newNameT = new JTextArea(30, 10);

    JLabel Address = new JLabel("Address: ");
    JTextArea newAddressT = new JTextArea(30, 10);

    JLabel PhoneNumber = new JLabel("Phone No: ");
    JTextArea newPhoneNumberT = new JTextArea(30, 10);

    JLabel searchByCNIC = new JLabel("CNIC:");
    JTextArea searchCNICText = new JTextArea(30, 10);

    JLabel changeByCNIC = new JLabel("CNIC ");
    JTextArea changeByCNICT = new JTextArea(30, 10);

    JLabel addTime = new JLabel("AddTime");
    JComboBox newTimecomboBox = new JComboBox(TimeList);

    JLabel changeTime = new JLabel("Change-Time");
    JComboBox changeTimecomboBox = new JComboBox(TimeList);

    JLabel deleteCNIClabel = new JLabel("CNIC: ");
    JTextArea deleteCNICText = new JTextArea(30, 10);

    JButton deleteButton = new JButton("Delete: ");
    JButton addNewButton = new JButton("Add above Data");
    JButton viewListButton = new JButton("View_List");
    JButton searchButton = new JButton("SearchByCNIC");
    JButton changeByCNICButton = new JButton("Change-By CNIC");

    JPanel panel;

    GUI() {
        frame = new JFrame("Pick & Drop Service");
        panel = new JPanel();

        panel.setLayout(null);

        SelectTime.setBounds(80, 40, 120, 20);
        panel.add(SelectTime);

        panel.add(comboBox);
        comboBox.setBounds(180, 40, 90, 20);

        viewListButton.setBounds(280, 40, 100, 20);
        panel.add(viewListButton);
        viewListButton.addActionListener(this);

        CNIC.setBounds(30, 130, 60, 20);
        panel.add(CNIC);

        Name.setBounds(30, 160, 60, 20);
        panel.add(Name);

        Address.setBounds(30, 190, 60, 20);
        panel.add(Address);

        PhoneNumber.setBounds(30, 220, 60, 20);
        panel.add(PhoneNumber);

        addTime.setBounds(30, 250, 60, 20);
        panel.add(addTime);
        //setting JTextAreas
        newCNICT.setBounds(100, 130, 100, 20);
        panel.add(newCNICT);

        newNameT.setBounds(100, 160, 100, 20);
        panel.add(newNameT);

        newAddressT.setBounds(100, 190, 100, 20);
        panel.add(newAddressT);

        newPhoneNumberT.setBounds(100, 220, 100, 20);
        panel.add(newPhoneNumberT);

        newTimecomboBox.setBounds(100, 250, 100, 20);
        panel.add(newTimecomboBox);

        addNewButton.setBounds(30, 290, 180, 25);
        panel.add(addNewButton);
        addNewButton.addActionListener(this);

        //adding search field
        searchByCNIC.setBounds(30, 350, 70, 20);
        panel.add(searchByCNIC);

        searchCNICText.setBounds(80, 350, 125, 20);
        panel.add(searchCNICText);

        searchButton.setBounds(30, 380, 180, 20);
        panel.add(searchButton);
        searchButton.addActionListener(this);

        changeByCNIC.setBounds(30, 410, 70, 20);
        panel.add(changeByCNIC);

        changeByCNICT.setBounds(80, 410, 125, 20);
        panel.add(changeByCNICT);

        changeTime.setBounds(30, 440, 100, 20);
        panel.add(changeTime);

        changeTimecomboBox.setBounds(120, 440, 90, 20);
        panel.add(changeTimecomboBox);

        changeByCNICButton.setBounds(30, 480, 180, 20);
        panel.add(changeByCNICButton);
        changeByCNICButton.addActionListener(this);

        deleteCNIClabel.setBounds(240, 130, 60, 20);
        panel.add(deleteCNIClabel);

        deleteCNICText.setBounds(290, 130, 100, 20);
        panel.add(deleteCNICText);

        deleteButton.setBounds(290, 160, 100, 20);
        panel.add(deleteButton);
        deleteButton.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(450, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DataBase dataBase = new DataBase();

        if (actionEvent.getSource() == addNewButton) {
            String cnic = newCNICT.getText();
            String name = newNameT.getText();
            String address = newAddressT.getText();
            String phone = newPhoneNumberT.getText();
            String time = (String) newTimecomboBox.getSelectedItem();

            if (cnic.equals("") || name.equals("") || address.equals("") || phone.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Complete data");
            } else {

                if (dataBase.search(cnic).getCNIC().equals("")) {

                    dataBase.addRecord(cnic, name, address, phone, time);
                    JOptionPane.showMessageDialog(null, "\nData has been added\n");

                } else {
                    JOptionPane.showMessageDialog(null, "Data already exists with this CNIC");

                }
            }
        }
        if (actionEvent.getSource() == searchButton) {
            String NIC = searchCNICText.getText();
            if (NIC.equals("")) {
                JOptionPane.showMessageDialog(null, "-Please enter CNIC-");
            } else {

                if (dataBase.search(NIC).getCNIC().equals("")) {
                    JOptionPane.showMessageDialog(null, "-Record not found-");
                } else {
                    JOptionPane.showMessageDialog(null, "CNIC: " + dataBase.search(NIC).getCNIC() + "\nName: " + dataBase.search(NIC).getName() + "\nAddress: " + dataBase.search(NIC).getAddress()
                            + "\nPhone Number: " + dataBase.search(NIC).getPhoneNumber() + "\nShiftTime: " + dataBase.search(NIC).getShiftTime());
                }
            }

        }

        if (actionEvent.getSource() == viewListButton) {

            showTable();

        }

        if (actionEvent.getSource() == deleteButton) {
            if (deleteCNICText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, " Enter CNIC ");
            } else {
                if (dataBase.DeleteRecord(deleteCNICText.getText()).equals(true)) {
                    JOptionPane.showMessageDialog(null, "...Record has been deleted...");
                }
                if (dataBase.DeleteRecord(deleteCNICText.getText()).equals(false)) {
                    JOptionPane.showMessageDialog(null, " Record not found for deletion ");
                }
            }
        }

    }

    private void showTable() {
        DataBase obj = new DataBase();
        JFrame tableFrame = new JFrame("dataBase Record");
        tableFrame.setSize(400, 500);
        String[] columsName = {"CNIC", "Name", "Address", "PhoneNumber", "ShiftTime"};
        String[][] Rows = {{data.get(0).getCNIC(), data.get(0).getName(), data.get(0).getAddress(), data.get(0).getPhoneNumber(), data.get(0).getShiftTime()}, {data.get(1).getCNIC(), data.get(1).getName(), data.get(1).getAddress(), data.get(1).getPhoneNumber(), data.get(1).getShiftTime()}};
        JTable table = new JTable(Rows, columsName);
        JScrollPane scrollPane =new JScrollPane(table);
        tableFrame.add(scrollPane);
        tableFrame.setVisible(true);
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i =0; i<7; i++)
        {
            System.out.print(data.get(i).getName());
        }
    }
}
