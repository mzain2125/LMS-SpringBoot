package com.lms.test.request;

import com.lms.test.enums.Department;
import com.lms.test.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class TeacherRequest {
        @NotBlank(message = "Name is required")
        private String name;

        @Email(message = "Invalid email")
        @NotBlank(message = "Email is required")
        private String email;

        @NotNull(message = "Status is required")
        private Status status;

        @NotBlank(message = "Qualification is required")
        private String qualification;

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "\\d{11,}", message = "Phone number must be 11 digits")
        private String phoneNumber;

        @NotNull(message = "Department is required")
        private Department department;

        @NotBlank(message = "Subject is required")
        private String subject;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public Status getStatus() { return status; }
        public void setStatus(Status status) { this.status = status; }

        public String getQualification() { return qualification; }
        public void setQualification(String qualification) { this.qualification = qualification; }

        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

        public Department getDepartment() { return department; }
        public void setDepartment(Department department) { this.department = department; }

        public String getSubject() { return subject; }
        public void setSubject(String subject) { this.subject = subject; }


}
