import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MegaCorpSearchJson {

    public static void main(String[] args) {
        String filePath = "megacorp_data.json";
        int targetId = 12;

        try {
            ObjectMapper mapper = new ObjectMapper();
            Department headOffice = mapper.readValue(new File(filePath), Department.class);

            System.out.println("Searching for Employee ID: " + targetId);
            boolean found = searchCompany(headOffice, targetId);

            if (!found) {
                System.out.println("Employee ID " + targetId + " not found in the company.");
            }

        } catch (IOException e) {
            System.err.println("Error reading or parsing file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --- RECURSIVE SEARCH ---
    // Rule: Check everywhere (Head Office -> SubDepartments)
    public static boolean searchCompany(Department dept, int id) {
        System.out.println("Checking Department: " + dept.name);

        // 1. Check Interns (Linear Search)
        if (linearSearch(dept.interns, id)) {
            System.out.println("FOUND! Employee " + id + " is an Intern in " + dept.name);
            return true;
        }

        // 2. Check Managers (Binary Search)
        if (binarySearch(dept.managers, id)) {
            System.out.println("FOUND! Employee " + id + " is a Manager in " + dept.name);
            return true;
        }

        // 3. Recurse into SubDepartments
        for (Department sub : dept.subDepartments) {
            if (searchCompany(sub, id)) {
                return true;
            }
        }

        return false;
    }

    // --- LINEAR SEARCH (Interns) ---
    // Rule: Interns are disorganized -> check one by one
    private static boolean linearSearch(List<Integer> list, int target) {
        if (list == null)
            return false;
        for (int id : list) {
            if (id == target) {
                return true;
            }
        }
        return false;
    }

    // --- BINARY SEARCH (Managers) ---
    // Rule: Managers are sorted -> split in half
    private static boolean binarySearch(List<Integer> list, int target) {
        if (list == null)
            return false;
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = list.get(mid);

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1; // Look in right half
            } else {
                right = mid - 1; // Look in left half
            }
        }
        return false;
    }

    // --- DATA STRUCTURES ---
    // Make class static and fields public (or add getters/setters) for Jackson
    public static class Department {
        public String name;
        public List<Integer> interns = new ArrayList<>();
        public List<Integer> managers = new ArrayList<>();
        public List<Department> subDepartments = new ArrayList<>();

        // Default constructor needed for Jackson
        public Department() {
        }

        public Department(String name) {
            this.name = name;
        }
    }
}
