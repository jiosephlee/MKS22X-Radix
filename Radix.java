public class Radix{

    public static void main(String[] args) {
        int[] test = new int[] {-1,4,5,-19,1,4,6,1,9,-6};
        radixsort(test);
        for(int i : test){
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("TIME FOR TEST 2");

        test = new int[] {1231,54,25,1,4,62,351,19,6};
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
        for(int i =  0; i < 10; i++){
            buckets[i] = new MyLinkedList<Integer>();
        }
        for (int i = 0; i < data.length; i++) {
            hold.add(data[i]);
        }
        //find largest number of digits
        int big = 0; int count = 1;
        for(int i : data){
            if (i*i > big*big){
                big = i;
            }
        }
        //System.out.println(big);
        while(big/10 > 0){
            count++;
            big = big/10;
        }
        //System.out.println(count);
        //loop through n digit number of times to sort within buckets
        //System.out.println(hold.size());
        for(int i = 0; i < count; i++){
            //System.out.println(i+1 + " nth digit pass!");
            //System.out.println(hold);
            for(int j = 0; j < data.length; j++){
                //resort buckets
                //System.out.println("hold" + hold);
                int yo = hold.removeFront();
                //System.out.println("YO "   + (yo/(int)Math.pow(10,i)));
                //System.out.println((yo/(int)Math.pow(10,i))%10);
                if (yo >= 0){
                    buckets[(yo/(int)Math.pow(10,i))%10].add(yo);
                } else{
                    buckets[-1 * (yo/(int)Math.pow(10,i))%10].addBack(yo);
                    //System.out.println(" yooo" + buckets[-1 * (yo/(int)Math.pow(10,i))%10]);
                }
            }
            int index = 0;
            /*for(MyLinkedList<Integer> x : buckets){
                System.out.print(x);
            }*/
            //System.out.println();
            //System.out.println(hold);
            //dump buckets back into holding linkedlist
            hold = new MyLinkedList<Integer>();
            if (i != count - 1){
                //System.out.println("sdf");
                for(MyLinkedList<Integer> x : buckets){
                    //System.out.println(x);
                        //System.out.println("hhf");
                    hold.extend(x);
                }
                //System.out.println("hold" + hold);
            }
        }
        //System.out.println("before final resort" + hold);
        //resort final time to resolve negs
        for(int i = 1; i < 10; i++){
            //System.out.println(buckets[i].size());
            for(int y = 0; y < buckets[i].size();){
                int holder = (int)buckets[i].removeFront();
                //System.out.print("xs" + holder);
                if (holder < 0){
                    buckets[0].addBack(holder);
                } else{
                    buckets[0].add(holder);
                }
            }
        }
        //System.out.println(buckets[0]);
        //dump into array
        for(int y = 0; y < data.length; y++){
            //System.out.println(buckets[0].removeFront());
            data[y] = buckets[0].removeFront();
        }

    }
}
