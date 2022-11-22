package 作业.暑假21年;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 员工的重要性 {
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(getEmployee(employees, id));
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            for (Integer i : e.subordinates) {
                queue.offer(getEmployee(employees, i));
            }
            sum += e.importance;
        }
        return sum;

    }

    Employee getEmployee(List<Employee> employees, int id) {

        for (Employee e : employees) {
            if (e.id == id) {
                return e;
            }
        }
        return null;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
