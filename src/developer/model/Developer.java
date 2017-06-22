package developer.model;

/**
 * Created by Zver on 20.06.2017.
 */
    public class Developer {
        private long id;
        private String firstName;
        private String secondName;
        private String speciality;
        private int salary;

    public Developer(long id, String firstName, String secondName, String speciality, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.speciality = speciality;
        this.salary = salary;
    }

    public Developer(){

        }

        @Override
        public String toString() {
            return "Developer{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", speciality='" + speciality + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }
    }


