import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Haroon Baloch on 12/14/17.
 */
public class DataBase extends Student {
    ArrayList<Student> data = new ArrayList<>();

    DataBase() {
        Student obj = new Student();

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String url = "jdbc:ucanaccess://dataBase.accdb";
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from studentRecord");
            while (resultSet.next()) {

                // System.out.print(resultSet.getString("Name")+"\nConstructor\n");
                obj.setCNIC(resultSet.getString("CNIC"));
                obj.setName(resultSet.getString("Name"));
                obj.setAddress(resultSet.getString("Address"));
                obj.setPhoneNumber(resultSet.getString("Phone"));
                obj.setShiftTime(resultSet.getString("ShiftTime"));

                data.add(obj);

            }
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        } catch (SQLException e) {
            System.out.print("Problem in connection");
        }
    }

    //this function will add the data
    public void addRecord(String cnic, String name, String address, String phone, String time) {

            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url = "jdbc:ucanaccess://dataBase.accdb";
                Connection con = DriverManager.getConnection(url);
                String sql = "INSERT INTO studentRecord(CNIC,Name,Address,Phone,ShiftTime) Values('" + cnic + "','" + name + "','" + address + "','" + phone + "','" + time + "')";
                PreparedStatement pstmnt = con.prepareStatement(sql);
                pstmnt.executeUpdate();
                System.out.print("\nData has been added\n");
            } catch (Exception ex) {
                System.out.print(ex + "\nthis is IN ADD function");
            }

    }

    //this function return search object
    public Student search(String cnic) {
        Student student = new Student();
        for (Student obj : data) {
            if (cnic.equals(obj.getCNIC())) {

                student.setCNIC(obj.getCNIC());
                student.setName(obj.getName());
                student.setAddress(obj.getAddress());
                student.setPhoneNumber(obj.getPhoneNumber());
                student.setShiftTime(obj.getShiftTime());

            }
            else {
                student.setCNIC("");
                student.setName("");
                student.setAddress("");
                student.setPhoneNumber("");
                student.setShiftTime("");
            }
        }
        System.out.print(data.get(0).getName());
        return student;
    }

    //this function delete record from ms access
    public Boolean DeleteRecord(String cnic) {

        boolean value = true;
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String url = "jdbc:ucanaccess://dataBase.accdb";
            Connection connection = DriverManager.getConnection(url);
            Statement stmnt = connection.createStatement();
            String sql = "delete from studentRecord where CNIC ='" + cnic + "' ";
            stmnt.executeUpdate(sql);

            stmnt.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            value = false;
        }

        return value;
    }

    //this function will change shift time
    public void changeShift(String shiftTime) {

    }
}
