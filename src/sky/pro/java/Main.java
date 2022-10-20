package sky.pro.java;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Random;

public class Main {

  private static int clientOS;
  private static int clientDeviceYear;

  private static int day = 1;

  public static void main(String[] args) {
    //Task №1:
    System.out.println("Task №1");
    int year = 2028;
    if (checkYear(year)) {
      System.out.printf("Год %d является високосным \n", year);
    } else {
      System.out.printf("Год %d не является високосным \n", year);
    }
    //Task №2:
    System.out.println("Task №2");
    inputData();
    checkDevice();
    //Task №3:
    System.out.println("Task №3");
    numberOfDeliveryDays();
    System.out.println();
    //Task №4 (дополнительная задача):
    int[] salary = generateRandom();
    sum(salary);
    average(salary);
    System.out.printf("Средняя трата за месяц равна %.2f рублей ", average(salary));
  }

  //Task №1
  public static boolean checkYear(int year) {
    return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
  }

  public static void inputData() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Нажмите 0, если у Вас iOS\nНажмите 1, если у Вас Android");
    clientOS = scan.nextInt();
    if (clientOS > 1 || clientOS < 0) {
      System.out.println("Ваше устройство не поддерживается");
    } else {
      System.out.println("Введите год выпуска Вашего устройства в формате: 2021");
      clientDeviceYear = scan.nextInt();
      if (clientDeviceYear > LocalDate.now().getYear() || clientDeviceYear < 1000) {
        System.out.println("Кто вы?");
      }
    }
  }

  //Task №2
  public static void checkDevice() {
    if (clientOS == 0 && clientDeviceYear < LocalDate.now().getYear()) {
      System.out.println("Установите облегченную версию приложения для iOS по ссылке");
    } else if (clientOS == 0 && clientDeviceYear == LocalDate.now().getYear()) {
      System.out.println("Установите версию приложения для iOS по ссылке");
    } else if (clientOS == 1 && clientDeviceYear < LocalDate.now().getYear()) {
      System.out.println("Установите облегченную версию приложения для Android по ссылке");
    } else if (clientOS == 1 && clientDeviceYear == LocalDate.now().getYear()) {
      System.out.println("Установите версию приложения для Android по ссылке");
    }
  }

  //Task №3
  public static void numberOfDeliveryDays() {
    int deliveryDistance = 65;
    if (deliveryDistance < 20) {
      System.out.println("Потребуется дней доставки " + day);
    } else if (deliveryDistance >= 20 && deliveryDistance < 60) {
      day++;
      System.out.println("Потребуется дней доставки " + day);
    } else if (deliveryDistance >= 60) {
      System.out.println("Так далеко не возим");
    }
  }

  //Task №4
  public static int[] generateRandom() {
    Random random = new Random();
    int[] arr = new int[30];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(100_000) + 100_000;
    }
    return arr;
  }

  public static int sum(int[] salary) {
    int result = 0;
    for (int i = 0; i < salary.length; i++) {
      result += salary[i];
    }
    return result;
  }

  public static double average(int[] salary) {
    double result = sum(salary) / salary.length;
    return result;
  }
}
