public class Radix{
    public static void radixsort(int[]data){
        MyLinkedList<Integer> hold = new MyLinkedList<Integer>();
        MyLinkedList<Integer>[] buckets = new MyLinkedList<Integer>()[10];
        int big = 0; int count = 0;
        for(int i : data){
            if (i > big){
                big = i;
            }
        }
        while(big/10 > 0){
            count++;
            big = big/10;
        }
        for(int i : data){
            buckets[i%10].add(i);
        }
        for(MyLinkedList<Integer> i : buckets){
            
        }
        for(int i = 1; i < count; i++){

        }

        }
    }
}
