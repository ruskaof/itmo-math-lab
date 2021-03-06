# Лабораторная работа «Интеграл Римана»

**Задание:**
 Составьте интегральную сумму для интеграла Римана данной функции по данному промежутку. Вычислите ее и найдите предел. Докажите, что соответствующий интеграл существует. Проверьте с помощью формулы Ньютона-Лейбница. Напишите программу (язык любой), вычисляющую (и желательно, рисующую), интегральные суммы для данной функции на данном отрезке по формуле прямоугольника.

**Входные данные для программы:** число точек разбиения, способ выбора оснащения (левые, правые, средние, случайные точки). Разбиение равномерное. По желанию, можно использовать любой метод численного интегрирования. Основные методы вы можете найти в  [методичке](https://drive.google.com/file/d/1oAw_wz1f6rTwv8im2PgPyzVBObMw_gTW/view?usp=sharing)

**Отчет по заданию должен содержать:** 
1) Аналитическая часть: доказательство существования интеграла Римана; получение интегральной суммы (для одного случая оснащения); нахождение ее предела; сравнение со значением интеграла, найденным по формуле Ньютона—Лейбница. 
2) Краткое описание выбранного численного метода. Результаты работы программы оформить в таблицу
3) Скриншоты результатов работы программы с комментариями. 
Должны быть несколько графиков слагаемых интегральных сумм (ступенчатые фигуры) для различных разбиений (n=10, 100, 1000, 10000, 105 , 106 ) и различных оснащений (4-х графиков достаточно). Для каждого графика должно быть указано значение соответствующей интегральной суммы.
4) Текст или скриншот текста программы. 
5) *(для желающих) Написать программу, вычисляющую приближенное значение интеграла для фиксированного разбиения методом трапеций/формулой Симпсона/формулой Эйлера или иным методом. Нарисовать соответствующий рисунок и сравнить полученный результат с имеющимися.

*Вариант 21: f(x) = 4^x, [0, 2]*

*Лабораторная работа была выполнена на языке программирования Kotlin с использованием UI фреймворка Compose Multiplatform*


# Примеры результатов выполнения программы:
*y = sin(x)*

количество точек разбиения: 300

пределы: [-3; 5]

<img width="960" alt="image" src="https://user-images.githubusercontent.com/91731881/161592450-b7439304-76cd-4f87-b1ca-4cbaf18243b9.png">

*y = 4^x*

количество точек разбиения: 10

пределы: [0; 2]

<img width="960" alt="image" src="https://user-images.githubusercontent.com/91731881/161594950-58c904fb-c243-4eb0-bd67-af22166f51e8.png">

