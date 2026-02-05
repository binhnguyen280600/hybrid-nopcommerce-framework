package employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.util.List;

public class EmployeeData {
    @JsonProperty("name")
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("position")
    private String position;

   @JsonProperty("address")
    private String address;

    public static EmployeeData getEmployee() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "Employee.json"), EmployeeData.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkillTree() {
        return skillTree;
    }

    public void setSkillTree(List<String> skillTree) {
        this.skillTree = skillTree;
    }

    @JsonProperty("skilltree")
    private List<String> skillTree;

    public static class getAddress {
        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public void setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
        }

        @JsonProperty("street")
        private String streetName;

        @JsonProperty("streetNo")
        private String streetNumber;
    }


}
