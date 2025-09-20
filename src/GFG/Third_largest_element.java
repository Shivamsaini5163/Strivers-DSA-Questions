package GFG;

public class Third_largest_element {
    //    NOTE: We are Not Finding distinct third largest number
    int thirdLargest(int arr[]) {
        // Your code here
        if(arr.length<3) return -1;

        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;

        for(int num:arr){
            if(num>first){
                third = second;
                second = first;
                first = num;
            }else if(num>second){
                third=second;
                second=num;
            }else if(num>third){
                third=num;
            }
        }
        return (third == Integer.MIN_VALUE) ? -1 : third;
    }

    //    NOTE: If we are Finding distinct third largest number
    int thirdLargest2(int arr[]) {
        // Your code here
        if(arr.length<3) return -1;

        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;

        for(int num:arr){
            // skip duplicates of the largest
            if (num == first || num == second) continue;
            if(num>first){
                third = second;
                second = first;
                first = num;
            }else if(num>second){
                third=second;
                second=num;
            }else if(num>third){
                third=num;
            }
        }
        return (third == Integer.MIN_VALUE) ? -1 : third;
    }
}
