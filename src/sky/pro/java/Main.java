package sky.pro.java;

import java.io.PrintStream;
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
    int year = 2024;
    trueOrFalse(year);
    System.out.println("==========================");
    //Task №2:
    System.out.println("Task №2");
    inputData();
    checkDevice();
    System.out.println("==========================");
    //Task №3:
    System.out.println("Task №3");
    numberOfDeliveryDays();
    System.out.println("==========================");
    //Task №4 (дополнительная задача):
    int[] salary = generateRandom();
    sum(salary);
    average(salary);
    System.out.printf("Средняя трата за месяц равна %.2f рублей \n", average(salary));
    System.out.println("==========================");
  }

  //Task №1
  public static boolean checkYear(int year) {
    return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
  }

  public static PrintStream trueOrFalse(int year) {
    if (checkYear(year)) {
      System.out.printf("Год %d является високосным \n", year);
    } else {
      return System.out.printf("Год %d не является високосным \n", year);
    }
    return null;
  }

  //Task №2
  public static void inputData() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Нажмите 0, если у Вас iOS\nНажмите 1, если у Вас Android");
    clientOS = scan.nextInt();
    if (clientOS > 1 || clientOS < 0) {
      System.out.println("Ваше устройство не поддерживается");
    } else {
      System.out.println("Введите год выпуска Вашего устройства в формате: 2021");
      clientDeviceYear = scan.nextInt();
      if (clientDeviceYear > LocalDate.now().getYear() || clientDeviceYear < 2007) {
        System.out.println("Мне кажется, таких телефонов еще не было!");
      }
    }
  }

  public static void checkDevice() {
    if (clientOS == 0 && clientDeviceYear < LocalDate.now().getYear() && clientDeviceYear > 2006) {
      System.out.println("Установите облегченную версию приложения для iOS по ссылке");
    } else if (clientOS == 0 && clientDeviceYear == LocalDate.now().getYear()) {
      System.out.println("Установите версию приложения для iOS по ссылке");
    } else if (clientOS == 1 && clientDeviceYear < LocalDate.now().getYear()
        && clientDeviceYear > 2006) {
      System.out.println("Установите облегченную версию приложения для Android по ссылке");
    } else if (clientOS == 1 && clientDeviceYear == LocalDate.now().getYear()) {
      System.out.println("Установите версию приложения для Android по ссылке");
    }
  }

  //Task №3
  public static void numberOfDeliveryDays() {
    int deliveryDistance = 50;
    if (deliveryDistance < 20) {
      System.out.println("Потребуется дней доставки " + day);
    } else if (deliveryDistance >= 20 && deliveryDistance < 60) {
      day++;
      System.out.println("Потребуется дней доставки " + day);
    } else if (deliveryDistance >= 60) {
      System.out.println("Так далеко не возим, извините");
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
