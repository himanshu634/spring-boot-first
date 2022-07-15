package com.example.SpringBootBasics.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    // These are the validation Annotations that we can use to validate the inputs from user
    //    @Email
    //    @Negative
    //    @NegativeOrZero
    //    @Positive
    //    @PositiveOrZero
    //    @Length(max = 40, min = 2)
    //    @Size(max = 40, min = 3)
    //    @Future
    //    @FutureOrPresent
    //    @Past
    //    @PastOrPresent
    //    @Pattern(regexp = "")
    @NotBlank(message = "Please enter department name.")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    // we can use lomboks @Getter, @Setter, @AllArgsConstructor, @NoArgsConstructor, @Data, @Builder to generate these
    // kind of methods. whereas @Data is used to generate getters of all the fields and setters of all the fields.

//    public Long getDepartmentId() {
//        return departmentId;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }
//
//    public void setDepartmentId(Long departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
//
//        this.departmentId = departmentId;
//        this.departmentName = departmentName;
//        this.departmentAddress = departmentAddress;
//        this.departmentCode = departmentCode;
//    }
//
//    public Department() {
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
}
