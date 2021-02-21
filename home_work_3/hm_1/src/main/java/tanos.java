import java.util.Arrays;
public class tanos{

	public static int[] ft_sort(int[] mass, int min, int max) // Сортируем. Бегаем по массиву, 
	{														// меньше средней - в левую часть, больше - в правую.
		int buff[] = Arrays.copyOf(mass, mass.length); // Буферный массив.
		float aver = average(mass, min, max); // Находим среднюю арифметическую
		int max_ct = max; 
		int min_ct = min; // счетчики добавлений влево и вправо
		int i = min;
		while (i <= max)
		{
			if (mass[i] < aver) // Сравниваем значения со средней
			{
				buff[min_ct] = mass[i]; 
				min_ct++;
			}
			else
			{
				buff[max_ct] = mass[i];
				max_ct--;
			}
			if (i != max)
			{
				i++;
				continue;
			}
			break;
		}
		return buff;
	}

	public static int[] ft_min_max(int[] mass, int min, int max) // Метод, который двигает индексы min и max вдоль массива
	{
		float aver = average(mass, min, max);  // Средняя
		int count = 0;
		int max_new;
		int min_new;
		if ((max + 1 - min) > 1) // Не пускаем на сортировку, если количество элементов в части меньше 2
		{
			if ((max + 1 - min) == 2) // Если количество элементов - 2
			{
				mass = ft_sort(mass, min, max); // Сортируем
				return  mass;
			}
			while(count < 2) // Просто счетчик, бегаем отдельно по левой части и по правой
			{
				if (count == 0) // По левой
				{
					max_new = max;
					while (mass[max_new] > aver) // Двигаем максимальный индекс влево пока не перейдем среднюю
					{
						max_new--; 
					}
					mass = ft_sort(mass, min, max_new); // Сортим
					mass = ft_min_max(mass, min, max_new); // Рекурсия
				}
				else // По правой
				{
					min_new = min;
					while (mass[min_new] < aver) // Двигаем минимальный индекс вправо пока не перейдем среднюю
					{
						min_new++; 
					}
					mass = ft_sort(mass, min_new, max); // Сортим
					mass = ft_min_max(mass, min_new, max); // Рекурсия
				}
				count++;
			}
		}
		return mass;
	}

public static float average(int[] mass, int min, int max) // Средняя арифметическая, здесь все просто)
	{
		float sum;
		float average;
		int i;

		sum = 0;
		i = 0;
		while (i <= max)
		{
			sum = sum + mass[i];
			if (i != max)
			{
				i++;
				continue;
			}
			break;
		}
		average = sum / (max + 1 - min);
		return (average);
	}
}
