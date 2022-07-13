class Solution {
    public int myAtoi(String s) {
        s=s.stripLeading();
        int i = 0;
        int convert = 0;
        int total = 0;
        int neg = 1;
        if(s.length()>0)
            if(s.charAt(0) == '-'){
                neg = -1;
                s = s.substring(1,s.length());
            }
        while(i<s.length()){
            convert = s.charAt(i) - '0';
            if(convert>=0 && convert <=9){
                total*=10;
                total+=convert;
                if(total*neg<-2147483648)
                    return -2147483648;
                if(total>2147483647)
                    return 2147483647;
            }
            else
                return total*neg;
            i++;
        }
        return total*neg;
    }
}
