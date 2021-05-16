public class CreateFileFolder {
    public static void main(String[] args) {
        String CIT591 = "CIT591_Week";
        String CIT592 = "CIT592_Week";
        String CIT593 = "CIT593_Week";
        helper(CIT591);
        helper(CIT592);
        helper(CIT593);

    }

    public static void helper(String s){
        for(int i=2; i<15; i++){
            System.out.printf("%S%d ",s,i);
        }
        System.out.println();
    }

}
