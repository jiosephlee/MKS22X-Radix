public class Radix{
    public static void radixsort(int[]data){
        MyLinkedList[] buckets = new MyLinkedList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyLinkedList<Integer>();
        }

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
        for(int i = 0; i < count; i++){
            for(int j : data){
                int yo = (int)(j/Math.pow(10,i));
                buckets[yo%(10*(i+1))].add(j);
            }
            int index = 0;
            for(MyLinkedList<Integer> x : buckets){
                for(int y = 0; y < x.size(); y++){
                    data[index] = x.removeFront();
                    index++;
                }
            }
        }
        for(int j : data){
            int yo = (int)(j/Math.pow(10,count-1));
            buckets[yo%(10*(count))].add(j);
        }
        int index = 0;
        for(int i = 1; i < 10; i++){
            for(int y = 0; y < buckets[i].size(); y++){
                int hold = (int)(buckets[i].removeFront());
                if (hold > 0){
                    buckets[0].add(0, hold);
                } else{
                    buckets[0].add(hold);
                }
                index++;
            }
        }
        for(int y = 0; y < buckets[0].size(); y++){
            data[index] = (int)buckets[0].removeFront();
            index++;
        }

    }
}
