class Solution {
    public String intToRoman(int num) {
        String ret_str = "";
        int rem = 0;
        for (int i = 3; i >= 0; i--){
            int curr_div = (int) Math.pow(10, i);
            int curr_digit = num/curr_div;
            if (curr_digit == 0){
                rem = num;
            }
            else{
                switch (i){
                    case 0:

                    case 1: 
                    
                    case 2:
                    if(curr_digit == 4){

                    }
                    else if (curr_digit == 9){

                    }
                    else if (curr_digit < 5){

                    }
                    else {

                    }
                    case 3: 
                    String to_add = "M";
                    to_add = to_add.repeat(curr_digit);
                    ret_str = ret_str + to_add;
                    rem = num - curr_digit * curr_div;
                    break;
                    
                    default:
                    break;
                }
            }
        }
    }
}