class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        boolean num_found = false;
        boolean non_zero = false;
        long sum = 0;
        char [] iter = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(iter[i])){
                if(!num_found){    
                    num_found = true;
                }
                if (!non_zero){
                    if (iter[i] == '0'){
                        continue;
                    }
                    else{
                        non_zero = true;
                        int digit = iter[i] - '0';
                        sum = sum*10 + digit;
                    }
                }
                else{
                    int digit = iter[i] - '0';
                    sum = sum*10 + digit;
                }
                if (sum > Integer.MAX_VALUE){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            else{
                if (!num_found){
                    switch(iter[i]){
                        case '-': 
                            sign = -1;
                            num_found = true;
                            break;
                        case '+': 
                            sign = 1;
                            num_found = true;
                            break;
                        case ' ': break;
                        default : return 0;
                    }
                }
                else{
                    break;
                }
            }
        }
        return sign * (int) sum;  
    }
}