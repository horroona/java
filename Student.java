/**
 * Created by Haroon Baloch on 12/14/17.
 */
public class Student {

    private String CNIC;
    private String Name;
    private String Address;
    private String PhoneNumber;
    private String ShiftTime;

    Student() {
    }

    //parametric constructor
    Student(String cnic, String name, String address, String phoneNumber, String shiftTime) {
        this.CNIC = cnic;
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.ShiftTime = shiftTime;
    }

    public void setCNIC(String cnic) {
        this.CNIC = cnic;
    }

    public String getCNIC() {
        return this.CNIC;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.PhoneNumber;
    }

    public void setShiftTime(String time) {
        this.ShiftTime = time;
    }

    public String getShiftTime(){
        return this.ShiftTime;
    }


}
