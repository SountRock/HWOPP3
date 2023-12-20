import java.util.Comparator;

/**
 * Сравнить по убыванию возрастов (от большего к меньшему).
 */

public class CompAge implements Comparator<Employer> {

    @Override
    public int compare(Employer o1, Employer o2) {
        return o2.getAge() - o1.getAge();
    }
}
