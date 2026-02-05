package employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.util.List;

public class EmployeeList {
    @JsonProperty("employees")
    private List<Employee> employeeList;

    public List<Employee> getEmployee() {
        return employeeList;
    }
    public static EmployeeData getEmployeeList() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "EmployeeList.json"), EmployeeData.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static class Employee {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAgeNumber() {
            return ageNumber;
        }

        public void setAgeNumber(int ageNumber) {
            this.ageNumber = ageNumber;
        }

        @JsonProperty("email")
        private String email;

        @JsonProperty("age")
        private int ageNumber;
    }
}
