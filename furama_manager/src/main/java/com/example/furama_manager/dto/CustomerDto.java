package com.example.furama_manager.dto;

import com.example.furama_manager.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {
    private int id;
    @NotBlank(message = "Không để trống")
    @Pattern(regexp = "^\\p{Lu}\\p{L}+(\\s\\p{Lu}\\p{L}*)+$", message = "Phải viết hoa đầu mỗi chữ")
    private String name;

    private String dayOfBirth;

    private boolean gender;

    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "Sai dịnh dạng (9 hoặc 12 số)")
    private String idCard;
    @Pattern(regexp = "^((090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|(\\(84\\)\\+91[0-9]{7}))$", message = "Sai định dạng (090, 091, (84)+90, (84)+91)")
    private String phoneNumber;
    @Pattern(regexp = "^[\\w.+\\-]+@gmail\\.com$", message = "Sai định dạng (@gmail.com)")
    private String email;
    private String address;
    private boolean deleted;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String dayOfBirth, boolean gender, String idCard,
                       String phoneNumber, String email, String address, boolean deleted, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.deleted = deleted;
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String dateOfBirth = customerDto.getDayOfBirth();
        if (!dateOfBirth.isEmpty()){
            LocalDate birth = LocalDate.parse(dateOfBirth);
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birth, currentDate).getYears();

            if (age < 18){
                errors.rejectValue("dayOfBirth", "error123", "Bạn dưới 18 tuổi");
            } else if (age > 100) {
                errors.rejectValue("dayOfBirth", "error123323", "Tuổi không hợp lệ > 100 tuổi");
            }
        } else {
            errors.rejectValue("dayOfBirth", "error1233", "Ngày sinh không được để trống");
        }
    }
}
