package Documentation;
import Annotation.MethodDocumentation;
import Annotation.ClassDocumentation;
/**
 * ClassManager to manage annotated classes.
 */
@ClassDocumentation("This is a class Manager ")
public class Manager {

    /**
     *
     * This is the Manager class
     *
     * @MethodDocumentation "Hi this is the method  Managing "
     */
    @MethodDocumentation("This is a method managing  inside Manager")
    public void Managing () {
        System.out.println("Manager");
    }

    /**
     * This is a method id  inside Manager managing .
     *
     * @MethodDocumentation "This is a method CB inside C"
     */
    @MethodDocumentation("This is a method CB inside C")
    public void id() {
        System.out.println("CB");
    }

    /**
     * This is a method salary .
     *
     * @MethodDocumentation "This is a method CC inside C"
     */
    @MethodDocumentation("This is a method salary inside manager")
    public void salary () {
        System.out.println("salary");
    }

    /**
     * This is a method salary inside Manager.
     *
     * @MethodDocumentation "This is a method salary  inside Manager"
     */
    @MethodDocumentation("This is a method pension inside manager")
    public void pension() {
        System.out.println("pension");
    }
}
