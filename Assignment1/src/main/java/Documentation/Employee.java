package Documentation;
import Annotation.MethodDocumentation;
import Annotation.ClassDocumentation;


public class Employee {
/**
 * ClassManager to manage annotated classes.
 */


    /**
     * This is a class Employee.
     *
     * @ClassDocumentation "This is a class Employee with salary,pension "
     */

    @ClassDocumentation("This is a class Employee")
    public class Employee1 {

        /**
         * This is a method Employee inside Employee1.
         *
         * @MethodDocumentation "This is a method employeeId inside employee"
         */
        @MethodDocumentation("This is a method Employee1 inside Employee1"
        )
        public void EmployeeId() {
            System.out.println("This is the Employeeid");
        }

        /**
         *
         *
         * @MethodDocumentation "This is a method Employee inside Employeee1"
         */
        @MethodDocumentation("This is a method Employeee inside Employyyee1")
        public void Salary() {

            System.out.println("Hi this is salary");
        }

        @MethodDocumentation("This is a method pension inside employee1")
        public void pension() {

            System.out.println("This is pension ");
        }
        /**
         * Generate a report based on the annotated classes.
         *
         *
         */

        /**
         * This is a method attendance  inside  a class Employee1.
         *
         * @MethodDocumentation "This is a method pension  inside employee1"
         */
        public void attendance() {

            System.out.println("This is the attendance ");
        }
    }
}
