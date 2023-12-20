import java.util.Comparator;

/**
 * Сравнить по по возрастанию зарплаты.
 */

public class CompSalary implements Comparator<Employer> {
    @Override
    public int compare(Employer o1, Employer o2) {
        return (int) (o1.getSalary() - o2.getSalary());
    }
}
