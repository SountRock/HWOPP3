import java.util.Comparator;

/**
 * Сравнить сотрудников по возрастанию возрастов
 *     * Если возрасты одинаковые - то по убыванию зарплаты
 *     * Если и они равны - в алфавитном порядке
 */
public class SpecialComp implements Comparator<Employer> {

    @Override
    public int compare(Employer o1, Employer o2) {
        Comparator<Employer> compAge = new CompAge().reversed();

        int result = compAge.compare(o1, o2);
        if(result == 0){
            Comparator<Employer> compSalary = new CompSalary().reversed();
            result = compSalary.compare(o1, o2);
            if(result == 0){
                o1.compareTo(o2);
            }
        }

        return result;
    }
}
