import java.util.*;

/**
 * Создать класс Employee (сотрудник) со следующими полями:
 * 1. String name - имя
 * 2. int age - возраст
 * 3. double salary - зарплата
 * <p>
 * Необходимо:
 * 0. Создать список из 10-20 рандомных сотрудников.
 * 1. Отсортировать его по убыванию возрастов (от большего к меньшему).
 * 2. Отсортировать его по возрастанию зарплаты.
 * 3. Вывести топ-5 сотрудников с наибольшей зарплатой, отсортированных по имени в алфавитном порядке.
 * 4.* Отсортировать сотрудников по возрастанию возрастов.
 * Если возрасты одинаковые - то по убыванию зарплаты.
 * Если и они равны - в алфавитном порядке.
 */
public class Main {
    public static void main(String[] args) {

        List<Employer> employerList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            String name = "";
            for (int j = 0; j < 2; j++) {
                int charName = new Random().nextInt(97, 113);
                name += (char) charName;
            }
            name += "ton";
            employerList.add(new Employer(name, new Random().nextInt(20, 61), new Random().nextInt(20_000, 80_000)));
        }

        employerList.add(new Employer("Axl1", 24, new Random().nextInt(20_000, 80_000)));
        employerList.add(new Employer("Axl2", 24, new Random().nextInt(20_000, 80_000)));
        employerList.add(new Employer("Bill", 34, 1000000));
        employerList.add(new Employer("Fill", 34, 1000000));

        System.out.println(employerList);

        CompAge employerCompAge = new CompAge();
        CompSalary employerCompSalary = new CompSalary();
        SpecialComp specialComp = new SpecialComp();


        System.out.println("0 По умолчанию (в алфавитном порядке) \n" +
                "1 Отсортировать его по убыванию возрастов (от большего к меньшему) \n" +
                "2 Отсортировать его по возрастанию зарплаты и вывести топ-5 сотрудников с наибольшей зарплатой, отсортированных по имени в алфавитном порядке\n" +
                "3 Отсортировать сотрудников по возрастанию возрастов \n" +
                "   * Если возрасты одинаковые - то по убыванию зарплаты \n" +
                "   * Если и они равны - в алфавитном порядке");

        Scanner scanner = new Scanner(System.in);

        int choise = scanner.nextInt();
        switch (choise) {
            case 0:
                //По умолчанию
                System.out.println("До: \n" + employerList);
                Collections.sort(employerList);
                System.out.println("После: \n" + employerList);
                break;
            case 1:
                //Отсортировать его по убыванию возрастов (от большего к меньшему).
                System.out.println("До: \n" + employerList);
                employerList.sort(employerCompAge);
                System.out.println("После: \n" + employerList);
                break;
            case 2:
                //Отсортировать его по возрастанию зарплаты и вывести топ-5 сотрудников с наибольшей зарплатой, отсортированных по имени в алфавитном порядке.
                System.out.println("До: \n" + employerList);
                employerList.sort(employerCompSalary);
                System.out.println("Всего: \n" + employerList);

                List<Employer> out = new LinkedList<>();
                for (int i = employerList.size() - 5; i < employerList.size(); i++) {
                    out.add(employerList.get(i));
                }
                Collections.sort(out);
                System.out.println("Топ5: \n" + out);
                break;
            case 3:
                //Отсортировать сотрудников по возрастанию возрастов.
                //   * Если возрасты одинаковые - то по убыванию зарплаты.
                //   * Если и они равны - в алфавитном порядке.
                System.out.println("До: \n" + employerList);

                employerList.sort(specialComp);

                System.out.println("После: \n" + employerList);
                break;

            }
    }
}