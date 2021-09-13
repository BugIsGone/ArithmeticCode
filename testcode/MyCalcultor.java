package testcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author shapemind
 * @create 2020-11-29 8:44
 */
public class MyCalcultor {
    public static void main(String[] args) {
        //获得终端输入的表达式，并且去除空格
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        expression = expression.replaceAll(" ","");
        System.out.println(expression);


        //两个栈实现计算功能
        Stack<Integer> numStack = new Stack<>();//数栈
        Stack<Character> operStack = new Stack<>();//符号栈

        //定义相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int result = 0;
        char ch = ' ';
        String multiNum = "";

        while (true){//用于入栈操作，非计算部分
            ch = expression.substring(index, index+1).charAt(0);//获得一个字符

            if (MyCalcultor.isOper(ch)){//如果是符号

                if (operStack.isEmpty()){//如果符号栈为空，直接加入
                    operStack.push(ch);
                }else{//如果符号栈不空
                    if(MyCalcultor.operPriority(ch) <= MyCalcultor.operPriority(operStack.peek())){
                        /*如果符号栈不为空，则需要判断符号栈的栈顶符号的优先级,只有当前符号大于符号栈栈顶的时候才可以顺利入栈，否则就要进行以下操作*/
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();

                        result = MyCalcultor.cal(num1, num2, oper);
                        numStack.push(result);//上述结果入栈
                        operStack.push(ch);
                    }else{//当前符号大于符号栈栈顶，顺利入栈
                        operStack.push(ch);
                    }
                }
            }else{//如果是数
                multiNum += ch;//拼接成多位数

                //如果ch已经是expression的最后一位，则直接入栈
                if (index == expression.length() - 1){//index不要越界
                    numStack.push(Integer.parseInt(multiNum));
                }else if(MyCalcultor.isOper(expression.substring(index + 1, index + 2).charAt(0))){//如果后一位是操作符直接入栈
                    numStack.push(Integer.parseInt(multiNum));
                    multiNum = "";//清空多位数存储
                }
            }

            index ++;
            if (index >= expression.length()){
                break;
            }
        }

        while (true){
            if (operStack.isEmpty()){//如果符号栈为空，则在数栈里面仅剩一个数字，且这个数字就是结果
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();

            result = MyCalcultor.cal(num1, num2, oper);
            numStack.push(result);//上述结果入栈

        }

        int result2 = numStack.pop();
        System.out.print(expression + " = " + result2);
        scanner.close();

    }

    //判断是不是符号
    public static boolean isOper(char val){
        return (val == '+' || val == '-' || val == '*' || val == '/');
    }

    //返回符号优先级，乘除最高，其次加减次之，其他符号最次
    //这里的符号没有考虑小括号的问题，如果有小括号，那处理的方式是另外一种
    public static int operPriority(int val){
        if (val == '*' || val == '/'){
            return 1;
        }else if (val == '+' || val == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    //用于计算
    public static int cal(int num1, int num2, int oper){
        int result = 0;//储存结果
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}
