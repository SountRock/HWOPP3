/**
 * Класс сотрудника
 */
public class Employer implements Comparable<Employer> {
    private String name;
    private int age;
    private double salary;

    private static int countEmpl;
    private final int numberEmpl;

    public Employer(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        numberEmpl = countEmpl++;
    }

    /**
     * Получить имя
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Получить значение возраста
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Получить значение зарплаты
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employer" + numberEmpl +" {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    /**
     * Сравнить по алфавитному порядку
     * @param o the object to be compared.
     * @return this.o - o
     */
    @Override
    public int compareTo(Employer o) {
        char[] name1 = this.name.toLowerCase().toCharArray();
        char[] name2 = o.getName().toLowerCase().toCharArray();

        int result = name1[0] - name2[0];

       // System.out.println(this.name + o.getName() + " : "+ result);

        if (result != 0){
            return result;
        } else {
            int length = name1.length < name2.length ? name1.length : name2.length;
            for (int i = 0; i < length; i++) {
                result = name1[i] - name2[i];
                if(result != 0){
                    //System.out.println(this.name + o.getName() + " : EXTRA "+ result);
                    return result;
                }
            }
        }

        return 0;
    }
}
