package nyc.c4q.unit5midunitassessment;

import java.util.List;

/**
 * Created by yokilam on 1/24/18.
 */

public class User {

    private PersonName name;
    private PersonAddress location;
    private String email;
    private String phone;
    private PersonPicture picture;

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public PersonName getName() {
        return name;
    }

    public PersonAddress getLocation() {
        return location;
    }

    public PersonPicture getPicture() {
        return picture;
    }

    public class PersonName {
        private String title;
        private String first;
        private String last;

        public String getTitle() {
            return title;
        }

        public String getFirst() {
            return first;
        }

        public String getLast() {
            return last;
        }
    }


    public class PersonAddress {
        private String street;
        private String city;
        private String state;
        private Integer postcode;

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public Integer getPostcode() {
            return postcode;
        }
    }


    public class PersonPicture {
        private String large;
        private String medium;
        private String thumbnail;

        public String getLarge() {
            return large;
        }

        public String getMedium() {
            return medium;
        }

        public String getThumbnail() {
            return thumbnail;
        }
    }
}
