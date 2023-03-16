import java.util.Arrays;
public class SimpleArrays{
    private String [] array = new String[4];

    public SimpleArrays(String insert){
        for(int i = 0; i < 4; i++){
            array[i] = insert;
        }
    }

    public SimpleArrays(){
        for(int i = 0; i < 4; i++){
            array[i] = "Hello, world";
        }
    }

    public String arrayConcat(int num){
        String output = "";
        for(int i = 0; i < num; i++){
            if(i < (num - 1)){
                output = output + array[i] + "#";
            }
            else{
                output = output + array[i];
            }
        }
        return output;
    }

    public String arrayConcat(){
        String output = "";
        for(int i = 0; i < 4; i++){
            if(i < (3)){
                output = output + array[i] + "#";
            }
            else{
                output = output + array[i];
            }
        }
        return output;
    }

    public String arrayCrop(int start, int end){
        String output = "";
        if( start == end){
            output = output + "Match";
        }
        else if (start < 0 || end > 3){
            output = output + "Fail";
        }

        else {
            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            for (int i = start; i <= end; i++) {
                if (i < (end)) {
                    output = output + array[i] + "#";
                } else {
                    output = output + array[i];
                }

            }

        }
        return output;
    }

    public static void main(String[] args){
        SimpleArrays myArray1 = new SimpleArrays();
        String foundResult1 = myArray1.arrayConcat();
        System.out.println(foundResult1);

        SimpleArrays myArray2 = new SimpleArrays();
        String foundResult2 = myArray2.arrayConcat(2);
        System.out.println(foundResult2);

        SimpleArrays myArray3 = new SimpleArrays("Hi you");
        String foundResult3 = myArray3.arrayConcat();
        System.out.println(foundResult3);

        SimpleArrays myArray4 = new SimpleArrays("Hi you");
        String foundResult4 = myArray4.arrayConcat(2);
        System.out.println(foundResult4);

        SimpleArrays myArray5 = new SimpleArrays("Hi you");
        String foundResult5 = myArray5.arrayCrop(0, 2);
        System.out.println(foundResult5);

        SimpleArrays myArray6 = new SimpleArrays("Hi you");
        String foundResult6 = myArray6.arrayCrop(3, 2);
        System.out.println(foundResult6);

        SimpleArrays myArray7 = new SimpleArrays("Hi you");
        String foundResult7 = myArray7.arrayCrop(0, 6);
        System.out.println(foundResult7);

        SimpleArrays myArray8 = new SimpleArrays("Hi you");
        String foundResult8 = myArray8.arrayCrop(3, 3);
        System.out.println(foundResult8);
    }
}