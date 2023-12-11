
public class ProgrammingTask {

    /*000002 -> 000004
      00003 -> 00006
      888888 -> 000000
      GL-321 -> GL-324
      GL-999 -> GL-000
      GL-699 -> GL-800
      DRI000EDERS0RE -> DRI000EDERS0RE*/

    public static void increment(char[] referenceNumber){

        int end = referenceNumber.length - 1;

        while(end >= 0 && !Character.isDigit(referenceNumber[end])){
            end --;
        }
        if (end <0){
            return;
        }

        for (int i = end; i >= 0; i--){
            if(!Character.isDigit(referenceNumber[i])){
                break;
            }
            int number = 0;
            number = referenceNumber[i] + '0';

            if(number % 2 == 0){
                number += 2;
            }
            else {
                number +=3;
            }
            if(number >= 100){
                number = 0;
            }

            int lastDigit = 0;
            while (number > 0){
                referenceNumber[end - lastDigit] = (char)((number % 10) + '0');
                number /=10;
            }
            for (int j = lastDigit; j < referenceNumber.length - end; j++){
                referenceNumber[end - j] = '0';
            }
        }

    }


}
