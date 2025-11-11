public class StudentValidator {

    public static void validateAge(int age) throws StudentException {
        if (age < 18 || age > 60) {
            throw new StudentException("Invalid Age! Age must be between 18 and 60.");
        }
    }

    public static void validateDept(String dept) throws StudentException {

        String[] validDepts = { "cse", "ict", "te", "me" };
        boolean found = false;

        for (String d : validDepts) {
            if (d.equalsIgnoreCase(dept)) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new StudentException("Invalid Department! Allowed: cse, ict, te, me");
        }
    }
}
