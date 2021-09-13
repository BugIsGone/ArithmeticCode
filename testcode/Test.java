package testcode;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
       do {
           Rectangle rectangle = new Rectangle();
           Scanner input = new Scanner(System.in);
           System.out.println("请输入第一个数字");
           if (input.hasNextInt()){
               rectangle.setLang(input.nextInt());
               System.out.println("请输入第二个数字");
               if (input.hasNextInt()) {
                   rectangle.setWide(input.nextInt());
                   System.out.println("请输入要求的是周长/面积：1/2");
                   int s2 =input.nextInt();
                   if (s2==1){
                       System.out.println("周长为："+rectangle.perimeter());
                   }else if (s2 == 2){
                       System.out.println("面积为"+rectangle.area());
                   }
               }else {
                   rectangle.setWided(input.nextDouble());
                   System.out.println("请输入要求的是周长/面积：1/2");
                   int s2 =input.nextInt();
                   if (s2==1){
                       System.out.println("周长为："+rectangle.perimeterd());
                   }else if (s2 == 2){
                       System.out.println("面积为"+rectangle.area());
                   }
               }

           }else if (input.hasNextDouble()){
               rectangle.setLangd(input.nextDouble());
               System.out.println("请输入第二个数字");
               rectangle.setWided(input.nextDouble());
               System.out.println("请输入要求的是周长/面积：1/2");
               int s2 =input.nextInt();
               if (s2==1){
                   System.out.println("周长为："+rectangle.perimeterdd());
               }else if (s2 == 2){
                   System.out.println("面积为"+rectangle.areadd());
               }

           }
           System.out.println("输入bye退出循环");
           String str = input.next();
           System.out.println("bye bye ");
           if("bye".equals(str)){
               System.out.println("byebyebye ");
               break;
           }

       }while (true);{

        }
    }
}

