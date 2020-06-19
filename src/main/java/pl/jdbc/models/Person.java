package pl.jdbc.models;

import java.util.Objects;

public class Person {
    private final int personId;
    private final String personName;
    private final String addressLine1;
    private final String addressLine2;
    private final String city;
    private final String postalCode;
    private final String country;

    public Person(int personId,
                  String personName,
                  String addressLine1,
                  String addressLine2,
                  String city,
                  String postalCode,
                  String country) {
        this.personId = personId;
        this.personName = personName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }


    public int getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return personId == person.personId &&
                personName.equals(person.personName) &&
                addressLine1.equals(person.addressLine1) &&
                Objects.equals(addressLine2, person.addressLine2) &&
                city.equals(person.city) &&
                postalCode.equals(person.postalCode) &&
                country.equals(person.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personName, addressLine1, addressLine2, city, postalCode, country);
    }


    public static class Builder {
        private final int personId;
        private final String personName;
        private String addressLine1 = "";
        private String addressLine2 = "";
        private String city = "";
        private String postalCode = "";
        private String country = "";

        public Builder(int personId, String personName) {
            this.personId = personId;
            this.personName = personName;
        }


        public Builder addressLine1(String address) {
            this.addressLine1 = address;
            return this;
        }

        public Builder addressLine2(String address) {
            this.addressLine2 = address;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Person build() {
            Person person = new Person(this.personId, this.personName, this.addressLine1, this.addressLine2, this.city, this.postalCode, this.country);

            return person;
        }
    }
}
