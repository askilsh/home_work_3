import  org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;
import java.util.Arrays;

/* В результате проверки делаем вывод, что наша программа tanos падает при:
1) При появлении в массиве от 3 одинаковых чисел
2) При равномерной последовательности от 5 одинаковых чисел (5, 6, 7, 8, 9).

1) При близких значениях неправильно сортирует два последних числа
 */


public class TestTanos
{
    @Test
    public void test_one()
    {
        int mass[] = {1000}; // Работаем
        int min = 0;
        int max = (mass.length - 1);
        int mass_exp[] = new int[]{1000};
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_large()
    {
        int mass[] = {1050012302, 1, 0, 500}; // Работаем
        int min = 0;
        int max = (mass.length - 1);
        int mass_exp[] = new int[]{0, 1, 500, 1050012302};
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_simm()
    {
        int mass[] = {777, 777, 777, 777, 777, 777, 777}; // Сломался :(. java.lang.StackOverflowError
        int min = 0;                                      // Ломаемся при больше чем два одинаковых числа
        int max = (mass.length - 1);
        int mass_exp[] = new int[]{777, 777, 777, 777, 777, 777, 777};
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_sim_norme()
    {
        int mass[] = {773, 773}; // Работаем
        int min = 0;
        int max = (mass.length - 1);
        int mass_exp[] = new int[]{773, 773};
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_sim_not_norme()
    {
        int mass[] = {1, 1, 1}; // Падаем
        int min = 0;
        int max = (mass.length - 1);
        int mass_exp[] = new int[]{1, 1, 1};
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_line()
    {
        int mass[] = new int[100]; // 100,99,...3,2,1, Падаем уже от 5 символов
        int mass_exp[] = new int[100];
        int i = 0;
        int z = 0;
        while(i < 100)
        {
            mass[i] = 100 - i;
            System.out.println(mass[i]);
            i++;
        }
        while(z < 100)
        {
            mass_exp[z] = z + 1;
            z++;
        }
        int min = 0;
        int max = (mass.length - 1);
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        //Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_line_work()
    {
        int mass[] = new int[4]; //4,3,2,1 Работаем
        int mass_exp[] = new int[4];
        int i = 0;
        int z = 0;
        while(i < 4)
        {
            mass[i] = 4 - i;
            System.out.println(mass[i]);
            i++;
        }
        while(z < 4)
        {
            mass_exp[z] = z + 1;
            z++;
        }
        int min = 0;
        int max = (mass.length - 1);
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_line_work()
    {
        int mass_exp[] = new int[4]; // 892, 891, 890, 889 Неккоректный вывод
        int i = 0;                   // 889, 890, 892, 891 -  891 не на своем месте
        int z = 0;
        while(i < 4)
        {
            mass[i] = 892 - i;
            System.out.println(mass[i]);
            i++;
        }
        while(z < 4)
        {
            mass_exp[z] = 888 + z + 1;
            z++;
        }
        int min = 0;
        int max = (mass.length - 1);
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_many()
    {
        int mass[] = {1, 1, 1}; // Падаем
        int min = 0;
        int max = (mass.length - 1);
        int mass_exp[] = new int[]{1, 1, 1};
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_many_random()
    {
        int mass[] = {10000, 6232, 1, 20, 5, 15, 1342, 0, 7, 1000000, 88, 9999, 76132}; // Работаем
        int min = 0;
        int max = (mass.length - 1);
        int mass_exp[] = new int[]{0, 1, 5, 7, 15, 20, 88, 1342, 6232, 9999, 10000, 76132, 1000000};
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }

    @Test
    public void test_many_random_break()
    {
        int mass[] = {10000, 6232, 1, 20, 1, 15, 1342, 1, 7, 1000000, 88, 9999, 76132}; // Падаем. Три "1".
        int min = 0;
        int max = (mass.length - 1);
        int mass_exp[] = new int[]{1, 1, 1, 7, 15, 20, 88, 1342, 6232, 9999, 10000, 76132, 1000000};
        mass = tanos.ft_sort(mass, min, max);
        mass = tanos.ft_min_max(mass, min, max);
        Assertions.assertArrayEquals(mass_exp, mass);
    }
}

