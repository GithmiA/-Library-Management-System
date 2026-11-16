package model;

public class MemberDTO {

    private String memberId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;


    public MemberDTO() {

    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return memberId + " -" + fullName;
    }
}
