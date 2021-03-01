import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestDemo {
    /**
     * 找前K个最大的元素
     * @param array
     */
   public static  void topK(int[] array,int k){
       PriorityQueue<Integer> qu = new PriorityQueue<>(k, new Comparator<Integer>(){
           @Override
           public int compare(Integer o1, Integer o2) {
               return o1-o2;
           }
       });
       for (int i = 0; i < array.length; i++) {
           if(i <k){
               qu.offer(array[i]);
           }else{
               Integer top = qu.peek();
               if(top != null){
                   if(array[i] > top){
                       qu.poll();
                       qu.offer(array[i]);
                   }
               }

           }

       }
       for (int i = 0; i < k; i++) {
           System.out.println(qu.poll());
       }
   }


    public static void adjustDown2(int[] array,int parent,int len) {
        int child = 2*parent+1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;//
            }
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }
    //时间复杂度：nlogn
    public static void crateBigHeap2(int[] array) {
        for(int i = (array.length-1-1) /2; i>= 0;i--) {
            adjustDown2(array,i,array.length);
        }
    }

    public static void heapSort2(int[] array){
        crateBigHeap2(array);
        int end = array.length-1;
        while(end > 0){
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown2(array,0,end);
            end--;
        }

    }

    public static void main(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37};
        heapSort2(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main1(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        topK(array,3);

    }

}


