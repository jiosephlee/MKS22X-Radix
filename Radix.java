public class Radix{

    public static void main(String[] args) {
        int[] test = new int[] {1,4,5,1,4,6,1,9,6};
        radixsort(test);
        for(int i : test){
            System.out.print(i + ",");
        }
        System.out.println();
    }
    @SuppressWarnings("unchecked")
    public static void radixsort(int[]data){
        @SuppressWarnings("unchecked")
        MyLinkedList<Integer> hold = new MyLinkedList<Integer>();
        MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
        for (int i = 0; i < data.length; i++) {
            hold.add(data[i]);
        }
        int big = 0; int count = 1;
        for(int i : data){
            if (i > big){
                big = i;
            }
        }
        while(big/10 > 0){
            count++;
            big = big/10;
        }
        //System.out.println(count);
        for(int i = 0; i < count; i++){
            for(int j = 0; j < hold.size(); j++){
                int yo = hold.removeFront();
                System.out.println(yo/Math.pow(10,i)%(10*(i+1)));
                buckets[yo%(10*(i+1))].add(j);
            }
            int index = 0;
            for(MyLinkedList<Integer> x : buckets){
                hold.extend(x);
            }
        }

        int index = 0;
        for(int i = 1; i < 10; i++){
            for(int y = 0; y < buckets[i].size(); y++){
                int holder = buckets[i].removeFront();
                if (holder > 0){
                    buckets[0].add(0, holder);
                } else{
                    buckets[0].add(holder);
                }
                index++;
            }
        }
        for(int y = 0; y < buckets[0].size(); y++){
            System.out.println(buckets[0].removeFront());
            //data[index] = buckets[0].removeFront();
            index++;
        }

    }
}
