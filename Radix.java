public class Radix{

    public static void main(String[] args) {
        int[] test = new int[] {-9, -28, -16, -34, -50, 0, 32, 42, 16, 29};
        radixsort(test);
        for(int i : test){
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("TIME FOR TEST 2");

        test = new int[] {-891429, -34349, -135868, -68048, -620397, -578817, -923357, -887007, -187247, -7267, -986767, -442527, -900616, -495306, -635486, -16386, -165225, -34385, -42195, -97935, -624185, -301875, -822824, -63244, -859994, -315924, -362914, -748873, -417863, -248753, -595013, -751942, -978282, -393141, -827941, -24111, -284260, -246850, -851070, -857470, -742710, -116510, -460380, 246860, 736190, 292270, 762940, 949210, 838890, 196211, 384111, 670931, 522771, 405552, 458532, 414112, 37632, 401812, 690619, 614299, 228259, 631389, 343739, 720969, 206149, 650339, 183409, 300869, 36909};
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
        MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
        for(int i =  0; i < 20; i++){
            buckets[i] = new MyLinkedList<Integer>();
        }
        int big = 0; int count = 0;
        for (int i = 0; i < data.length; i++) {
            hold.add(data[i]);
            if(data[i] < 0){
                if(data[i] * -1 > big) big = data[i] * -1;
            } else if (data[i]> big){
                big = data[i];
            }
        }
        while(big > 0){
            count++;
            big = big/10;
        }
        //System.out.println(count);
        //loop through n digit number of times to sort within buckets
        for(int i = 0; i < count; i++){
            //System.out.println(i+1 + " nth digit pass!");
            //System.out.println(hold);
            for(int j = 0; j < data.length; j++){
                //resort buckets
                //System.out.println("hold" + hold);
                int yo = hold.removeFront();
                if (yo >= 0){
                    buckets[(yo/(int)Math.pow(10,i))%10 + 10].add(yo);
                } else{
                    buckets[9 + (yo/(int)Math.pow(10,i))%10].add(yo);
                }
            }
            //dump buckets back into holding linkedlist
            for(MyLinkedList<Integer> x : buckets){
                //System.out.println(x);
                //System.out.println("hhf");
                hold.extend(x);
                }
            //System.out.println("hold" + hold);
            }

        //dump into array
        for(int y = 0; y < data.length; y++){
            //System.out.println(buckets[0].removeFront());
            data[y] = hold.removeFront();
        }

    }
}
