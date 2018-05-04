package wang.tyrael.leetcode.twentyfour679;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Num> list = new ArrayList<>();
        list.add(new Num(nums[0], 1));
        list.add(new Num(nums[1], 1));
        list.add(new Num(nums[2], 1));
        list.add(new Num(nums[3], 1));
        //两种计算树
        return symmetric(list) || asymmetric(list);
    }

    public boolean symmetric(List<Num> nums){
        List<List<Num>> all = getA(nums);
        for (List<Num> item:
             all) {
            List<Num> result1 = calculate(item.get(0), item.get(1));
            List<Num> result2 = calculate(item.get(2), item.get(3));
            if(get24(result1, result2)){
                return true;
            }
        }
        return false;
    }

    public boolean get24(List<Num> aResult, List<Num> bResult){
        for (Num a :
                aResult) {
            for (Num b:
                 bResult) {
                //System.out.println("a:" + a.getValue() + ";b:" + b.getValue());
                List<Num> result = calculate(a, b);
                for (Num item:result){
                    if (item.is24()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * *, /, +, -
     * 1, 2, 3,4
     * @param a
     * @param b
     * @return
     */
    public List<Num> calculate(Num a, Num b){
        List<Num> result = new ArrayList<>();
        result.add(a.add(b));
        result.add(a.minus(b));
        if(!b.isZero()){
            result.add(a.divide(b));
        }
        result.add(a.multipy(b));

        result.add(b.minus(a));
        if(!a.isZero()){
            result.add(b.divide(a));
        }
        return result;
    }

    public boolean asymmetric(List<Num> nums){
        List<List<Num>> all = getA(nums);
        int i=0;
        for (List<Num> item :
                all) {
            //System.out.println("" + i++);
            if(asymCalculate(item)){
                return true;
            }
        }
        return false;
    }

    public boolean asymCalculate(List<Num> nums){
        //print(nums);
        List<Num> result1 = calculate(nums.get(0), nums.get(1));
        for(Num item1 : result1){
            List<Num> result2 = calculate(item1, nums.get(2));
            for (Num item2:
                result2 ) {
                List<Num> result3 = calculate(item2, nums.get(3));
                for (Num item3 :
                        result3) {
                    if(item3.is24()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 获取全排列
     * @param a
     * @return
     */
    public List<List<Num>> getA(List<Num> a){

        List<List<Num>> result = new ArrayList<>();
        if(a.size() == 1){
            result.add(new ArrayList<>(a));
            return result;
        }

        for (int i = 0; i < a.size(); i++) {
            List<Num> left = new ArrayList<>(a);
            Num removed = left.remove(i);
            List<List<Num>> small = getA(left);
            for (List<Num> n:
                    small) {
                List<Num> copy = new ArrayList<>(n);
                copy.add(removed);
                result.add(copy);
            }
            //print(a);
        }
        return result;
    }

    public class Num{
        int numerator;
        int denominator;

        public Num(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        double getValue(){
            return numerator / (double)denominator;
        }

        Num calcuate(Num b, int flag){
            switch (flag){
                case 0:
                    return this.add(b);
                case 1:
                    return this.minus(b);
                case 2:
                    return this.multipy(b);
                case 3:
                    return this.divide(b);
            }
            return null;
        }

        Num add(Num b){
            return new Num(this.numerator * b.denominator + this.denominator * b.numerator,
                    this.denominator * b.denominator);
        }

        Num minus(Num b){
            return new Num(this.numerator* b.denominator - this.denominator * b.numerator,
                    this.denominator * b.denominator);
        }

        Num multipy(Num b){
            return new Num(this.numerator * b.numerator,
                    this.denominator * b.denominator);
        }

        Num divide(Num b){
            return new Num(this.numerator * b.denominator,
                    this.denominator * b.numerator);
        }

        boolean is24(){
            return numerator % denominator == 0 && numerator / denominator == 24;
        }

        boolean isZero(){
            return numerator == 0;
        }
    }

    public static void print(List<Num> list){
        for (int i = 0; i < list.size(); i++) {
            Num s = list.get(i);
            System.out.print(s.numerator +"/" + s.denominator + ",");
        }
        System.out.println();
    }
}
