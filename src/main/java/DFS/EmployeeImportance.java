package DFS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class EmployeeImportance {
    public static void main(String[] args) {
        EmployeeImportance employeeImportance = new EmployeeImportance();
        employeeImportance.getImportance(null, 1);


    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        employees.forEach(e -> map.put(e.id, e));

        Stack<Integer> ids = new Stack<>();
        ids.add(id);

        int total = 0;
        while (!ids.empty()) {
            int i = ids.pop();
            Employee e = map.get(i);
            total = total + e.importance;
            ids.addAll(e.subordinates);
        }

        return total;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
